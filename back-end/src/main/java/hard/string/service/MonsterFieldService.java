package hard.string.service;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import hard.string.entity.MonsterField;
import hard.string.entity.TempMonster;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/26/2018.
 */

@Service
public class MonsterFieldService {

    public TempMonster getMonster(int index, MonsterField monsterField){
        switch(index){
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
                return null;
        }
    }
}
