

package be.vdab.DAO;

import be.vdab.entities.Genre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil.laga
 */
public class GenreDAO {
    private static final String FIND_ALL = "select * from genres order by naam";
    private final DatabaseUtil databaseUtil = new DatabaseUtil();
    
    public List<Genre> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Genre> genres = new ArrayList<Genre>();
            connection = databaseUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                genres.add(resultSetRijNaarGenre(resultSet));
            }
            return genres;
        } catch (SQLException ex) {
            throw new DAOException("kan genres niet laden uit database", ex);
        } finally {
            databaseUtil.close(resultSet, statement, connection);
        }
    }
    
    private Genre resultSetRijNaarGenre(ResultSet resultSet) throws SQLException {
        return new Genre(resultSet.getLong("genreNr"), 
                resultSet.getString("Naam"));
    }
    
}
