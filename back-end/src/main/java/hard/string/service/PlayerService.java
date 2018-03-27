package hard.string.service;

import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.repository.MagicRespository;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  MagicRespository magicRespository;
    @Autowired
    private TempMonsterRepository tempMonsterRepository;


    public void drawCard(Player p){
        TempDeck deck = p.getTempDeck();
        p.getTempHand().getHand().add(deck.getCards().pop());
    }

    public Player initPlayer(long userId, TempDeck tempDeck, TempHand tempHand,
                             MonsterField monsterField, String username){
        Player player = new Player();
        player.setPlayerId(userId);
        player.setTempDeck(tempDeck);
        player.setTempHand(tempHand);
        player.setMonsterField(monsterField);
        player.setActiveTaunt(0);
        player.setUsername(username);


        return player;
    }


}
