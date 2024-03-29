package org.openhbx.keycloak_themes.login;

import java.net.URI;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.credential.CredentialModel;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.models.UserModel.RequiredAction;
import org.keycloak.sessions.AuthenticationSessionModel;
import org.keycloak.theme.FreeMarkerUtil;
import org.keycloak.theme.Theme;
import org.openhbx.keycloak_themes.LoginThemeInventory;

/**
 *
 * @author tevans
 */
public class TemplateRenderContext {
    public static FreeMarkerLoginFormsProvider dummyLoginFormsProvider(Theme t, CredentialModel currentCredentials) {
        FreeMarkerUtil fmu = new FreeMarkerUtil();
        KeycloakSession kSession = new LoginSession(t, currentCredentials);
        FreeMarkerLoginFormsProvider provider = new FreeMarkerFormsProvider(kSession,fmu);
        provider.setActionUri(URI.create("https://keycloak/login"));
        return provider;
    }
    
    public static FreeMarkerLoginFormsProvider dummyLoginFormsProvider(Theme t) {
        return dummyLoginFormsProvider(t, null);
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
            lfp = TemplateRenderContext.dummyLoginFormsProvider(t, cm);
            lfp.setUser(new LoginUserModel());
            return lfp.createResponse(RequiredAction.CONFIGURE_TOTP);
        } else if (LoginThemeInventory.OAUTH2_DEVICE_VERIFY_TEMPLATE.equalsIgnoreCase(templateName)) {
            return lfp.createOAuth2DeviceVerifyUserCodePage();
        } else if (LoginThemeInventory.OTP_TEMPLATE.equalsIgnoreCase(templateName)) {
            CredentialModel cm = TemplateRenderContext.createMockCredential();
            cm.setType(CredentialModel.OTP);
            lfp = TemplateRenderContext.dummyLoginFormsProvider(t, cm);
            return lfp.createLoginTotp();
        } else if (LoginThemeInventory.RESET_PASSWORD_TEMPLATE.equalsIgnoreCase(templateName)) {
            MultivaluedMap<String, String> formData = new MultivaluedHashMap<String,String>();
            lfp.setFormData(formData);
            AuthenticationSessionModel asm = new LoginAuthenticationSession();
            lfp.setAuthenticationSession(asm);
            UserModel uModel = new LoginUserModel();
            AuthenticationFlowContext afc = new LoginAuthenticationFlowContext(asm,uModel);
            lfp.setUser(uModel);
            lfp.setAuthContext(afc);
            return lfp.createPasswordReset();
        } else if (LoginThemeInventory.VERIFY_EMAIL_TEMPLATE.equalsIgnoreCase(templateName)) {
            return lfp.createResponse(RequiredAction.VERIFY_EMAIL);
        } else if (LoginThemeInventory.SELECT_AUTHENTICATOR_TEMPLATE.equalsIgnoreCase(templateName)) {
            return lfp.createSelectAuthenticator();
        }
        return lfp.createLoginPassword();
    }
}
