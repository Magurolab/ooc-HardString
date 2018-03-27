package hard.string.service;


import hard.string.entity.TempMonster;
import hard.string.entity.cards.Monster.Monster;
import org.springframework.stereotype.Service;

@Service
public  class MonsterService {



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
