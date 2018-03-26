package hard.string.service;

import hard.string.entity.User;
import hard.string.repository.MagicRespository;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonstersRepository;
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
    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  MagicRespository magicRespository;
    @Autowired
    private  TempMonstersRepository tempMonstersRepository;

    public User findDuelist(long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public User addUser(String username, String password){
        User user = new User();
        return user;
    }
}
