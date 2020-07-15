
package GUI.HR.Meetings;

import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRMeetingsHomeMenu</b> holds all the components, styling and logic for
 * the HR meetings landing page.
 * 
 */
public class HRMeetingsHomeMenu {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, holidays, meetings, overtime, accept, view;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText, acceptText;
    private final JLabel welcome, title;
   
    /**
    * Initialises the code for the HR meetings landing page
    */
    public HRMeetingsHomeMenu() {
       
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
        
        acceptText = "Accept/decline\nMeetings";
        accept = new JButton("<html><style>p {text-align: center;}</style> <p>" + acceptText.replaceAll("\\n", "<br>") + "</p></html>");
        
        view = new JButton("View Meetings");
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
       
        titleText = "<html><h2 align='center'>Meetings Portal<h2>";
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
        
        
        accept.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMeetingsActions");
            try {
                HRMeetingsActions.meetingRefresh();
            } catch (ClassNotFoundException ex) {}
        });
        
        
        view.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMeetingsView");
            try {
                SystemInfo.setMeetings();
            } catch (Exception ex) {}
            HRMeetingsView.HRViewMeetingRefresh();
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
        
        accept.setBounds(90, 170, 140, 100);
        content.add(accept);
        
        view.setBounds(330, 170, 140, 100);
        content.add(view);
       
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
       
 
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HRMeetingsHomeMenu</b> JPanel.
     * 
     * @return HRMeetingsHomeMenu JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}