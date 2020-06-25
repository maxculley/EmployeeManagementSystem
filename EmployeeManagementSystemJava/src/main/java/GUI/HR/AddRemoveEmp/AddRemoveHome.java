package GUI.HR.AddRemoveEmp;

import GUI.General.GUIInfo;
import Database.DBRequests;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddRemoveHome {

    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, add, remove;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText;
    private final JLabel welcome, title;
    
    
    public AddRemoveHome() {
        
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
        
        logout = new JButton("Logout");
        
        add = new JButton("Add Employee");
        
        remove = new JButton("Remove Employee");
        
        
        
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        titleText = "<html><h2 align='center'>Add/Remove Employee<h2>";
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
        
        
        addRemoveEmployee.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRAddRemove");
        });
        
        
        add.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRAdd");
            AddEmployee.HRAddRefresh();
        });
        
        
        remove.addActionListener(listener -> {
            RemoveEmployee.HRRemoveRefresh();
            RemoveEmployee.clearEntry();
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRRemove");
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
        
        
        
        // Content positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        add.setBounds(90, 170, 140, 100);
        content.add(add);
        
        remove.setBounds(330, 170, 140, 100);
        content.add(remove);
        
        
        
        
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
        
        content.setBounds(231, 0, 800, 500);
        
        
        
        // Add content
        menu.add(content);
        menu.add(quickmenu);
        

    }

    public static JPanel getPage() {
        return menu;
    }

}