package org.openhbx.keycloak_themes.login;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.SubjectCredentialManager;

/**
 *
 * @author tevans
 */
public class LoginUserCredentialManager extends org.openhbx.keycloak_themes.login.unimplemented.CredentialManager implements SubjectCredentialManager {
    private List<CredentialModel> currentCredentials;
    
    public LoginUserCredentialManager(CredentialModel currentCredentials) {
        this.currentCredentials = new ArrayList<CredentialModel>();
        if (currentCredentials != null) {
            this.currentCredentials.add(currentCredentials);
        }
    }

    @Override
    public Stream<CredentialModel> getStoredCredentialsByTypeStream(String string) {
        return this.currentCredentials.stream().filter(
          c -> c.getType() == string
        );
    }
}
