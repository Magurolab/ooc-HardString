package hard.string.repository;

import hard.string.entity.cards.Monster.Monster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends CrudRepository<Monster,Long>{

    Monster findMonsterByName(String name);

}
