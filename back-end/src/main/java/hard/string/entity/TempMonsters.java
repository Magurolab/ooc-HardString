package hard.string.entity;


import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;

import javax.persistence.*;

@Entity
@Table(name = "temp_monsters")
public class TempMonsters {
    //Exclusive for each player

    @OneToOne
    @JoinColumn(name = "temp_monsters_owner")
    private Player tempMonstersOwner;


    @Id
    @Column(name = "temp_monsters_index")
    private int index;

//    @OneToOne
//    @JoinColumn(name = "temp_monsters_monster") //Join with Temp_deck
//    private Monster monster;

//    private Monster p;
//    private Monster m0;
//    private Monster m1;
//    private Monster m2;
//    private Monster m3;
//    private Monster m4;

    //OR
//    @Id
//    //Get from tempDeck
//    private int id;

    @Column(name ="temp_monsters_name")
    private String name;
    @Column(name ="temp_monsters_cost")
    private int cost;
    @Column(name ="temp_monsters_hp")
    private int hp;
    @Column(name ="temp_monsters_max_hp")
    private int maxHP;
    @Column(name ="temp_monsters_atk")
    private int atk;
    @Column(name ="temp_monsters_taunt")
    private boolean taunt;
    @Column(name ="temp_monsters_can_attack")
    private boolean canAttack;
    @Column(name = "temp_monster_dead")
    private boolean isDead;

    public TempMonsters() {
    }

    public Player getTempMonsterOwner() {
        return tempMonstersOwner;
    }

    public void setTempMonsterOwner(Player tempMonsterOwner) {
        this.tempMonstersOwner = tempMonsterOwner;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public boolean isCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }
}
