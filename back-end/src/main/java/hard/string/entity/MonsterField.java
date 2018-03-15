package hard.string.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hard.string.entity.cards.Monster.Monster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
public class MonsterField {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private List<Monster> field;
    //TODO Chaged to static array for position manipulation.
    private int tauntNum;
    private final int MAXCARD = 6; //1 Player 5 Monster




    public MonsterField() {
        this.field = new ArrayList<>();
        tauntNum = 0;
    }

    public boolean addMonster(Monster monster){
        if(field.size()<=MAXCARD){
            field.add(monster);
            if(monster.isTaunt()){
                tauntNum++;
            }
            return true;
        }
        else {
            //ลงไม่ได้
            return false;
        }
    }
    public void remove(Monster monster){
        if(monster.isTaunt()){
            tauntNum--;
        }
        field.remove(monster);
    }

    public int getTauntNum(){
        return tauntNum;
    }


//    @Column(name = "UserName", length = 100)


}
