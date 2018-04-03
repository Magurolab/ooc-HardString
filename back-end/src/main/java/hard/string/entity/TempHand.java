package hard.string.entity;


import hard.string.entity.cards.Card;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TempHand {

    private List<Card> hand;

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }
}
