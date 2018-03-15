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
public class Monster implements Card {

    /**
     * Todo
     * What will monster have? attribute, attack, etc.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer cost, hp, maxHP ,atk;
    private boolean taunt;
    private boolean canAttack;
    private String type;


//    public Monster(Integer cost, Integer hp, Integer atk, Integer id, boolean taunt, boolean canAttack) {
//        this.cost = cost;
//        this.hp = hp;
//        this.atk = atk;
//        this.id = id;
//        this.taunt = taunt;
//        this.canAttack = canAttack;
//
//    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Integer getCost() {
        return cost;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void init() {
        //TODO: extract it to the board and do some shite.
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


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
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

    public void setType(String type) {
        this.type = type;
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
