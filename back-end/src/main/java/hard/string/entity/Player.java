package hard.string.entity;

import hard.string.entity.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Player {
    private long idUser;
    private long idDeck;
    private String username;
    private Stack<Card> deck ;
    private List<Card> hand;


    public  Player(User user){
        this.idUser = user.getIduser();
        this.idDeck = user.getIdDeck();
        this.username = user.getUsername();
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
        Stack<Integer> m = new Stack<>();
        Collections.shuffle(m);
//        a.remove(a.size());
    }

    public void initDeck(){
        //TODO get data from database to build a deck

        //Stack<Card> deck = new Stack<>();
        //TODO create obj card and add to stack
        Collections.shuffle(this.deck);
        //hope that we got a random order deck
    }



}
