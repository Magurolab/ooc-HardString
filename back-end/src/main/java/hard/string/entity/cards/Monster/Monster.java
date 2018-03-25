package hard.string.entity.cards.Monster;

import hard.string.entity.cards.Card;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Teama on 3/10/2018.
 */
@Entity
@Table(name = "monster")
public class Monster extends Card {


//    @GeneratedValue()
//    private Integer id;
//    private String name;
//    private Integer cost;
    private int hp;
    private int maxHP;
    private int atk;
    private boolean taunt;
    private boolean canAttack;
//    private String type;


    public Monster() {
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public boolean canAttack(){
        return  canAttack;
    }


    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }


    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public boolean isTaunt() {
        return taunt;
    }

    public boolean isCanAttack() {
        return canAttack;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }
}
