package org.openhbx.keycloak_themes.login;

import java.util.HashMap;
import java.util.Map;
import org.keycloak.credential.CredentialModel;
import org.keycloak.credential.CredentialProvider;
import org.keycloak.models.KeycloakContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.ThemeManager;
import org.keycloak.models.UserCredentialManager;
import org.keycloak.provider.Provider;
import org.keycloak.theme.Theme;


import org.keycloak.urls.HostnameProvider;
/**
 *
 * @author tevans
 */
public class LoginSession extends org.openhbx.keycloak_themes.login.unimplemented.KeycloakSession implements KeycloakSession {
    
    private KeycloakContext context;
    private Map<Integer, Object> providers;
    private ThemeManager theme;
    private UserCredentialManager userCredentialManager;
    
    public LoginSession(Theme t, CredentialModel currentCredentials) {
        initializeProviders();
        this.context = new LoginContext(this);
        this.theme = new LoginThemeManager(t);
        this.userCredentialManager = new LoginUserCredentialManager(currentCredentials);
    }
    
    public LoginSession(Theme t) {
      this(t, null);
    }

    private void initializeProviders() {
        this.providers = new HashMap<Integer, Object>();
        this.providers.put(HostnameProvider.class.hashCode(), new LoginHostnameProvider());
        
        CredentialProvider otpcp = new LoginOtpCredentialProvider(this);
        Integer cphash = CredentialProvider.class.hashCode() + "keycloak-otp".hashCode();
        providers.put(cphash, otpcp);
        
    }

    @Override
    public KeycloakContext getContext() {
        return this.context;
    }

    @Override
    public <T extends Provider> T getProvider(Class<T> type) {
        return (T) this.providers.get(type.hashCode());
    }

    @Override
    public <T extends Provider> T getProvider(Class<T> type, String string) {
        Integer hash = type.hashCode() + string.hashCode();
        T provider = (T) providers.get(hash);
        return provider;
    }

    @Override
    public UserCredentialManager userCredentialManager() {
        return this.userCredentialManager;
    }

    @Override
    public ThemeManager theme() {
        return this.theme;
    }
}
