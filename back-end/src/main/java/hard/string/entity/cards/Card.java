package hard.string.entity.cards;

import hard.string.entity.Deck;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/10/2018.
 */

@Entity
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @ManyToMany(mappedBy = "cards")
    private List<Deck> decks = new ArrayList<>();

    private String name;

    private String type;

    private Integer cost;

    private String path;

    public String getName(){
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public Long getId() {
        return cardId;
    }

    public String getType() {
        return type;
    }
}
