package hard.string.controller;

import hard.string.entity.*;
import hard.string.repository.UserRepository;
import hard.string.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Teama on 4/5/2018.
 */

@RequestMapping("/ready")
public class ReadyController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TempDeckService tempDeckService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TempHandService tempHandService;

    @Autowired
    private MonsterFieldService monsterFieldService;

    @Autowired
    private PlayerQueueService playerQueueService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity ready(
            @RequestParam Long userId
    ){
        User currentUser =  userRepository.findById(userId).orElse(null);
        if(currentUser!=null) {
            TempHand tempHand = tempHandService.initTempHand();
            MonsterField monsterField = monsterFieldService.initMonsterField(currentUser.getFirstName());
            TempDeck tempDeck = tempDeckService.makeTempDeck(currentUser.getDeck());
            Player player = playerService.initPlayer(userId,tempDeck,tempHand,monsterField,currentUser.getUsername());
            playerQueueService.addPlayerToQueue(player);
            return ResponseEntity.ok("You're in queue!");
        }
        return ResponseEntity.badRequest().body("Failed to queue");
    }

}
