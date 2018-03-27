package hard.string.repository;

import hard.string.entity.Deck;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Teama on 3/25/2018.
 */
public interface DeckService extends CrudRepository<Deck, Long> {
}
