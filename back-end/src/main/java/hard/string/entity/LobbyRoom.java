package hard.string.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Teama on 3/17/2018.
 */

@Entity
public class LobbyRoom {

    @Id
    @GeneratedValue
    private long roomId;

    private long user1;
    private long user2;
    //default 1 = true, 0 = false;
    private boolean isPlaying;

    public long getRoomId() {
        return roomId;
    }

    public long getUser1() {
        return user1;
    }

    public long getUser2() {
        return user2;
    }

    public boolean getIsPlaying(){
        return isPlaying;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public void setUser1(long user1) {
        this.user1 = user1;
    }

    public void setUser2(long user2) {
        this.user2 = user2;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
