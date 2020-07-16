
package Holiday;

/**
 * This class <b>Holiday</b> contains methods for setting and retrieving data
 * about different holidays in the system.
 * 
 */
public class Holiday {
    
    private int holidayID, employeeID;
    private String firstName, lastName, startDate, endDate, status;
    
    /**
     * Creates a Holiday object with data.
     * 
     * @param holidayID Holiday's ID
     * @param employeeID Employee's ID
     * @param firstName Employee's First Name
     * @param lastName Employee's Last Name
     * @param startDate Holiday Start Date
     * @param endDate Holiday's End Date
     * @param status Holiday's confirmation status
     */
    public Holiday(int holidayID, int employeeID, String firstName, String lastName, String startDate, String endDate, String status) {
        setHolidayID(holidayID);
        setEmployeeID(employeeID);
        setFirstName(firstName);
        setLastName(lastName);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(status);
    }
    
    /**
     * This method <b>getHolidayID</b> returns the Holiday ID.
     * 
     * @return Holiday ID
     */
    public int getHolidayID() {
        return holidayID;
    }
    /**
     * This method <b>setHolidayID</b> sets the ID of a holiday.
     * 
     * @param holidayID Value of the new Holiday ID.
     */
    public void setHolidayID(int holidayID) {
        this.holidayID = holidayID;
    }
    
    /**
     * This method <b>getEmployeeID</b> returns the Employee's ID that belongs to
     * a holiday.
     * 
     * @return Employee ID
     */
    public int getEmployeeID(){
        return employeeID;
    }
    /**
     * This method <b>setEmployeeID</b> sets the Employee ID for a specific holiday.
     * 
     * @param employeeID Value of the new Employee ID for that holiday
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    /**
     * This method <b>getFirstName</b> returns the first name of an employee for a
     * specific holiday.
     * 
     * @return Employee first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * This method <b>setFirstName</b> sets the first name of an employee for a
     * specific holiday.
     * 
     * @param firstName Value of the new first name for the holiday
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * This method <b>getLastName</b> returns the last name of an employee for a
     * specific holiday.
     * 
     * @return Employee last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * This method <b>setLastName</b> sets the last name of an employee for a
     * specific holiday.
     * 
     * @param lastName Value of the new last name for the holiday
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * This method <b>getStartDate</b> returns the start date of a specific holiday.
     * 
     * @return Holiday start date
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * This method <b>setStartDate</b> sets the start date of a specific holiday.
     * 
     * @param startDate Value of the new holiday start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    /**
     * This method <b>getEndDate</b> returns the end date of a specific holiday.
     * 
     * @return Holiday end date
     */
    public String getEndDate() {
        return endDate;
    }
    /**
     * This method <b>setEndDate</b> sets the end date of a specific holiday.
     * 
     * @param endDate Value of the new holiday end date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    /**
     * This method <b>getStatus</b> returns the status of a specific holiday.
     * 
     * @return Holiday status
     */
    public String getStatus() {
        return status;
    }
    /**
     * This method <b>setStatus</b> sets the status of a specific holiday.
     * 
     * @param status Value of the new holiday status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
