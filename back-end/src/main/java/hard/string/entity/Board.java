package hard.string.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Teama on 3/25/2018.
 */

@Component
public class Board {

    private int mana1;
    private int mana2;

    private int maxmana1;
    private int maxmana2;

    private Player player1;

    private Player player2;

    private int turn; //1 for Player1, 2 Player2
    private boolean gameIsOver;

    public int getTurn() {
        return turn;
    }

    public int getMana2() {
        return mana2;
    }

    public int getMana1() {
        return mana1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setMana2(int mana2) {
        this.mana2 = mana2;
    }

    public void setMana1(int mana1) {
        this.mana1 = mana1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public int getMaxmana1() {
        return maxmana1;
    }

    public int getMaxmana2() {
        return maxmana2;
    }

    public void setMaxmana1(int maxmana1) {
        this.maxmana1 = maxmana1;
    }

    public void setMaxmana2(int maxmana2) {
        this.maxmana2 = maxmana2;
    }
}
