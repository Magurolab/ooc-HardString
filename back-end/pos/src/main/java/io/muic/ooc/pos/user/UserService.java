package io.muic.ooc.pos.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public boolean authenticate(String username, String password){
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
            return false;
        }

        UserModel user = userRepository.findByUsername(username);

        if (user==null){
            return false;
        }

        return encoder.matches(password, user.getPassword());
    }




    public UserModel register(String username, String password, String repeatPassword){
        if (!password.equals(repeatPassword)){
            // Better to throw a custom exception to controller;
            return null;
        }

        UserModel user = userRepository.findByUsername(username);

        if (user != null) {
            // User Already exist
            return null;
        }

        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(encoder.encode(password));
        return userRepository.save(userModel);
    }
}
