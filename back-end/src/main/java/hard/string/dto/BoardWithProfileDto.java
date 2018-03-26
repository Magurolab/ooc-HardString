package hard.string.dto;

import hard.string.entity.*;
import hard.string.repository.BoardDBRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Teama on 3/25/2018.
 */
public class BoardWithProfileDto {

    private int mana1;
    private int mana2;

    private long player1;
    private MonsterField field1;
    private TempHand tempHand1;
    private long deck1;
    private String username1;

    private long player2;
    private MonsterField field2;
    private int tempHand2;
    private long deck2;
    private String username2;

    private int turn;
    private boolean gameOver;


    public BoardWithProfileDto(Board board, Player currentPlayer, Player enemyPlayer){
        mana1 = board.getMana1();
        mana2 = board.getMana2();
        player1 = currentPlayer.getPlayerId();
        player2 = enemyPlayer.getPlayerId();
        field1 = currentPlayer.getMonsterField();
        field2 = enemyPlayer.getMonsterField();
        tempHand1 = currentPlayer.getTempHand();
        tempHand2 = enemyPlayer.getTempHand().getHand().size();
        deck1 = currentPlayer.getTempDeck().getCards().size();
        deck2 = enemyPlayer.getTempDeck().getCards().size();
        username1 = currentPlayer.getUsername();
        username2 = enemyPlayer.getUsername();
        turn = board.getTurn();
        gameOver = board.isGameIsOver();
    }

    public int getMana1() {
        return mana1;
    }

    public int getMana2() {
        return mana2;
    }

    public int getTurn() {
        return turn;
    }

    public long getPlayer2() {
        return player2;
    }

    public long getPlayer1() {
        return player1;
    }

    public int getTempHand2() {
        return tempHand2;
    }

    public long getDeck1() {
        return deck1;
    }

    public long getDeck2() {
        return deck2;
    }

    public MonsterField getField1() {
        return field1;
    }

    public MonsterField getField2() {
        return field2;
    }

    public String getUsername1() {
        return username1;
    }

    public String getUsername2() {
        return username2;
    }

    public TempHand getTempHand1() {
        return tempHand1;
    }
}

