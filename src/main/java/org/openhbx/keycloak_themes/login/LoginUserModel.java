package org.openhbx.keycloak_themes.login;

import java.util.HashSet;
import java.util.Set;
import org.keycloak.models.UserModel;

/**
 *
 * @author tevans
 */
public class LoginUserModel extends org.openhbx.keycloak_themes.login.unimplemented.UserModel implements UserModel {

    private String userName = "";
    private Long createdTimestamp;
    private boolean enabled = true;

    public LoginUserModel() {
        this.createdTimestamp = System.currentTimeMillis();
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public void setUsername(String string) {
        this.userName = string;
    }

    @Override
    public Long getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    @Override
    public void setCreatedTimestamp(Long l) {
        this.createdTimestamp = l;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean bln) {
        this.enabled = bln;
    }

    @Override
    public Set<String> getRequiredActions() {
        Set result = new HashSet<String>();
        return result;
    }
}
