package hard.string.service;


import hard.string.entity.Deck;
import hard.string.entity.TempDeck;
import hard.string.entity.TempHand;
import hard.string.entity.cards.Card;
import hard.string.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Service
public class TempDeckService {

    @Autowired
    DeckRepository deckRepository;

    public TempDeck initTempDeck(long deckID){
        TempDeck tempDeck  = new TempDeck();
        Deck deck = deckRepository.findDistinctByDeckId(deckID);
        Stack<Card> stack = new Stack<>();
        Collections.copy(stack,deck.getCards());
        Collections.shuffle(stack);
        tempDeck.setCards(stack);

        return tempDeck;
    }


}
