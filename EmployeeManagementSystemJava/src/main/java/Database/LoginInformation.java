package Database;

abstract class LoginInformation {

    private static String URL = "jdbc:mysql://localhost:3306/sql_employees";
    private static String username = "root";
    private static String password = "";

    public static String getURL() {
        return URL;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

}
 