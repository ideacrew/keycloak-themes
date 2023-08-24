package org.openhbx.keycloak_themes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.keycloak.theme.Theme;
import org.openhbx.keycloak_themes.login.TemplateRenderContext;

/**
 *
 * @author tevans
 */
@WebServlet(name = "ThemeHostServelet", urlPatterns = {"/preview/*"})
public class ThemeHostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paths = isolatePath(request);
        Theme t = selectTheme(paths.split("/",3)[0]);
        Response r = TemplateRenderContext.renderSelectedTemplate(t, paths.split("/",3)[1]);
        response.setStatus(r.getStatus());
        response.getWriter().write(r.getEntity().toString());
    }
    
    private String isolatePath(HttpServletRequest request) {
        URI theUri = URI.create(request.getRequestURI());
        String[] pathParts = theUri.getPath().split("/", 3);
        return pathParts[2];
    }

    private Theme selectTheme(String themeName) throws IOException {
        List<Theme> themes = LoginThemeInventory.getThemes();
        for (Theme t: themes) {
            if(t.getName().equalsIgnoreCase(themeName)) {
                return t;
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
