package hard.string.service;

import hard.string.entity.Player;
import hard.string.entity.TempMonster;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.CardRepository;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TempMonsterService {


    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MonsterRepository monsterRepository;
    @Autowired
    private MonsterFieldService monsterFieldService;


    public  boolean isDead(TempMonster m){
        return m.getHp()<=0;
    }

    public  void takeDamage(TempMonster m, int dmg){
        m.setHp(m.getHp()-dmg);
    }

    public  void takeAtkBuff(TempMonster m, int buff){
        m.setAtk(m.getAtk()+buff);
    }

    public  void takeHeal(TempMonster m, int heal){
        int newHealth = m.getHp() + heal;
        if(newHealth > m.getMaxHP()){
            m.setHp(m.getMaxHP());
        }else {
            m.setHp(newHealth);
        }

    }

    public TempMonster createTempMonster(long cardId){
        Monster monster = monsterRepository.findById(cardId).orElse(null);
        TempMonster tempMonster = new TempMonster();
        tempMonster.setName(monster.getName());
        tempMonster.setCost(monster.getCost());
        tempMonster.setHp(monster.getMaxHP());
        tempMonster.setMaxHP(monster.getMaxHP());
        tempMonster.setAtk(monster.getAtk());
        tempMonster.setTaunt(monster.isTaunt());
        tempMonster.setCanAttack(monster.isCharge());
        tempMonster.setDead(false);
        return tempMonster;
    }

    public TempMonster createPlayer(String name){
        TempMonster player = new TempMonster();
        player.setAtk(0);
        player.setCanAttack(false);
        player.setCost(0);
        player.setDead(false);
        player.setHp(30);
        player.setMaxHP(30);
        player.setName(name);
        player.setTaunt(false);
        player.setIndex(0);
        return player;
    }
}
