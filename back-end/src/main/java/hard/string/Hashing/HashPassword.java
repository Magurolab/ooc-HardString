package hard.string.hashing;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by Teama on 3/13/2018.
 */

public class HashPassword {

    public static final String hashPassword(String plainPwd){
        return BCrypt.hashpw(plainPwd,BCrypt.gensalt(12));
    }

    public static final boolean verifyPassword(String hash, String plain){
        return BCrypt.checkpw(plain,hash);
    }
}
