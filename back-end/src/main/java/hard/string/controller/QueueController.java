package hard.string.controller;

import hard.string.component.PlayerQueue;
import hard.string.entity.Board;
import hard.string.entity.BoardDB;
import hard.string.repository.BoardDBRepository;
import hard.string.repository.UserRepository;
import hard.string.response.ResponseQueue;
import hard.string.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teama on 4/3/2018.
 */

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardDBRepository boardDBRepository;

    @Autowired
    private PlayerQueue playerQueue = PlayerQueue.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity queue(
            @RequestParam Long userId
    ){
        BoardDB boardDB = null;
        boardDB = boardDBRepository.findByPlayer1OrPlayer2(userId, userId);
        System.out.println("catch exception");
        if(boardDB == null){
            return ResponseEntity.ok().body(new ResponseQueue());
        }
        else{
            return ResponseEntity.ok().body(new ResponseQueue("Found game!",true));
        }
    }

}
