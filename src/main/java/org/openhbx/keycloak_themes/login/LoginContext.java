package org.openhbx.keycloak_themes.login;

import jakarta.ws.rs.core.HttpHeaders;
import java.net.URI;
import java.util.Locale;
import org.keycloak.common.ClientConnection;
import org.keycloak.http.HttpRequest;
import org.keycloak.http.HttpResponse;
import org.keycloak.models.ClientModel;
import org.keycloak.models.KeycloakContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakUriInfo;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.sessions.AuthenticationSessionModel;
import org.keycloak.urls.UrlType;

/**
 *
 * @author tevans
 */
public class LoginContext implements KeycloakContext {
    private RealmModel realm;
    private ClientModel client;
    private KeycloakUriInfo uriInfo;
    
    public LoginContext(KeycloakSession session) {
        this.realm = new LoginRealmModel();
        this.client = new LoginClient(this.realm);
        this.uriInfo = new KeycloakUriInfo(session, UrlType.BACKEND,new LoginUriInfo());
    }

    @Override
    public URI getAuthServerUrl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getContextPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeycloakUriInfo getUri() {
        return this.uriInfo;
    }

    @Override
    public KeycloakUriInfo getUri(UrlType ut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HttpHeaders getRequestHeaders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T getContextObject(Class<T> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RealmModel getRealm() {
        return this.realm;
    }

    @Override
    public void setRealm(RealmModel rm) {
        this.realm = rm;
    }

    @Override
    public ClientModel getClient() {
        return this.client;
    }

    @Override
    public void setClient(ClientModel cm) {
        this.client = cm;
    }

    @Override
    public ClientConnection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locale resolveLocale(UserModel um) {
        return Locale.US;
    }

    @Override
    public AuthenticationSessionModel getAuthenticationSession() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthenticationSession(AuthenticationSessionModel asm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HttpRequest getHttpRequest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HttpResponse getHttpResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

