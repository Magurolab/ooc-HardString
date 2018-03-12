package io.muic.ooc.pos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.POST)
//    public String index() {
//        return "Hello, World!";
//    }
    public String create(@RequestParam("username") String user, @RequestParam("password") String password) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.createNewInventory(io.muic.ooc.pos.user, password));
        return user + "" + password;
    }

}
