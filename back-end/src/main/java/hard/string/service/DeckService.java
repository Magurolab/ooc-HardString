package hard.string.service;

import hard.string.entity.Deck;
import hard.string.entity.cards.Card;
import hard.string.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/26/2018.
 */

@Service
public class DeckService {

    @Autowired
    private CardRepository cardRepository;

    public void addCard(Deck d, Card c){
        d.getCards().add(c);
    }
}
