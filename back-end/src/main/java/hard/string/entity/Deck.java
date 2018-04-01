package hard.string.entity;


import hard.string.entity.cards.Card;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue
    private Long deckId;

    @ManyToMany
    @JoinTable(name="deck2cards",
        joinColumns = @JoinColumn(name="deckId"),
        inverseJoinColumns = @JoinColumn(name="cardId"))
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }
}
