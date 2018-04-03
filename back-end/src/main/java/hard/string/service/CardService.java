package hard.string.service;

import hard.string.dto.CardDto;
import hard.string.entity.TempHand;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teama on 4/3/2018.
 */

@Service
public class CardService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<CardDto> createHandDto(TempHand tempHand){
        List<CardDto> handDto = new ArrayList<>();
        for(Card c: tempHand.getHand()){
            String type = c.getType();
            if(type.equals("Magic")){
                handDto.add(new CardDto(c, 0, 0));
            }
            else if(type.equals("Monster")) {
//                System.out.println("Creating monster ..... ID: "+ c.getId());
                Monster temp = monsterRepository.findById(c.getId()).orElse(null);
                System.out.println((temp != null));
                if(temp!=null) {
//                System.out.println(temp.getClass().isInstance(Monster.class));
                    handDto.add(new CardDto(c, temp.getAtk(), temp.getMaxHP()));
                }
                else{
                    System.out.println("Couldn't find the monster");
                    return null;
                }
            }
            else{
                System.out.println("Something weird happen");
                return null;
                }//shouldn't reach here
            }
        return handDto;
    }
}

