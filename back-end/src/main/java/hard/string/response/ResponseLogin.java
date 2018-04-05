package hard.string.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseLogin {

    public ResponseLogin() {
        this("You're not logged in", false);
    }

    public ResponseLogin(String message, boolean login) {
        this.message = message;
        this.login = login;
    }

    private String message;
    private boolean login;

    public String getMessage() {
        return message;
    }

    public boolean isLogin() {
        return login;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        }catch (JsonProcessingException e){
            return null;
        }
    }
}
