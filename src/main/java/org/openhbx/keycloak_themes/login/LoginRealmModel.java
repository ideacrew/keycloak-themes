package org.openhbx.keycloak_themes.login;

import java.util.Arrays;
import java.util.stream.Stream;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.OTPPolicy;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RequiredCredentialModel;

/**
 *
 * @author tevans
 */
public class LoginRealmModel extends org.openhbx.keycloak_themes.login.unimplemented.RealmModel implements RealmModel {

    private String displayName = "LOGIN REALM DISPLAY NAME";
    private String name = "LOGIN REALM NAME";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String string) {
        this.name = string;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public void setDisplayName(String string) {
        this.displayName = string;
    }

    @Override
    public String getDisplayNameHtml() {
        return "LOGIN REALM";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isRegistrationAllowed() {
        return true;
    }

    @Override
    public boolean isRegistrationEmailAsUsername() {
        return true;
    }

    @Override
    public boolean isRememberMe() {
        return true;
    }

    @Override
    public boolean isLoginWithEmailAllowed() {
        return true;
    }

    @Override
    public boolean isDuplicateEmailsAllowed() {
        return false;
    }

    @Override
    public boolean isResetPasswordAllowed() {
        return true;
    }

    @Override
    public Stream<RequiredCredentialModel> getRequiredCredentialsStream() {
        return Arrays.stream(new RequiredCredentialModel[]{RequiredCredentialModel.PASSWORD});
    }

    @Override
    public OTPPolicy getOTPPolicy() {
        OTPPolicy otpp = new OTPPolicy();
        otpp.setType("otp");
        return otpp;
    }

    @Override
    public Stream<IdentityProviderModel> getIdentityProvidersStream() {
        return Arrays.stream(new IdentityProviderModel[]{});
    }

    @Override
    public boolean isInternationalizationEnabled() {
        return false;
    }

}
