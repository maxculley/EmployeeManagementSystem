package GUI.NonHR.Meetings;

import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>NonHRMeetingsHome</b> holds all the components, styling and logic for
 * the NonHR meetings landing page.
 * 
 */
public class NonHRMeetingsHome {
 
    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title;
    private final JButton changeInfo, holidays, switchType, logout, meetings, overtime, add, view;
    private final String changeInfoText, changeHolidaysText, switchTypeText, titleText, meetingsText, overtimeText, addText;
    
    /**
    * Initialises the code for the NonHR meetings landing page
    */
    public NonHRMeetingsHome() {
       
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
       
        quickmenu = new JPanel();
        quickmenu.setLayout(null);
       
        content = new JPanel();
        content.setLayout(null);
       
       
       
        // Buttons
        changeInfoText = "View/Change\nInformation";
        changeInfo = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeInfoText.replaceAll("\\n", "<br>") + "</p></html>");
       
        changeHolidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeHolidaysText.replaceAll("\\n", "<br>") + "</p></html>");
       
        switchTypeText = "Switch to \nManagement";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        meetingsText = "View/Change\nMeetings";
        meetings = new JButton("<html><style>p {text-align: center;}</style> <p>" + meetingsText.replaceAll("\\n", "<br>") + "</p></html>");
       
        overtimeText = "View/Change\nOvertime";
        overtime = new JButton("<html><style>p {text-align: center;}</style> <p>" + overtimeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        logout = new JButton("Logout");
        
        addText = "Request a\nMeeting";
        add = new JButton("<html><style>p {text-align: center;}</style> <p>" + addText.replaceAll("\\n", "<br>") + "</p></html>");
        
        view = new JButton("View Meetings");
       
       
       
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
       
        titleText = "<html><h2 align='center'>Meeting Portal<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
       
       
       
        // Listeners
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
       
       
        changeInfo.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
        });
        
        
        add.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMeetingsAdd");
        });
        
        
        view.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMeetingsView");
            try {
                SystemInfo.setEmployeeMeeting();
            } catch (Exception e) {}
            NonHRMeetingsView.NonHRViewMeetingRefresh();
        });
        
        
        holidays.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRHolidayHome");
        });
        
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMeetingsHome");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHROvertimeHome");
        });
       
       
       
        // Quickbar positioning and adding
        logout.setBounds(0, 0, 65, 20);
        quickmenu.add(logout);
       
        welcome.setBounds(0, 15, 230, 15);
        quickmenu.add(welcome);
       
        changeInfo.setBounds(50, 55, 135, 45);
        quickmenu.add(changeInfo);
       
        holidays.setBounds(50, 105, 135, 45);
        quickmenu.add(holidays);
       
        meetings.setBounds(50, 155, 135, 45);
        quickmenu.add(meetings);
        
        overtime.setBounds(50, 205, 135, 45);
        quickmenu.add(overtime);
       
        switchType.setBounds(55, 415, 120, 45);
        quickmenu.add(switchType);
       
       
       
        // Content positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        add.setBounds(90, 170, 140, 100);
        content.add(add);
        
        view.setBounds(330, 170, 140, 100);
        content.add(view);
       
       
       
        // Panel positioning & styling
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
       
        content.setBounds(231, 0, 569, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>getPage</b> returns the <b>NonHRMeetingsHome</b> JPanel.
     * 
     * @return NonHRMeetingsHome JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}