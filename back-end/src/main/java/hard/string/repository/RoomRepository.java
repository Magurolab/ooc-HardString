package hard.string.repository;

import hard.string.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Teama on 3/17/2018.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {

    Room findByRoomId(Long id);

}
