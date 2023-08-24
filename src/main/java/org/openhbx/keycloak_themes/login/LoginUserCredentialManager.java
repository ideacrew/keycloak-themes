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
public class LoginUserCredentialManager implements SubjectCredentialManager {
    private List<CredentialModel> currentCredentials;
    
    public LoginUserCredentialManager(CredentialModel currentCredentials) {
        this.currentCredentials = new ArrayList<CredentialModel>();
        if (currentCredentials != null) {
            this.currentCredentials.add(currentCredentials);
        }
    }

    @Override
    public boolean isValid(List<CredentialInput> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCredential(CredentialInput ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStoredCredential(CredentialModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel createStoredCredential(CredentialModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeStoredCredentialById(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel getStoredCredentialById(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<CredentialModel> getStoredCredentialsStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<CredentialModel> getStoredCredentialsByTypeStream(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel getStoredCredentialByNameAndType(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveStoredCredentialTo(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCredentialLabel(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableCredentialType(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<String> getDisableableCredentialTypesStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConfiguredFor(String string) {
        return false;
    }

    @Override
    public boolean isConfiguredLocally(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<String> getConfiguredUserStorageCredentialTypesStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel createCredentialThroughProvider(CredentialModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
