package org.openhbx.keycloak_themes.login;

import javax.ws.rs.core.UriInfo;
import org.keycloak.urls.HostnameProvider;
import org.keycloak.urls.UrlType;

/**
 *
 * @author tevans
 */
public class LoginHostnameProvider implements HostnameProvider {
    @Override
    public String getScheme(UriInfo originalUriInfo, UrlType type) {
        return "https";
    }

    @Override
    public String getScheme(UriInfo originalUriInfo) {
        return "https";
    }

    @Override
    public String getHostname(UriInfo originalUriInfo, UrlType type) {
        return "keycloak_theme_test";
    }

    @Override
    public String getHostname(UriInfo originalUriInfo) {
        return "keycloak_theme_test";
    }

    @Override
    public int getPort(UriInfo originalUriInfo, UrlType type) {
        return 443;
    }

    @Override
    public int getPort(UriInfo originalUriInfo) {
        return 443;
    }

    @Override
    public String getContextPath(UriInfo originalUriInfo, UrlType type) {
        return "/";
    }

    @Override
    public String getContextPath(UriInfo originalUriInfo) {
        return "/";
    }
}
