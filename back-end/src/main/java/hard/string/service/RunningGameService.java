package hard.string.service;

import hard.string.component.RunningGame;
import hard.string.entity.Board;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class RunningGameService {

    private RunningGame runningGame = RunningGame.getInstance();

    public void addGame(Long key, Board board){
        runningGame.put(key,board);
    }

    public void removeGame(Long key){
        runningGame.remove(key);
    }

    public Board getGame(Long key){
        return runningGame.get(key);
    }
}
