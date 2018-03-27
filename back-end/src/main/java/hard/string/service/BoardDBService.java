package hard.string.service;

import hard.string.entity.Board;
import hard.string.entity.BoardDB;
import hard.string.repository.BoardDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 3/27/2018.
 */

@Service
public class BoardDBService {

    @Autowired
    BoardDBRepository boardDBRepository;

    public long findBoard(Long playerId){
        BoardDB boardDB = boardDBRepository.findByPlayer1OrPlayer2(playerId,playerId);
        if(boardDB != null){
            return boardDB.getBoardId();
        }
        return -1;
    }
}

