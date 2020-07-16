package GUI.NonHR.Overtime;

import Database.DBRequests;
import GUI.General.GUIInfo;
import Overtime.Overtime;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>NonHROvertimeView</b> holds all the components, styling and logic for
 * the NonHR overtime view page.
 * 
 */
public class NonHROvertimeView {
 
    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title, dateText, morningHoursText, eveningHoursText, statusText;
    private final JButton changeInfo, holidays, switchType, logout, meetings, overtime, next, previous;
    private final String changeInfoText, changeHolidaysText, switchTypeText, titleText, meetingsText, overtimeText;
    private static JLabel date, morningHours, eveningHours, status;
    private static boolean refresh = false;
    private static int pageCount = 0;
    private static Overtime currentOvertime;
    
    /**
    * Initialises the code for the NonHR overtime view page
    */
    public NonHROvertimeView() {
       
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
        
        next = new JButton("Next");
        
        previous = new JButton("Previous");
       
        logout = new JButton("Logout");
       
       
       
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        
        
        dateText = new JLabel("Date:");
        morningHoursText = new JLabel("Morning Hours:");
        eveningHoursText = new JLabel("Evening Hours:");
        statusText = new JLabel("Status:");
        
        date = new JLabel();
        morningHours = new JLabel();
        eveningHours = new JLabel();
        status = new JLabel();
        
        
        titleText = "<html><h2 align='center'>View Overtime<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
       
       
       
        // Listeners
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
       
       
        changeInfo.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
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
        
        
        next.addActionListener(listener -> {
            pageCount++;
            previous.setVisible(true);
            NonHRViewOvertimeRefresh();
            if (pageCount == SystemInfo.getOvertimes().size() - 1) {
                next.setVisible(false);
            }
            
        });
        
        
        previous.addActionListener(listener -> {
            pageCount--;
            next.setVisible(true);
            NonHRViewOvertimeRefresh();
            if (pageCount == 0) {
                previous.setVisible(false);
            }
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
        
        
        dateText.setBounds(70, 97, 140, 25);
        content.add(dateText);
        
        morningHoursText.setBounds(70, 157, 140, 25);
        content.add(morningHoursText);
        
        eveningHoursText.setBounds(70, 217, 140, 25);
        content.add(eveningHoursText);
        
        statusText.setBounds(70, 277, 140, 25);
        content.add(statusText);
        
        
        content.add(date);
        
        content.add(morningHours);
        
        content.add(eveningHours);
        
        content.add(status);
        
        
        previous.setBounds(175, 350, 90, 25); 
        content.add(previous);
        previous.setVisible(false);
        
        next.setBounds(290, 350, 90, 25);
        content.add(next);
       
       
       
        // Panel positioning & styling
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
       
        content.setBounds(231, 0, 569, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>NonHRViewOvertimeRefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void NonHRViewOvertimeRefresh() {
        currentOvertime = (Overtime) SystemInfo.getOvertimes().get(pageCount);
        if (!refresh) {
            date.setText(currentOvertime.getDate());
            date.setHorizontalAlignment(SwingConstants.RIGHT);
            date.setBounds(250, 97, 235, 15);

            morningHours.setText(currentOvertime.getMorningHours() + "");
            morningHours.setHorizontalAlignment(SwingConstants.RIGHT);
            morningHours.setBounds(250, 157, 235, 15);

            eveningHours.setText(currentOvertime.getEveningHours() + "");
            eveningHours.setHorizontalAlignment(SwingConstants.RIGHT);
            eveningHours.setBounds(250, 217, 235, 15);

            status.setText(currentOvertime.getStatus());
            status.setHorizontalAlignment(SwingConstants.RIGHT);
            status.setBounds(250, 277, 235, 15);
            refresh = true;
        } else {
            date.setText(currentOvertime.getDate());
            morningHours.setText(currentOvertime.getMorningHours() + "");
            eveningHours.setText(currentOvertime.getEveningHours() + "");
            status.setText(currentOvertime.getStatus());
        }
    }
    
    /**
     * This method <b>getPage</b> returns the <b>NonHROvertimeView</b> JPanel.
     * 
     * @return NonHROvertimeView JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}