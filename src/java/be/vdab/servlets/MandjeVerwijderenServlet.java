/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.DAO.FilmDAO;
import be.vdab.entities.Film;
import be.vdab.entities.Mandje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mandje/verwijderen")
public class MandjeVerwijderenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW ="/mandje";
    private static final String MANDJE="mandje";
    private final FilmDAO filmDAO = new FilmDAO();
    private final Mandje mandje = new Mandje();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
    
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         if (session != null) {
            Mandje mandje = (Mandje) session.getAttribute(MANDJE);
            
             if (request.getParameterValues("filmNr") != null) {
                 try {
                     for (String filmNrAlsString : request.getParameterValues("filmNr")) {
                         long filmNr= Long.parseLong(filmNrAlsString);
                         mandje.removeByFilmNr(filmNr);                         
                     }
                 } catch (NumberFormatException ex) {ex.getMessage();}
             }
             
         }
         response.sendRedirect(request.getContextPath() + VIEW);
    }

    

}
