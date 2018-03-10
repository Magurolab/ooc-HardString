package hard.string.Database.Cards.Monster;

import hard.string.Database.Cards.Card;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * Created by Teama on 3/10/2018.
 */
public class Monster implements Card {

    /**
     * Todo
     * What will monster have? attribute, attack, etc.
     */
    @Id
    @GeneratedValue
    private String name;
    private Integer cost;
    private Integer id;


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


}
