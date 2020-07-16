
package GUI.HR.Meetings;

import Database.DBRequests;
import GUI.General.GUIInfo;
import Meeting.Meeting;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRMeetingsView</b> holds all the components, styling and logic for
 * the HR view meetings page.
 * 
 */
public class HRMeetingsView {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, holidays, meetings, overtime, next, previous, clear, search;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private final JLabel welcome, title, employeeIDText, dateText, startTimeText, endTimeText, firstNameText, lastNameText, statusText;
    private static JTextField idInput;
    private static JLabel employeeID, date, startTime, endTime, firstName, lastName, status;
    private static Meeting currentMeeting;
    private static boolean refresh = false;
    private static int pageCount;
   
    /**
    * Initialises the code for the HR view meetings page
    */
    public HRMeetingsView() {
       
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
       
        quickmenu = new JPanel();
        quickmenu.setLayout(null);
       
        content = new JPanel();
        content.setLayout(null);
        
        
        
        // JTextFields
        idInput = new JTextField("Enter ID");
        
        
        
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
        
        clear = new JButton("Clear");
        
        search = new JButton("Search");
        
        next = new JButton("Next");
        
        previous = new JButton("Previous");
       
        logout = new JButton("Logout");
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        
        employeeIDText = new JLabel("ID:");
        dateText = new JLabel("Meeting date:");
        startTimeText = new JLabel("Start time:");
        endTimeText = new JLabel("End time:");
        firstNameText = new JLabel("First name:");
        lastNameText = new JLabel("Last name:");
        statusText = new JLabel("Status:");
        
        employeeID = new JLabel();
        date = new JLabel();
        startTime = new JLabel();
        endTime = new JLabel();
        firstName = new JLabel();
        lastName = new JLabel();
        status = new JLabel();
        
       
        titleText = "<html><h2 align='center'>View Meetings<h2>";
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
        
        
        next.addActionListener(listener -> {
            pageCount++;
            previous.setVisible(true);
            HRViewMeetingRefresh();
            if (pageCount == SystemInfo.getMeetings().size() - 1) {
                next.setVisible(false);
            }
        });
        
        
        previous.addActionListener(listener -> {
            pageCount--;
            next.setVisible(true);
            HRViewMeetingRefresh();
            if (pageCount == 0) {
                previous.setVisible(false);
            }
        });
        
        search.addActionListener(listener -> {
            try {
                int searchId = Integer.parseInt(idInput.getText());
                try {
                    SystemInfo.setMeetings(searchId);
                    HRViewMeetingRefresh();
                } catch (Exception e) {
                employeeID.setText("Invalid ID");
                firstName.setText("");
                lastName.setText("");
                date.setText("");
                startTime.setText("");
                endTime.setText("");
                status.setText("");
                }
            } catch (Exception e) {
                employeeID.setText("Invalid ID");
                firstName.setText("");
                lastName.setText("");
                date.setText("");
                startTime.setText("");
                endTime.setText("");
                status.setText("");
            }
        });
        
        clear.addActionListener(listener ->{
            try {
                SystemInfo.setMeetings();
                HRViewMeetingRefresh();
            } catch (ClassNotFoundException ex) {}
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
        
        
        clear.setBounds(140, 56, 100, 25);
        content.add(clear);
        
        search.setBounds(330, 56, 100, 25);
        content.add(search);
        
        idInput.setBounds(235, 56, 100, 25);
        content.add(idInput);
        
        employeeIDText.setBounds(70, 87, 140, 25);
        content.add(employeeIDText);
        
        firstNameText.setBounds(70, 127, 140, 25);
        content.add(firstNameText);
        
        lastNameText.setBounds(70, 167, 140, 25);
        content.add(lastNameText);
        
        dateText.setBounds(70, 207, 140, 25);
        content.add(dateText);
        
        startTimeText.setBounds(70, 247, 140, 25);
        content.add(startTimeText);
        
        endTimeText.setBounds(70, 287, 140, 25);
        content.add(endTimeText);
        
        statusText.setBounds(70, 327, 140, 25);
        content.add(statusText);
        
        
        content.add(employeeID);
        
        content.add(firstName);
        
        content.add(lastName);
        
        content.add(date);
        
        content.add(startTime);
        
        content.add(endTime);
        
        content.add(status);
        
        
        previous.setBounds(175, 380, 90, 25);
        content.add(previous);
        previous.setVisible(false);
        
        next.setBounds(290, 380, 90, 25);
        content.add(next);
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>HRViewMeetingRefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void HRViewMeetingRefresh() {
        currentMeeting = (Meeting) SystemInfo.getMeetings().get(pageCount);
        if (!refresh) {
            employeeID.setText(currentMeeting.getEmployeeID() + "");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 87, 235, 15);
            
            firstName.setText(currentMeeting.getFirstName());
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 127, 235, 15);
            
            lastName.setText(currentMeeting.getLastName());
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 167, 235, 15);
            
            date.setText(currentMeeting.getDate());
            date.setHorizontalAlignment(SwingConstants.RIGHT);
            date.setBounds(250, 207, 235, 15);

            startTime.setText(currentMeeting.getStartTime());
            startTime.setHorizontalAlignment(SwingConstants.RIGHT);
            startTime.setBounds(250, 247, 235, 15);

            endTime.setText(currentMeeting.getEndTime());
            endTime.setHorizontalAlignment(SwingConstants.RIGHT);
            endTime.setBounds(250, 287, 235, 15);

            status.setText(currentMeeting.getStatus());
            status.setHorizontalAlignment(SwingConstants.RIGHT);
            status.setBounds(250, 327, 235, 15);
            refresh = true;
        } else {
            employeeID.setText(currentMeeting.getEmployeeID() + "");
            firstName.setText(currentMeeting.getFirstName());
            lastName.setText(currentMeeting.getLastName());
            date.setText(currentMeeting.getDate());
            startTime.setText(currentMeeting.getStartTime());
            endTime.setText(currentMeeting.getEndTime());
            status.setText(currentMeeting.getStatus());
        }
    }
    
    /**
     * This method <b>setCount</b> sets the page count to 0.
     * 
     * This is used when leaving the page to set the count to the start of the
     * ArrayList of holidays so that you don't go back onto the page and view the
     * previous holiday you looked at.
     * 
     */
    public static void setCount() {
        pageCount = 0;
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HRMeetingsView</b> JPanel.
     * 
     * @return HRMeetingsView JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}