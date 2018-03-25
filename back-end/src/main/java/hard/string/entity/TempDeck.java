package hard.string.entity;


import hard.string.entity.cards.Card;

import javax.persistence.*;

import java.util.Stack;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "temp_deck")
public class TempDeck {
    //Exclusive for each player


    @OneToOne
    @JoinColumn(name = "temp_deck_owner")
    private Player tempDeckOwner;

    @Id
    @GeneratedValue
    @Column(name = "temp_deck_index")
    private int index;
    // Generate
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name="tempCardID_generator", sequenceName = "tempCardID_seq", allocationSize=50)
//    @Column(name = "temp_deck_cardID")
//    private int cardID; //Newly generated,
//    // All "temp" Entity will now refer to this ID instead of from Card Entity

    @Column(name= "temp_deck_cardID")
    private long cardID;


//    @Column(name = "temp_deck_name")
//    private String name;


    public TempDeck() {
    }


}
