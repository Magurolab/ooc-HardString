package hard.string.entity;

import hard.string.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Teama on 3/12/2018.
 */

@Entity
public class User{



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long iduser;
    private String username;
    private String password;
    private String name;
    private Long iddeck;




    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdDeck(Long deckid) {
        this.iddeck = deckid;
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

    public Long getIdDeck() {
        return iddeck;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
