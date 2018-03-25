package hard.string.entity.cards;


import javax.persistence.*;

/**
 * Created by Teama on 3/10/2018.
 */

//All Card in game
@Entity
@Table(name= "card")
public class Card {

    @Id
    @GeneratedValue
    private long cardID;
    @Column(name ="card_name")
    private String name;
    @Column(name = "card_type")
    private String type;
    @Column(name = "card_cost")
    private int cost;

    public Card() {
    }

    public long getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
