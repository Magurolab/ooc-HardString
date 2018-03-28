package hard.string.service;

import hard.string.dto.PlayingRoomDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Teama on 3/29/2018.
 */

@Service
public class RunningRoomService {

    private Map<Long,PlayingRoomDto> rooms = new HashMap<Long,PlayingRoomDto>();

    public void addPlayingRoom(Long key, PlayingRoomDto playingRoomDto){
        rooms.put(key,playingRoomDto);
    }

    public void removePlayingRoom(Long key){
        rooms.remove(key);
    }

    public PlayingRoomDto getPlayingRoom(Long key){
        return rooms.get(key);
    }
}
