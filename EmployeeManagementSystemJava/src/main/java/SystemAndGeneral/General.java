
package SystemAndGeneral;

import Database.DBRequests;

/**
 * This class <b>General</b> holds all the methods and final variables which should
 * be used wherever needed and do not belong to a specific class.
 * 
 */
public class General {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private General() {}
    
    
    private final static int HOURS_PER_WEEK = 35, WEEKS_PER_YEAR = 52;
    
    /**
     * This method <b>DBRefresh</b> refreshes all the system information about the
     * current user.
     * 
     * This is used when changing data in the database to make sure that all locally
     * saved data is up to date.
     * 
     * @throws ClassNotFoundException if the DBRequests class is not found.
     */
    public static void DBRefresh() throws ClassNotFoundException {
        SystemInfo.setFirstName(DBRequests.getFirstName(SystemInfo.getID()));
        SystemInfo.setLastName(DBRequests.getLastName(SystemInfo.getID()));
        SystemInfo.setAddress(DBRequests.getAddress(SystemInfo.getID()));
        SystemInfo.setAge(Integer.parseInt(DBRequests.getAge(SystemInfo.getID())));
        SystemInfo.setGender(DBRequests.getGender(SystemInfo.getID()));
        SystemInfo.setSalary(Integer.parseInt(DBRequests.getSalary(SystemInfo.getID())));
    }
    
    /**
     * This method <b>overtime</b> calculates the additional salary a person should
     * gain after completing a queried amount of hours.
     * 
     * @param totalHours Number of total overtime hours
     * @return Total additional salary due to overtime
     */
    public static int overtime(int totalHours) {
        return totalHours * (SystemInfo.getSalary() / (HOURS_PER_WEEK * WEEKS_PER_YEAR));
    }
    
}
