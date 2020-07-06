package SystemAndGeneral;

import Database.DBRequests;
import Employee.Employee;
import Holiday.Holiday;
import Meeting.Meeting;
import Overtime.Overtime;
import java.util.ArrayList;

public class SystemInfo {

    private static Employee user;
    private static ArrayList<Holiday> holidays;
    private static ArrayList<Meeting> meetings;
    private static ArrayList<Overtime> overtimes;

    public static void setUser(Employee user) {
        SystemInfo.user = user;
    }
    public static Employee getUser() {
        return user;
    }

    
    public static String getFirstName() {
        return user.getFirstName();
    }
    public static void setFirstName(String name) {
        user.setFirstName(name);
    }
    
    
    public static String getLastName() {
        return user.getLastName();
    }
    public static void setLastName(String name) {
        user.setLastName(name);
    }
    
    
    public static String getAddress() {
        return user.getAddress();
    }
    public static void setAddress(String address) {
        user.setAddress(address);
    }
    
    
    public static int getAge() {
        return user.getAge();
    }
    public static void setAge(int age) {
        user.setAge(age);
    }
    
            
    public static String getGender() {
        return user.getGender();
    }
    public static void setGender(String gender) {
        user.setGender(gender);
    }
    
    
    public static int getSalary() {
        return user.getSalary();
    }
    public static void setSalary(int salary) {
        user.setSalary(salary);
    }
    
    
    public static int getID() {
        return user.getID();
    }
    
    
    public static void setEmployeeHoliday() throws ClassNotFoundException {
        holidays = DBRequests.getHolidayList(getID());
    }
    public static void setHolidays() throws ClassNotFoundException {
        holidays = DBRequests.getHolidayList();
    }
    public static ArrayList getHolidays() {
        return holidays;
    }
    
    
    public static void setEmployeeMeeting() throws ClassNotFoundException {
        meetings = DBRequests.getMeetingList(getID());
    }
    public static void setMeetings() throws ClassNotFoundException {
        meetings = DBRequests.getMeetingList();
    }
    public static ArrayList getMeetings() {
        return meetings;
    }
    
    
    public static void setEmployeeOvertime() throws ClassNotFoundException {
        overtimes = DBRequests.getOvertimeList(getID());
    }
    public static void setOvertimes() throws ClassNotFoundException {
        overtimes = DBRequests.getOvertimeList();
    }
    public static ArrayList getOvertimes() {
        return overtimes;
    }

}