package Employee;

public class Employee {

    private int ID = 0;
    private String firstName = "";
    private String lastName = "";
    private String gender = "";

    public Employee(int ID, String firstName, String lastName, String gender) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String name) {
        firstName = name;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String name) {
        lastName = name;
    }

    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

}
