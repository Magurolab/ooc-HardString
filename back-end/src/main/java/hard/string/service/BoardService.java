package hard.string.service;


import hard.string.entity.Board;
import hard.string.entity.MonsterField;
import hard.string.entity.Player;
import hard.string.entity.cards.Monster.Monster;
import org.springframework.stereotype.Service;

@Service
public class BoardService {


    //TODO Return values of both the monster (What else??)
    //[0] == monsterA
    //[1] == monsterB

    //[x][] == {health,atk,?isDead?}
    public static int[][] fight(Monster monsterA, MonsterField a, Monster monsterB, MonsterField b){
        if(!a.equals(b)){
            //if player try to attack monster on the same side, we'll not allow that
            if(b.getTauntNum() == 0 || monsterB.isTaunt()){
                //doing an attack
                MonsterService.takeDamage(monsterA,monsterB.getAtk());
//                monA hp -= monB atk
                MonsterService.takeDamage(monsterB,monsterA.getAtk());
//                monB hp -= monA atk
                if(MonsterService.isDead(monsterA)){
                    //remove monster if it dead
                    a.remove(monsterA);
                }
                else{
                    //make monster cannot attack twice in a turn
                    monsterA.setCanAttack(false);
                }
                if(MonsterService.isDead(monsterB)){
                    //remove monster if it dead
                    b.remove(monsterB);
                }

            }
            else{
                //cannot attack since taunt is on the field
            }
        }
        else{
            //cannot attack
        }
        return new int[][] {{monsterA.getHp(),monsterA.getAtk()},{monsterB.getHp(),monsterB.getAtk()}};
    }


    //Switch turn
    //Return Player legitimate for playing cards
    //TODO Ask if they want names or object or username
    public static Player endTurn(Board b){
        if(b.getTurn() ==1){
            b.setTurn(2);
            return b.getP2();
        }else {
            b.setTurn(1);
            return b.getP1();
        }

    }



    //TODO Ask them if they prefer integer or object as player argument.(if obj, put mana in Player)(Not possible if Player is not Entity)
    //Set the new remaining mana.
    //Return the remaining mana.
    public static int usedMana(Board b,int pNum,int manaCost){
        if(pNum==1){
            b.setMana1(b.getMana1()-manaCost);
            return b.getMana1();
        }else {
            b.setMana2(b.getMana2()-manaCost);
            return b.getMana2();
        }
    }


    //Return True if player is legitimate for using this card
    public static boolean canPlayThisCard(Board b,int pNum,int manaCost){
        //Check if it's the player turn.
        if(b.getTurn() == pNum){
            //Check if the player have enough mana
            if(pNum ==1){
                return (b.getMana1()-manaCost)>=0;
            }else{
                return (b.getMana2()-manaCost)>=0;
            }
        }else {
            return false;
        }
    }




















}
