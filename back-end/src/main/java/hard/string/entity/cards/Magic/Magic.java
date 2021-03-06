package hard.string.entity.cards.Magic;

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
public class Magic{

    @Id
    private Long id;

    private String name;
    private Integer cost;

    private int heal;
    private int dmg;
    private int atkBuff;
    private int draw;
    private boolean needTarget;
    private boolean randomEff;



    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public Long getId() {
        return id;
    }


    public int getHeal() {
        return heal;
    }

    public int getDmg() {
        return dmg;
    }

    public int getAtkBuff() {
        return atkBuff;
    }

    public int getDraw() {
        return draw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setAtkBuff(int atk) {
        this.atkBuff = atk;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public boolean isNeedTarget() {
        return needTarget;
    }

    public boolean isRandomEff() {
        return randomEff;
    }

    public void setNeedTarget(boolean needTarget) {
        this.needTarget = needTarget;
    }

    public void setRandomEff(boolean randomEff) {
        this.randomEff = randomEff;
    }




}
