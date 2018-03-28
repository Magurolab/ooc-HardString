package hard.string.controller;

import hard.string.dto.RoomDto;
import hard.string.entity.LobbyRoom;
import hard.string.repository.LobbyRoomRepository;
import hard.string.service.LobbyRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/17/2018.
 */

@RestController
public class LobbyController {

    @Autowired
    private LobbyRoomRepository lobbyRoomRepository;

    @Autowired
    private LobbyRoomService lobbyRoomService;

    @GetMapping(value = "/lobby")
    public ResponseEntity displayRooms(
            @RequestParam Long userId
    ) {
        //user is in the room
        LobbyRoom inLobbyRoom = lobbyRoomRepository.findByUser1OrUser2(userId,userId);
        if(inLobbyRoom !=null){
            //player is already in the room redirect??
            return ResponseEntity.ok().body("d");
        }
        else {
            Iterable<LobbyRoom> roomsIterable = lobbyRoomRepository.findAll();
            List<RoomDto> rooms = new ArrayList<>();
            for (LobbyRoom c : roomsIterable) {
                rooms.add(new RoomDto(c));
            }
            return ResponseEntity.ok(rooms);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/lobby"}, params = {"roomId", "userId"})
    public ResponseEntity joinRoom(
            @RequestParam Long roomId,
            @RequestParam Long userId
    ) {
        LobbyRoom selectedLobbyRoom = lobbyRoomRepository.findByRoomId(roomId);
        boolean addSuccess = lobbyRoomService.addUser(selectedLobbyRoom,userId);
        if(addSuccess) {
            lobbyRoomRepository.save(selectedLobbyRoom);
            return ResponseEntity.ok(new RoomDto(selectedLobbyRoom));
        }
        else{
            return ResponseEntity.badRequest().body("Join room fail");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/lobby"} , params = {"userId"})
    public ResponseEntity createRoom(
            @RequestParam Long userId
    ){
        LobbyRoom newLobbyRoom = new LobbyRoom();
        newLobbyRoom.setUser1(userId);
        newLobbyRoom.setPlaying(false);
        lobbyRoomRepository.save(newLobbyRoom);
        //redirect player to the room he creates
        return ResponseEntity.ok(new RoomDto(newLobbyRoom));
    }


}
