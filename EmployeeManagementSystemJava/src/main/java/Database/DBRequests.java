package Database;

import Holiday.Holiday;
import Meeting.Meeting;
import Overtime.Overtime;
import SystemAndGeneral.SystemInfo;
import java.sql.*;
import java.util.ArrayList;


/**
 * This class <b>DBRequests</b> has all the methods which communicate with the
 * database.
 * 
 * These methods include <b>Requests</b>, <b>Updates</b>, <b>Deletes</b> and <b>Inserts</b>.
 * 
 */
public final class DBRequests {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private DBRequests(){}
    
    
    
    /**
     * The most recent employee added.
     */
    private static int employeeCount = 1003;
    
    
    
    /******************** REQUEST DATA ********************/
    
    /**
     * This method <b>isEmployee</b> checks if the user ID is valid in the 
     * database.
     * 
     * If the ID is valid then the method returns the type of the user, 
     * either HR or Non HR. This then reflects what restrictions their account
     * has.
     * 
     * @param ID Employee's ID 
     * @return Employee type or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String isEmployee(int ID) throws ClassNotFoundException {
        String query = "SELECT employee_type FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("employee_type");

        } catch (Exception e) {
            return "User does not exist";
        }
    }
    
    /**
     * This method <b>getPassword</b> returns the user's password based off
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the password of that
     * user. If the employee ID is invalid the method returns an error message.
     * 
     * @param ID Employee's ID
     * @return Employee's password or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getPassword(int ID) throws ClassNotFoundException {
        String query = "SELECT password FROM employee_passwords WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("password");

        } catch (Exception e) {
            return "Incorrect Password";
        }
    }
    
    /**
     * This method <b>getFirstName</b> returns the user's first name based off
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the first name
     * of that user. If The employee ID is invalid, the method returns an error
     * message.
     * 
     * @param ID Employee's ID
     * @return Employee's first name or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getFirstName(int ID) throws ClassNotFoundException {
        String query = "SELECT first_name FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("first_name");

        } catch (Exception e) {
            return "Input for is invalid";
        }
    }
    
    /**
     * This method <b>getLastName</b> returns the user's last name based off 
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the last name
     * of that user. If The employee ID is invalid, the method returns an error
     * message.
     * 
     * @param ID Employee's ID
     * @return Employee's last name or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getLastName(int ID) throws ClassNotFoundException {
        String query = "SELECT last_name FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("last_name");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }
    
    /**
     * This method <b>getGender</b> returns the user's gender based off 
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the gender
     * of that user. If The employee ID is invalid, the method returns an error
     * message.
     * 
     * @param ID Employee's ID
     * @return Employee's gender or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getGender(int ID) throws ClassNotFoundException {
        String query = "SELECT gender FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("gender");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }
    
    /**
     * This method <b>getAge</b> returns the user's age based off 
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the age
     * of that user. If The employee ID is invalid, the method returns an error
     * message.
     * 
     * @param ID Employee's ID
     * @return Employee's age or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getAge(int ID) throws ClassNotFoundException {
        String query = "SELECT age FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("age");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }
    
    /**
     * This method <b>getAddress</b> returns the user's address based off 
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the address
     * of that user. If The employee ID is invalid, the method returns an error
     * message.
     * 
     * @param ID Employee's ID
     * @return Employee's address or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getAddress(int ID) throws ClassNotFoundException {
        String query = "SELECT address FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("address");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }
    
    /**
     * This method <b>getSalary</b> returns the user's salary based off 
     * their employee ID.
     * 
     * If the employee ID is valid then the method returns the salary
     * of that user. If The employee ID is invalid, the method returns an error
     * message.
     * 
     * @param ID Employee's ID
     * @return Employee's salary or error return comment
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static String getSalary(int ID) throws ClassNotFoundException {
        String query = "SELECT employee_salary FROM employee_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            return rs.getString("employee_salary");

        } catch (Exception e) {
            return "Input is invalid";
        }
    }
    
    /**
     * This method <b>getHoliday</b> returns a Holiday object from the database
     * sorted from the start date in ascending order.
     * 
     * This object takes in the following fields:
     * <b>Holiday ID</b>, 
     * <b>Employee ID</b>, 
     * <b>First Name</b>, 
     * <b>Last Name</b>, 
     * <b>Start Date</b>, 
     * <b>End Date</b>, 
     * <b>Status</b>
     * 
     * @return Holiday object with data
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static Holiday getHoliday() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_holidays WHERE status = 'Pending' ORDER BY start_date ASC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            int id = rs.getInt("employee_id");
            
            return new Holiday(rs.getInt("holiday_id"),
                    id,
                    getFirstName(id),
                    getLastName(id),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getString("status"));

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getHolidayList</b> returns an ArrayList of Holiday objects
     * for every holiday that is in the database.
     * 
     * @return ArrayList of Holiday objects
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static ArrayList getHolidayList() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_holidays ORDER BY status";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Holiday> holidays = new ArrayList();

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while(rs.next()) {
                int ID = rs.getInt("employee_id");
                holidays.add(new Holiday(rs.getInt("holiday_id"),
                        ID,
                        getFirstName(ID),
                        getLastName(ID),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("status")));
            }
            
            return holidays;

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getHolidayList</b> takes an employee ID and returns an
     * ArrayList of Holiday objects for the holidays of that specific employee.
     * 
     * @param ID Employee's ID
     * @return ArrayList of Holiday objects for an specific employee
     * @throws ClassNotFoundException 
     */
    public static ArrayList getHolidayList(int ID) throws ClassNotFoundException {
        String query = "SELECT * FROM employee_holidays WHERE employee_id = '" + ID + "' ORDER BY status";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Holiday> holidays = new ArrayList();

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while(rs.next()) {
                holidays.add(new Holiday(rs.getInt("holiday_id"),
                        ID,
                        getFirstName(ID),
                        getLastName(ID),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("status")));
            }
            
            return holidays;

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getMeeting</b> returns a Meeting object from the database.
     * 
     * This object takes in the following fields:
     * <b>Meeting ID</b>, 
     * <b>Employee ID</b>, 
     * <b>First Name</b>, 
     * <b>Last Name</b>, 
     * <b>Date</b>, 
     * <b>Start Time</b>, 
     * <b>End Time</b>, 
     * <b>Status</b>
     * 
     * @return Meeting object with data
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static Meeting getMeeting() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_meetings WHERE status = 'Pending' ORDER BY date ASC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            int id = rs.getInt("employee_id");
            
            return new Meeting(rs.getInt("meeting_id"),
                    id,
                    getFirstName(id),
                    getLastName(id),
                    rs.getString("date"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getString("status"));

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getMeetingList</b> returns an ArrayList of Meeting objects
     * for every meeting that is in the database.
     * 
     * @return ArrayList of Meeting objects
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static ArrayList getMeetingList() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_meetings ORDER BY status";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Meeting> meetings = new ArrayList();

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while(rs.next()) {
                int ID = rs.getInt("employee_id");
                meetings.add(new Meeting(rs.getInt("meeting_id"),
                        ID,
                        getFirstName(ID),
                        getLastName(ID),
                        rs.getString("date"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getString("status")));
            }
            
            return meetings;

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getMeetingList</b> takes an employee ID and returns an
     * ArrayList of Meeting objects for the meetings of that specific employee
     * 
     * @param ID Employee's ID
     * @return ArrayList of Meeting objects for a specific employee
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static ArrayList getMeetingList(int ID) throws ClassNotFoundException {
        String query = "SELECT * FROM employee_meetings WHERE employee_id = '" + ID + "' ORDER BY status";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Meeting> meetings = new ArrayList();

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while(rs.next()) {
                meetings.add(new Meeting(rs.getInt("meeting_id"),
                        ID,
                        getFirstName(ID),
                        getLastName(ID),
                        rs.getString("date"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getString("status")));
            }
            
            return meetings;

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getOvertime</b> returns an Overtime object from the database.
     * 
     * This object takes in the following fields:
     * <b>Date</b>, 
     * <b>Status</b>, 
     * <b>Overtime ID</b>, 
     * <b>Employee ID</b>, 
     * <b>Morning Hours</b>, 
     * <b>Evening Hours</b>, 
     * <b>First Name</b>, 
     * <b>Last Name</b>
     * 
     * @return Overtime object with data
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static Overtime getOvertime() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_overtime WHERE status = 'Pending' ORDER BY date ASC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {

            rs.next();
            int id = rs.getInt("employee_id");
            
            return new Overtime(rs.getString("date"),
                    rs.getString("status"),
                    rs.getInt("overtime_id"),
                    id,
                    rs.getInt("morning_hours"),
                    rs.getInt("evening_hours"),
                    getFirstName(id),
                    getLastName(id));

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getOvertimeList</b> returns an ArrayList of Overtime objects
     * for every overtime listing that is in the database.
     * 
     * @return ArrayList of Overtime objects
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static ArrayList getOvertimeList() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_overtime ORDER BY status";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Overtime> overtime = new ArrayList();

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while(rs.next()) {
                int ID = rs.getInt("employee_id");
                overtime.add(new Overtime(rs.getString("date"),
                        rs.getString("status"),
                        rs.getInt("overtime_id"),
                        ID,
                        rs.getInt("morning_hours"),
                        rs.getInt("evening_hours"),
                        getFirstName(ID),
                        getLastName(ID)));
            }
            
            return overtime;

        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * This method <b>getOvertimeList</b> takes an employee ID and returns an
     * ArrayList of Overtime objects for the overtime requests of that specific
     * employee.
     * 
     * @param ID Employee's ID
     * @return ArrayList of Overtime objects for a specific employee
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     */
    public static ArrayList getOvertimeList(int ID) throws ClassNotFoundException {
        String query = "SELECT * FROM employee_overtime WHERE employee_id = '" + ID + "' ORDER BY status";

        Class.forName("com.mysql.cj.jdbc.Driver");
        
        ArrayList<Overtime> overtime = new ArrayList();

        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            
            while(rs.next()) {
                overtime.add(new Overtime(rs.getString("date"),
                        rs.getString("status"),
                        rs.getInt("overtime_id"),
                        ID,
                        rs.getInt("morning_hours"),
                        rs.getInt("evening_hours"),
                        getFirstName(ID),
                        getLastName(ID)));
            }
            
            return overtime;

        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    /******************** UPDATE DATA ********************/
    
    /**
     * This method <b>changeAddress</b> changes the value of the address in the 
     * database of the employee currently using the system.
     * 
     * @param newAddress The value of the New Address
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeAddress(String newAddress) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET address = '" + newAddress + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeAddress</b> changes the value of the address in the
     * database of a specified employee.
     * 
     * @param newAddress The value of the New Address
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeAddress(String newAddress, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET address = '" + newAddress + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeFirstName</b> changes the value of the first name
     * in the database of the employee using the system.
     * 
     * @param firstName The value of the new First Name
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeFirstName(String firstName) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET first_name = '" + firstName + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeFirstName</b> changes the value of the first name 
     * in the database of a specified employee.
     * 
     * @param firstName Value of the new First Name
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeFirstName(String firstName, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET first_name = '" + firstName + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeLastName</b> changes the value of the last name
     * in the database of the employee using the system.
     * 
     * @param lastName Value of the new Last Name
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeLastName(String lastName) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET last_name = '" + lastName + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeLastName</b> changes the value of the last name
     * in the database of a specified employee.
     * 
     * @param lastName Value of the new Last Name
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeLastName(String lastName, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET last_name = '" + lastName + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeGender</b> changes the value of the Gender in the
     * database of the employee using the system.
     * 
     * @param gender Value of the new Gender
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeGender(String gender) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET gender = '" + gender + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    /**
     * This method <b>changeGender</b> changes the value of the Gender in the
     * database of a specified employee.
     * 
     * @param gender Value of the new Gender
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeGender(String gender, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET gender = '" + gender + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changePassword</b> changes the value of the password in the
     * database of the employee using the system.
     * 
     * @param newPassword Value of the new password
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changePassword(String newPassword) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_passwords SET password = '" + newPassword + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changePassword</b> changes the value of the password in the
     * database of a specified employee.
     * 
     * @param newPassword Value of the new password
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changePassword(String newPassword, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_passwords SET password = '" + newPassword + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeSalary</b> changes the value of the salary in the
     * database for the employee using the system.
     * 
     * @param salary Value of the new salary
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeSalary(int salary) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_info SET employee_salary = '" + salary + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>changeSalary</b> changes the value of the salary in the
     * database for a specified employee.
     * 
     * @param salary Value of the new salary
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void changeSalary(int salary, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_info SET employee_salary = '" + salary + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>acceptHoliday</b> changes the status of a 'Pending' holiday
     * request to 'Accepted' in the database.
     * 
     * @param holidayID Value of a specific holiday
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void acceptHoliday(int holidayID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_holidays SET status = 'Accepted' WHERE holiday_id = " + holidayID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>declineHoliday</b> changes the status of a 'Pending' holiday
     * request to 'Declined' in the database.
     * 
     * @param holidayID Value of a specific holiday
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void declineHoliday(int holidayID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_holidays SET status = 'Declined' WHERE holiday_id = " + holidayID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>acceptMeeting</b> changes the status of a 'Pending' meeting
     * request to 'Accepted' in the database.
     * 
     * @param meetingID Value of a specific meeting
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void acceptMeeting(int meetingID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_meetings SET status = 'Accepted' WHERE meeting_id = " + meetingID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>declineMeetin</b> changes the status of a 'Pending' meeting
     * request to 'Declined' in the database.
     * 
     * @param meetingID Value of a specific meeting
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void declineMeeting(int meetingID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_meetings SET status = 'Declined' WHERE meeting_id = " + meetingID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>acceptOvertime</b> changes the status of a 'Pending' overtime
     * request to 'Accepted' in the database.
     * 
     * @param overtimeID Value of a specific overtime
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void acceptOvertime(int overtimeID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_overtime SET status = 'Accepted' WHERE overtime_id = " + overtimeID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>declineOvertime</b> changes the status of a 'Pending' overtime
     * request to 'Declined' in the database.
     * 
     * @param overtimeID Value of a specific overtime
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void declineOvertime(int overtimeID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_overtime SET status = 'Declined' WHERE overtime_id = " + overtimeID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    
    
    /******************** DELETE DATA ********************/
    
    /**
     * This method <b>deleteEmployee</b> removes all data in the database for a
     * specified employee.
     * 
     * @param ID Employee's ID
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void deleteEmployee(int ID) throws ClassNotFoundException, SQLException {
        String query1 = "DELETE FROM employee_info WHERE employee_id = '" + ID + "'";
        String query2 = "DELETE FROM employee_passwords WHERE employee_id = '" + ID + "'";
        String query3 = "DELETE FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            st.executeUpdate(query3);
        }
        st.close();
    }
    
    
    
    /******************** INSERT DATA ********************/
    
    /**
     * This method <b>addEmployee</b> adds an employee to the database.
     * 
     * @param firstName Value of the employee's First Name
     * @param lastName Value of the employee's Last Name
     * @param address Value of the employee's Address
     * @param age Value of the employee's Age
     * @param gender Value of the employee's Gender
     * @param employeeType Value of the employee's account type
     * @param baseSalary Value of the employee's base salary
     * @param employeeSalary Value of the employee's salary
     * @param password Value of the employee's password
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void addEmployee(String firstName,
            String lastName,
            String address,
            int age,
            String gender,
            int employeeType,
            int baseSalary,
            int employeeSalary,
            String password) throws ClassNotFoundException, SQLException {
        
        String query1 = "INSERT INTO personal_info VALUES (DEFAULT,'" + firstName + "','" + lastName + "','" + address + "'," + age + ",'" + gender + "'," + employeeType + ");";
        String query2 = "INSERT INTO `employee_info` VALUES (DEFAULT," + baseSalary + "," + employeeSalary + ");";
        String query3 = "INSERT INTO `employee_passwords` VALUES (DEFAULT,'" + password + "');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            st.executeUpdate(query3);
            employeeCount++;
        }
        st.close();
    }
    
    /**
     * This method <b>addMeeting</b> adds a new meeting to the database.
     * 
     * @param startYear Meeting start Year value
     * @param startMonth Meeting start Month value
     * @param startDay Meeting start Day value
     * @param startHour Meeting start Hour value
     * @param startMin Meeting start Minute value
     * @param endHour Meeting end Hour value
     * @param endMin Meeting end Minute value
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void addMeeting(String startYear,
            String startMonth,
            String startDay,
            String startHour,
            String startMin,
            String endHour,
            String endMin) throws ClassNotFoundException, SQLException {
        
        String query = "INSERT INTO employee_meetings VALUES (DEFAULT," + SystemInfo.getID() + ",'" + startYear + "-" + startMonth + "-" + startDay + "','" + startHour + ":" + startMin + "','" + endHour + ":" + endMin + "','Pending');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>addHoliday</b> adds a new holiday to the database.
     * 
     * @param startYear Holiday start Year
     * @param startMonth Holiday start Month
     * @param startDay Holiday start Day
     * @param endYear Holiday end Year
     * @param endMonth Holiday end Month
     * @param endDay Holiday end Day
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void addHoliday(String startYear,
            String startMonth,
            String startDay,
            String endYear,
            String endMonth,
            String endDay) throws ClassNotFoundException, SQLException {
        
        String query = "INSERT INTO employee_holidays VALUES (DEFAULT," + SystemInfo.getID() + ",'" + startYear + "-" + startMonth + "-" + startDay + "','" + endYear + "-" + endMonth + "-" + endDay + "','Pending');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
        }
        st.close();
    }
    
    /**
     * This method <b>addOvertime</b> adds a new overtime to the database.
     * 
     * @param date Overtime date
     * @param morning Overtime morning hours
     * @param evening Overtime evening hours
     * @throws ClassNotFoundException - if the JDBC Driver is not found
     * @throws SQLException - if there is an issue connecting to the database
     */
    public static void addOvertime(String date,
            int morning,
            int evening) throws ClassNotFoundException, SQLException {
        
        String query = "INSERT INTO employee_overtime VALUES (DEFAULT," + SystemInfo.getID() + ",'" + date + "'," + morning + "," + evening + ",'Pending');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword())) {
            st = con.createStatement();
            st.executeUpdate(query);
            employeeCount++;
        }
        st.close();
        
    }
    
    
    
    /******************** GENERAL ********************/
    
    /**
     * This method <b>getCount</b>
     * 
     * @return 
     */
    public static int getCount() {
        return employeeCount;
    }
    
}