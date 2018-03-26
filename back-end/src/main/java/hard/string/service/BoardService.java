package hard.string.service;


import hard.string.entity.Board;
import hard.string.entity.BoardDB;
import hard.string.entity.Player;
import hard.string.entity.TempMonster;
import org.springframework.stereotype.Service;

@Service
public class BoardService {


    //TODO Return values of both the monster (What else??)
    //[0] == monsterA
    //[1] == monsterB

    //[x][] == {health,atk,?isDead?}
    public void fight(Player pA, Player pB, TempMonster mA, TempMonster mB){

//        if(pA.getUserID() != pA.getUserID()){
//            //if player try to attack monster on the same side, we'll not allow that
//
//
//            if(pA.getActiveTaunt() == 0 || mB.isTaunt()){
//                //doing an attack
//                MonsterService.takeDamage(mA,mB.getAtk());
////                monA hp -= monB atk
//                MonsterService.takeDamage(mB,mA.getAtk());
////                monB hp -= monA atk
//                if(MonsterService.isDead(mA)){
//                    //remove monster if it dead
//                    a.remove(mA);
//                }
//                else{
//                    //make monster cannot attack twice in a turn
//                    mA.setCanAttack(false);
//                }
//                if(MonsterService.isDead(mB)){
//                    //remove monster if it dead
//                    b.remove(mB);
//                }
//
//            }
//            else{
//                //cannot attack since taunt is on the field
//            }
//        }
//        else{
//            //cannot attack
//        }
//        return new int[][] {{m1.getHp(),m1.getAtk()},{m2.getHp(),m2.getAtk()}};
//        return new int[][] {{0},{0}};

    }



    //Switch turn
    //Return Player legitimate for playing cards
    //TODO Ask if they want names or object or username
    public static Player endTurn(Board b){
//        if(b.getTurn() ==1){
//            //Add one mana to P1
//            b.setMana1(b.getMana1()+1);
//            //Set turn to P2
//            b.setTurn(2);
//            return b.getP2();
//        }else {
//            //Add one mana to P2
//            b.setMana2(b.getMana2()+1);
//            //Set turn to P1
//            b.setTurn(1);
//
//            return b.getP1();
//        }
        return null;
    }





    //TODO Ask them if they prefer integer or object as player argument.(if obj, put mana in Player)(Not possible if Player is not Entity)
    //Set the new remaining mana.
    //Return the remaining mana.
    public static int usedMana(BoardDB b, int pNum, int manaCost){
//        if(pNum==1){
//            b.setMana1(b.getMana1()-manaCost);
//            return b.getMana1();
//        }else {
//            b.setMana2(b.getMana2()-manaCost);
//            return b.getMana2();
//        }
        return 0;
    }


    //Return True if player is legitimate for using this card
    public static boolean canPlayThisCard(BoardDB b, int pNum, int manaCost){
        //Check if it's the player turn.
//        if(b.getTurn() == pNum){
//            //Check if the player have enough mana
//            if(pNum ==1){
//                return (b.getMana1()-manaCost)>=0;
//            }else{
//                return (b.getMana2()-manaCost)>=0;
//            }
//        }else {
            return false;
//        }
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
