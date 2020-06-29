package GUI.NonHR.Holidays;
 
import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;
 
public class NonHRHolidayHome {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title;
    private final JButton changeInfo, holidays, switchType, logout, add, view;
    private final String changeInfoText, changeHolidaysText, switchTypeText, titleText;

    public NonHRHolidayHome() throws ClassNotFoundException {
        
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
        
        logout = new JButton("Logout");
        
        add = new JButton("Add holiday");
        
        view = new JButton("View holiday");
        
        
        
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        
        titleText = "<html><h2 align='center'>Holiday Portal<h2>";
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
        
        
        add.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRAddHoliday");
        });
        
        
        view.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRViewHoliday");
            try {
                SystemInfo.setHolidays();
            } catch (Exception e) {}
            NonHRViewHoliday.NonHRrefresh();
        });
        
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
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
    
    public static JPanel getPage() {
        return menu;
    }
 
}