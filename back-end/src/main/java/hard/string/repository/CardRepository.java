package hard.string.repository;

import hard.string.entity.User;
import hard.string.entity.cards.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Teama on 3/10/2018.
 */

@Repository
public interface CardRepository extends CrudRepository<Card,Long> {

    Card findByName(String cardName);

    Card findByCardID(Long cardId);


}
