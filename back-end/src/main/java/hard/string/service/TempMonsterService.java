package hard.string.service;

import hard.string.entity.MonsterField;
import hard.string.entity.Player;
import hard.string.entity.TempMonster;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.CardRepository;
import hard.string.repository.MonsterRepository;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TempMonsterService {




    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TempMonsterRepository tempMonsterRepository;
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
        Monster monster = monsterRepository.findMonsterByCardID(cardId);
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

    public  boolean addMonster(long userId,long cardId,int index){
        Player player = playerRepository.findDistinctByUserID(userId);
        MonsterField monsterField = player.getMonsterField();
        TempMonster tempMonster = createTempMonster(cardId);

        //If taunt add counter in Player
        if(tempMonster.isTaunt()){
            player.setActiveTaunt(player.getActiveTaunt()+1);
        }
        //Put tempMonster in field
        monsterFieldService.setMonster(index,monsterField,tempMonster);
        return true;
    }

    public boolean removeMonster(int monsterIndex, Player p){
        if(monsterFieldService.getMonster(monsterIndex,p.getMonsterField()).isTaunt()){
            p.setActiveTaunt(p.getActiveTaunt()-1);
        }
        monsterFieldService.setMonster(monsterIndex,p.getMonsterField(),null);
        return true;
    }





}
