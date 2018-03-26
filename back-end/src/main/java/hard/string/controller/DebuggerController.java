package hard.string.controller;

import hard.string.entity.Deck;
import hard.string.entity.User;
import hard.string.entity.cards.Card;
import hard.string.repository.CardRepository;
import hard.string.repository.UserRepository;
import hard.string.service.DeckService;
import hard.string.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/12/2018.
 */

@RestController
public class DebuggerController {

    @Autowired
    private UserRepository
            userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private CardRepository cardRepository;

    @GetMapping(value = {"/displayAll"})
    public ResponseEntity displayAll(){
        Iterable<User> userIterable = userRepository.findAll();

        List<User> users = new ArrayList<>();

        for (User c : userIterable) {
            users.add(c);
        }

        return ResponseEntity.ok(users);

    }

    @RequestMapping(method = RequestMethod.POST, value = {"/addCardtoDeck"})
    public ResponseEntity addCard(
            @RequestParam long userId
    ){
        User user = userRepository.findById(userId).orElse(null);
        Card boat =  cardRepository.findById(1L).orElse(null);
        deckService.addCard(user.getDeck(),boat);
        deckService.addCard(user.getDeck(),boat);

        return ResponseEntity.ok(user);
    }

}
