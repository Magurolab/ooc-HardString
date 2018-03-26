package hard.string.service;


import hard.string.entity.Board;
import hard.string.entity.Player;
import hard.string.entity.TempMonsters;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonstersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  TempMonstersRepository tempMonstersRepository;





    //TODO Return values of both the monster (What else??)
    //[0] == monsterA
    //[1] == monsterB

    //[x][] == {health,atk,?isDead?}

    public boolean fight(int pIdA ,int pIdB, int mIndexA,int mIndexB){

        TempMonstersService tempMonstersService = new TempMonstersService();

        Player pA = playerRepository.findDistinctByUserID(pIdA);
        Player pB = playerRepository.findDistinctByUserID(pIdB);
        TempMonsters mA  = tempMonstersRepository.findDistinctByIndexAndTempMonsterOwner(mIndexA,pA);
        TempMonsters mB = tempMonstersRepository.findDistinctByIndexAndTempMonsterOwner(mIndexB,pB);

        if(pIdA != pIdB){
            //if player try to attack monster on the same side, we'll not allow that


            if(pA.getActiveTaunt() == 0 || mB.isTaunt()){
                //doing an attack
                tempMonstersService.takeDamage(mA,mB.getAtk());
//                monA hp -= monB atk
                tempMonstersService.takeDamage(mB,mA.getAtk());
//                monB hp -= monA atk
                if(tempMonstersService.isDead(mA)){
                    //remove monster if it dead
                    tempMonstersRepository.delete(mA);
//                    a.remove(mA);
                }
                else{
                    //make monster cannot attack twice in a turn
                    mA.setCanAttack(false);
                }
                if(tempMonstersService.isDead(mB)){
                    //remove monster if it dead
                    tempMonstersRepository.delete(mB);
//                    b.remove(mB);
                }

            }
            else{
                //cannot attack since taunt is on the field
                return false;
            }
        }
        else{
            //cannot attack
            return false;
        }
        tempMonstersRepository.save(mA);
        tempMonstersRepository.save(mB);
//        return new int[][] {{mA.getHp(),mA.getAtk()},{mB.getHp(),mB.getAtk()}};
        return true;
    }



    //Switch turn
    //Return Player legitimate for playing cards
    //TODO Ask if they want names or object or username
    public  Player endTurn(Board b){
        if(b.getTurn() ==1){
            Player p2 = playerRepository.findDistinctByUserID(b.getP2ID());
            //Add one mana to P1
            b.setMana1(b.getMana1()+1);
            //Set turn to P2
            b.setTurn(2);
            return p2;
        }else {
            Player p1 = playerRepository.findDistinctByUserID(b.getP1ID());
            //Add one mana to P2
            b.setMana2(b.getMana2()+1);
            //Set turn to P1
            b.setTurn(1);

            return p1;
        }

    }





    //TODO Ask them if they prefer integer or object as player argument.(if obj, put mana in Player)(Not possible if Player is not Entity)
    //Set the new remaining mana.
    //Return the remaining mana.
    public  int usedMana(Board b,int pNum,int manaCost){
        if(pNum==1){
            b.setMana1(b.getMana1()-manaCost);
            return b.getMana1();
        }else {
            b.setMana2(b.getMana2()-manaCost);
            return b.getMana2();
        }
    }


    //Return True if player is legitimate for using this card
    public  boolean canPlayThisCard(Board b,int pNum,int manaCost){
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
