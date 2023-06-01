package org.openhbx.keycloak_themes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.keycloak.theme.Theme;

/**
 *
 * @author tevans
 */
public class LoginThemeInventory {
  public static String[] THEME_LIST = {"maine-sbm", "maine-cp"};
  
  public final static String CODE_TEMPLATE = "code.ftl";
  public final static String CONFIG_TOPT_TEMPLATE = "login-config-totp.ftl";
  public final static String OAUTH2_DEVICE_VERIFY_TEMPLATE = "login-oauth2-device-verify-user-code.ftl";
  public final static String OTP_TEMPLATE = "login-otp.ftl";
  public final static String RESET_PASSWORD_TEMPLATE = "login-reset-password.ftl";
  public final static String VERIFY_EMAIL_TEMPLATE = "login-verify-email.ftl";
  public final static String LOGIN_TEMPLATE = "login.ftl";
  public final static String SELECT_AUTHENTICATOR_TEMPLATE = "select-authenticator.ftl";
  
    
  public static String[] TEMPLATE_LIST = {
    CODE_TEMPLATE,
    CONFIG_TOPT_TEMPLATE,
    OAUTH2_DEVICE_VERIFY_TEMPLATE,
    OTP_TEMPLATE,
    RESET_PASSWORD_TEMPLATE,
    VERIFY_EMAIL_TEMPLATE,
    LOGIN_TEMPLATE,
    SELECT_AUTHENTICATOR_TEMPLATE
  };
  
  public static List<Theme> getThemes() throws IOException {
      List<Theme> themes = new ArrayList<Theme>();
      for (String tn : THEME_LIST) {
        Theme theme = new ExtendedTheme(tn, Theme.Type.LOGIN, classLoaderForThemes());
        themes.add(theme);
      }
      return themes;
  }
  
  public static ClassLoader classLoaderForThemes() {
      return new ThemeClassLoader(LoginThemeInventory.class.getClassLoader(), "org/openhbx/keycloak_themes/");
  }
}
