package org.openhbx.keycloak_themes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.keycloak.common.util.StringPropertyReplacer;
import org.keycloak.common.util.SystemEnvProperties;
import org.keycloak.models.RealmModel;
import org.keycloak.theme.ClassLoaderTheme;
import org.keycloak.theme.Theme;
import org.keycloak.services.util.LocaleUtil;

/**
 *
 * @author tevans
 */
public class ExtendedTheme implements Theme {

    private List<Theme> themes = new ArrayList<Theme>();
    private Properties properties;

    private ConcurrentHashMap<String, ConcurrentHashMap<Locale, Properties>> messages = new ConcurrentHashMap<>();

    public ExtendedTheme(String name, Type type, ClassLoader classLoader) throws IOException {
        this.themes.add(new ClassLoaderTheme(name, type, classLoader));
        ThemeClassLoader cLoader = new ThemeClassLoader(this.getClass().getClassLoader(), "");
        this.themes.add(new ClassLoaderTheme("base", type, cLoader));
    }

    @Override
    public String getName() {
        return themes.get(0).getName();
    }

    @Override
    public String getParentName() {
        return themes.get(0).getParentName();
    }

    @Override
    public String getImportName() {
        return themes.get(0).getImportName();
    }

    @Override
    public Type getType() {
        return themes.get(0).getType();
    }

    @Override
    public URL getTemplate(String name) throws IOException {
        for (Theme t : themes) {
            URL template = t.getTemplate(name);
            if (template != null) {
                return template;
            }
        }

        return null;
    }

    @Override
    public InputStream getResourceAsStream(String path) throws IOException {
        for (Theme t : themes) {
            InputStream resource = t.getResourceAsStream(path);
            if (resource != null) {
                return resource;
            }
        }

        return null;
    }

    @Override
    public Properties getMessages(Locale locale) throws IOException {
        return getMessages("messages", locale);
    }

    @Override
    public Properties getMessages(String baseBundlename, Locale locale) throws IOException {
        if (messages.get(baseBundlename) == null || messages.get(baseBundlename).get(locale) == null) {
            Properties messages = new Properties();

            Locale parent = getParent(locale);

            if (parent != null) {
                messages.putAll(getMessages(baseBundlename, parent));
            }

            ListIterator<Theme> itr = themes.listIterator(themes.size());
            while (itr.hasPrevious()) {
                Properties m = itr.previous().getMessages(baseBundlename, locale);
                if (m != null) {
                    messages.putAll(m);
                }
            }

            this.messages.putIfAbsent(baseBundlename, new ConcurrentHashMap<Locale, Properties>());
            this.messages.get(baseBundlename).putIfAbsent(locale, messages);

            return messages;
        } else {
            return messages.get(baseBundlename).get(locale);
        }
    }

    @Override
    public Properties getProperties() throws IOException {
        if (properties == null) {
            Properties properties = new Properties();
            ListIterator<Theme> itr = themes.listIterator(themes.size());
            while (itr.hasPrevious()) {
                Properties p = itr.previous().getProperties();
                if (p != null) {
                    properties.putAll(p);
                }
            }
            substituteProperties(properties);
            this.properties = properties;
            return properties;
        } else {
            return properties;
        }
    }

    private void substituteProperties(final Properties properties) {
        for (final String propertyName : properties.stringPropertyNames()) {
            properties.setProperty(propertyName, StringPropertyReplacer.replaceProperties(properties.getProperty(propertyName), new SystemEnvProperties()));
        }
    }

    private static Locale getParent(Locale locale) {
        if (Locale.ENGLISH.equals(locale)) {
            return null;
        }

        if (locale.getVariant() != null && !locale.getVariant().isEmpty()) {
            return new Locale(locale.getLanguage(), locale.getCountry());
        }

        if (locale.getCountry() != null && !locale.getCountry().isEmpty()) {
            return new Locale(locale.getLanguage());
        }

        return Locale.ENGLISH;
    }

    @Override
    public Properties getEnhancedMessages(RealmModel realm, Locale locale) throws IOException {
        if (locale == null){
            return null;
        }

        Map<Locale, Properties> localeMessages = Collections.singletonMap(locale, getMessages(locale));
        return LocaleUtil.enhancePropertiesWithRealmLocalizationTexts(realm, locale, localeMessages);
    }
}
