/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.DAO.FilmDAO;
import be.vdab.DAO.GenreDAO;
import be.vdab.entities.Film;
import be.vdab.entities.Genre;
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
@WebServlet("/welkom")
public class ReservatiesServlet extends HttpServlet {
    private static final long serialVersionUID =1L;
    private static final String VIEW = "/WEB-INF/JSP/reservaties.jsp";
    private final GenreDAO genreDAO = new GenreDAO();
    private final FilmDAO filmDAO = new FilmDAO();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("genres", genreDAO.findAll());        
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }*/
}
