
package SystemAndGeneral;

import Database.DBRequests;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetchUser {
    
    private int id, age, salary;
    private String firstName, lastName, address, gender;
    
    public FetchUser(int id, String firstName, String lastName, String address, int age, String gender, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
    
    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getSalary() {
        return salary;
    }
    
    
    
}
