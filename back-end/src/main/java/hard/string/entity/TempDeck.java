package hard.string.entity;


import hard.string.entity.cards.Card;

import java.util.Stack;


public class TempDeck {

    private Stack<Card> cards;


    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
