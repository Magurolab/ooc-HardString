package hard.string.service;

import hard.string.entity.LobbyRoom;
import hard.string.repository.LobbyRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/19/2018.
 */

@Service
public class LobbyRoomService {

    @Autowired
    private LobbyRoomRepository lobbyRoomRepository;

    public boolean addUser(LobbyRoom lobbyRoom, Long userId){
        Long userOne = lobbyRoom.getUser1();
        if(userOne<0){
            lobbyRoom.setUser1(userId);
            return true;
        }
        Long userTwo = lobbyRoom.getUser2();
        if(userTwo<0){
            lobbyRoom.setUser2(userId);
            return true;
        }
        return false;
    }

    public boolean closeRoom(LobbyRoom lobbyRoom){
        //remove player from lobbyRoom first.
        lobbyRoom.setUser1(0);
        lobbyRoom.setUser2(0);
        lobbyRoomRepository.delete(lobbyRoom);
        return true;
    }
}
