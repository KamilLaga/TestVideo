/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;


/**
 *
 * @author kamil.laga
 */
public class RapportDAO {
    private final DatabaseUtil databaseUtil = new DatabaseUtil();
    private static final String READ_KLANT_FAMILIENAAM = "select * from klanten WHERE Familienaam LIKE ? ";
    private static final String MAKE_RESERVATION = "insert into reservaties (KlantNr, FilmNr, ReservatieDatum) values (?,?,?)";
    
    public synchronized void maakReservatie(long klantNr, long filmNr, Date reservatieDatum) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {

            connection = databaseUtil.getConnection();
            statement= connection.prepareStatement(MAKE_RESERVATION);
            //resultSet = statement.executeQuery(READ_RESERVATIONS);
            statement.setLong(1, klantNr);
            statement.setLong(2, filmNr);
            statement.setDate(3, reservatieDatum);
            int aantal = statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("kan reservatie niet aan database toevoegen", ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
}
