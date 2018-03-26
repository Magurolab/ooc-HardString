package hard.string.entity;


import hard.string.entity.cards.Card;

import javax.persistence.*;

@Entity
@Table(name = "temp_hand")
public class TempHand {
    //Exclusive for each player
    @Id
    @OneToOne
    @JoinColumn(name = "temp_hand_owner")
    private Player tempHandOwner;

    @Id
    @Column(name = "temp_hand_index")
    private int index;

    @Column(name = "temp_hand_cardID")
    private long cardID; //From TempDeck

    public Player getTempHandOwner() {
        return tempHandOwner;
    }

    public void setTempHandOwner(Player tempHandOwner) {
        this.tempHandOwner = tempHandOwner;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    //    @Column(name = "temp_hand_id_0")
//    private int hand0ID;
//    @Column(name = "temp_hand_name_0")
//    private String hand0Name;
//
//    @Column(name = "temp_hand_id_1")
//    private int hand1ID;
//    @Column(name = "temp_hand_name_1")
//    private String hand1Name;
//
//    @Column(name = "temp_hand_id_2")
//    private int hand2ID;
//    @Column(name = "temp_hand_name_2")
//    private String hand2Name;
//
//    @Column(name = "temp_hand_id_3")
//    private int hand3ID;
//    @Column(name = "temp_hand_name_3")
//    private String hand3Name;
//
//    @Column(name = "temp_hand_id_4")
//    private int hand4ID;
//    @Column(name = "temp_hand_name_4")
//    private String hand4Name;
//
//    @Column(name = "temp_hand_id_5")
//    private int hand5ID;
//    @Column(name = "temp_hand_name_5")
//    private String hand5Name;
//
//    @Column(name = "temp_hand_id_6")
//    private int hand6ID;
//    @Column(name = "temp_hand_name_6")
//    private String hand6Name;
//
//    @Column(name = "temp_hand_id_7")
//    private int hand7ID;
//    @Column(name = "temp_hand_name_7")
//    private String hand7Name;
//
//    @Column(name = "temp_hand_id_8")
//    private int hand8ID;
//    @Column(name = "temp_hand_name_8")
//    private String hand8Name;


    public TempHand() {
    }


}
