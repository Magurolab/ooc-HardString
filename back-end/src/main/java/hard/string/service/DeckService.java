package hard.string.service;

import hard.string.entity.Deck;
import hard.string.entity.cards.Card;
import hard.string.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Deck customDeck(){
        Deck d = new Deck();
        Iterable<Card> allCards = cardRepository.findAll();
        for(Card c:allCards){
            d.getCards().add(c);
        }
        return d;
    }
}
