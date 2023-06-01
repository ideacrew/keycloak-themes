package org.openhbx.keycloak_themes.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.CredentialValidationOutput;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserCredentialManager;
import org.keycloak.models.UserModel;

/**
 *
 * @author tevans
 */
public class LoginUserCredentialManager implements UserCredentialManager {
    private List<CredentialModel> currentCredentials;
    
    public LoginUserCredentialManager(CredentialModel currentCredentials) {
        this.currentCredentials = new ArrayList<CredentialModel>();
        if (currentCredentials != null) {
            this.currentCredentials.add(currentCredentials);
        }
    }

    @Override
    public boolean isValid(RealmModel rm, UserModel um, List<CredentialInput> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(RealmModel rm, UserModel um, CredentialInput... cis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCredential(RealmModel rm, UserModel um, CredentialInput ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel createCredentialThroughProvider(RealmModel rm, UserModel um, CredentialModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCredentialLabel(RealmModel rm, UserModel um, String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableCredentialType(RealmModel rm, UserModel um, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getDisableableCredentialTypes(RealmModel rm, UserModel um) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConfiguredFor(RealmModel rm, UserModel um, String string) {
        return false;
        //throw new UnsupportedOperationException(string); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConfiguredLocally(RealmModel rm, UserModel um, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialValidationOutput authenticate(KeycloakSession ks, RealmModel rm, CredentialInput ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getConfiguredUserStorageCredentialTypes(RealmModel rm, UserModel um) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCredential(RealmModel rm, UserModel um, CredentialModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel createCredential(RealmModel rm, UserModel um, CredentialModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeStoredCredential(RealmModel rm, UserModel um, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel getStoredCredentialById(RealmModel rm, UserModel um, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CredentialModel> getStoredCredentials(RealmModel rm, UserModel um) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CredentialModel> getStoredCredentialsByType(RealmModel rm, UserModel um, String string) {
        return this.currentCredentials;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CredentialModel getStoredCredentialByNameAndType(RealmModel rm, UserModel um, String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveCredentialTo(RealmModel rm, UserModel um, String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
