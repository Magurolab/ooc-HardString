package hard.string.service;

import hard.string.entity.*;
import hard.string.repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    public boolean drawCard(Player p){
        TempDeck deck = p.getTempDeck();
        if(deck.getCards().size() > 0) {
            p.getTempHand().getHand().add(deck.getCards().pop());
            return true;
        }
        else{
            p.getMonsterField().getPlayer().setHp(p.getMonsterField().getPlayer().getHp()-2);
            return false;
        }
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
