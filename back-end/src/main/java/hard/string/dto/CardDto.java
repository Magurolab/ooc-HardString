package hard.string.dto;

import hard.string.entity.cards.Card;
import hard.string.entity.cards.Monster.Monster;
import hard.string.repository.CardRepository;
import hard.string.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Teama on 4/2/2018.
 */
public class CardDto {

    @Autowired
    private MonsterRepository monsterRepository;

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
        if(type.equals("Magic")){
            this.attack = 0;
            this.hp = 0;
        }
        else{
            Monster temp = monsterRepository.findById(c.getId());
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
