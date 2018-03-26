package hard.string.repository;

import hard.string.entity.Deck;
import hard.string.entity.cards.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepository extends CrudRepository<Deck,Long>{

//    List<Card> findByDeckId(Long deckId);

}
