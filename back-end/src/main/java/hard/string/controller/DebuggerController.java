package hard.string.controller;

import hard.string.dto.BoardDto;
import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.repository.CardRepository;
import hard.string.repository.DeckRepository;
import hard.string.repository.UserRepository;
import hard.string.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/12/2018.
 */

@RestController
@RequestMapping("/debug")
public class DebuggerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private TempDeckService tempDeckService;

    @Autowired
    private TempMonsterService tempMonsterService;

    @Autowired
    private TempHandService tempHandService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private MonsterFieldService monsterFieldService;

    @Autowired
    private MonsterService monsterService;

    private Board board;

    /**
     * initialize fake board for debugging
     * @return board
     */

    private Board createFakeboard(){
        //assuming that user"Boat" is the currentPlayer
        User user1 = userService.addUser("Boat","1234","Boat","Doge");
        User user2 = userService.addUser("Ply","1234","Plyton","Doggo");
        user1.setDeck(deckService.customDeck());
        user2.setDeck(deckService.customDeck());
        userRepository.save(user1);
        deckRepository.save(user1.getDeck());
        userRepository.save(user2);
        deckRepository.save(user2.getDeck());
        TempHand t1 = tempHandService.initTempHand();
        TempHand t2 = tempHandService.initTempHand();
        MonsterField m1 = monsterFieldService.initMonsterField(user1.getFirstName());
        MonsterField m2 = monsterFieldService.initMonsterField(user2.getFirstName());
        Player p1 = playerService.initPlayer(user1.getIduser(),tempDeckService.makeTempDeck(user1.getDeck()),t1,m1,user1.getUsername());
        Player p2 = playerService.initPlayer(user2.getIduser(),tempDeckService.makeTempDeck(user2.getDeck()),t2,m2,user2.getUsername());
        for(int i = 0; i < 3;i++){
            playerService.drawCard(p1);
            playerService.drawCard(p2);
        }
        Board  b = new Board();
        b.setGameIsOver(false);
        b.setMana1(1);
        b.setMana2(1);
        b.setPlayer1(p1);
        b.setPlayer2(p2);
        b.setTurn(1);
        return b;
    }

    /**
     * display all registered users
     * @return list of users
     */
    @GetMapping(value = {"/displayall"})
    public ResponseEntity displayAll(){
        Iterable<User> userIterable = userRepository.findAll();

        List<User> users = new ArrayList<>();

        for (User c : userIterable) {
            users.add(c);
        }

        return ResponseEntity.ok(users);

    }

    /**
     * call this to add card to user deck
     * @param userId id of the login user
     * @return response code and updated user
     */
    @RequestMapping(method = RequestMethod.POST, value = {"/addcardtodeck"})
    public ResponseEntity addCard(
            @RequestParam long userId
    ){
        User user = userRepository.findById(userId).orElse(null);
        Card boat =  cardRepository.findById(1L).orElse(null);
        deckService.addCard(user.getDeck(),boat);
        deckService.addCard(user.getDeck(),boat);
        System.out.println(user.getDeck().getCards());
        deckRepository.save(user.getDeck());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    /**
     * call this to create fake game, do this only once
     * @return board
     */

    @RequestMapping(value = {"/fakegame"})
    public ResponseEntity fakeGame(){
        board = createFakeboard();
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()));
    }

    /**
     * display all status of the active board for debugging
     * @return board
     */

    @RequestMapping(value = {"/showboard"})
    public ResponseEntity showBoard(){
        return ResponseEntity.ok().body(board);
    }

    //call this once to create a fake board
    @RequestMapping(value = {"/playmonsterfromhand"})
    public ResponseEntity playMonsterFromHand(){
        Card gift = cardRepository.findByName("Gift");
        System.out.println("Current mana " + board.getMana1());
        board.setMana1(6);
        board.getPlayer1().getTempHand().getHand().add(gift);
        System.out.println("Current hand size " + board.getPlayer1().getTempHand().getHand().size());
        tempHandService.playCard(board,board.getPlayer1(),gift,1,true);
        System.out.println("After played " + board.getMana1());
        System.out.println("Current hand size " + board.getPlayer1().getTempHand().getHand().size());
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()));
    }

    /**
     * Set monsters for both side of the field
     * @return board
     */
    @RequestMapping(value = {"/testsetmonster"})
    public ResponseEntity testSetMonster(){
        Player p1 = board.getPlayer1();
        Player p2 = board.getPlayer2();
        Card DDosGuy = cardRepository.findByName("This guy again");
        Card gift = cardRepository.findByName("Wit");
        TempMonster m1  = tempMonsterService.createTempMonster(DDosGuy.getId());
        TempMonster m2 = tempMonsterService.createTempMonster(gift.getId());
        board.getPlayer1().getMonsterField().setMonster1(m1);
        board.getPlayer2().getMonsterField().setMonster2(m2);
        return ResponseEntity.ok(new BoardDto(board,p1,p2));
    }

    /**
     * Attempt to make monsters set by setMonster function to attack
     * @return board
     */
    @RequestMapping(value = {"/testattack"})
    public ResponseEntity testAttackMonster(){
        boardService.fight(board.getPlayer1(),board.getPlayer2(),board.getPlayer1().getMonsterField().getMonster1(),
                board.getPlayer2().getMonsterField().getMonster2(),1,2);
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()));
    }

    /**
     * End turn of the current player, this does not draw card for another player.
     * @return board
     */
    @RequestMapping(value = {"/testendturn"})
    public ResponseEntity testEndTurn(){
        boardService.endTurn(board);
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()));
    }

    /**
     * Draw card for the player of that turn
     * @return board
     */
    @RequestMapping(value = {"/testdraw"})
    public ResponseEntity testDraw(){
        int turn = board.getTurn();
        if(turn==1) {
            playerService.drawCard(board.getPlayer1());
        }
        else{
            playerService.drawCard(board.getPlayer2());
        }
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()));
    }

    /**
     * return current player mana, in this case we assume that the current player is player1
     * @return mana
     */

    @RequestMapping(method = RequestMethod.GET, value={"/currentmana"})
    public ResponseEntity getCurrentMana(
    ){
        return ResponseEntity.ok(board.getMana1());
    }

    /**
     *  return enemy player mana, in this case we assume that the enemy player is player2
     * @return mana
     */

    @RequestMapping(method = RequestMethod.GET, value={"/enemymana"})
    public ResponseEntity getEnemyMana(
    ){
        return ResponseEntity.ok(board.getMana2());
    }

    /**
     * return current player mosnterfield, in this case we assume that the current player is player1
     * @return monsterfield
     */

    @RequestMapping(method = RequestMethod.GET, value={"/currentmonsterfield"})
    public ResponseEntity getCurrentMonsterField(
    ){
        return ResponseEntity.ok(board.getPlayer1().getMonsterField());
    }

    /**
     * return enemy player monsterfield, in this case we assume that the enemy player is player2
     * @return monsterfield
     */

    @RequestMapping(method = RequestMethod.GET, value={"/enemymonsterfield"})
    public ResponseEntity getEnemyMonsterField(
    ){
        return ResponseEntity.ok(board.getPlayer2().getMonsterField());
    }

    /**
     * return current player deck.size(), in this case we assume that the current player is player1
     * @return size of deck
     */


    @RequestMapping(method = RequestMethod.GET, value={"/currentdeck"})
    public ResponseEntity getCurrentDeck(
    ){
        return ResponseEntity.ok(board.getPlayer1().getTempDeck().getCards().size());
    }

    /**
     * return enemy player deck.size(), in this case we assume that the current player is player2
     * @return size of deck
     */

    @RequestMapping(method = RequestMethod.GET, value={"/enemydeck"})
    public ResponseEntity getEnemyDeck(
    ){
        return ResponseEntity.ok(board.getPlayer2().getTempDeck().getCards().size());
    }

    /**
     * Return valid monster field to be play by current player, in this case we assume that the current player is player1
     * @return list of valid monsterfield index under our agreement
     */

    @RequestMapping(method = RequestMethod.GET, value={"/validmonsterfield"})
    public ResponseEntity getValidMonsterField(
    ){
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()).getAvailableMonsterField());
    }

    /**
     * Return valid magic target to be play by current player, in this case we assume that the current player is player1
     * @return list of valid magic target index under our agreement
     */

    @RequestMapping(method = RequestMethod.GET, value={"/validmagictaget"})
    public ResponseEntity getValidMagicTarget(
    ){
        return ResponseEntity.ok(new BoardDto(board,board.getPlayer1(),board.getPlayer2()).getAvailableMagicTarget());
    }

}
