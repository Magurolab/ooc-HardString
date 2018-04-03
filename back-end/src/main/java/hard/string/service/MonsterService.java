package hard.string.service;


import hard.string.entity.TempMonster;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public Monster createMonster(Card c){
        Monster m = monsterRepository.findById(c.getId()).orElse(null);
        System.out.println(m.equals(null));
        return m;
    }


    public boolean isDead(TempMonster m){
        return m.getHp()<=0;
    }

    public void takeDamage(TempMonster m, int dmg){
        m.setHp(m.getHp()-dmg);
    }

    public void takeAtkBuff(TempMonster m, int buff){
        m.setAtk(m.getAtk()+buff);
    }

    public void takeHeal(TempMonster m, int heal){
        int newHealth = m.getHp() + heal;
        if(newHealth > m.getMaxHP()){
            m.setHp(m.getMaxHP());
        }else {
            m.setHp(newHealth);
        }

    }

}
