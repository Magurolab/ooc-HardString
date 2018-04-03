package hard.string.dto;

import hard.string.entity.TempMonster;
import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.CardRepository;
import hard.string.repository.MonsterRepository;
import hard.string.service.MonsterService;
import hard.string.service.TempMonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Teama on 4/2/2018.
 */

public class CardDto {

    private TempMonsterService tempMonsterService = new TempMonsterService();

    private Long cardId;

    private String name;

    private String type;

    private Integer cost;

    private Integer attack;

    private Integer hp;

    public CardDto(Card c){
        this.cardId = c.getId();
        this.name = c.getName();
        this.type = c.getType();
        this.cost = c.getCost();
        System.out.println(type);
        if(type.equals("Magic")){
            this.attack = 0;
            this.hp = 0;
        }
        else{
            System.out.println(type.equals("Monster") + " Monster");
            System.out.println(cardId);
            TempMonster temp = tempMonsterService.createTempMonster(cardId);
            this.attack = temp.getAtk();
            this.hp = temp.getMaxHP();
        }
    }

    public Integer getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getHp() {
        return hp;
    }

    public Long getCardId() {
        return cardId;
    }
}
