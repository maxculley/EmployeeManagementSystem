
package Overtime;

/**
 * This class <b>Overtime</b> contains methods for setting and retrieving data
 * about different overtimes in the system.
 * 
 */
public class Overtime {
    
    private String date, status, firstName, lastName;
    private int overtimeID, employeeID, morningHours, eveningHours;
    
    /**
     * Creates an Overtime object with data.
     * 
     * @param date Overtime date
     * @param status Overtime confirmation status
     * @param overtimeID Overtime ID
     * @param employeeID Employee ID
     * @param morningHours Completed morning overtime hours
     * @param eveningHours Completed evening overtime hours
     * @param firstName Employee First Name
     * @param lastName Employee Last Name
     */
    public Overtime(String date, String status, int overtimeID, int employeeID, int morningHours, int eveningHours, String firstName, String lastName) {
        setDate(date);
        setStatus(status);
        setOvertimeID(overtimeID);
        setEmployeeID(employeeID);
        setMorningHours(morningHours);
        setEveningHours(eveningHours);
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    /**
     * This method <b>setDate</b> sets the date of a specific overtime.
     * 
     * @param date Value of the new date for that overtime
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * This method <b>getDate</b> returns the date of a specific overtime.
     * 
     * @return Overtime date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * This method <b>setStatus</b> sets the status of a specific overtime.
     * 
     * @param status Value of the new overtime status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * This method <b>getStatus</b> returns the status of a specific overtime.
     * 
     * @return Overtime status
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * This method <b>setOvertimeID</b> sets the ID of a specific overtime.
     * 
     * @param overtimeID Value of the new Meeting ID for that overtime
     */
    public void setOvertimeID(int overtimeID){
        this.overtimeID = overtimeID;
    }
    /**
     * This method <b>getOvertimeID</b> returns the overtime ID.
     * 
     * @return Overtime ID
     */
    public int getOvertimeID() {
        return overtimeID;
    }
    
    /**
     * This method <b>setEmployeeID</b> sets the Employee ID for a specific overtime.
     * 
     * @param employeeID Value of the new Employee ID for that overtime
     */
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }
    /**
     * This method <b>getEmployeeID</b> returns the Employee's ID that belongs to
     * an overtime.
     * 
     * @return Employee ID
     */
    public int getEmployeeID() {
        return employeeID;
    }
    
    /**
     * This method <b>setMorningHours</b> sets the morning hours for a specific
     * overtime.
     * 
     * @param morningHours Value of the new morning hours for that overtime
     */
    public void setMorningHours(int morningHours){
        this.morningHours = morningHours;
    }
    /**
     * This method <b>getMorningHours</b> returns the morning hours that belongs to
     * an overtime.
     * 
     * @return Morning hours
     */
    public int getMorningHours() {
        return morningHours;
    }
    
    /**
     * This method <b>setEveningHours</b> sets the evening hours for a specific
     * overtime.
     * 
     * @param eveningHours Value of the new evening hours for that overtime
     */
    public void setEveningHours(int eveningHours){
        this.eveningHours = eveningHours;
    }
    /**
     * This method <b>getEveningHours</b> returns the evening hours that belongs to
     * an overtime.
     * 
     * @return Evening hours
     */
    public int getEveningHours() {
        return eveningHours;
    }
    
    /**
     * This method <b>setFirstName</b> sets the First Name of an employee who has
     * requested that overtime.
     * 
     * @param firstName Value of the new First Name for that overtime
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * This method <b>getFirstName</b> returns the First Name of the employee who has
     * requested that overtime.
     * 
     * @return Employee's First Name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * This method <b>setLastName</b> sets the Last Name of an employee who has
     * requested that overtime.
     * 
     * @param lastName Value of the new Last Name for that overtime
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * This method <b>getLastName</b> returns the Last Name of an employee who has
     * requested that overtime.
     * 
     * @return Employee's Last Name
     */
    public String getLastName() {
        return lastName;
    }
}
