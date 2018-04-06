package hard.string.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Teama on 4/5/2018.
 */
public class ResponseQueue {

    private String response;
    private boolean isGameFound;

    public ResponseQueue(){
        this("Searching for player in O(log n)...", true);
    }

    public ResponseQueue(String response, boolean isQueue){
        this.response = response;
        this.isGameFound = isQueue;
    }


    public String getMessage() {
        return response;
    }

    public boolean isQueue() {
        return isGameFound;
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
