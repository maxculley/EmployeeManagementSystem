
package GUI.HR.Meetings;

import Database.DBRequests;
import GUI.General.GUIInfo;
import Meeting.Meeting;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRMeetingsActions</b> holds all the components, styling and logic for
 * the HR meetings actions page.
 * 
 */
public class HRMeetingsActions {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, holidays, meetings, overtime, accept, decline;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private final JLabel welcome, title, employeeIDText, dateText, startTimeText, endTimeText, firstNameText, lastNameText;
    private static JLabel employeeID, date, startTime, endTime, firstName, lastName;
    private static Meeting currentMeeting;
    private static boolean refresh = false;
   
    /**
    * Initialises the code for the HR meetings actions page
    */
    public HRMeetingsActions() {
       
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
       
        quickmenu = new JPanel();
        quickmenu.setLayout(null);
       
        content = new JPanel();
        content.setLayout(null);
       
       
       
        // Buttons
        switchTypeText = "Switch to \npersonal";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        userSearchText = "Employee\nSearch/Edit";
        userSearch = new JButton("<html><style>p {text-align: center;}</style> <p>" + userSearchText.replaceAll("\\n", "<br>") + "</p></html>");
       
        addRemoveEmployeeText = "Add/Remove\nEmployee";
        addRemoveEmployee = new JButton("<html><style>p {text-align: center;}</style> <p>" + addRemoveEmployeeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        holidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");
       
        meetingsText = "View/Change\nMeetings";
        meetings = new JButton("<html><style>p {text-align: center;}</style> <p>" + meetingsText.replaceAll("\\n", "<br>") + "</p></html>");
       
        overtimeText = "View/Change\nOvertime";
        overtime = new JButton("<html><style>p {text-align: center;}</style> <p>" + overtimeText.replaceAll("\\n", "<br>") + "</p></html>");
        
        accept = new JButton("Accept");
        
        decline = new JButton("Decline");
       
        logout = new JButton("Logout");
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        
        employeeIDText = new JLabel("ID:");
        dateText = new JLabel("Meeting date:");
        startTimeText = new JLabel("Start time:");
        endTimeText = new JLabel("End time:");
        firstNameText = new JLabel("First name:");
        lastNameText = new JLabel("Last name:");
        
        employeeID = new JLabel();
        date = new JLabel();
        startTime = new JLabel();
        endTime = new JLabel();
        firstName = new JLabel();
        lastName = new JLabel();
        
       
        titleText = "<html><h2 align='center'>Accept/Decline Meeting Requests<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
       
       
       
        // Action Listeners
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
       
       
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
 
           
        userSearch.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
        });
       
       
        holidays.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRHolidayHome");
        });
       
       
        addRemoveEmployee.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRAddRemove");
        });
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMeetingsHomeMenu");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HROvertimeHomeMenu");
        });
        
        
        decline.addActionListener(listener -> {
            try {
                DBRequests.declineMeeting(currentMeeting.getMeetingID());
                meetingRefresh();
            } catch (Exception e) {
                employeeID.setText("No meetings requested");
            }
        });
        
        accept.addActionListener(listener -> {
            try {
                DBRequests.acceptMeeting(currentMeeting.getMeetingID());
                meetingRefresh();
            } catch (Exception e) {
                employeeID.setText("No meetings requested");
            }
        });
       
       
       
        // Quickbar positioning & adding
        logout.setBounds(0, 0, 65, 20);
        quickmenu.add(logout);
       
        welcome.setBounds(0, 15, 230, 15);
        quickmenu.add(welcome);
       
        switchType.setBounds(60, 415, 110, 45);
        quickmenu.add(switchType);
       
        userSearch.setBounds(50, 55, 135, 45);
        quickmenu.add(userSearch);
       
        addRemoveEmployee.setBounds(50, 105, 135, 45);
        quickmenu.add(addRemoveEmployee);
       
        holidays.setBounds(50, 155, 135, 45);
        quickmenu.add(holidays);
       
        meetings.setBounds(50, 205, 135, 45);
        quickmenu.add(meetings);
        
        overtime.setBounds(50, 255, 135, 45);
        quickmenu.add(overtime);
       
       
       
        // Content positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        employeeIDText.setBounds(70, 97, 140, 25);
        content.add(employeeIDText);
        
        firstNameText.setBounds(70, 147, 140, 25);
        content.add(firstNameText);
        
        lastNameText.setBounds(70, 197, 140, 25);
        content.add(lastNameText);
        
        dateText.setBounds(70, 247, 140, 25);
        content.add(dateText);
        
        startTimeText.setBounds(70, 297, 140, 25);
        content.add(startTimeText);
        
        endTimeText.setBounds(70, 347, 140, 25);
        content.add(endTimeText);
        
        decline.setBounds(175, 410, 90, 25);
        content.add(decline);
        
        accept.setBounds(290, 410, 90, 25);
        content.add(accept);
        
        
        content.add(employeeID);
        
        content.add(firstName);
        
        content.add(lastName);
        
        content.add(date);
        
        content.add(startTime);
        
        content.add(endTime);
       
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
       
 
    }
    
    /**
     * This method <b>meetingRefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank if the page has been previously accessed, or set the
     * position of the fields and inform the user that there are no meetings requested
     * if the ArrayList is null.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void meetingRefresh() throws ClassNotFoundException {
        loadData();
        
        if (currentMeeting == null) {
            employeeID.setText("No meetings requested");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 97, 235, 15);

            firstName.setText("");
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 147, 235, 15);

            lastName.setText("");
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 197, 235, 15);

            date.setText("");
            date.setHorizontalAlignment(SwingConstants.RIGHT);
            date.setBounds(250, 247, 235, 15);

            startTime.setText("");
            startTime.setHorizontalAlignment(SwingConstants.RIGHT);
            startTime.setBounds(250, 297, 235, 15);

            endTime.setText("");
            endTime.setHorizontalAlignment(SwingConstants.RIGHT);
            endTime.setBounds(250, 347, 235, 15);
        } else if (!refresh) {
            employeeID.setText(currentMeeting.getEmployeeID() + "");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 97, 235, 15);

            firstName.setText(currentMeeting.getFirstName());
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 147, 235, 15);

            lastName.setText(currentMeeting.getLastName());
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 197, 235, 15);

            date.setText(currentMeeting.getDate());
            date.setHorizontalAlignment(SwingConstants.RIGHT);
            date.setBounds(250, 247, 235, 15);

            startTime.setText(currentMeeting.getStartTime());
            startTime.setHorizontalAlignment(SwingConstants.RIGHT);
            startTime.setBounds(250, 297, 235, 15);

            endTime.setText(currentMeeting.getEndTime());
            endTime.setHorizontalAlignment(SwingConstants.RIGHT);
            endTime.setBounds(250, 347, 235, 15);
            refresh = true;
        } else {
            employeeID.setText(currentMeeting.getEmployeeID() + "");
            firstName.setText(currentMeeting.getFirstName());
            lastName.setText(currentMeeting.getLastName());
            date.setText(currentMeeting.getDate());
            startTime.setText(currentMeeting.getStartTime());
            endTime.setText(currentMeeting.getEndTime());
        }
        
    }
    
    /**
     * This method <b>loadData</b> loads the meetings from the database into an
     * ArrayList for display to the user
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void loadData() throws ClassNotFoundException {
        currentMeeting = DBRequests.getMeeting();
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HRMeetingsActions</b> JPanel.
     * 
     * @return HRMeetingsActions JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}