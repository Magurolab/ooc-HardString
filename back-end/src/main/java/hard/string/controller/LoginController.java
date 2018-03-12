package hard.string.controller;

import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teama on 3/12/2018.
 */
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
}
