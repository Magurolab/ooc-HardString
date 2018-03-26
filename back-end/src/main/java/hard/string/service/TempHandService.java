package hard.string.service;


import hard.string.entity.Player;
import hard.string.entity.cards.Card;
import org.springframework.stereotype.Service;

@Service
public class TempHandService {

    public boolean playCard(Player p,Card c ){
        if(c.getType().equals("magic")){

        }else if (c.getType().equals("monster")){

        }else{
            return false;
        }
    }

    public boolean playMagic(){

    }

    public boolean playMonster(){

    }


}
