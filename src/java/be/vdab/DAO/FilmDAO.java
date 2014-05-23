/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.DAO;

import be.vdab.entities.Film;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kamil.laga
 */
public class FilmDAO {
    private static final String FIND_ALL = "select * from films";
    private static final String READ_GENRENR = "select * from films where GenreNr=? order by titel";
    private static final String READ_FILMNR = "select * from films where FilmNr=?";
    private static final String UPDATE_FILM = "update films set Gereserveerd=Gereserveerd + 1 where FilmNr = ?";
    private static final String READ_TITEL=  "select * from films WHERE titel LIKE ? ";
    private final DatabaseUtil databaseUtil = new DatabaseUtil();
    
    public List<Film> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Film> genres = new ArrayList<Film>();
            connection = databaseUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                genres.add(resultSetRijNaarFilm(resultSet));
            }
            return genres;
        } catch (SQLException ex) {
            throw new DAOException("kan genres niet laden uit database", ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
    private Film resultSetRijNaarFilm(ResultSet resultSet) throws SQLException {
        return new Film(resultSet.getLong("FilmNr"),resultSet.getLong("GenreNr"),
                resultSet.getString("Titel"),resultSet.getLong("Voorraad"),resultSet.getLong("Gereserveerd"), 
                resultSet.getBigDecimal("Prijs"));
    }

    public List<Film> readGenre(long genreNr) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            List<Film> films = new ArrayList<Film>();
            connection = databaseUtil.getConnection();
            statement = connection.prepareStatement(READ_GENRENR);
            statement.setLong(1, genreNr);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                films.add(resultSetRijNaarFilm(resultSet));
            }
            return films;
        }
        catch (SQLException ex) {
            throw new DAOException("Kan film niet lezen uit database", ex);
        }
        finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
    
    
    public Film readFilmNr(long filmNr) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Film film = null;
            connection = databaseUtil.getConnection();
            statement = connection.prepareStatement(READ_FILMNR);
            statement.setLong(1, filmNr);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                film = resultSetRijNaarFilm(resultSet);
            }
            return film;
        }
        catch (SQLException ex) {
            throw new DAOException("Kan film niet lezen uit database", ex);
        }
        finally {
            databaseUtil.close(resultSet, statement, connection);
        }   
    }
    
    public synchronized void reserveerFilm(long filmNr) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = databaseUtil.getConnection();
            statement = connection.prepareStatement(UPDATE_FILM);
            statement.setLong(1, filmNr);
            int aantal = statement.executeUpdate();   
        }
        catch (SQLException ex) {
            throw new DAOException("Kan film niet lezen uit database", ex);
        }
        finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
    public synchronized boolean controleFilm(long filmNr) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Film film = null;
            connection = databaseUtil.getConnection();
            statement = connection.prepareStatement(READ_FILMNR);
            statement.setLong(1, filmNr);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                film = resultSetRijNaarFilm(resultSet);
            }
            long voorraad = film.getVoorraad();
            long gereserveerd = film.getGereserveerd();
            if (voorraad > gereserveerd) {
                return true;
            }
            else return false;
        }
        catch (SQLException ex) {
            throw new DAOException("Kan film niet lezen uit DB", ex);
        }
    }
}