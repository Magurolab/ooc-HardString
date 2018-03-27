package hard.string.service;


import hard.string.entity.*;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Magic.Magic;
import hard.string.repository.MagicRespository;
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
    private MagicRespository magicRespository;
    @Autowired
    private MonsterFieldService monsterFieldService;
    @Autowired
    private TempMonsterService tempMonsterService;



    public boolean playCard(Board b, Player player, Card c, int indexTarget , boolean friendlyTarget){
        if(!boardService.canPlayThisCard(b,boardService.getPlayerNum(b,player),c.getCost())){
            return false;
        }

        MonsterField monsterField;
        if(friendlyTarget){
            monsterField= boardService.getPlayer(player.getPlayerId(),b).getMonsterField();

        }else {
            monsterField = boardService.getEnemeyPlayer(player.getPlayerId(),b).getMonsterField();
        }

        boardService.usedMana(b,boardService.getPlayerNum(b,player),c.getCost());

        if(c.getType().equals("magic")){
            return playMagic(player,c,monsterFieldService.getMonster(indexTarget,monsterField));
        }else if (c.getType().equals("monster")){

            return playMonster(player,c,indexTarget);
        }else{
            return false;
        }

    }

    private boolean playMagic(Player player,Card c,TempMonster tempMonster){

        Magic m = magicRespository.findDistinctByCardID(c.getId());
        magicService.applyEffectToTarget(player,m,tempMonster);
        return true;
    }

    private boolean playMonster(Player p,Card c,int index){

        return tempMonsterService.addMonster(p.getPlayerId(),c.getId(),index);

    }


    public TempHand initTempHand(){
        TempHand tempHand = new TempHand();
        tempHand.setHand(new ArrayList<>());
        return tempHand;
    }





}
