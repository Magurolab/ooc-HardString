package hard.string.entity;


import hard.string.entity.cards.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deck {

    @Id
    @GeneratedValue
    private Long deckId;

    private Card cardId;

}
