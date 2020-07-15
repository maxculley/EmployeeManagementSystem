
package GUI.NonHR.Holidays;
 
import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>NonHRHolidaysAdd</b> holds all the components, styling and logic for
 * the NonHR holiday add page.
 * 
 */
public class NonHRHolidaysAdd {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title, startDateText, endDateText;
    private JLabel returnMessage;
    private final JButton changeInfo, holidays, switchType, logout, submit, meetings, overtime;
    private final String changeInfoText, changeHolidaysText, switchTypeText, titleText, meetingsText, overtimeText;
    private JTextField startDateYear, startDateMonth, startDateDay, endDateYear, endDateMonth, endDateDay;
    
    /**
    * Initialises the code for the NonHR holiday add page
    */
    public NonHRHolidaysAdd() {
        
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
        endDateYear = new JTextField("YYYY");
        endDateMonth = new JTextField("MM");
        endDateDay = new JTextField("DD");
        
        
        
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        startDateText = new JLabel("Start Date:");
        endDateText = new JLabel("End Date:");
        returnMessage = new JLabel("", SwingConstants.CENTER);
        
        titleText = "<html><h2 align='center'>Add Holiday<h2>";
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
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMeetingsHome");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHROvertimeHome");
        });
        
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
        
        
        submit.addActionListener(listener -> {
            try {
                DBRequests.addHoliday(startDateYear.getText(), startDateMonth.getText(), startDateDay.getText(), endDateYear.getText(), endDateMonth.getText(), endDateDay.getText());
                returnMessage.setText("Holiday successfully requested");
            } catch (Exception e) {
                returnMessage.setText("Input error, check entries are correct");
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
        
        
        endDateText.setBounds(70, 157, 140, 25);
        content.add(endDateText);
        
        endDateYear.setBounds(220, 157, 90, 25);
        content.add(endDateYear);
        
        endDateMonth.setBounds(310, 157, 90, 25);
        content.add(endDateMonth);
        
        endDateDay.setBounds(400, 157, 90, 25);
        content.add(endDateDay);
        
        
        submit.setBounds(230, 215, 100, 25);
        content.add(submit);
        
        returnMessage.setBounds(135, 260, 300, 25);
        content.add(returnMessage);
        
        
        
        // Panel positioning & styling
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
        
        content.setBounds(231, 0, 569, 500);
        
        
        
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>getPage</b> returns the <b>NonHRHolidaysAdd</b> JPanel.
     * 
     * @return NonHRHolidaysAdd JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
 
}