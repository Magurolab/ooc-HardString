package hard.string.service;

import hard.string.entity.Board;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class RunningGameService {

    private Map<Long,Board> games = new HashMap<Long,Board>();

    public void addGame(Long key, Board board){
        games.put(key,board);
    }

    public void removeGame(Long key){
        games.remove(key);
    }

    public Board getGame(Long key){
        return games.get(key);
    }
}
