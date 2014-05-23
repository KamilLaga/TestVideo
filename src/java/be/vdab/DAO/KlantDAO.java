

package be.vdab.DAO;

import be.vdab.entities.Klant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil.laga
 */
public class KlantDAO {
    private final DatabaseUtil databaseUtil = new DatabaseUtil();
    private static final String READ_KLANT_FAMILIENAAM = "select * from klanten WHERE Familienaam LIKE ? ";
    
    public List<Klant> findByFamilienaam(String Familienaam) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            List<Klant> klanten = new ArrayList<Klant>();
            connection = databaseUtil.getConnection();
            statement= connection.prepareStatement(READ_KLANT_FAMILIENAAM);
            statement.setString(1, "%" +Familienaam+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                klanten.add(resultSetRijNaarKlant(resultSet));
            }
            return klanten;
        } catch (SQLException ex) {
            throw new DAOException("kan klanten niet laden uit database", ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
    private Klant resultSetRijNaarKlant(ResultSet resultSet) throws SQLException {
        return new Klant(resultSet.getLong("KlantNr"),resultSet.getString("Familienaam"),
                resultSet.getString("Voornaam"),resultSet.getString("StraatNummer"),resultSet.getString("Postcode"), 
                resultSet.getString("Gemeente"));
    }
}
