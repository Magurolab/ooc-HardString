package hard.string.repository;

import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MonsterFieldRepository extends CrudRepository<Monster,Long> {

    List<Monster> findMonsterById(Long monsterId);

}
