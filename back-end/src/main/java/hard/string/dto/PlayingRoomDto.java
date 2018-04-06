package hard.string.dto;

import hard.string.entity.LobbyRoom;
import hard.string.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Teama on 3/28/2018.
 */

public class PlayingRoomDto {

    private Long roomId;

    private Integer size;

    private String player1;

    private String player2;

    private boolean canStart;

    private boolean player1ready;

    private boolean player2ready;

    public String getPlayer2() {
        return player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public Long getRoomId() {
        return roomId;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isCanStart() {
        return canStart;
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

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setCanStart(boolean canStart) {
        this.canStart = canStart;
    }

    public PlayingRoomDto(LobbyRoom lobbyRoom){
//        this.roomId = lobbyRoom.getRoomId();
//        int count = 0;
//        if(lobbyRoom.getUser1()>0){
//            this.setPlayer1(userService.findDuelist(lobbyRoom.getUser1()).getFirstName());
//            count++;
//        }
//        if(lobbyRoom.getUser2()>0){
//            this.setPlayer2(userService.findDuelist(lobbyRoom.getUser2()).getFirstName());
//            count++;
//        }
//        this.size = count;
//        if(count > 1){
//            setCanStart(true);
//        }
//        else{
//            setCanStart(false);
//        }
    }

}
