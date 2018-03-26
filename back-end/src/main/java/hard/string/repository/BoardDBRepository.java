package hard.string.repository;

import hard.string.entity.BoardDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Teama on 3/25/2018.
 */

@Repository
public interface BoardDBRepository extends CrudRepository<BoardDB,Long>{

    BoardDB findByPlayer1(Long playerId);

    BoardDB findByPlayer2(Long playerId);

    BoardDB findByPlayer1OrPlayer2(Long player1, Long player2);
}
