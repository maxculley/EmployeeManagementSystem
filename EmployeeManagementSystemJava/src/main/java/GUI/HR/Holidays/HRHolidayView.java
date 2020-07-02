package GUI.HR.Holidays;
 
import Database.DBRequests;
import GUI.General.GUIInfo;
import Holiday.Holiday;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;
 
public class HRHolidayView {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, holidays, next, previous, meetings, overtime;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private final JLabel welcome, title, startDateText, endDateText, statusText, idText, firstNameText, lastNameText;
    private static JLabel startDate, endDate, status, id, firstName, lastName;
    private static int pageCount;
    private static boolean refresh = false;
    private static Holiday currentHol;
   
   
    public HRHolidayView() {
       
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
        
        next = new JButton("Next");
        
        previous = new JButton("Previous");
       
        logout = new JButton("Logout");
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        startDateText = new JLabel("Start Date:");
        endDateText = new JLabel("End Date:");
        statusText = new JLabel("Status:");
        idText = new JLabel("Employee ID:");
        firstNameText = new JLabel("First Name:");
        lastNameText = new JLabel("Last Name:");
        
        id = new JLabel();
        startDate = new JLabel();
        endDate = new JLabel();
        status = new JLabel();
        firstName = new JLabel();
        lastName = new JLabel();
       
        titleText = "<html><h2 align='center'>View Holidays<h2>";
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
        
        
        next.addActionListener(listener -> {
            pageCount++;
            previous.setVisible(true);
            HRViewHolRefresh();
            if (pageCount == SystemInfo.getHoliday().size() - 1) {
                next.setVisible(false);
            }
        });
        
        
        previous.addActionListener(listener -> {
            pageCount--;
            next.setVisible(true);
            HRViewHolRefresh();
            if (pageCount == 0) {
                previous.setVisible(false);
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
        
        
        idText.setBounds(70, 87, 140, 25);
        content.add(idText);
        
        firstNameText.setBounds(70, 137, 140, 25);
        content.add(firstNameText);
        
        lastNameText.setBounds(70, 187, 140, 25);
        content.add(lastNameText);
        
        startDateText.setBounds(70, 237, 140, 25);
        content.add(startDateText);
        
        endDateText.setBounds(70, 287, 140, 25);
        content.add(endDateText);
        
        statusText.setBounds(70, 337, 140, 25);
        content.add(statusText);
        
        
        content.add(id);
        
        content.add(firstName);
        
        content.add(lastName);
        
        content.add(startDate);
        
        content.add(endDate);
        
        content.add(status);
        
        
        previous.setBounds(175, 390, 90, 25);
        content.add(previous);
        previous.setVisible(false);
        
        next.setBounds(290, 390, 90, 25);
        content.add(next);
       
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
       
 
    }
    
    public static void HRViewHolRefresh() {
        currentHol = (Holiday) SystemInfo.getHoliday().get(pageCount);
        if (!refresh) {
            id.setText(currentHol.getEmployeeID() + "");
            id.setHorizontalAlignment(SwingConstants.RIGHT);
            id.setBounds(250, 87, 235, 15);
            
            firstName.setText(currentHol.getFirstName());
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 137, 235, 15);
            
            lastName.setText(currentHol.getLastName());
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 187, 235, 15);
            
            startDate.setText(currentHol.getStartDate());
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 237, 235, 15);

            endDate.setText(currentHol.getEndDate());
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 287, 235, 15);

            status.setText(currentHol.getStatus());
            status.setHorizontalAlignment(SwingConstants.RIGHT);
            status.setBounds(250, 337, 235, 15);
            refresh = true;
        } else {
            id.setText(currentHol.getEmployeeID() + "");
            firstName.setText(currentHol.getFirstName());
            lastName.setText(currentHol.getLastName());
            startDate.setText(currentHol.getStartDate());
            endDate.setText(currentHol.getEndDate());
            status.setText(currentHol.getStatus());
        }
    }
    
    public static void setCount() {
        pageCount = 0;
    }
 
    public static JPanel getPage() {
        return menu;
    }
 
}