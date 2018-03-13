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
    private String first_name;
    private String last_name;
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

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getIddeck() {
        return iddeck;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setIddeck(Long iddeck) {
        this.iddeck = iddeck;
    }
}
