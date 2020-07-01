
package Meeting;


public class Meeting {
    
    private int meetingID, employeeID;
    private String firstName, lastName, date, startTime, endTime, status;
    
    
    public Meeting(int meetingID, int employeeID, String firstName, String lastName, String date, String startTime, String endTime, String status) {
        setMeetingID(meetingID);
        setEmployeeID(employeeID);
        setFirstName(firstName);
        setLastName(lastName);
        setDate(date);
        setStartTime(startTime);
        setEndTime(endTime);
        setStatus(status);
    }
    

    public int getMeetingID() {
        return meetingID;
    }
    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
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
    
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
