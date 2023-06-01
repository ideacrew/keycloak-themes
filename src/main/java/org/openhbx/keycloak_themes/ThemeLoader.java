package org.openhbx.keycloak_themes;
import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.core.HTMLOutputFormat;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author tevans
 */
public class ThemeLoader {
    public static class UrlLoader extends URLTemplateLoader {

        @Override
        protected URL getURL(String string) {
            try {
                return new URL(string);
            } catch (MalformedURLException ex) {
                return null;
            }
        }
    
    }
    
    public static Configuration initiateConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setOutputFormat(HTMLOutputFormat.INSTANCE);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setTemplateLoader(new UrlLoader());
        configuration.setLocalizedLookup(false);
        return configuration;
    }
}
