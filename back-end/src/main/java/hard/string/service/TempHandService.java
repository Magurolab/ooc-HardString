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
        if(!havethisInHand(player,c)){
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
            playMagic(player,c,monsterFieldService.getMonster(indexTarget,monsterField));
            if(monsterFieldService.getMonster(indexTarget,monsterField).isDead()){
                if(friendlyTarget) {
                    monsterFieldService.removeMonster(indexTarget,player);
                }
                else{
                    monsterFieldService.removeMonster(indexTarget, boardService.getEnemeyPlayer(player.getPlayerId(),b));
                }
            }
            return  true;
        }else if (c.getType().equals("Monster")){
            return playMonster(player,c,indexTarget);
        }else{
            return false;
        }
    }

    private boolean playMagic(Player player,Card c,TempMonster tempMonster){
        Magic m = magicRepository.findById(c.getId()).orElse(null);
        if(m!=null) {
            removeCard(player,c);
            magicService.applyEffectToTarget(player, m, tempMonster);
            return true;
        }
        return false;
    }

    private boolean playMonster(Player player,Card c,int index){
        if(monsterFieldService.getMonster(index,player.getMonsterField())==null) {
            removeCard(player,c);
            return monsterFieldService.addMonster(player, c.getId(), index);
        }
        return false;
    }

    private boolean havethisInHand(Player p, Card c){
        for(Card temp: p.getTempHand().getHand()){
            if(temp.getId().equals(c.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean removeCard(Player p, Card c){
        Card rem = null;
        for(Card temp: p.getTempHand().getHand()){
            if(temp.getId().equals(c.getId())){
                rem = temp;
                break;
            }
        }
        if(rem!=null){
            p.getTempHand().getHand().remove(rem);
            return true;
        }
        return false;
    }


    public TempHand initTempHand(){
        TempHand tempHand = new TempHand();
        tempHand.setHand(new ArrayList<>());
        return tempHand;
    }

}
