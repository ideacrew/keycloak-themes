package org.openhbx.keycloak_themes.login;

import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProvider;
import org.keycloak.theme.Theme;
import org.openhbx.keycloak_themes.LoginThemeInventory;

/**
 *
 * @author tevans
 */
public abstract class ThemeRenderTestBase {
    
    protected abstract String themeName();
     
    protected Theme selectTheme() throws IOException {
        List<Theme> themes = LoginThemeInventory.getThemes();
        for (Theme t: themes) {
            if (this.themeName().equalsIgnoreCase(t.getName())) {
                return t;
            }
        }
        return null;
    }
    
    @Test
    public void renderLoginWithPasswordTest() throws IOException, Exception {
        Response r = TemplateRenderContext.renderSelectedTemplate(selectTheme(), LoginThemeInventory.LOGIN_TEMPLATE);
        if (r.getStatus() >= 500) {
            throw new Exception(r.getEntity().toString());
        }
    }
    
    @Test
    public void renderLoginOtpTest() throws IOException, Exception {
        Response r = TemplateRenderContext.renderSelectedTemplate(selectTheme(), LoginThemeInventory.OTP_TEMPLATE);
        if (r.getStatus() >= 500) {
            throw new Exception(r.getEntity().toString());
        }
    }
    
    @Test
    public void renderLoginConfigureOtpTest() throws IOException, Exception {
        Response r = TemplateRenderContext.renderSelectedTemplate(selectTheme(), LoginThemeInventory.CONFIG_TOPT_TEMPLATE);
        if (r.getStatus() >= 500) {
            throw new Exception(r.getEntity().toString());
        }
    }
    
    @Test
    public void renderVerifyEmailTest() throws IOException, Exception {
        Response r = TemplateRenderContext.renderSelectedTemplate(selectTheme(), LoginThemeInventory.VERIFY_EMAIL_TEMPLATE);
        if (r.getStatus() >= 500) {
            throw new Exception(r.getEntity().toString());
        }
    }
    
    @Test
    public void renderResetPasswordTest() throws IOException, Exception {
        Response r = TemplateRenderContext.renderSelectedTemplate(selectTheme(), LoginThemeInventory.RESET_PASSWORD_TEMPLATE);
        if (r.getStatus() >= 500) {
            throw new Exception(r.getEntity().toString());
        }
    }           
}
