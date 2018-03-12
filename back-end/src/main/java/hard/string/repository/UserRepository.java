package hard.string.repository;

import hard.string.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Teama on 3/12/2018.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByUsername(String username);

}
