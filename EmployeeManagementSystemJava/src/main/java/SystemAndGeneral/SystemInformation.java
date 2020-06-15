package SystemAndGeneral;

import Database.DataBaseRequests;
import Employee.Employee;

public class SystemInformation {

    private static Employee user;

    public static void setUser(Employee user) {
        SystemInformation.user = user;
    }

    public static Employee getUser() {
        return user;
    }

}
