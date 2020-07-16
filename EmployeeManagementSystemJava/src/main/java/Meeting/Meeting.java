
package Meeting;

/**
 * This class <b>Meeting</b> contains methods for setting and retrieving data
 * about different meetings in the system.
 * 
 */
public class Meeting {
    
    private int meetingID, employeeID;
    private String firstName, lastName, date, startTime, endTime, status;
    
    /**
     * Creates a Meeting object with data.
     * 
     * @param meetingID Meeting's ID
     * @param employeeID Employee's ID
     * @param firstName Employee's First Name
     * @param lastName Employee's Last Name
     * @param date Meeting date
     * @param startTime Meeting start time
     * @param endTime Meeting end time
     * @param status Meeting confirmation status
     */
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
    
    /**
     * This method <b>getMeetingID</b> returns the meeting ID.
     * 
     * @return Meeting ID
     */
    public int getMeetingID() {
        return meetingID;
    }
    /**
     * This method <b>setMeetingID</b> sets the ID of a meeting.
     * 
     * @param meetingID Value of the new Meeting ID for that meeting
     */
    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }
    
    /**
     * This method <b>getEmployeeID</b> returns the Employee's ID that belongs to
     * a meeting.
     * 
     * @return Employee ID
     */
    public int getEmployeeID(){
        return employeeID;
    }
    /**
     * This method <b>setEmployeeID</b> sets the Employee ID for a specific meeting.
     * 
     * @param employeeID Value of the new Employee ID for that meeting
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    /**
     * This method <b>getFirstName</b> returns the First Name of the employee who has
     * requested that meeting.
     * 
     * @return Employee's First Name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * This method <b>setFirstName</b> sets the First Name of an employee who has
     * requested that meeting.
     * 
     * @param firstName Value of the new First Name for that meeting
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * This method <b>getLastName</b> returns the Last Name of an employee who has
     * requested that meeting.
     * 
     * @return Employee's Last Name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * This method <b>setLastName</b> sets the Last Name of an employee who has
     * requested that meeting.
     * 
     * @param lastName Value of the new Last Name for that meeting
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * This method <b>getDate</b> returns the date of a specific meeting.
     * 
     * @return Meeting date
     */
    public String getDate() {
        return date;
    }
    /**
     * This method <b>setDate</b> sets the date of a specific meeting.
     * 
     * @param date Value of the new date for that meeting
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * This method <b>getStartTime</b> returns the start time of a specific meeting.
     * 
     * @return Meeting start time
     */
    public String getStartTime() {
        return startTime;
    }
    /**
     * This method <b>setStartTime</b> sets the start time of a specific meeting.
     * 
     * @param startTime Value of the new start time for that meeting
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    /**
     * This method <b>getEndTime</b> returns the end time of a specific meeting.
     * 
     * @return Meeting end time
     */
    public String getEndTime() {
        return endTime;
    }
    /**
     * This method <b>setEndTime</b> sets the end time of a specific meeting.
     * 
     * @param endTime Value of the new end time for that meeting
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    /**
     * This method <b>getStatus</b> returns the status of a specific meeting.
     * 
     * @return Meeting status
     */
    public String getStatus() {
        return status;
    }
    /**
     * This method <b>setStatus</b> sets the status of a specific meeting.
     * 
     * @param status Value of the new meeting status for that meeting
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
