package hard.string.entity;

import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Player{
    private long idUser;
    private long idDeck;
    private String username;
    private Stack<Card> deck ;
    private List<Card> hand;
    private EntityManager entityManager;

    public Stack<Card> getDeck() {
        return deck;
    }

    @Autowired
    private MonsterFieldRepository monsterFieldRepository;

    @Autowired
    private UserRepository userReposity;
//    private User user;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private DeckRepository deckRepository;



    public  Player(User user){
//        this.user = user;
        this.idUser = user.getIduser();
        this.idDeck = user.getIdDeck();
        this.username = user.getUsername();
        this.deck = new Stack<>();
        this.hand = new ArrayList<>();
//        Stack<Integer> m = new Stack<>();
//        Collections.shuffle(m);
//        a.remove(a.size());
    }



    public void initDeck(){

        List<Card> cards = deckRepository.findByDeckId(idDeck);
        deck.addAll(cards);

        Collections.shuffle(this.deck);
    }

    public



}
