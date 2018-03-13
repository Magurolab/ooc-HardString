package hard.string.service;

import hard.string.Hashing.HashPassword;
import hard.string.entity.User;
import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/12/2018.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findDuelist(long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User addUser(String username, String password, String firstName, String lastName, Long deckId){
        User user = new User();
        String hashpassword = HashPassword.hashPassword(password);
        user.setUsername(username);
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setPassword(hashpassword);
        user.setIddeck(deckId);
        return user;
    }
}
