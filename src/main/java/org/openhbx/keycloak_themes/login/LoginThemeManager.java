package org.openhbx.keycloak_themes.login;

import java.io.IOException;
import java.util.Set;
import org.keycloak.models.ThemeManager;
import org.keycloak.theme.Theme;

/**
 *
 * @author tevans
 */
public class LoginThemeManager implements ThemeManager {

    private Theme loginTheme;
    
    public LoginThemeManager(Theme t) {
        this.loginTheme = t;
    }
    
    @Override
    public Theme getTheme(Theme.Type type) throws IOException {
        return this.loginTheme;
    }

    @Override
    public Theme getTheme(String string, Theme.Type type) throws IOException {
        return this.loginTheme;
    }

    @Override
    public Set<String> nameSet(Theme.Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCacheEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearCache() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
