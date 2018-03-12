package hard.string.controller;

import com.sun.org.apache.regexp.internal.RE;
import hard.string.entity.Greeting;
import hard.string.entity.User;
import hard.string.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRepository userRepository;

    @GetMapping(value = {"/addUser"})
    public List<User> addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String name
    ) {
        User user = new User();
        user.setIdDeck(counter.incrementAndGet());
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);

        userRepository.save(user);

        Iterable<User> userIterable = userRepository.findAll();

        List<User> users = new ArrayList<>();
        for (User c : userIterable) {
            users.add(c);
        }

        return users;
    }
}
