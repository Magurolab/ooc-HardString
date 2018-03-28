package hard.string.repository;

import hard.string.entity.LobbyRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Teama on 3/17/2018.
 */

@Repository
public interface LobbyRoomRepository extends CrudRepository<LobbyRoom,Long> {

    LobbyRoom findByRoomId(Long id);

    LobbyRoom findByUser1OrUser2(Long id1, Long id2);

}
