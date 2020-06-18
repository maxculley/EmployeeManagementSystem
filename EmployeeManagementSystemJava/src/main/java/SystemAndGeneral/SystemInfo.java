package SystemAndGeneral;

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

}