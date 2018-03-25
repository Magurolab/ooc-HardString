package hard.string.entity.cards.Magic;

import hard.string.entity.cards.Card;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by Teama on 3/10/2018.
 */

@Entity
@Table(name="magic")
public class Magic extends Card {


    //ID same as what is in Card
//    private Integer id;
//    private String name;
//    private Integer cost;
//    private String type;
    private int heal;
    private int dmg;
    private int atkBuff;
    private int draw;
    private boolean needTarget;
    private boolean randomEff;

    public Magic() {

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
