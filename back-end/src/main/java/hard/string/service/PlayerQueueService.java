package hard.string.service;

import hard.string.component.PlayerQueue;
import hard.string.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 4/5/2018.
 */

@Service
public class PlayerQueueService {

    @Autowired
    private PlayerService playerService;

    private PlayerQueue playerQueue = PlayerQueue.getInstance();

    private List<Player> bronze = new ArrayList<>();
    private List<Player> silver = new ArrayList<>();
    private List<Player> gold = new ArrayList<>();
    private List<Player> platinum = new ArrayList<>();
    private List<Player> diamond = new ArrayList<>();


    public void addPlayerToQueue(Player p){
        playerQueue.add(p);
        updateQueue();
    }

    public synchronized void updateQueue(){

    }
}
