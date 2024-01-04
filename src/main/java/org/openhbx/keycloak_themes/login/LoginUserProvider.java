package org.openhbx.keycloak_themes.login;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.keycloak.models.FederatedIdentityModel;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.UserProvider;

/**
 *
 * @author tevans
 */
public class LoginUserProvider extends org.openhbx.keycloak_themes.login.unimplemented.UserProvider implements UserProvider {
    private final UserModel cModel;
    
    public LoginUserProvider(UserModel uModel) {
        this.cModel = uModel;
    }
    
    @Override
    public Stream<FederatedIdentityModel> getFederatedIdentitiesStream(RealmModel rm, UserModel um) {
        if (this.cModel != null) {
          FederatedIdentityModel fim = new FederatedIdentityModel("", this.cModel.getId(), this.cModel.getUsername());
          return Collections.singletonList(fim).stream();
        }
        List<FederatedIdentityModel> iList = Collections.emptyList();
        return iList.stream();
    }
}
