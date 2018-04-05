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
            Player p2 = list.remove(1);
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
        }

    }

    private synchronized void updateQueue(){
        while(!playerQueue.isEmpty()){
            Player player = playerQueue.getFirstPlayer();
            System.out.println(player.getPlayerId());
            if(player.getElo() > WEERAPONG){
                weerapong.add(player);
                updateList(weerapong);
            }
            else if(player.getElo() > PLATINUM){
                platinum.add(player);
                updateList(platinum);
            }
            else if(player.getElo() > GOLD){
                gold.add(player);
                updateList(gold);
            }
            else if(player.getElo() > SILVER){
                silver.add(player);
                updateList(silver);
            }
            else{
                bronze.add(player);
                updateList(bronze);
            }
        }
    }
}
