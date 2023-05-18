package org.openhbx.keycloak_themes.login;

import java.io.IOException;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialModel;
import org.keycloak.credential.CredentialTypeMetadata;
import org.keycloak.credential.CredentialTypeMetadataContext;
import org.keycloak.credential.OTPCredentialProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.OTPCredentialModel;
import org.keycloak.models.credential.dto.OTPCredentialData;
import org.keycloak.models.credential.dto.OTPSecretData;
import org.keycloak.util.JsonSerialization;

/**
 *
 * @author tevans
 */
public class LoginOtpCredentialProvider extends OTPCredentialProvider  {

    private KeycloakSession session;

    public LoginOtpCredentialProvider(KeycloakSession session) {
        super(session);
        this.session = session;
    }

    @Override
    public String getType() {
        return OTPCredentialModel.TYPE;
    }

    @Override
    public CredentialModel createCredential(RealmModel rm, UserModel um, OTPCredentialModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCredential(RealmModel rm, UserModel um, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OTPCredentialModel getCredentialFromModel(CredentialModel credentialModel) {
        try {
        OTPCredentialData credentialData = new OTPCredentialData("",0,0,0,"");
        OTPSecretData secretData = new OTPSecretData("");
        credentialModel.setCredentialData(JsonSerialization.writeValueAsString(credentialData));
        credentialModel.setSecretData(JsonSerialization.writeValueAsString(secretData));
        return OTPCredentialModel.createFromCredentialModel(credentialModel); 
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CredentialTypeMetadata getCredentialTypeMetadata(CredentialTypeMetadataContext ctmc) {
        return CredentialTypeMetadata.builder()
                .type(getType())
                .category(CredentialTypeMetadata.Category.TWO_FACTOR)
                .displayName("otp-display-name")
                .helpText("otp-help-text")
                .iconCssClass("kcAuthenticatorOTPClass")
                .createAction(UserModel.RequiredAction.CONFIGURE_TOTP.toString())
                .removeable(true)
                .build(session);
    }

    @Override
    public boolean supportsCredentialType(String string) {
        return getType().equals(string);
    }

    @Override
    public boolean isConfiguredFor(RealmModel rm, UserModel um, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(RealmModel rm, UserModel um, CredentialInput ci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
