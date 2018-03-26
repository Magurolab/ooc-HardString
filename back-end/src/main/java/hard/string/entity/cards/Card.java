package hard.string.entity.cards;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Teama on 3/10/2018.
 */

//TODO Do we need entity here??
public class Card {


    @Id
    @GeneratedValue
    private String cardId;

    private String name;

    private String type;

    private Integer cost;

    String getName(){
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public String getId() {
        return cardId;
    }

    public String getType() {
        return type;
    }
}
