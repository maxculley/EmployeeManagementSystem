package GUI.NonHR.Meetings;

import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;
 
public class NonHRMeetingsAdd {
 
    private static JPanel menu;
    private static JPanel quickmenu, content;
    private JLabel returnMessage;
    private final JLabel welcome, title, startDateText, startTimeText, endTimeText;
    private final JButton changeInfo, holidays, switchType, logout, meetings, overtime, submit;
    private final String changeInfoText, changeHolidaysText, switchTypeText, titleText, meetingsText, overtimeText;
    private JTextField startDateYear, startDateMonth, startDateDay, startTimeHour, startTimeMin, endTimeHour, endTimeMin;
 
    public NonHRMeetingsAdd() throws ClassNotFoundException {
       
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
        
        submit = new JButton("Submit");
       
        logout = new JButton("Logout");
        
        
        
        // Text Fields
        startDateYear = new JTextField("YYYY");
        startDateMonth = new JTextField("MM");
        startDateDay = new JTextField("DD");
        startTimeHour = new JTextField("HH");
        startTimeMin = new JTextField("MM");
        endTimeHour = new JTextField("HH");
        endTimeMin = new JTextField("MM");
        
        
        
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        startDateText = new JLabel("Start Date:");
        startTimeText = new JLabel("Start Time:");
        endTimeText = new JLabel("End Time:");
        returnMessage = new JLabel("", SwingConstants.CENTER);
       
        titleText = "<html><h2 align='center'>Add Meeting<h2>";
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
        
        
        submit.addActionListener(listener -> {
            try {
                DBRequests.addMeeting(startDateYear.getText(), startDateMonth.getText(), startDateDay.getText(), startTimeHour.getText(), startTimeMin.getText(), endTimeHour.getText(), endTimeMin.getText());
                returnMessage.setText("Meeting successfully requested");
            } catch (Exception e) {
                returnMessage.setText("Input error, check entries are correct");
                e.printStackTrace();
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
        
        
        startDateText.setBounds(70, 97, 140, 25);
        content.add(startDateText);
        
        startDateYear.setBounds(220, 97, 90, 25);
        content.add(startDateYear);
        
        startDateMonth.setBounds(310, 97, 90, 25);
        content.add(startDateMonth);
        
        startDateDay.setBounds(400, 97, 90, 25);
        content.add(startDateDay);
        
        
        startTimeText.setBounds(70, 157, 140, 25);
        content.add(startTimeText);
        
        startTimeHour.setBounds(265, 157, 90, 25);
        content.add(startTimeHour);
        
        startTimeMin.setBounds(355, 157, 90, 25);
        content.add(startTimeMin);
        
        
        endTimeText.setBounds(70, 217, 140, 25);
        content.add(endTimeText);
        
        endTimeHour.setBounds(265, 217, 90, 25);
        content.add(endTimeHour);
        
        endTimeMin.setBounds(355, 217, 90, 25);
        content.add(endTimeMin);
        
        
        submit.setBounds(230, 277, 100, 25);
        content.add(submit);
        
        returnMessage.setBounds(135, 305, 300, 25);
        content.add(returnMessage);
       
       
       
        // Panel positioning & styling
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
       
        content.setBounds(231, 0, 569, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
   
    public static JPanel getPage() {
        return menu;
    }
 
}