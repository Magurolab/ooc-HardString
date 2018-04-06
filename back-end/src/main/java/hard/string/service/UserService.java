package hard.string.service;

import hard.string.dto.UserWithProfileDto;
import hard.string.entity.Deck;
import hard.string.hashing.HashPassword;
import hard.string.entity.User;
import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Teama on 3/12/2018.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeckService deckService;

    public User findDuelist(long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User addUser(String username, String password, String firstName, String lastName){
        User user = new User();
        User duplicateCheck = userRepository.findByUsername(username);
        if(duplicateCheck!=null){
            return null;
        }
        String hashpassword = HashPassword.hashPassword(password);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(hashpassword);
        user.setElo(1000);
        user.setDeck(deckService.customDeck());
        return user;
    }

    public UserWithProfileDto authenticate(String username, String password){
        User findUser = userRepository.findByUsername(username);
        System.out.println("try loggin in : " +username);
        if(findUser!=null) {
            System.out.println(username);
            System.out.println(password);
            System.out.println("Attempting match password..");
            if (HashPassword.verifyPassword(findUser.getPassword(), password)) {
                System.out.println("login success");
                return new UserWithProfileDto(findUser);
            }
            System.out.println("Password mismatched");
        }
        return null;
    }

}
