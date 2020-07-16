package GUI.HR.Holidays;
 
import Database.DBRequests;
import GUI.General.GUIInfo;
import Holiday.Holiday;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRHolidayActions</b> holds all the components, styling and logic for
 * the HR holiday add/view selector page.
 * 
 */
public class HRHolidayActions {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, holidays, accept, decline, meetings, overtime;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private final JLabel welcome, title, employeeIDText, startDateText, endDateText, firstNameText, lastNameText;
    private static JLabel employeeID, startDate, endDate, firstName, lastName;
    private static boolean refresh = false;
    private static Holiday currentHoliday;
   
    /**
     * Initialises the code for the HRHolidayActions page.
     */
    public HRHolidayActions() {
       
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
        startDateText = new JLabel("Start date:");
        endDateText = new JLabel("End date:");
        firstNameText = new JLabel("First name:");
        lastNameText = new JLabel("Last name:");
        
        employeeID = new JLabel();
        startDate = new JLabel();
        endDate = new JLabel();
        firstName = new JLabel();
        lastName = new JLabel();
        
       
        titleText = "<html><h2 align='center'>Accept/Decline Holiday Requests<h2>";
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
        
        
        decline.addActionListener(listener -> {
            try {
                DBRequests.declineHoliday(currentHoliday.getHolidayID());
                holidayRefresh();
            } catch (Exception e) {
                employeeID.setText("No holidays requested");
            }
        });
        
        accept.addActionListener(listener -> {
            try {
                DBRequests.acceptHoliday(currentHoliday.getHolidayID());
                holidayRefresh();
            } catch (Exception e) {
                employeeID.setText("No holidays requested");
            }
        });
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMeetingsHomeMenu");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HROvertimeHomeMenu");
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
        
        startDateText.setBounds(70, 247, 140, 25);
        content.add(startDateText);
        
        endDateText.setBounds(70, 297, 140, 25);
        content.add(endDateText);
        
        decline.setBounds(175, 360, 90, 25);
        content.add(decline);
        
        accept.setBounds(290, 360, 90, 25);
        content.add(accept);
        
        
        content.add(employeeID);
        
        content.add(firstName);
        
        content.add(lastName);
        
        content.add(startDate);
        
        content.add(endDate);
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
       
 
    }
    /**
     * This class <b>holidayRefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank.
     * 
     * This is used for clearing data off the screen when you exit a page.
     * 
     * @throws ClassNotFoundException - if the <b>DBRequests</b> class is
     * not found
     */
    public static void holidayRefresh() throws ClassNotFoundException {
        loadData();
        
        if (currentHoliday == null) {
            employeeID.setText("No holidays requested");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 97, 235, 15);

            firstName.setText("");
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 147, 235, 15);

            lastName.setText("");
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 197, 235, 15);

            startDate.setText("");
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 247, 235, 15);

            endDate.setText("");
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 297, 235, 15);
        } else if (!refresh) {
            employeeID.setText(currentHoliday.getEmployeeID() + "");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 97, 235, 15);

            firstName.setText(currentHoliday.getFirstName());
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 147, 235, 15);

            lastName.setText(currentHoliday.getLastName());
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 197, 235, 15);

            startDate.setText(currentHoliday.getStartDate());
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 247, 235, 15);

            endDate.setText(currentHoliday.getEndDate());
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 297, 235, 15);
            refresh = true;
        } else {
            employeeID.setText(currentHoliday.getEmployeeID() + "");
            firstName.setText(currentHoliday.getFirstName());
            lastName.setText(currentHoliday.getLastName());
            startDate.setText(currentHoliday.getStartDate());
            endDate.setText(currentHoliday.getEndDate());
        }
        
    }
    
    /**
     * This method <b>loadData</b> loads and stored a Holiday Object from ascending
     * date order.
     * 
     * If called twice will move onto the next one to store, not store the same one.
     * 
     * @throws ClassNotFoundException - if the JDBC Class is not found
     */
    public static void loadData() throws ClassNotFoundException {
        currentHoliday = DBRequests.getHoliday();
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HRHolidayActions</b> JPanel.
     * 
     * @return HRHolidayActions JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}