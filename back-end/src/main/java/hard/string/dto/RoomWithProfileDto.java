package hard.string.dto;

import hard.string.entity.Room;

/**
 * Created by Teama on 3/17/2018.
 */
public class RoomWithProfileDto {

    private Long roomId;

    private Integer size;

    public Integer getSize() {
        return size;
    }

    public Long getRoomId() {
        return roomId;
    }

    public RoomWithProfileDto(Room room){
        this.roomId = room.getRoomId();
        int count = 0;
        if(room.getUser1()>0){
            count++;
        }
        if(room.getUser2()>0){
            count++;
        }
        this.size = count;
    }
}
