package hard.string.entity.cards.Magic;

import hard.string.entity.cards.Card;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

/**
 * Created by Teama on 3/10/2018.
 */
public class Magic implements Card {

    @Id
    @GeneratedValue
    private String name;
    private Integer cost;
    private Integer id;

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
}
