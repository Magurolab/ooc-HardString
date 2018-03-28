package hard.string.service;


import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Magic.Magic;
import hard.string.repository.MagicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TempHandService {

    @Autowired
    private BoardService boardService;
    @Autowired
    private MagicService magicService;
    @Autowired
    private MagicRepository magicRepository;
    @Autowired
    private MonsterFieldService monsterFieldService;


    public boolean playCard(Board b, Player player, Card c, int indexTarget , boolean friendlyTarget){
        //Doesn't have this card in the first place?
        if(!player.getTempHand().getHand().contains(c)){
            return false;
        }
        MonsterField monsterField;
        if(friendlyTarget){
            monsterField= boardService.getPlayer(player.getPlayerId(),b).getMonsterField();
        }else {
            monsterField = boardService.getEnemeyPlayer(player.getPlayerId(),b).getMonsterField();
        }

        boardService.usedMana(b,boardService.getPlayerNum(b,player),c.getCost());

        if(c.getType().equals("Magic")){
            return playMagic(player,c,monsterFieldService.getMonster(indexTarget,monsterField));
        }else if (c.getType().equals("Monster")){
            return playMonster(player,c,indexTarget);
        }else{
            return false;
        }

    }

    private boolean playMagic(Player player,Card c,TempMonster tempMonster){
        Magic m = magicRepository.findById(c.getId()).orElse(null);
        if(m!=null) {
            player.getTempHand().getHand().remove(c);
            magicService.applyEffectToTarget(player, m, tempMonster);
            return true;
        }
        return false;
    }

    private boolean playMonster(Player p,Card c,int index){
        p.getTempHand().getHand().remove(c);
        return monsterFieldService.addMonster(p,c.getId(),index);
    }


    public TempHand initTempHand(){
        TempHand tempHand = new TempHand();
        tempHand.setHand(new ArrayList<>());
        return tempHand;
    }

}