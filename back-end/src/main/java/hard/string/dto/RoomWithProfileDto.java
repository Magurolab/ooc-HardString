package hard.string.dto;

import hard.string.entity.Room;
import hard.string.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Teama on 3/17/2018.
 */
public class RoomWithProfileDto {

    @Autowired
    UserService userService;

    private Long roomId;

    private Integer size;

    private String player1;

    private String player2;

    public Integer getSize() {
        return size;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public RoomWithProfileDto(Room room){
        this.roomId = room.getRoomId();
        int count = 0;
        if(room.getUser1()>0){
            this.setPlayer1(userService.findDuelist(room.getUser1()).getFirstName());
            count++;
        }
        if(room.getUser2()>0){
            this.setPlayer2(userService.findDuelist(room.getUser2()).getFirstName());
            count++;
        }
        this.size = count;
    }
}
