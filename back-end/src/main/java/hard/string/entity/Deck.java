package hard.string.entity;


import hard.string.entity.cards.Card;

import javax.persistence.*;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue
    private Long deckId;

    @OneToMany(targetEntity = Card.class, mappedBy = "cardId")
    private List<Card> cards;


}
