package hard.string.service;


import hard.string.entity.cards.Monster.Monster;
import org.springframework.stereotype.Service;

@Service
public  class MonsterService {


    public static boolean isDead(Monster m){
        return m.getHp()<=0;
    }

    public static void takeDamage(Monster m,int dmg){
        m.setHp(m.getHp()-dmg);
    }

    public static void takeAtkBuff(Monster m, int buff){
        m.setAtk(m.getAtk()+buff);
    }

    public static void takeHeal(Monster m, int heal){
        int newHealth = m.getHp() + heal;
        if(newHealth > m.getMaxHP()){
            m.setHp(m.getMaxHP());
        }else {
            m.setHp(newHealth);
        }

    }



}
