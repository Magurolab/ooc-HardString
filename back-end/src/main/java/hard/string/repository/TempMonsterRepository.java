package hard.string.repository;

import hard.string.entity.Player;
import hard.string.entity.TempMonster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TempMonsterRepository extends CrudRepository<TempMonster,Integer> {

    TempMonster findDistinctByIndex(int index);

    TempMonster findDistinctByName(String name);

    TempMonster findDistinctByIndexAndTempMonsterOwner(int index, Player p);

}
