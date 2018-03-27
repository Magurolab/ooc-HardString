package hard.string.entity;


import javax.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue
    private Long iduser;

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne(targetEntity = Deck.class,
            mappedBy = "deckId",
            cascade = CascadeType.ALL
    )
    private Deck deck;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public Long getIduser() {
        return iduser;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
