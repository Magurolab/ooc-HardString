package hard.string.entity;

import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * Created by Teama on 3/12/2018.
 */

@Entity
public class User{



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @OneToOne(mappedBy = "player_idUser")
    @Column(name = "user_id")
    private long iduser;
    @Column(name = "user_username")
    private String username;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_deckID")
    private long deckID;




    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdDeck(Long deckid) {
        this.deckID = deckid;
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

    public long getIdDeck() {
        return deckID;
    }

    public long getIduser() {
        return iduser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
