package Employee;

/**
 * This class <b>Employee</b> contains methods for setting and retrieving data
 * about different employees in the system.
 * 
 */
public class Employee {
    
    private final int ID;
    private int age, salary;
    private String firstName, lastName, address, gender;
    
    
    /**
     * Creates an Employee object with data.
     * 
     * @param ID Employee's ID
     * @param firstName Employee's First Name
     * @param lastName Employee's Last Name
     * @param address Employee's address
     * @param age Employee's age
     * @param gender Employee's gender
     * @param salary Employee's salary
     */
    public Employee(int ID, String firstName, String lastName, String address, int age, String gender, int salary) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
    
    /**
     * This method <b>getID</b> returns the ID of an employee.
     * 
     * @return Employee's ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * This method <b>getFirstName</b> returns the First Name of an employee.
     * 
     * @return Employee's First Name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * This method <b>setFirstName</b> sets the First Name of an employee.
     * 
     * @param name Value of the new First Name
     */
    public void setFirstName(String name) {
        firstName = name;
    }
    
    /**
     * This method <b>getLastName</b> returns the Last Name of an employee.
     * 
     * @return Employee's Last Name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * This method <b>setLastName</b> sets the Last Name of an employee.
     * 
     * @param name Value of the new Last Name
     */
    public void setLastName(String name) {
        lastName = name;
    }
    
    /**
     * This method <b>getAddress</b> returns the address of an employee.
     * 
     * @return Employee's address
     */
    public String getAddress() {
        return address;
    }
    /**
     * This method <b>setAddress</b> sets the address of an employee.
     * 
     * @param address Value of the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * This method <b>getAge</b> returns the age of an employee.
     * 
     * @return Employee's age
     */
    public int getAge() {
        return age;
    }
    /**
     * This method <b>setAge</b> sets the age of an employee.
     * 
     * @param age Value of the new age.
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * This method <b>getGender</b> returns the gender of an employee.
     * 
     * @return Employee's gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * This method <b>setGender</b> sets the gender of an employee.
     * 
     * @param gender Value of the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /**
     * This method <b>getSalary</b> returns the salary of an employee.
     * 
     * @return Employee's salary
     */
    public int getSalary() {
        return salary;
    }
    /**
     * This method <b>setSalary</b> sets the salary of an employee.
     * 
     * @param salary Value of the new salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
    

}