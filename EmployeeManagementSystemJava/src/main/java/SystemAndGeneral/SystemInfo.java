package SystemAndGeneral;

import Database.DBRequests;
import Employee.Employee;

public class SystemInfo {

    private static Employee user;

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
    
    public static String getGender() {
        return user.getGender();
    }
    
    public static void setGender(String gender) {
        user.setGender(gender);
    }
    
    
    
    
    
    public static int getID() {
        return user.getID();
    }

}