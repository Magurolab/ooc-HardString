package hard.string.controller;

import hard.string.entity.User;
import hard.string.repository.UserRepository;
import hard.string.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 3/12/2018.
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository
            userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/displayAll"})
    public ResponseEntity displayAll(){
        Iterable<User> userIterable = userRepository.findAll();

        List<User> users = new ArrayList<>();

        for (User c : userIterable) {
            users.add(c);
        }

        return ResponseEntity.ok(users);

    }

}
