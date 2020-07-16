package Database;
/**
 * This class <b>LoginInformation</b> contains methods for retrieving the required
 * login data for connection to the database.
 * 
 */
public final class LoginInformation {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private LoginInformation() {}
    
    
    
    /**
     * URL of the database for connection.
     */
    private final static String URL = "jdbc:mysql://localhost:3306/sql_employees";
    
    /**
     * SQL root username for database connection.
     */
    private final static String USERNAME = "root";
    
    /**
     * Password of SQL root account for database connection.
     */
    private final static String PASSWORD = "";
    
    
    
    /**
     * Returns the URL used for connection.
     * 
     * @return URL of database.
     */
    public static String getURL() {
        return URL;
    }
    
    /**
     * Returns the username of the SQL account.
     * 
     * @return SQL account username.
     */
    public static String getUsername() {
        return USERNAME;
    }
    
    /**
     * Returns the password of the SQL account.
     * 
     * @return SQL account password.
     */
    public static String getPassword() {
        return PASSWORD;
    }

}
