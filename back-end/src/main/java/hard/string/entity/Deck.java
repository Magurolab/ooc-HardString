package hard.string.entity;


import hard.string.entity.cards.Card;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Player custom deck
@Entity
@Table(name = "deck")
public class Deck {

    @Id
    @GeneratedValue
    private long deckId;


    private long cardId;

    private int quantity;

    public Deck() {
    }

    public long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }


}
