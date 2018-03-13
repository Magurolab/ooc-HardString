package hard.string.entity.cards.Magic;

import hard.string.entity.cards.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Teama on 3/10/2018.
 */

@Entity
public class Magic implements Card {

    @Id
    @GeneratedValue
    private String name;
    private Integer cost;
    private Integer id;

    public Magic(String name, int cost){
        this.name = name;
        this.cost = cost;

    }


    /**
     * Todo
     * How would effect work? sub-class of magic card?
     * How do we keep what magic have what effect?
     */
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
        //TODO: apply the effect
    }
}
