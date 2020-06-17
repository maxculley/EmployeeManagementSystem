package Database;

import GUI.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.sql.*;

public class DBRequests {

    /**
     * This function checks if an employee is valid and in the database
     *
     * @param ID ID of the user
     * @return the employee type or an error message
     * @throws ClassNotFoundException
     */
    public static String isEmployee(int ID) throws ClassNotFoundException {
        String query = "SELECT employee_type FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("employee_type");

        } catch (Exception e) {
            return "User does not exist";
        }
    }

    public static String getPassword(int ID) throws ClassNotFoundException {
        String query = "SELECT password FROM employee_passwords WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("password");

        } catch (Exception e) {
            return "Incorrect Password";
        }
    }

    public static String getFirstName(int ID) throws ClassNotFoundException {
        String query = "SELECT first_name FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("first_name");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }

    public static String getLastName(int ID) throws ClassNotFoundException {
        String query = "SELECT last_name FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("last_name");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }

    public static String getGender(int ID) throws ClassNotFoundException {
        String query = "SELECT gender FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("gender");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }
    
    public static void changeAddress(String newAddress) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET address = '" + newAddress + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeFirstName(String firstName) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET first_name = '" + firstName + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeLastName(String lastName) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET last_name = '" + lastName + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeGender(String gender) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET gender = '" + gender + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changePassword(String newPassword) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_passwords SET password = '" + newPassword + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }

}