package hard.string.service;

import hard.string.component.PlayerQueue;
import hard.string.entity.Board;
import hard.string.entity.BoardDB;
import hard.string.entity.Player;
import hard.string.repository.BoardDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 4/5/2018.
 */

@Service
public class PlayerQueueService {

    private final int BRONZE = 1000;
    private final int SILVER = 1200;
    private final int GOLD = 1400;
    private final int PLATINUM = 1600;
    private final int WEERAPONG = 1800;

    @Autowired
    private BoardDBRepository boardDBRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private RunningGameService runningGameService;

    private PlayerQueue playerQueue = PlayerQueue.getInstance();

    private List<Player> bronze = new ArrayList<>();
    private List<Player> silver = new ArrayList<>();
    private List<Player> gold = new ArrayList<>();
    private List<Player> platinum = new ArrayList<>();
    private List<Player> weerapong = new ArrayList<>();

    public void addPlayerToQueue(Player p){
        playerQueue.add(p);
        updateQueue();
    }

    private void updateList(List<Player> list){
        if(list.size() == 2){
            Player p1 = list.remove(0);
            Player p2 = list.remove(0);
            BoardDB boardDB = new BoardDB();
            boardDB.setPlayer1(p1.getPlayerId());
            boardDB.setPlayer2(p2.getPlayerId());
            boardDBRepository.save(boardDB);
            Board b = new Board();
            b.setGameIsOver(false);
            b.setMana1(1);
            b.setMana2(1);
            b.setPlayer1(p1);
            b.setPlayer2(p2);
            b.setTurn(1);
            runningGameService.addGame(boardDB.getBoardId(),b);
            System.out.println("Create game success!");
            System.out.println(p1.getPlayerId() + "and " + p2.getPlayerId() + " is now in the game!");
            System.out.println(boardDBRepository.findByPlayer1OrPlayer2(p1.getPlayerId(), p1.getPlayerId()));
        }

    }

    private boolean checkDupes(List<Player> list, Player player){
        for(Player p: list){
            if(player.getPlayerId() == p.getPlayerId()){
                return true;
            }
        }
        return false;
    }

    private synchronized void updateQueue(){
        while(!playerQueue.isEmpty()){
            Player player = playerQueue.getFirstPlayer();
            System.out.println("Attempt to put player : " + player.getPlayerId() + " in queue");
            if(player.getElo() > WEERAPONG){
                if(!checkDupes(weerapong,player)) {
                    weerapong.add(player);
                    updateList(weerapong);
                }
                else {
                    playerQueue.push(player);
                }
            }
            else if(player.getElo() > PLATINUM){
                if(!checkDupes(platinum,player)) {
                    platinum.add(player);
                    updateList(platinum);
                }
                else {
                    playerQueue.push(player);
                }
            }
            else if(player.getElo() > GOLD){
                if(!checkDupes(gold,player)) {
                    gold.add(player);
                    updateList(gold);
                }
                else {
                    playerQueue.push(player);
                }
            }
            else if(player.getElo() > SILVER){
                if(!checkDupes(silver,player)) {
                    silver.add(player);
                    updateList(silver);
                }
                else {
                    playerQueue.push(player);
                }
            }
            else{
                if(!checkDupes(bronze,player)) {
                    bronze.add(player);
                    updateList(bronze);
                }
                else {
                    playerQueue.push(player);
                }
            }
        }
    }
}
