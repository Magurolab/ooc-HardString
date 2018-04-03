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

    private Long cardId;

    private String name;

    private String type;

    private Integer cost;

    private Integer attack;

    private Integer hp;

    public CardDto(Card c, Integer attack, Integer hp){
        cardId = c.getId();
        name = c.getName();
        type = c.getType();
        this.attack = attack;
        this.hp = hp;
        cost = c.getCost();
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
