package hard.string.service;

import hard.string.entity.cards.Magic.Magic;
import hard.string.entity.cards.Monster.Monster;

import java.util.Random;

public class MagicService {


    public int[] getEffect(Magic m){
        return new int[]{m.getHeal(),m.getDmg(),m.getAtkBuff(),m.getDraw()};
    }

    public void applyEffectToTarget(Magic magic,Monster target){
        int[] eff = getEffect(magic);
        if(magic.isRandomEff()){
            int i = getRandomEff(eff);
            if(i==0){
                //heal
                MonsterService.takeHeal(target,eff[0]);
            }else if(i ==1){
                //dmg
                MonsterService.takeDamage(target,eff[1]);
            }else if(i ==2){
                //atkbuf
                MonsterService.takeAtkBuff(target,eff[2]);
            }else if(i == 3){
                drawCard(eff[3]);
            }
        }else{
            target.setHp(target.getHp()+eff[0]);
            target.setHp(target.getHp()-eff[1]);
            target.setAtk(target.getAtk()+eff[2]);
            drawCard(eff[3]);
        }
    }

    public void applyEffectNoTarget(Magic magic){
        int[] eff = getEffect(magic);
        drawCard(eff[3]);
    }



    private int getRandomEff(int[] eff){
        Random rn = new Random();
        int index = rn.nextInt(4);
        while(0 == eff[index]){
            index = rn.nextInt(4);
        }
        return index;

    }

    public void drawCard(int num){
        //TODO draw card
    }




}