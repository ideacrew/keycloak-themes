package org.openhbx.keycloak_themes.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.ClientModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.SubjectCredentialManager;
import org.keycloak.models.UserModel;

/**
 *
 * @author tevans
 */
public class LoginUserModel extends org.openhbx.keycloak_themes.login.unimplemented.UserModel implements UserModel {

    private String userName = "";
    private Long createdTimestamp;
    private boolean enabled = true;
    private CredentialModel currentCredentials;

    public LoginUserModel(CredentialModel cm) {
        this.currentCredentials = cm;
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
    public Stream<String> getAttributeStream(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<String> getRequiredActionsStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<GroupModel> getGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubjectCredentialManager credentialManager() {
        return new LoginUserCredentialManager(this.currentCredentials);
    }

    @Override
    public Stream<RoleModel> getRealmRoleMappingsStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<RoleModel> getClientRoleMappingsStream(ClientModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<RoleModel> getRoleMappingsStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Map<String, List<String>> getAttributes() {
        Map<String, List<String>> aMap = new HashMap<String, List<String>>();
        return aMap;
    }
    
    @Override
    public String getId() {
        return "UserID";
    }
    
    @Override
    public String getEmail() {
        return "UserEmail";
    }
}
