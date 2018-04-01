package hard.string.service;


import hard.string.entity.Board;
import hard.string.entity.Player;
import hard.string.entity.cards.Card;
import org.springframework.beans.factory.annotation.Autowired;
import hard.string.entity.TempMonster;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private TempMonsterService tempMonstersService = new TempMonsterService();
    @Autowired
    private MonsterFieldService monsterFieldService = new MonsterFieldService();

    public boolean fight(Player pA ,Player pB, TempMonster mA,TempMonster mB,int indexA,int indexB) {

        if (pA.getPlayerId() != pB.getPlayerId()) {
            //if player try to attack monster on the same side, we'll not allow that
            if (pA.getActiveTaunt() == 0 || mB.isTaunt()) {
                //doing an attack
                tempMonstersService.takeDamage(mA, mB.getAtk());
//                monA hp -= monB atk
                tempMonstersService.takeDamage(mB, mA.getAtk());
//                monB hp -= monA atk
                if (tempMonstersService.isDead(mA)) {
                    //remove monster if it dead
                    monsterFieldService.setMonster(indexA,pA.getMonsterField(),null);
//                    a.remove(mA);
                } else {
                    //make monster cannot attack twice in a turn
                    mA.setCanAttack(false);
                }
                if (tempMonstersService.isDead(mB)) {
                    //remove monster if it dead
                    monsterFieldService.setMonster(indexB,pB.getMonsterField(),null);
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
            b.setMana1(b.getMana1()+1);
            //Set turn to P2
            b.setTurn(2);
            return b.getPlayer2();
        }else {
            //Add one mana to P2
            b.setMana2(b.getMana2()+1);
            //Set turn to P1
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




    //TODO Ask them if they prefer integer or object as player argument.(if obj, put mana in Player)(Not possible if Player is not Entity)
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

    public void isGameEnd(Board game){
        if(game.getPlayer1().getMonsterField().getPlayer().getHp() == 0 ||
                game.getPlayer2().getMonsterField().getPlayer().getHp() == 0){
            game.setGameIsOver(true);
        }
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
