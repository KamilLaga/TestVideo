
package be.vdab.servlets;

import be.vdab.DAO.FilmDAO;
import be.vdab.entities.Film;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@WebServlet("/Films")
public class FilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/films.jsp";
    private final FilmDAO filmDAO = new FilmDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        long genreNr = Long.parseLong(request.getParameter("genrenummer"));
        List<Film> films = filmDAO.readGenre(genreNr);
        String filmFotosPad = this.getServletContext().getRealPath("/images");
        Set<Long> filmsMetFoto = new HashSet<Long>();
        for (Film film: films) {
            File file = new File(filmFotosPad + "/" + film.getFilmNr() + ".jpg");
            if (file.exists()) {
                filmsMetFoto.add(film.getFilmNr());
            }
        }
        request.setAttribute("films", films);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request,response);
        
    }
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }*/
}
