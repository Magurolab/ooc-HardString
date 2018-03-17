package hard.string.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Teama on 3/12/2018.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long iduser;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long iddeck;


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

    public Long getIddeck() {
        return iddeck;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setIddeck(Long iddeck) {
        this.iddeck = iddeck;
    }
}
