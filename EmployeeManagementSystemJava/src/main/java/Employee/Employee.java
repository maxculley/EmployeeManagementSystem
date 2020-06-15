package Employee;

public class Employee {

    private int ID;
    private String firstName;
    private String lastName;
    private String gender;

    public Employee(int ID, String firstName, String lastName, String gender) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getGender() {
        return gender;
    }
    
    public int getID() {
        return ID;
    }

}
