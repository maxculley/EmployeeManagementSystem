
package SystemAndGeneral;

import Database.DBRequests;

public class General {
    
    private final static int HOURS_PER_WEEK = 35, WEEKS_PER_YEAR = 52;
    
    public static void DBRefresh() throws ClassNotFoundException {
        SystemInfo.setFirstName(DBRequests.getFirstName(SystemInfo.getID()));
        SystemInfo.setLastName(DBRequests.getLastName(SystemInfo.getID()));
        SystemInfo.setAddress(DBRequests.getAddress(SystemInfo.getID()));
        SystemInfo.setAge(Integer.parseInt(DBRequests.getAge(SystemInfo.getID())));
        SystemInfo.setGender(DBRequests.getGender(SystemInfo.getID()));
        SystemInfo.setSalary(Integer.parseInt(DBRequests.getSalary(SystemInfo.getID())));
    }
    
    public static int overtime(int totalHours) {
        return totalHours * (SystemInfo.getSalary() / (HOURS_PER_WEEK * WEEKS_PER_YEAR));
    }
    
}
