package hard.string.controller;

import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Teama on 4/3/2018.
 */

@RequestMapping("/queue")
public class QueueController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity queue(
            @RequestParam Long userId
    ){
        return ResponseEntity.ok().body("not yet implement");
    }
}
