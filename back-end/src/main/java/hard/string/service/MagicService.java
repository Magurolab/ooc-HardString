package hard.string.service;

import hard.string.entity.Player;
import hard.string.entity.TempMonster;
import hard.string.entity.cards.Magic.Magic;
import hard.string.entity.cards.Monster.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MagicService {
    @Autowired
    private MonsterService monsterService;
    @Autowired
    private PlayerService playerService;


    public int[] getEffect(Magic m){
        return new int[]{m.getHeal(),m.getDmg(),m.getAtkBuff(),m.getDraw()};
    }

    public void applyEffectToTarget(Player p ,Magic magic,TempMonster target){
        int[] eff = getEffect(magic);
        if(magic.isRandomEff()){
            int i = getRandomEff(eff);
            if(i==0){
                //heal
                monsterService.takeHeal(target,eff[0]);
            }else if(i ==1){
                //dmg
                monsterService.takeDamage(target,eff[1]);
            }else if(i ==2){
                //atkbuf
                monsterService.takeAtkBuff(target,eff[2]);
            }else if(i == 3){
                drawCard(p,eff[3]);
            }
        }else{
            target.setHp(target.getHp()+eff[0]);
            target.setHp(target.getHp()-eff[1]);
            target.setAtk(target.getAtk()+eff[2]);
            drawCard(p,eff[3]);
        }
    }

    public void applyEffectNoTarget(Player p,Magic magic){
        int[] eff = getEffect(magic);
        drawCard(p,eff[3]);
    }



    private int getRandomEff(int[] eff){
        Random rn = new Random();
        int index = rn.nextInt(4);
        while(0 == eff[index]){
            index = rn.nextInt(4);
        }
        return index;

    }

    public void drawCard(Player player,int num){
        for(int i =0 ;i<num;i++){
            playerService.drawCard(player);
        }
    }




}
