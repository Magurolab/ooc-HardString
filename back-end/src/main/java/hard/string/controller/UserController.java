package hard.string.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teama on 4/6/2018.
 */

@RestController
public class UserController {

    @GetMapping("/whoami")
    public String whoami(Authentication authentication){
        return authentication.getPrincipal().toString();
    }

}
