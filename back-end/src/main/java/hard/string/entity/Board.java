package hard.string.entity;

import hard.string.entity.cards.Monster.Monster;

import javax.persistence.*;


//TODO Get Update every turn?
@Entity
@Table(name = "board")
public class Board {

    @Id
    @Column(name ="board_id")
    @GeneratedValue
    private long b_id;

//    @Transient
    @Column(name = "board_p1ID")
    private long p1ID;
    @Column(name = "board_p2ID")
    private long p2ID;

//    @OneToOne
//    @JoinColumn(name = "board_player_1")
//    private Player p1;
//
//    @OneToOne
//    @JoinColumn(name = "board_player_2")
//    private Player p2;

    @Column(name = "board_mana1")
    private int mana1;
    @Column(name = "board_mana2")
    private int mana2;
    @Column(name = "board_turn")
    private int turn; //1 for Player1, 2 Player2
    @Column(name = "board_gameIsOver")
    static boolean gameIsOver;

    public Board() {
    }



    public long getB_id() {
        return b_id;
    }

    public long getP1ID() {
        return p1ID;
    }

    public long getP2ID() {
        return p2ID;
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

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setP1ID(int p1ID) {
        this.p1ID = p1ID;
    }

    public void setP2ID(int p2ID) {
        this.p2ID = p2ID;
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
