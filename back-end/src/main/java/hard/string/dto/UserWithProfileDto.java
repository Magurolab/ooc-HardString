package hard.string.dto;

import hard.string.entity.User;

/**
 * Created by Teama on 3/17/2018.
 */
public class UserWithProfileDto {

    private String username;
    private String displayName;

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }


    public UserWithProfileDto(User user){
        this.username = user.getUsername();
        this.displayName = user.getFirstName();
    }
}
