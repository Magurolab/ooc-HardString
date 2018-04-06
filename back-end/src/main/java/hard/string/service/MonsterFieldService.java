package hard.string.service;

import hard.string.entity.MonsterField;
import hard.string.entity.Player;
import hard.string.entity.TempMonster;
import hard.string.entity.cards.Monster.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/26/2018.
 */

@Service
public class MonsterFieldService {

    @Autowired
    private TempMonsterService tempMonsterService;

    public TempMonster getMonster(int index, MonsterField monsterField){
        switch(index){
            case 0:
                return monsterField.getPlayer();
            case 1:
                return monsterField.getMonster1();
            case 2:
                return monsterField.getMonster2();
            case 3:
                return monsterField.getMonster3();
            case 4:
                return monsterField.getMonster4();
            case 5:
                return monsterField.getMonster5();
            default:
                //shouldn't go here at all
                return null;
        }
    }

    public boolean checkMonster(int index, MonsterField monsterField){
        switch(index){
            case 0:
                return monsterField.getPlayer() != null;
            case 1:
                return monsterField.getMonster1() != null;
            case 2:
                return monsterField.getMonster2() != null;
            case 3:
                return monsterField.getMonster3() != null;
            case 4:
                return monsterField.getMonster4() != null;
            case 5:
                return monsterField.getMonster5() != null;
            default:
                //shouldn't go here at all
                return false;
        }
    }

    public boolean setMonster(int index, MonsterField monsterField,TempMonster tempMonster){
        switch(index){
            case 0:
                monsterField.setPlayer(tempMonster);
                return true;
            case 1:
                monsterField.setMonster1(tempMonster);
                return true;
            case 2:
                monsterField.setMonster2(tempMonster);
                return true;
            case 3:
                monsterField.setMonster3(tempMonster);
                return true;
            case 4:
                monsterField.setMonster4(tempMonster);
                return true;
            case 5:
                monsterField.setMonster5(tempMonster);
                return true;
            default:
                return false;
        }

    }

    public void setAllAttack(MonsterField monsterField){
        if(checkMonster(1,monsterField)){
            monsterField.getMonster1().setCanAttack(true);
        }
        if(checkMonster(2,monsterField)){
            monsterField.getMonster2().setCanAttack(true);
        }
        if(checkMonster(3,monsterField)){
            monsterField.getMonster3().setCanAttack(true);
        }
        if(checkMonster(4,monsterField)){
            monsterField.getMonster4().setCanAttack(true);
        }
        if(checkMonster(5,monsterField)){
            monsterField.getMonster5().setCanAttack(true);
        }
    }

    public MonsterField initMonsterField(String name){
        MonsterField monsterField = new MonsterField();
        for(int i = 0; i<7;i++){
            setMonster(i,monsterField,null);
        }
        monsterField.setPlayer(tempMonsterService.createPlayer(name));
        return monsterField;
    }

    public  boolean addMonster(Player player,long cardId,int index){
        MonsterField monsterField = player.getMonsterField();
        TempMonster tempMonster = tempMonsterService.createTempMonster(cardId);
        tempMonster.setIndex(index);
        //If taunt add counter in Player
        if(tempMonster.isTaunt()){
            player.setActiveTaunt(player.getActiveTaunt()+1);
        }
        //Put tempMonster in field
        setMonster(index,monsterField,tempMonster);
        return true;
    }

    public boolean removeMonster(int monsterIndex, Player p){
        if(getMonster(monsterIndex,p.getMonsterField()).isTaunt()){
            System.out.println("Before monster die: " + p.getActiveTaunt());
            p.setActiveTaunt(p.getActiveTaunt()-1);
            System.out.println("After monster die: " + p.getActiveTaunt());
        }
        setMonster(monsterIndex,p.getMonsterField(),null);
        return true;
    }

}
