package hard.string.service;

import hard.string.entity.Deck;
import hard.string.entity.TempDeck;
import hard.string.entity.TempHand;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by Teama on 3/28/2018.
 */

@Service
public class TempDeckService {

    public TempDeck makeTempDeck(Deck d){
        TempDeck td = new TempDeck();
        td.setCards(new Stack<>());
        td.getCards().addAll(d.getCards());
        Collections.shuffle(td.getCards());
        return td;
    }
}
