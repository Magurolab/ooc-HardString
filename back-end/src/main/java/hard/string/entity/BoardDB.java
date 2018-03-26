package hard.string.entity;

import javax.persistence.*;

@Entity
public class BoardDB {

    @Id
    @GeneratedValue
    private long boardId;

    private Long player1;

    private Long player2;

    public void setPlayer2(Long player2) {
        this.player2 = player2;
    }

    public void setPlayer1(Long player1) {
        this.player1 = player1;
    }

    public long getBoardId() {
        return boardId;
    }

    public Long getPlayer1() {
        return player1;
    }

    public Long getPlayer2() {
        return player2;
    }
}
