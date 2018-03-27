package hard.string.entity;


import hard.string.entity.cards.Card;

import java.util.List;

public class TempHand {

    private List<Card> hand;

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }
}
