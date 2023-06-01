package org.openhbx.keycloak_themes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 *
 * @author tevans
 */
public class ThemeClassLoader extends ClassLoader {
    private String themeRoot;
    
    public ThemeClassLoader(ClassLoader parent, String themeRoot) {
      super(parent);
      this.themeRoot = themeRoot;
    }
    
    @Override
    public URL getResource(String name) {
        return super.getResource(this.themeRoot + name);
    }
    
    @Override
    public InputStream getResourceAsStream(String name) {
        return super.getResourceAsStream(this.themeRoot + name);
    }
    
    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        return super.getResources(this.themeRoot + name);
    }
}
