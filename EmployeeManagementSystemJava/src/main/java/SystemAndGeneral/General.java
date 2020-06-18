
package SystemAndGeneral;

import Database.DBRequests;

public class General {
    
    public static void DBRefresh() throws ClassNotFoundException {
        SystemInfo.setFirstName(DBRequests.getFirstName(SystemInfo.getID()));
        SystemInfo.setLastName(DBRequests.getLastName(SystemInfo.getID()));
        SystemInfo.setAddress(DBRequests.getAddress(SystemInfo.getID()));
        SystemInfo.setAge(Integer.parseInt(DBRequests.getAge(SystemInfo.getID())));
        SystemInfo.setGender(DBRequests.getGender(SystemInfo.getID()));
        SystemInfo.setSalary(Integer.parseInt(DBRequests.getSalary(SystemInfo.getID())));
    }
    
}
