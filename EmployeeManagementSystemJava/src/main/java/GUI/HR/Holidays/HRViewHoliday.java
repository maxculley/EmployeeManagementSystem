package GUI.HR.Holidays;
 
import Database.DBRequests;
import GUI.General.GUIInfo;
import static GUI.NonHR.Holidays.NonHRViewHoliday.NonHRViewHolRefresh;
import Holiday.Holiday;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;
 
public class HRViewHoliday {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, holidays, next, previous;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText;
    private final JLabel welcome, title, startDateText, endDateText, statusText;
    private static JLabel startDate, endDate, status;
    private static int pageCount;
    private static boolean refresh = false;
    private static Holiday currentHol;
   
   
    public HRViewHoliday() {
       
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
        
        next = new JButton("Next");
        
        previous = new JButton("Previous");
       
        logout = new JButton("Logout");
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        startDateText = new JLabel("Start Date:");
        endDateText = new JLabel("End Date:");
        statusText = new JLabel("Status:");
        
        startDate = new JLabel();
        endDate = new JLabel();
        status = new JLabel();
       
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
       
       
       
        // Content positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        
        startDateText.setBounds(70, 97, 140, 25);
        content.add(startDateText);
        
        endDateText.setBounds(70, 157, 140, 25);
        content.add(endDateText);
        
        statusText.setBounds(70, 217, 140, 25);
        content.add(statusText);
        
        
        content.add(startDate);
        
        content.add(endDate);
        
        content.add(status);
        
        
        previous.setBounds(175, 290, 90, 25);
        content.add(previous);
        previous.setVisible(false);
        
        next.setBounds(290, 290, 90, 25);
        content.add(next);
       
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
       
 
    }
    
    public static void HRViewHolRefresh() {
        currentHol = (Holiday) SystemInfo.getHoliday().get(pageCount);
        if (!refresh) {
            startDate.setText(currentHol.getStartDate());
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 97, 235, 15);

            endDate.setText(currentHol.getEndDate());
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 157, 235, 15);

            status.setText(currentHol.getStatus());
            status.setHorizontalAlignment(SwingConstants.RIGHT);
            status.setBounds(250, 217, 235, 15);
            refresh = true;
        } else {
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