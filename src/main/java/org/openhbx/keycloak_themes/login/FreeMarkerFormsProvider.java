package org.openhbx.keycloak_themes.login;

import jakarta.ws.rs.core.Response;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import org.jboss.logging.Logger;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.theme.FreeMarkerException;
import org.keycloak.theme.freemarker.FreeMarkerProvider;
import org.keycloak.theme.Theme;
import org.keycloak.utils.MediaType;
import org.apache.commons.lang3.exception.ExceptionUtils;
/**
 *
 * @author tevans
 */
public class FreeMarkerFormsProvider extends FreeMarkerLoginFormsProvider {
    private final Logger responseLogger = Logger.getLogger(FreeMarkerFormsProvider.class);

    public FreeMarkerFormsProvider(KeycloakSession session) {
        super(session);
    }

    /**
     * Process FreeMarker template and prepare Response. Some fields are used
     * for rendering also.
     *
     * @param theme to be used (provided by <code>getTheme()</code>)
     * @param templateName name of the template to be rendered
     * @param locale to be used
     * @return Response object to be returned to the browser, never null
     */
    @Override
    protected Response processTemplate(Theme theme, String templateName, Locale locale) {
        try {
            this.freeMarker = session.getProvider(FreeMarkerProvider.class);
            String result = freeMarker.processTemplate(attributes, templateName, theme);
            //MediaType mediaType = contentType == null ? MediaType.TEXT_HTML_UTF_8_TYPE : contentType;
            Response.ResponseBuilder builder = Response.status(status == null ? Response.Status.OK : status).language(locale).entity(result);
            for (Map.Entry<String, String> entry : httpResponseHeaders.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
            return builder.build();
        } catch (FreeMarkerException e) {
            responseLogger.error("Failed to process template", e);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw, true);
            sw.write("Exception:\n\n");
            sw.write(ExceptionUtils.getMessage(e) + "\n");
            sw.write(ExceptionUtils.getStackTrace(e) + "\n\n");
            sw.write("Root Cause:\n\n");
            sw.write(ExceptionUtils.getRootCauseMessage(e) + "\n");
            ExceptionUtils.printRootCauseStackTrace(e, pw);
            return Response.serverError().entity(sw.toString()).build();
        }
    }
}
