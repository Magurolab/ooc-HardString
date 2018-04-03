package hard.string.repository;

import hard.string.entity.cards.Monster.Monster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterRepository extends CrudRepository<Monster,Long>{

    Monster findByName(String name);

    @Override
    Optional<Monster> findById(Long Id);
}
