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

}
