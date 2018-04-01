package hard.string.component;

import hard.string.entity.Board;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Teama on 4/1/2018.
 */
@Component
public final class RunningGame {

    private HashMap<Long,Board> game = new HashMap<>();

    private static volatile RunningGame instance = null;

    private RunningGame() {
        this.game = new HashMap<>();
    }

    public void put(Long key, Board b) {
        getInstance().game.put(key,b);
    }

    public void remove(Long key){
        getInstance().game.remove(key);
    }

    public Board get(Long key){
        return getInstance().game.getOrDefault(key,null);
    }

    public static RunningGame getInstance() {
        if (instance == null) {
            synchronized(RunningGame.class) {
                if (instance == null) {
                    instance = new RunningGame();
                }
            }
        }
        return instance;
    }

}
