package org.openhbx.keycloak_themes.login;

import org.keycloak.authentication.otp.OTPApplicationProvider;
import org.keycloak.models.OTPPolicy;

/**
 *
 * @author tevans
 */
public class LoginOtpApplicationProvider implements OTPApplicationProvider {

    @Override
    public String getName() {
        return "LoginOtpApplicationProvider";
    }

    @Override
    public boolean supports(OTPPolicy otpp) {
        return true;
    }

    @Override
    public void close() {
        
    }
    
}
