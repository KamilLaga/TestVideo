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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kamil.laga
 */
@WebServlet("/Films/Detail")
public class FilmDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/filmdetail.jsp";
    private static final String REDIRECT_URL = "/mandje";
    private static final String MANDJE = "mandje";  
    private final FilmDAO filmDAO = new FilmDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long filmNr = Long.parseLong(request.getParameter("filmNummer"));
        Film film = filmDAO.readFilmNr(filmNr);
        request.setAttribute("filmDetail", film);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request,response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            HttpSession session= request.getSession();
            long filmNr = Long.parseLong(request.getParameter("filmNummer"));
            if (session != null) {
               Mandje mandje = (Mandje) session.getAttribute(MANDJE);  
                if (mandje == null) {                                         
                    mandje = new Mandje();                       
                    try {
                        Film film = filmDAO.readFilmNr(filmNr);
                        mandje.addFilm(film);
                        session.setAttribute(MANDJE, mandje);                     
                    } catch (Exception ex) {
                }
            } 
        }
        response.sendRedirect(REDIRECT_URL);
    }
}
