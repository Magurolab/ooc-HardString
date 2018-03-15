package hard.string.entity;

import hard.string.entity.cards.Monster.Monster;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//TODO Get Update every turn?
@Entity
public class Board {

    @Id
    @GeneratedValue
    private Player p1;
    private Player p2;
    private int mana1;
    private int mana2;
    private int turn; //1 for Player1, 2 Player2
    static boolean gameIsOver;

//    public Board(Player p1,Player p2){
//        this.p1 = p1;
//        this.p2 = p2;
//    }


    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
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

    public static boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public void setMana1(int mana1) {
        this.mana1 = mana1;
    }

    public void setMana2(int mana2) {
        this.mana2 = mana2;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public static void setGameIsOver(boolean gameIsOver) {
        Board.gameIsOver = gameIsOver;
    }
}
