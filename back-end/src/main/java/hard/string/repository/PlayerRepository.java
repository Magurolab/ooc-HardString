package hard.string.repository;

import hard.string.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player,Long>{


    Player findDistinctByUserID(long userID);

}
