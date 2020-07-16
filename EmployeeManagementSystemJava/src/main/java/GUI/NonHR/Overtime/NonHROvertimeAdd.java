package GUI.NonHR.Overtime;

import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>NonHROvertimeAdd</b> holds all the components, styling and logic for
 * the NonHR overtime add page.
 * 
 */
public class NonHROvertimeAdd {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title, dateText, morningText, eveningText;
    private final JButton changeInfo, holidays, switchType, logout, meetings, overtime, submit;
    private final String changeInfoText, changeHolidaysText, switchTypeText, titleText, meetingsText, overtimeText;
    private final JTextField dateYear, dateMonth, dateDay;
    private static JLabel returnMessage;
    private final Choice morningDropdown, eveningDropdown;
    private String morningString, eveningString, date;
    private int morningCount, eveningCount;
    
    /**
    * Initialises the code for the NonHR overtime add page
    */
    public NonHROvertimeAdd() {
        
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
        
        
        
        // JTextFields
        dateYear = new JTextField("YYYY");
        dateMonth = new JTextField("MM");
        dateDay = new JTextField("DD");
        
        
        
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        dateText = new JLabel("Date:");
        morningText = new JLabel("Morning overtime:");
        eveningText = new JLabel("Evening overtime:");
        returnMessage = new JLabel("", SwingConstants.CENTER);
       
        titleText = "<html><h2 align='center'>Add Overtime<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
       
       
       
        // Drop down menu
        morningDropdown = new Choice();
        eveningDropdown = new Choice();
        
        morningDropdown.add("0");
        morningDropdown.add("1");
        morningDropdown.add("2");
        morningDropdown.add("3");
        morningDropdown.add("4");
        
        eveningDropdown.add("0");
        eveningDropdown.add("1");
        eveningDropdown.add("2");
        eveningDropdown.add("3");
        eveningDropdown.add("4");
       
       
       
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
        
        
        morningDropdown.addItemListener(listener -> {
            morningString = morningDropdown.getSelectedItem();
            switch(morningString) {
                case "0":
                    morningCount = 0;
                    break;
                case "1":
                    morningCount = 1;
                    break;
                case "2":
                    morningCount = 2;
                    break;
                case "3":
                    morningCount = 3;
                    break;
                case "4":
                    morningCount = 4;
                    break;
                default:
                    morningCount = 0;
                    break;
            }
        });
        
        
        eveningDropdown.addItemListener(listener -> {
            eveningString = eveningDropdown.getSelectedItem();
            switch(eveningString) {
                case "0":
                    eveningCount = 0;
                    break;
                case "1":
                    eveningCount = 1;
                    break;
                case "2":
                    eveningCount = 2;
                    break;
                case "3":
                    eveningCount = 3;
                    break;
                case "4":
                    eveningCount = 4;
                    break;
                default:
                    eveningCount = 0;
                    break;
            }
        });
        
        
        submit.addActionListener(listener -> {
            date = dateYear.getText() + "-" + dateMonth.getText() + "-" + dateDay.getText();
            try {
                DBRequests.addOvertime(date, morningCount, eveningCount);
                returnMessage.setText("Overtime successfully requested");
            } catch (Exception e) {
                returnMessage.setText("Invalid input data");
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
        
        dateYear.setBounds(220, 97, 90, 25);
        content.add(dateYear);
        
        dateMonth.setBounds(310, 97, 90, 25);
        content.add(dateMonth);
        
        dateDay.setBounds(400, 97, 90, 25);
        content.add(dateDay);
        
        
        morningText.setBounds(70, 157, 140, 25);
        content.add(morningText);
        
        morningDropdown.setBounds(400, 157, 90, 25);
        content.add(morningDropdown);
        
        
        eveningText.setBounds(70, 217, 140, 25);
        content.add(eveningText);
        
        eveningDropdown.setBounds(400, 217, 90, 25);
        content.add(eveningDropdown);
        
        
        submit.setBounds(230, 277, 100, 25);
        content.add(submit);
        
        returnMessage.setBounds(135, 320, 300, 25);
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
     * This method <b>getPage</b> returns the <b>NonHROvertimeAdd</b> JPanel.
     * 
     * @return NonHROvertimeAdd JPanel
     */
    public static JPanel getPage() {
        return menu;
    }

}