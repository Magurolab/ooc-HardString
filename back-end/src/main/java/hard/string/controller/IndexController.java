package hard.string.controller;

import hard.string.dto.RoomWithProfileDto;
import hard.string.entity.Room;
import hard.string.entity.User;
import hard.string.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/17/2018.
 */

@RestController
public class IndexController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = {"/room"})
    public ResponseEntity displayRooms(){
        Iterable<Room> roomsIterable =  roomRepository.findAll();
        List<RoomWithProfileDto> rooms = new ArrayList<>();

        for (Room c : roomsIterable) {
            rooms.add(new RoomWithProfileDto(c));
        }

        return ResponseEntity.ok(rooms);
    }


}
