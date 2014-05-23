

package be.vdab.DAO;

/**
 *
 * @author kamil.laga
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DatabaseUtil {
    private static final String JNDI_NAME = "java:/comp/env/jdbc/reservaties";
    
    public Connection getConnection() {
        Context context = null;
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(JNDI_NAME);
            return dataSource.getConnection();
        } catch (NamingException ex) {
            throw new DAOException(JNDI_NAME + "niet gevonden", ex);
        } catch (SQLException ex) {
            throw new DAOException("kan geen connectie krijgen van " + JNDI_NAME , ex);
        } finally {
            try {
                if (context != null) {
                    context.close();
                }
            } catch (NamingException ex) {
                throw new DAOException("kan " + JNDI_NAME + " niet sluiten", ex);
            }
        } 
    }
    
    public void close(Statement statement, Connection connection) {
       if (statement != null) {
           try {
               statement.close();
           } catch (SQLException ex) {
               throw new DAOException("kan statement niet sluiten", ex);
           }
       }
       if (connection != null) {
           try {
               connection.close();
           } catch (SQLException ex) {
               throw new DAOException("kan connection niet sluiten", ex);
           }
       }
    }
    
    public void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                throw new DAOException("kan resultset niet sluiten", ex);
            }
            close(statement, connection);
        }
    }

}

