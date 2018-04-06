package hard.string.controller;

import hard.string.dto.UserWithProfileDto;
import hard.string.entity.*;
import hard.string.repository.UserRepository;
import hard.string.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teama on 4/5/2018.
 */

@RestController
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
            Authentication authentication
    ){
        UserWithProfileDto user = (UserWithProfileDto) authentication.getPrincipal();
        User currentUser =  userRepository.findById(user.getUserId()).orElse(null);
        if(currentUser!=null) {
            TempHand tempHand = tempHandService.initTempHand();
            MonsterField monsterField = monsterFieldService.initMonsterField(currentUser.getFirstName());
            TempDeck tempDeck = tempDeckService.makeTempDeck(currentUser.getDeck());
            Player player = playerService.initPlayer(currentUser.getIduser(),tempDeck,tempHand,monsterField,currentUser.getUsername());
            player.setElo(currentUser.getElo());
            playerQueueService.addPlayerToQueue(player);
            return ResponseEntity.ok("You're in queue!");
        }
        return ResponseEntity.badRequest().body("Failed to queue");
    }

}
