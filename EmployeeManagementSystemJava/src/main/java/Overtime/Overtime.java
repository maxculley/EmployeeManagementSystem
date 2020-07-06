
package Overtime;

public class Overtime {
    
    private String date, status, firstName, lastName;
    private int overtimeID, employeeID, morningHours, eveningHours;
    
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
    
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    
    
    public void setOvertimeID(int overtimeID){
        this.overtimeID = overtimeID;
    }
    public int getOvertimeID() {
        return overtimeID;
    }
    
    
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    
    
    public void setMorningHours(int morningHours){
        this.morningHours = morningHours;
    }
    public int getMorningHours() {
        return morningHours;
    }
    
    
    public void setEveningHours(int eveningHours){
        this.eveningHours = eveningHours;
    }
    public int getEveningHours() {
        return eveningHours;
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
