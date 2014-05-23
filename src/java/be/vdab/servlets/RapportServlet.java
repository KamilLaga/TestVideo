/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.DAO.FilmDAO;
import be.vdab.DAO.RapportDAO;
import be.vdab.entities.Film;
import be.vdab.entities.Klant;
import be.vdab.entities.Mandje;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet("/rapport")
public class RapportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/rapport.jsp";
    private final RapportDAO rapportDAO = new RapportDAO();
    private final FilmDAO filmDAO = new FilmDAO();
    private static final String MANDJE = "mandje";
    private static final String KLANT = "klant";
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         Map<String,String> fouten = new HashMap<String,String>();
         if (session != null) {
            Mandje mandje = (Mandje) session.getAttribute(MANDJE);
            if (mandje != null) {
                List<Film> films = mandje.getFilms();
                for (Film film : films) {
                    long filmNr = film.getFilmNr();
                    //long voorraad = film.getVoorraad();
                    //long gereserveerd = film.getGereserveerd();
                    if (filmDAO.controleFilm(filmNr) == true) {
                        
                        filmDAO.reserveerFilm(filmNr);
                        
                        java.util.Date utilDate = new java.util.Date();
                        java.sql.Date reservatieDatum = new java.sql.Date(utilDate.getTime());
                        List<Klant> klanten = (List<Klant>) session.getAttribute(KLANT);
                        for (Klant klant : klanten) {
                            long klantNr = klant.getKlantNr();
                            rapportDAO.maakReservatie(klantNr, filmNr, reservatieDatum);
                        }
                    } else {
                        fouten.put("fout", film.getTitel());
                    }
                }
                
            }
            request.setAttribute("fouten", fouten);
        }
         RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
         dispatcher.forward(request, response);
    }
}
