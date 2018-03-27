package hard.string.entity.cards.Monster;

import hard.string.entity.cards.Card;
//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Teama on 3/10/2018.
 */
@Entity
public class Monster {

    /**
     * Todo
     * What will monster have? attribute, attack, etc.
     */
    @Id
    private Integer id;
    private String name;
    private Integer cost, maxHP ,atk;
    private boolean taunt;
    private boolean charge;


//    public Monster(Integer cost, Integer hp, Integer atk, Integer id, boolean taunt, boolean canAttack) {
//        this.cost = cost;
//        this.hp = hp;
//        this.atk = atk;
//        this.id = id;
//        this.taunt = taunt;
//        this.canAttack = canAttack;
//
//    }


    public String getName() {
        return name;
    }


    public Integer getCost() {
        return cost;
    }

    public Integer getId() {
        return id;
    }





    public int getAtk() {
        return atk;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }


    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public boolean isTaunt() {
        return taunt;
    }


    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }
}
