package hard.string.service;

import hard.string.entity.Player;
import hard.string.entity.TempMonsters;
import hard.string.entity.cards.Magic.Magic;
import hard.string.repository.MagicRespository;
import hard.string.repository.PlayerRepository;
import hard.string.repository.TempMonstersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MagicService {

    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private  MagicRespository magicRespository;
    @Autowired
    private  TempMonstersRepository tempMonstersRepository;

    public int[] getEffect(Magic m){
        return new int[]{m.getHeal(),m.getDmg(),m.getAtkBuff(),m.getDraw()};
    }

    public void applyEffectToTarget(long magicId,long pIdTarget ,int index ){
        TempMonstersService tempMonstersService = new TempMonstersService();
        Magic magic = magicRespository.findDistinctByCardID(magicId);
        Player p = playerRepository.findDistinctByUserID(pIdTarget);
        TempMonsters target = tempMonstersRepository.findDistinctByIndexAndTempMonsterOwner(index,p);
        int[] eff = getEffect(magic);
        if(magic.isRandomEff()){
            int i = getRandomEff(eff);
            if(i==0){
                //heal
                tempMonstersService.takeHeal(target,eff[0]);
            }else if(i ==1){
                //dmg
                tempMonstersService.takeDamage(target,eff[1]);
            }else if(i ==2){
                //atkbuf
                tempMonstersService.takeAtkBuff(target,eff[2]);
            }else if(i == 3){
                drawCard(eff[3]);
            }
        }else{
            target.setHp(target.getHp()+eff[0]);
            target.setHp(target.getHp()-eff[1]);
            target.setAtk(target.getAtk()+eff[2]);
            drawCard(eff[3]);
        }
        if(target.getHp() == 0){
            tempMonstersRepository.delete(target);
        }else{
            tempMonstersRepository.save(target);
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
