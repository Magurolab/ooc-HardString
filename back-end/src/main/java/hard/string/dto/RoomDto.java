package hard.string.dto;

import hard.string.entity.LobbyRoom;
import hard.string.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Teama on 3/17/2018.
 */
public class RoomDto {

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

    private void setPlayer1(String player1) {
        this.player1 = player1;
    }

    private void setPlayer2(String player2) {
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

    public RoomDto(LobbyRoom lobbyRoom){
        this.roomId = lobbyRoom.getRoomId();
        int count = 0;
        if(lobbyRoom.getUser1()>0){
            this.setPlayer1(userService.findDuelist(lobbyRoom.getUser1()).getFirstName());
            count++;
        }
        if(lobbyRoom.getUser2()>0){
            this.setPlayer2(userService.findDuelist(lobbyRoom.getUser2()).getFirstName());
            count++;
        }
        this.size = count;
    }
}
