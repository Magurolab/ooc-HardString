package hard.string.controller;

import hard.string.dto.UserWithProfileDto;
import hard.string.entity.Greeting;
import hard.string.entity.User;
import hard.string.repository.DeckRepository;
import hard.string.repository.UserRepository;
import hard.string.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Teama on 3/12/2018.
 */

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository
            userRepository;


    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private UserService userService;



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {

        User user = userService.addUser(username,password,firstName,lastName);
        if(user == null) {
            System.out.println(username);
            return ResponseEntity.badRequest().body("This username already exists");
        }
        userRepository.save(user);
        deckRepository.save(user.getDeck());

        return ResponseEntity.ok(new UserWithProfileDto(user));
    }
}
