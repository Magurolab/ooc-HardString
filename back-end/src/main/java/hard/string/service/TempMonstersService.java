package hard.string.service;


import hard.string.entity.Player;
import hard.string.entity.TempMonsters;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.CardRepository;
import hard.string.repository.MagicRespository;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonstersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class TempMonstersService {

    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  CardRepository cardRepository;
    @Autowired
    private  TempMonstersRepository tempMonstersRepository;


    public  boolean isDead(TempMonsters m){
        return m.getHp()<=0;
    }

    public  void takeDamage(TempMonsters m, int dmg){
        m.setHp(m.getHp()-dmg);
    }

    public  void takeAtkBuff(TempMonsters m, int buff){
        m.setAtk(m.getAtk()+buff);
    }

    public  void takeHeal(TempMonsters m, int heal){
        int newHealth = m.getHp() + heal;
        if(newHealth > m.getMaxHP()){
            m.setHp(m.getMaxHP());
        }else {
            m.setHp(newHealth);
        }

    }

    public  void addMonster(long userId,long cardId){
        Player p = playerRepository.findDistinctByUserID(userId);
        TempMonsters tm = new TempMonsters();
        Card c = cardRepository.findByCardID(cardId);


    }

//    private static Card initTempMonster(Card c,){
//
//    }



}
