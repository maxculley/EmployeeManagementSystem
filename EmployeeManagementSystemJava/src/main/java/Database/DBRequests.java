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
    private static int count = 1003;
    
    
    
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
     * @throws ClassNotFoundException 
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
     * If the employee ID is valid then the method returns the password of that user,
     * if the employee ID is invalid the method returns an error message.
     * 
     * @param ID Employee's ID
     * @return Employee's password or error return comment
     * @throws ClassNotFoundException 
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
            return "Input is invalid";
        }
    }

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
                    id, getFirstName(id), getLastName(id),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getString("status"));

        } catch (Exception e) {
            return null;
        }
    }
    
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
    
    public static void changeAddress(String newAddress) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET address = '" + newAddress + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeAddress(String newAddress, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET address = '" + newAddress + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeFirstName(String firstName) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET first_name = '" + firstName + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeFirstName(String firstName, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET first_name = '" + firstName + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeLastName(String lastName) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET last_name = '" + lastName + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeLastName(String lastName, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET last_name = '" + lastName + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
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
    
    public static void changeGender(String gender, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE personal_info SET gender = '" + gender + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changePassword(String newPassword) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_passwords SET password = '" + newPassword + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changePassword(String newPassword, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_passwords SET password = '" + newPassword + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeSalary(int salary) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_info SET employee_salary = '" + salary + "' WHERE employee_id = '" + SystemInfo.getID() + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void changeSalary(int salary, int ID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_info SET employee_salary = '" + salary + "' WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void acceptHoliday(int holidayID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_holidays SET status = 'Accepted' WHERE holiday_id = " + holidayID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void declineHoliday(int holidayID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_holidays SET status = 'Declined' WHERE holiday_id = " + holidayID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void acceptMeeting(int meetingID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_meetings SET status = 'Accepted' WHERE meeting_id = " + meetingID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void declineMeeting(int meetingID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_meetings SET status = 'Declined' WHERE meeting_id = " + meetingID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void acceptOvertime(int overtimeID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_overtime SET status = 'Accepted' WHERE overtime_id = " + overtimeID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void declineOvertime(int overtimeID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_overtime SET status = 'Declined' WHERE overtime_id = " + overtimeID + ";";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    
    
    /******************** DELETE DATA ********************/
    
    public static void deleteEmployee(int ID) throws ClassNotFoundException, SQLException {
        String query1 = "DELETE FROM employee_info WHERE employee_id = '" + ID + "'";
        String query2 = "DELETE FROM employee_passwords WHERE employee_id = '" + ID + "'";
        String query3 = "DELETE FROM personal_info WHERE employee_id = '" + ID + "'";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(),
                LoginInformation.getUsername(),
                LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query1);
        st.executeUpdate(query2);
        st.executeUpdate(query3);
        
        con.close();
        st.close();
    }
    
    
    
    /******************** INSERT DATA ********************/
    
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

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query1);
        st.executeUpdate(query2);
        st.executeUpdate(query3);
        count++;
        
        
        con.close();
        st.close();
    }
    
    public static void addMeeting(String startYear,
            String startMonth,
            String startDay,
            String startHour,
            String startMin,
            String endHour,
            String endMin) throws ClassNotFoundException, SQLException {
        
        String query = "INSERT INTO employee_meetings VALUES (DEFAULT," + SystemInfo.getID() + ",'" + startYear + "-" + startMonth + "-" + startDay + "','" + startHour + ":" + startMin + "','" + endHour + ":" + endMin + "','Pending');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void addHoliday(String startYear,
            String startMonth,
            String startDay,
            String endYear,
            String endMonth,
            String endDay) throws ClassNotFoundException, SQLException {
        
        String query = "INSERT INTO employee_holidays VALUES (DEFAULT," + SystemInfo.getID() + ",'" + startYear + "-" + startMonth + "-" + startDay + "','" + endYear + "-" + endMonth + "-" + endDay + "','Pending');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        con.close();
        st.close();
    }
    
    public static void addOvertime(String date,
            int morning,
            int evening) throws ClassNotFoundException, SQLException {
        
        String query = "INSERT INTO employee_overtime VALUES (DEFAULT," + SystemInfo.getID() + ",'" + date + "'," + morning + "," + evening + ",'Pending');";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(LoginInformation.getURL(), LoginInformation.getUsername(), LoginInformation.getPassword());
        Statement st = con.createStatement();
        st.executeUpdate(query);
        count++;
        
        
        con.close();
        st.close();
        
    }
    
    
    
    /******************** GENERAL ********************/
    
    public static int getCount() {
        return count;
    }
    
}