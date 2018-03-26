package hard.string.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Teama on 3/17/2018.
 */

@RestController
@RequestMapping("/hand")
public class HandController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity update(){
        //return hand
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/useCard")
    public ResponseEntity useCard(
            @RequestParam long playerId,
            @RequestParam long cardId
    ){
        //1. use card
        //2. remove card from hand

//        return ResponseEntity.ok();
        return null;
    }

}
