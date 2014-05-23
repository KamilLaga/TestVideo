
package be.vdab.DAO;

/**
 *
 * @author kamil.laga
 */
public class DAOException extends RuntimeException {
    
    private final static long serialVersionUID = 1L;
    
    public DAOException(String message) {
        super(message);
    }
    
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
