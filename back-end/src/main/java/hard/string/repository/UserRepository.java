package hard.string.repository;

import hard.string.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Teama on 3/12/2018.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

}
