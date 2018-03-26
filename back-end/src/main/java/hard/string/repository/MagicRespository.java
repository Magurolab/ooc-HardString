package hard.string.repository;

import hard.string.entity.cards.Magic.Magic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicRespository extends CrudRepository<Magic,Long> {


    Magic findDistinctByCardID(Long cardId);

}
