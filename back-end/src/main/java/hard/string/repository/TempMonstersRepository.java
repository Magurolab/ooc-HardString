package hard.string.repository;

import hard.string.entity.TempMonsters;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TempMonstersRepository extends CrudRepository<TempMonsters,Integer> {

    TempMonsters findDistinctByIndex(int index);

    TempMonsters findDistinctByName(String name);



}
