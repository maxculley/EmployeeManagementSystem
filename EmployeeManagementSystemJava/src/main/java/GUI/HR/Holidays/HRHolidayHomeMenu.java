package GUI.HR.Holidays;
 
import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRHolidayHomeMenu</b> holds all the components, styling and logic for
 * the HR holiday landing page.
 * 
 */
public class HRHolidayHomeMenu {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title;
    private final JButton holidays, switchType, logout, accept, view, userSearch, addRemoveEmployee, meetings, overtime;
    private final String userSearchText, switchTypeText, titleText, holidaysText, addRemoveEmployeeText, acceptText, meetingsText, overtimeText;
    
    /**
    * Initialises the code for the HR holiday landing page
    */
    public HRHolidayHomeMenu() {
        
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
       
        logout = new JButton("Logout");
        
        acceptText = "Accept/decline\nHolidays";
        accept = new JButton("<html><style>p {text-align: center;}</style> <p>" + acceptText.replaceAll("\\n", "<br>") + "</p></html>");
        
        view = new JButton("View Holidays");
        
        
        
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        titleText = "<html><h2 align='center'>Holiday Portal<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
        
        
        
        // Listeners
        userSearch.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
        });
       
        
        addRemoveEmployee.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRAddRemove");
        });
        
        
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
        
        
        accept.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRHolidayActions");
            try {
                HRHolidayActions.holidayRefresh();
            } catch (ClassNotFoundException ex) {}
        });
        
        
        view.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRViewHoliday");
            try {
                SystemInfo.setHolidays();
            } catch (Exception ex) {}
            HRHolidayView.HRViewHolRefresh();
        });
        
        
        holidays.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRHolidayHomeMenu");
        });
        
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMeetingsHomeMenu");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HROvertimeHomeMenu");
        });
        
        
        
        // Quickbar positioning and adding
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
        
        accept.setBounds(90, 170, 140, 100);
        content.add(accept);
        
        view.setBounds(330, 170, 140, 100);
        content.add(view);
        
        
        
        // Panel positioning & styling
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
        
        content.setBounds(231, 0, 569, 500);
        
        
        
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HRHolidayHomeMenu</b> JPanel.
     * 
     * @return HRHolidayHomeMenu JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}