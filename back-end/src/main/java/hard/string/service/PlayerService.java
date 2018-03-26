package hard.string.service;

import hard.string.entity.Player;
import hard.string.entity.cards.Card;
import hard.string.repository.MagicRespository;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonstersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  MagicRespository magicRespository;
    @Autowired
    private  TempMonstersRepository tempMonstersRepository;

//    public static Card drawCard(Player p){
////        if(p.getDeck().size() != 0){
////            p.getp.getDeck().remove(0);
////        }
//
//    }


}
