package hard.string.controller;

import hard.string.dto.RoomDto;
import hard.string.entity.Room;
import hard.string.repository.RoomRepository;
import hard.string.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/17/2018.
 */

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/room")
    public ResponseEntity displayRooms() {
        Iterable<Room> roomsIterable = roomRepository.findAll();
        List<RoomDto> rooms = new ArrayList<>();
        for (Room c : roomsIterable) {
            rooms.add(new RoomDto(c));
        }
        return ResponseEntity.ok(rooms);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/room"}, params = {"roomId", "userId"})
    public ResponseEntity joinRoom(
            @RequestParam Long roomId,
            @RequestParam Long userId
    ) {
        Room selectedRoom = roomRepository.findByRoomId(roomId);
        boolean addSuccess = roomService.addUser(selectedRoom,userId);
        if(addSuccess) {
            roomRepository.save(selectedRoom);
            return ResponseEntity.ok(new RoomDto(selectedRoom));
        }
        else{
            return ResponseEntity.badRequest().body("Join room fail");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/room"} , params = {"userId"})
    public ResponseEntity createRoom(
            @RequestParam Long userId
    ){
        Room newRoom = new Room();
        newRoom.setUser1(userId);
        newRoom.setPlaying(false);
        roomRepository.save(newRoom);
        //redirect player to the room he creates
        return ResponseEntity.ok(new RoomDto(newRoom));
    }

}
