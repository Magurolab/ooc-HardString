package hard.string.service;


import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RunningGameService runningGameService;

    @Autowired
    private BoardDBRepository boardDBRepository;
    @Autowired
    private TempMonsterService tempMonstersService;
    @Autowired
    private MonsterFieldService monsterFieldService;

    public boolean fight(Player pA ,Player pB, TempMonster mA,TempMonster mB,int indexA,int indexB) {

        if (pA.getPlayerId() != pB.getPlayerId()) {
            //if player try to attack monster on the same side, we'll not allow that
            if (pB.getActiveTaunt() == 0 || mB.isTaunt()) {
                //doing an attack
                tempMonstersService.takeDamage(mA, mB.getAtk());
                System.out.println("Monster a after attack : " + mA.getHp());
//                monA hp -= monB atk
                tempMonstersService.takeDamage(mB, mA.getAtk());
                System.out.println("Monster b after being attacked : " + mB.getHp());
//                monB hp -= monA atk
                if (tempMonstersService.isDead(mA)) {
                    //remove monster if it dead
                    if(indexA != 0) {
                        monsterFieldService.removeMonster(indexA, pA);
                    }
//                    monsterFieldService.setMonster(indexA,pA.getMonsterField(),null);
//                    a.remove(mA);
                } else {
                    System.out.println("set can't attack");
                    //make monster cannot attack twice in a turn
                    mA.setCanAttack(false);
                }
                if (tempMonstersService.isDead(mB)) {
                    //remove monster if it dead
                    if(indexB != 0) {
                        monsterFieldService.removeMonster(indexB, pB);
                    }
//                    monsterFieldService.setMonster(indexB,pB.getMonsterField(),null);
//                    b.remove(mB);
                }
            } else {
                //cannot attack since taunt is on the field
                return false;
            }
        } else {
            //cannot attack
            return false;
        }
        return true;
    }


    public Player endTurn(Board b){
        if(b.getTurn() == 1){
            //Add one mana to P1
            if(b.getMaxmana1()>10){
                b.setMaxmana1(10);
                b.setMana1(10);
            }
            else {
                b.setMaxmana1((b.getMaxmana1() + 1));
                b.setMana1(b.getMaxmana1());
            }
            //Set turn to P2
            monsterFieldService.setAllAttack(b.getPlayer2().getMonsterField());
            b.setTurn(2);
            return b.getPlayer2();
        }else {
            //Add one mana to P2
            if(b.getMaxmana2()>10){
                b.setMaxmana2(10);
                b.setMana2(10);
            }
            else {
                b.setMaxmana2(b.getMaxmana2() + 1);
                b.setMana2(b.getMaxmana2());
            }
            //Set turn to P1
            monsterFieldService.setAllAttack(b.getPlayer1().getMonsterField());
            b.setTurn(1);
            return b.getPlayer1();
        }
    }

    public boolean isValidTurn(Player p, Board b){
        //if player1
        int turn = b.getTurn();
        if(p.equals(b.getPlayer1()) && turn == 1){
            return true;
        }
        else if(p.equals(b.getPlayer2()) && turn == 2){
            return true;
        }
        return false;
    }




    //Set the new remaining mana.
    //Return the remaining mana.
    public int usedMana(Board game,int pNum,int manaCost){
        if(pNum==1){
            game.setMana1(game.getMana1()-manaCost);
            return game.getMana1();
        }else {
            game.setMana2(game.getMana2()-manaCost);
            return game.getMana2();
        }

    }

    public boolean isGameEnd(Board game){
        if((game.getPlayer1().getMonsterField().getPlayer().getHp() == 0 ||
                game.getPlayer2().getMonsterField().getPlayer().getHp() == 0)){
            game.setGameIsOver(true);
            return true;
        }
        if(game.isGameIsOver()){
            return true;
        }
        return false;
    }

    private void gameEnd(Board game){
        TempMonster p1 = game.getPlayer1().getMonsterField().getPlayer();
        TempMonster p2 = game.getPlayer2().getMonsterField().getPlayer();
        User winner = null;
        User loser = null;
        //player 1 lost
        if(p1.getHp() <= 0){
            winner = userRepository.findById(game.getPlayer1().getPlayerId()).orElse(null);
            loser = userRepository.findById(game.getPlayer2().getPlayerId()).orElse(null);
        }
        else if(p2.getHp() <= 0){
            winner = userRepository.findById(game.getPlayer2().getPlayerId()).orElse(null);
            loser = userRepository.findById(game.getPlayer1().getPlayerId()).orElse(null);
        }
        if(winner != null && loser != null) {
            winner.setElo(winner.getElo() + 20);
            loser.setElo(loser.getElo() - 10);
            userRepository.save(winner);
            userRepository.save(loser);
            BoardDB ended = boardDBRepository.findByPlayer1OrPlayer2(game.getPlayer1().getPlayerId(),game.getPlayer1().getPlayerId());
            runningGameService.removeGame(ended.getBoardId());
            boardDBRepository.delete(ended);
            System.out.println("Successfully remove game");
        }
        //rage quit
        else{
            BoardDB ended = boardDBRepository.findByPlayer1OrPlayer2(game.getPlayer1().getPlayerId(),game.getPlayer1().getPlayerId());
            runningGameService.removeGame(ended.getBoardId());
            boardDBRepository.delete(ended);
        }
        //player 2 lost
    }

    public boolean gameEndHandler(Board b){
        if(isGameEnd(b)){
            gameEnd(b);
            return true;
        }
        return false;
    }


    //Return True if player is legitimate for using this card

    public  boolean canPlayThisCard(Board game, Card card, Player p){
        //Check if it's the player turn.
        if(isValidTurn(p,game)){
            //Check if the player have enough mana
            int playerNum = getPlayerNum(game,p);
            if(playerNum==1){
                return (game.getMana1()-card.getCost())>=0;
            }else{
                return (game.getMana2()-card.getCost())>=0;
            }
        }else {
            //Not a player turn
            return false;
        }
    }

    public int getPlayerNum(Board b,Player p){
        if(p.getPlayerId() == b.getPlayer1().getPlayerId()){
            return 1;
        }else {
            return 2;
        }
    }

    public Player getPlayer(long playerId, Board game){
        if(playerId == game.getPlayer1().getPlayerId()){
            return game.getPlayer1();
        }
        else if(playerId == game.getPlayer2().getPlayerId()){
            return game.getPlayer2();
        }
        else{
            return null;
        }
    }

    public Integer getMaxMana(long playerId, Board game){
        if(playerId == game.getPlayer1().getPlayerId()){
            return game.getMaxmana1();
        }
        else if(playerId == game.getPlayer2().getPlayerId()){
            return game.getMaxmana2();
        }
        else{
            return null;
        }
    }

    public Integer getCurrentMana(long playerId, Board game){
        if(playerId == game.getPlayer1().getPlayerId()){
            return game.getMana1();
        }
        else if(playerId == game.getPlayer2().getPlayerId()){
            return game.getMana2();
        }
        else{
            return null;
        }
    }

    public Player getEnemeyPlayer(long playerId, Board game){
        if(playerId == game.getPlayer1().getPlayerId()){
            return game.getPlayer2();
        }
        else if(playerId == game.getPlayer2().getPlayerId()){
            return game.getPlayer1();
        }
        else{
            return null;
        }
    }

}
