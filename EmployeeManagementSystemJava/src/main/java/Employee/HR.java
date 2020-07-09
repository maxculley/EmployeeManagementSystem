package Employee;

/**
 * This class <b>HR</b> extends the class <b>Employee</b>.
 * 
 * No additional functionality yet but has potential to have methods which can
 * interact with all employees; unlike <b>NonHR</b> which can only interact with itself.
 * 
 */
public class HR extends Employee {

    /**
     * Creates an HR object with data.
     * 
     * @param ID Employee's ID
     * @param firstName Employee's First Name
     * @param lastName Employee's Last Name
     * @param address Employee's address
     * @param age Employee's age
     * @param gender Employee's gender
     * @param salary Employee's salary
     */
    public HR(int ID, String firstName, String lastName, String address, int age, String gender, int salary) {
        super (ID, firstName, lastName, address, age, gender, salary);
    }

}