
package Holiday;


public class Holiday {
    
    private int holidayID, employeeID;
    private String firstName, lastName, startDate, endDate, status;
    
    
    public Holiday(int holidayID, int employeeID, String firstName, String lastName, String startDate, String endDate, String status) {
        setHolidayID(holidayID);
        setEmployeeID(employeeID);
        setFirstName(firstName);
        setLastName(lastName);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(status);
    }
    
    public Holiday(int holidayID, int employeeID, String startDate, String endDate, String status) {
        setHolidayID(holidayID);
        setEmployeeID(employeeID);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(status);
    }
    

    public int getHolidayID() {
        return holidayID;
    }
    public void setHolidayID(int holidayID) {
        this.holidayID = holidayID;
    }
    
    
    public int getEmployeeID(){
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
    
    
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
