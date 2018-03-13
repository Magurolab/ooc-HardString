package hard.string.entity.cards.Monster;

import hard.string.entity.cards.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue

    private String name;
    private Integer cost, hp ,atk;
    private Integer id;
    private boolean taunt;
    private boolean canAttack;

    public Monster(Integer cost, Integer hp, Integer atk, Integer id, boolean taunt, boolean canAttack) {
        this.cost = cost;
        this.hp = hp;
        this.atk = atk;
        this.id = id;
        this.taunt = taunt;
        this.canAttack = canAttack;
    }

    @Override
    public String getName() {
        return name;
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

    public void setAttack(boolean canAttack){
        this.canAttack = canAttack;
    }
    public boolean isTaunt(){
        return this.taunt;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public boolean isDead(){
        return hp<=0;
    }

    public void getDamage(int dmg){
        this.hp -= dmg;
    }

    public void increaseAtk(int buff){
        this.atk += buff;
    }




}
