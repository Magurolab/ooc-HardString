package hard.string.component;

import hard.string.entity.Board;
import hard.string.entity.Player;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Teama on 4/5/2018.
 */

@Component
public class PlayerQueue {

    private Queue<Player> playerqueue;

    private static volatile PlayerQueue instance = null;

    private PlayerQueue() {
        this.playerqueue = new LinkedList<>();
    }

    public void add(Player p) {
        getInstance().playerqueue.add(p);
    }

    public Integer size(){
        return getInstance().playerqueue.size();
    }

    public boolean isEmpty(){
        return getInstance().playerqueue.size() == 0;
    }

    public Player peekFirstPlayer(){
        return getInstance().playerqueue.peek();
    }

    public Player getFirstPlayer(){
        return getInstance().playerqueue.poll();
    }

    public static PlayerQueue getInstance() {
        if (instance == null) {
            synchronized(RunningGame.class) {
                if (instance == null) {
                    instance = new PlayerQueue();
                }
            }
        }
        return instance;
    }
}
