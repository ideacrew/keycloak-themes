package org.openhbx.keycloak_themes.login;

import java.net.URI;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tevans
 */
public class LoginUriInfo implements UriInfo {
    private URI sourceUri = URI.create("https://keycloak_themes_test/");

    @Override
    public String getPath() {
        return "/";
    }

    @Override
    public String getPath(boolean bln) {
        return "/";
    }

    @Override
    public List<PathSegment> getPathSegments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PathSegment> getPathSegments(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URI getRequestUri() {
        return this.sourceUri;
    }

    @Override
    public UriBuilder getRequestUriBuilder() {
        return UriBuilder.fromUri(this.getRequestUri());
    }

    @Override
    public URI getAbsolutePath() {
        return this.sourceUri;
    }

    @Override
    public UriBuilder getAbsolutePathBuilder() {
        return UriBuilder.fromUri(this.getAbsolutePath());
    }

    @Override
    public URI getBaseUri() {
        return this.sourceUri;
    }

    @Override
    public UriBuilder getBaseUriBuilder() {
        return UriBuilder.fromUri(this.getBaseUri());
    }

    @Override
    public MultivaluedMap<String, String> getPathParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultivaluedMap<String, String> getPathParameters(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultivaluedMap<String, String> getQueryParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MultivaluedMap<String, String> getQueryParameters(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getMatchedURIs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getMatchedURIs(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getMatchedResources() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URI resolve(URI uri) {
        return this.sourceUri.resolve(uri);
    }

    @Override
    public URI relativize(URI uri) {
        return this.sourceUri.relativize(uri);
    }
    
}
