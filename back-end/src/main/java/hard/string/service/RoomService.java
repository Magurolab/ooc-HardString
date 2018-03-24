package hard.string.service;

import hard.string.entity.Room;
import hard.string.entity.User;
import hard.string.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/19/2018.
 */

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public boolean addUser(Room room, Long userId){
        Long userOne = room.getUser1();
        if(userOne<0){
            room.setUser1(userId);
            return true;
        }
        Long userTwo = room.getUser2();
        if(userTwo<0){
            room.setUser2(userId);
            return true;
        }
        return false;
    }
}
