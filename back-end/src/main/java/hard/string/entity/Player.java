package hard.string.entity;

import hard.string.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//Player profile in game
@Entity
@Table(name = "player")
public class Player{
//    @OneToOne
//    @JoinColumn(name = "user_id")
    @Id
    @Column(name = "player_userID")
    private long userID;

    @Column(name = "player_deckID")
    private long deckID;

    @Column(name = "player_tempDeckID")
    private long tempDeckID;
    @OneToOne(mappedBy = "tempDeckOwner")
    private TempDeck tempDeck;


    @Column(name = "player_tempHandID")
    private long tempHandID;
    @OneToOne(mappedBy = "tempHandOwner")
    private TempHand tempHand;


    @Column(name = "player_tempMonsterID")
    private long tempMonsterID;
    @OneToOne(mappedBy = "tempMonstersOwner")
    private TempMonsters tempMonsters;

    @Column(name = "player_active_taunt")
    private int activeTaunt;


    @Column(name = "player_username")
    private String username;


//    @Column(name = "player_num_card_hold")
//    private int numCard;
//
//    @Column(name = "player_num_card_on_field")
//    private int numCardOnField;


//    private Stack<Card> deck ;
//    private List<Card> hand;
//    private EntityManager entityManager;


    @Autowired
    private TempMonstersRepository tempMonstersRepository;

    @Autowired
    private UserRepository userReposity;
//    private User user;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private DeckRepository deckRepository;

    public Player() {
    }

    public int getActiveTaunt() {
        return activeTaunt;
    }

    public void setActiveTaunt(int activeTaunt) {
        this.activeTaunt = activeTaunt;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getDeckID() {
        return deckID;
    }

    public void setDeckID(long deckID) {
        this.deckID = deckID;
    }

    public long getTempDeckID() {
        return tempDeckID;
    }

    public void setTempDeckID(long tempDeckID) {
        this.tempDeckID = tempDeckID;
    }

    public TempDeck getTempDeck() {
        return tempDeck;
    }

    public void setTempDeck(TempDeck tempDeck) {
        this.tempDeck = tempDeck;
    }

    public long getTempHandID() {
        return tempHandID;
    }

    public void setTempHandID(long tempHandID) {
        this.tempHandID = tempHandID;
    }

    public TempHand getTempHand() {
        return tempHand;
    }

    public void setTempHand(TempHand tempHand) {
        this.tempHand = tempHand;
    }

    public long getTempMonsterID() {
        return tempMonsterID;
    }

    public void setTempMonsterID(long tempMonsterID) {
        this.tempMonsterID = tempMonsterID;
    }

    public TempMonsters getTempMonsters() {
        return tempMonsters;
    }

    public void setTempMonsters(TempMonsters tempMonsters) {
        this.tempMonsters = tempMonsters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TempMonstersRepository getTempMonstersRepository() {
        return tempMonstersRepository;
    }

    public void setTempMonstersRepository(TempMonstersRepository tempMonstersRepository) {
        this.tempMonstersRepository = tempMonstersRepository;
    }

    public UserRepository getUserReposity() {
        return userReposity;
    }

    public void setUserReposity(UserRepository userReposity) {
        this.userReposity = userReposity;
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public DeckRepository getDeckRepository() {
        return deckRepository;
    }

    public void setDeckRepository(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    //    public void initDeck(){
//
//        List<Card> cards = deckRepository.findByDeckId(idDeck);
//        deck.addAll(cards);
//
//        Collections.shuffle(this.deck);
//    }









}
