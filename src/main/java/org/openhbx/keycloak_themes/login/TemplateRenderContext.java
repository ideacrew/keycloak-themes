package org.openhbx.keycloak_themes.login;

import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.credential.CredentialModel;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.models.UserModel.RequiredAction;
import org.keycloak.sessions.AuthenticationSessionModel;
import org.keycloak.theme.Theme;
import org.openhbx.keycloak_themes.LoginThemeInventory;

/**
 *
 * @author tevans
 */
public class TemplateRenderContext {
    public static FreeMarkerLoginFormsProvider dummyLoginFormsProvider(Theme t, CredentialModel currentCredentials, UserModel userModel) {
        KeycloakSession kSession = new LoginSession(t, currentCredentials, userModel);
        FreeMarkerLoginFormsProvider provider = new FreeMarkerFormsProvider(kSession);
        provider.setActionUri(URI.create("https://keycloak/login"));
        return provider;
    }
    
    public static FreeMarkerLoginFormsProvider dummyLoginFormsProvider(Theme t) {
        return dummyLoginFormsProvider(t, null, null);
    }
    
    public static CredentialModel createMockCredential() {
        CredentialModel cm = new CredentialModel();
        return cm;
    }
    
    public static Response renderSelectedTemplate(Theme t, String templateName) {
        FreeMarkerLoginFormsProvider lfp;
        lfp = dummyLoginFormsProvider(t);
        if (LoginThemeInventory.CODE_TEMPLATE.equalsIgnoreCase(templateName)) {
            return lfp.createCode();
        } else if (LoginThemeInventory.CONFIG_TOPT_TEMPLATE.equalsIgnoreCase(templateName)) {
            CredentialModel cm = TemplateRenderContext.createMockCredential();
            cm.setType(CredentialModel.OTP);
            UserModel user = new LoginUserModel(cm);
            lfp = TemplateRenderContext.dummyLoginFormsProvider(t, cm, user);
            lfp.setUser(user);
            return lfp.createResponse(RequiredAction.CONFIGURE_TOTP);
        } else if (LoginThemeInventory.OAUTH2_DEVICE_VERIFY_TEMPLATE.equalsIgnoreCase(templateName)) {
            return lfp.createOAuth2DeviceVerifyUserCodePage();
        } else if (LoginThemeInventory.OTP_TEMPLATE.equalsIgnoreCase(templateName)) {
            CredentialModel cm = TemplateRenderContext.createMockCredential();
            cm.setType(CredentialModel.OTP);
            UserModel uModel = new LoginUserModel(cm);
            lfp = TemplateRenderContext.dummyLoginFormsProvider(t, cm, uModel);
            lfp.setUser(uModel);
            return lfp.createLoginTotp();
        } else if (LoginThemeInventory.RESET_PASSWORD_TEMPLATE.equalsIgnoreCase(templateName)) {
            CredentialModel cm = TemplateRenderContext.createMockCredential();
            MultivaluedMap<String, String> formData = new MultivaluedHashMap<String,String>();
            lfp.setFormData(formData);
            AuthenticationSessionModel asm = new LoginAuthenticationSession();
            lfp.setAuthenticationSession(asm);
            UserModel uModel = new LoginUserModel(cm);
            AuthenticationFlowContext afc = new LoginAuthenticationFlowContext(asm,uModel);
            lfp.setUser(uModel);
            lfp.setAuthContext(afc);
            return lfp.createPasswordReset();
        } else if (LoginThemeInventory.VERIFY_EMAIL_TEMPLATE.equalsIgnoreCase(templateName)) {
            CredentialModel cm = TemplateRenderContext.createMockCredential();
            cm.setType(CredentialModel.OTP);
            UserModel uModel = new LoginUserModel(cm);
            lfp = TemplateRenderContext.dummyLoginFormsProvider(t, cm, uModel);
            lfp.setUser(uModel);
            return lfp.createResponse(RequiredAction.VERIFY_EMAIL);
        } else if (LoginThemeInventory.SELECT_AUTHENTICATOR_TEMPLATE.equalsIgnoreCase(templateName)) {
            return lfp.createSelectAuthenticator();
        }
        return lfp.createLoginUsernamePassword();
    }
}
