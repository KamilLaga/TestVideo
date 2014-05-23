/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.DAO.KlantDAO;
import be.vdab.entities.Klant;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamil.laga
 */
@WebServlet("/klant")
public class KlantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/klant.jsp";
    private final KlantDAO klantDAO = new KlantDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Familienaam = request.getParameter("Familienaam");
        if (Familienaam != null) {
            Map<String,String> fouten = new HashMap<String,String>();
            if (Familienaam.isEmpty()) {
                fouten.put("familienaam", "Tik minstens 1 letter in");
            } else {
                List<Klant> klanten = klantDAO.findByFamilienaam(Familienaam);
                if (klanten.isEmpty()) {
                    fouten.put("nietgevonden", "Geen klanten gevonden");
                }
                request.setAttribute("klanten", klanten);
            }
            request.setAttribute("fouten", fouten);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
