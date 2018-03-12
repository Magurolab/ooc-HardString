package io.muic.ooc.pos.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

//import java.security.Principal;
import java.security.Principal;
import java.util.Date;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/whoami")
    public String whoami(Authentication authentication){
        return authentication.getPrincipal().toString();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("repeatPassword") String repeatPass){
        UserModel model;

        if ((model = userService.register(username, password, repeatPass)) != null){
            return ResponseEntity.ok(model);
        }

        return ResponseEntity.badRequest().body("Cant Register");
    }
}
