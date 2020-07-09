package Employee;

/**
 * This class <b>NonHR</b> extends the class <b>Employee</b>.
 * 
 * No additional functionality yet but has potential to have methods which can
 * bring more functionality to the class with manipulation of data within itself,
 * unlike the <b>HR</b> class which can interact with all employees.
 * 
 */
public class NonHR extends Employee {
    
    /**
     * Creates an NonHR object with data.
     * 
     * @param ID Employee's ID
     * @param firstName Employee's First Name
     * @param lastName Employee's Last Name
     * @param address Employee's address
     * @param age Employee's age
     * @param gender Employee's gender
     * @param salary Employee's salary
     */
    public NonHR(int ID, String firstName, String lastName, String address, int age, String gender, int salary) {
        super (ID, firstName, lastName, address, age, gender, salary);
    }

}