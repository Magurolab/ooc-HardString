package hard.string.controller;

import hard.string.entity.Greeting;
import hard.string.entity.User;
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
public class RegisterController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private UserRepository
            userRepository;

    @Autowired
    private UserService userService;

//    @GetMapping(value = {"/registerdebug"})
//    public List<User> addUserDebug(
//            @RequestParam String username,
//            @RequestParam String password,
//            @RequestParam String name
//    ) {
//        User user = new User();
//
//        userRepository.save(user);
//
//        Iterable<User> userIterable = userRepository.findAll();
//
//        List<User> users = new ArrayList<>();
//        for (User c : userIterable) {
//            users.add(c);
//        }
//
//        return users;
//    }


    @GetMapping(value = {"/register"})
    public ResponseEntity addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname
    ) {
        User user = userService.addUser(username,password,firstname,lastname,counter.incrementAndGet());
        userRepository.save(user);

        Iterable<User> userIterable = userRepository.findAll();

        List<User> users = new ArrayList<>();
        for (User c : userIterable) {
            users.add(c);
        }
        boolean success = true;
        if(success) {
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.badRequest().body("Registration fail");
        }
    }
}
