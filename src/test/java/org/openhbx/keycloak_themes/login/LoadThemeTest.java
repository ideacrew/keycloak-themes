package org.openhbx.keycloak_themes.login;

import org.openhbx.keycloak_themes.LoginThemeInventory;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.openhbx.keycloak_themes.ThemeLoader;
import org.keycloak.theme.Theme;

/**
 *
 * @author tevans
 */
public class LoadThemeTest {
    
    @Test
    public void LocateTemplatesTest() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        List<Theme> themes = LoginThemeInventory.getThemes();
        Configuration c = ThemeLoader.initiateConfiguration();
        for (Theme t : themes) {
            for (String tName : LoginThemeInventory.TEMPLATE_LIST) {
              c.getTemplate(t.getTemplate(tName).toString());
            }
        }
    }
}
