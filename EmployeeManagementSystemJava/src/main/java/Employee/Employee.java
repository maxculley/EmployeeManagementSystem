package Employee;

public class Employee {

    private final int ID;
    private int age, salary;
    private String firstName, lastName, address, gender;

    public Employee(int ID, String firstName, String lastName, String address, int age, String gender, int salary) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
    
    public int getID() {
        return ID;
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
    
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    

}