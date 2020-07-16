package SystemAndGeneral;

import Database.DBRequests;
import Employee.Employee;
import Holiday.Holiday;
import Meeting.Meeting;
import Overtime.Overtime;
import java.util.ArrayList;

/**
 * This class <b>SystemInfo</b> holds all the data that isn't relevant enough to
 * store in the database.
 * 
 */
public class SystemInfo {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private SystemInfo() {}
    
    
    /**
     * This variable <b>user</b> is an Employee object to store information about
     * the current employee using the system.
     */
    private static Employee user;
    /**
     * This variable <b>holidays</b> stores a list of specific holidays requested,
     * this could be a list of holidays from a specific employee or for the whole
     * database
     */
    private static ArrayList<Holiday> holidays;
    /**
     * This variable <b>meetings</b> stores a list of specific meetings requested,
     * this could be a list of meetings from a specific employee or for the whole
     * database
     */
    private static ArrayList<Meeting> meetings;
    /**
     * This variable <b>overtimes</b> stores a list of specific overtimes requested,
     * this could be a list of overtimes from a specific employee or for the whole
     * database
     */
    private static ArrayList<Overtime> overtimes;
    
    
    /**
     * This method <b>getUser</b> returns the Employee object of the current user of
     * the system.
     * 
     * @return Current user employee object
     */
    public static Employee getUser() {
        return user;
    }
    /**
     * This method <b>setUser</b> sets the current user.
     * 
     * @param user Value of the new current user
     */
    public static void setUser(Employee user) {
        SystemInfo.user = user;
    }

    /**
     * This method <b>getFirstName</b> returns the first name of the current user.
     * 
     * @return User's first name
     */
    public static String getFirstName() {
        return user.getFirstName();
    }
    /**
     * This method <b>setFirstName</b> sets the first name of the current user.
     * 
     * @param name Value of the new first name
     */
    public static void setFirstName(String name) {
        user.setFirstName(name);
    }
    
    /**
     * This method <b>getLastName</b> returns the last name of the current user.
     * 
     * @return User's last name
     */
    public static String getLastName() {
        return user.getLastName();
    }
    /**
     * This method <b>setLastName</b> sets the last name of the current user.
     * 
     * @param name Value of the new last name
     */
    public static void setLastName(String name) {
        user.setLastName(name);
    }
    
    /**
     * This method <b>getAddress</b> returns the address of the current user.
     * 
     * @return User's address
     */
    public static String getAddress() {
        return user.getAddress();
    }
    /**
     * This method <b>setAddress</b> sets the address of the current user.
     * 
     * @param address Value of the new address
     */
    public static void setAddress(String address) {
        user.setAddress(address);
    }
    
    /**
     * This method <b>getAge</b> returns the age of the current user.
     * 
     * @return User's age
     */
    public static int getAge() {
        return user.getAge();
    }
    /**
     * This method <b>setAge</b> sets the age of the current user.
     * 
     * @param age Value of the new age.
     */
    public static void setAge(int age) {
        user.setAge(age);
    }
    
    /**
     * This method <b>getGender</b> returns the gender of the current user.
     * 
     * @return User's gender
     */
    public static String getGender() {
        return user.getGender();
    }
    /**
     * This method <b>setGender</b> sets the gender of the current user.
     * 
     * @param gender Value of the new gender
     */
    public static void setGender(String gender) {
        user.setGender(gender);
    }
    
    /**
     * This method <b>getSalary</b> returns the salary of the current user.
     * 
     * @return User's salary
     */
    public static int getSalary() {
        return user.getSalary();
    }
    /**
     * This method <b>setSalary</b> sets the salary of the current user.
     * 
     * @param salary Value of the new salary
     */
    public static void setSalary(int salary) {
        user.setSalary(salary);
    }
    
    /**
     * This method <b>getID</b> returns the Employee ID of the current user.
     * 
     * @return User's Employee ID
     */
    public static int getID() {
        return user.getID();
    }
    
    /**
     * This method <b>setEmployeeHoliday</b> loads the holidays of a specific employee
     * from the database into the holidays ArrayList.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setEmployeeHoliday() throws ClassNotFoundException {
        holidays = DBRequests.getHolidayList(getID());
    }
    /**
     * This method <b>setHolidays</b> loads all the holidays from the database
     * into the holidays ArrayList.
     * 
     * @throws ClassNotFoundException  - if the JDBC Class is not found
     */
    public static void setHolidays() throws ClassNotFoundException {
        holidays = DBRequests.getHolidayList();
    }/**
     * This method <b>setHolidays</b> loads all the holidays from the database
     * into the holidays ArrayList from a specific employee ID.
     * 
     * @throws ClassNotFoundException  - if the JDBC Class is not found
     */
    public static void setHolidays(int ID) throws ClassNotFoundException {
        holidays = DBRequests.getHolidayList(ID);
    }
    /**
     * This method <b>getHolidays</b> returns the holidays ArrayList.
     * 
     * @return holidays ArrayList
     */
    public static ArrayList getHolidays() {
        return holidays;
    }
    
    /**
     * This method <b>setEmployeeMeeting</b> loads the meetings of a specific employee
     * from the database into the meetings ArrayList.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setEmployeeMeeting() throws ClassNotFoundException {
        meetings = DBRequests.getMeetingList(getID());
    }
    /**
     * This method <b>setMeetings</b> loads all the meetings from the database
     * into the meetings ArrayList.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setMeetings() throws ClassNotFoundException {
        meetings = DBRequests.getMeetingList();
    }
    /**
     * This method <b>setMeetings</b> loads all the meetings from the database
     * into the meetings ArrayList from a specific user ID
     * 
     * @param ID Employee ID
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setMeetings(int ID) throws ClassNotFoundException {
        meetings = DBRequests.getMeetingList(ID);
    }
    /**
     * This method <b>getMeetings</b> returns the meetings ArrayList.
     * 
     * @return meetings ArrayList
     */
    public static ArrayList getMeetings() {
        return meetings;
    }
    
    /**
     * This method <b>setEmployeeOvertime</b> loads the overtimes of a specific employee
     * from the database into the overtimes ArrayList.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setEmployeeOvertime() throws ClassNotFoundException {
        overtimes = DBRequests.getOvertimeList(getID());
    }
    /**
     * This method <b>setOvertimes</b> loads all the overtimes from the database
     * into the overtimes ArrayList.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setOvertimes() throws ClassNotFoundException {
        overtimes = DBRequests.getOvertimeList();
    }
    /**
     * This method <b>setOvertimes</b> loads all the overtimes from the database
     * into the overtimes ArrayList from a specific employee ID.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void setOvertimes(int ID) throws ClassNotFoundException {
        overtimes = DBRequests.getOvertimeList(ID);
    }
    /**
     * This method <b>getOvertimes</b> returns the overtimes ArrayList.
     * 
     * @return overtimes ArrayList
     */
    public static ArrayList getOvertimes() {
        return overtimes;
    }

}