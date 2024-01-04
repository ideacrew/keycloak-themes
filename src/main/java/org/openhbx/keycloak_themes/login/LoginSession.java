package org.openhbx.keycloak_themes.login;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.keycloak.authentication.otp.OTPApplicationProvider;
import org.keycloak.credential.CredentialModel;
import org.keycloak.credential.CredentialProvider;
import org.keycloak.models.KeycloakContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.ThemeManager;
import org.keycloak.models.UserModel;
import org.keycloak.models.UserProvider;
import org.keycloak.provider.Provider;
import org.keycloak.theme.KeycloakSanitizerMethod;
import org.keycloak.theme.Theme;
import org.keycloak.theme.freemarker.FreeMarkerProvider;
import org.keycloak.theme.freemarker.DefaultFreeMarkerProvider;


import org.keycloak.urls.HostnameProvider;
/**
 *
 * @author tevans
 */
public class LoginSession extends org.openhbx.keycloak_themes.login.unimplemented.KeycloakSession implements KeycloakSession {
    
    private KeycloakContext context;
    private Map<Integer, Object> providers;
    private ThemeManager theme;
    private UserModel currentUser;
    
    public LoginSession(Theme t, CredentialModel currentCredentials, UserModel uModel) {
        initializeProviders();
        this.context = new LoginContext(this);
        this.theme = new LoginThemeManager(t);
        this.currentUser = uModel;
    }
    
    public LoginSession(Theme t) {
      this(t, null, null);
    }
    
    private void initializeProviders() {
        ConcurrentHashMap<String,freemarker.template.Template> cacheMap = new ConcurrentHashMap<String,freemarker.template.Template>();
        KeycloakSanitizerMethod sMethod = new KeycloakSanitizerMethod();
        this.providers = new HashMap<Integer, Object>();
        this.providers.put(HostnameProvider.class.hashCode(), new LoginHostnameProvider());
        this.providers.put(FreeMarkerProvider.class.hashCode(), new DefaultFreeMarkerProvider(cacheMap, sMethod));
        this.providers.put(OTPApplicationProvider.class.hashCode(), new LoginOtpApplicationProvider());

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
    public ThemeManager theme() {
        return this.theme;
    }
    
    @Override
    public <T extends Provider> Set<T> getAllProviders(Class<T> clazz) {
        return Collections.singleton(getProvider(clazz));
    }
    
    @Override
    public <T extends Provider> Set<String> listProviderIds(Class<T> clazz) {
        return this.providers.keySet().stream().map(id -> id.toString()).collect(Collectors.toSet());
    }

    @Override
    public UserProvider users() {
        return new LoginUserProvider(currentUser);
    }
    
}
