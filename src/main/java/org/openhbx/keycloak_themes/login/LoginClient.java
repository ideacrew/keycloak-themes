package org.openhbx.keycloak_themes.login;

import org.keycloak.models.ClientModel;
import org.keycloak.models.RealmModel;

/**
 *
 * @author tevans
 */
public class LoginClient extends org.openhbx.keycloak_themes.login.unimplemented.ClientModel implements ClientModel {

    private RealmModel realm;

    public LoginClient(RealmModel rm) {
        this.realm = rm;
    }

    @Override
    public String getClientId() {
        return "clientID";
    }

    @Override
    public String getName() {
        return "clientName";
    }

    @Override
    public RealmModel getRealm() {
        return this.realm;
    }

}
