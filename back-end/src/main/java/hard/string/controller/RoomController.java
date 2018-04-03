package hard.string.controller;

import hard.string.dto.RoomDto;
import hard.string.entity.LobbyRoom;
import hard.string.repository.LobbyRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

/**
 * Created by Teama on 3/29/2018.
 */

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private LobbyRoomRepository lobbyRoomRepository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity room(
            @RequestParam Long userId
    ){
        LobbyRoom room = lobbyRoomRepository.findByRoomId(userId);
        return ResponseEntity.ok().body("replace this with something useful");
    }

    @RequestMapping(method = RequestMethod.POST, value = "ready")
    public ResponseEntity ready(
            @RequestParam Long userId,
            @RequestParam Long roomId
    )
    {
    //        LobbyRoom room = lobbyRoomRepository.findByRoomId(roomId);
    //        return ResponseEntity.ok(new RoomDto())
        return ResponseEntity.ok().body("mah");
    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/start")
//    public ResponseEntity startGame(
//            @RequestParam Long user1,
//            @RequestParam Long user2,
//            @RequestParam Long roomId
//    )
}
