package GUI;

import java.awt.Color;
import javax.swing.*;
import Database.DBRequests;
import SystemAndGeneral.SystemInfo;
import java.awt.Choice;
import java.util.HashSet;


public class NonHRMenu {

    private static JPanel menu;
    private JPanel quickMenu, content;
    private JLabel welcome, dropdownLabel, infoInputLabel, title;
    private JButton changeInfo, holidays, switchType, logout, contentSend;
    private JTextField infoInput;
    String changeInfoText, changeHolidaysText, switchTypeText, userSelection, titleText, newData, data;
    Choice selection;

    public static JPanel getPage() {
        return menu;
    }

    public NonHRMenu() throws ClassNotFoundException {
        
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
        
        quickMenu = new JPanel();
        quickMenu.setLayout(null);
        
        content = new JPanel();
        content.setLayout(null);
        
        
        
        // Buttons
        changeInfoText = "View/Change\nInformation";
        changeInfo = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeInfoText.replaceAll("\\n", "<br>") + "</p></html>");
        
        changeHolidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeHolidaysText.replaceAll("\\n", "<br>") + "</p></html>");
        
        switchTypeText = "Switch to \nManagement";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
        
        contentSend = new JButton("Confirm");
        
        logout = new JButton("Logout");
        
        
        
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        dropdownLabel = new JLabel("Select an option:");
        infoInputLabel = new JLabel("Information to be changed to:");
        
        titleText = "<html><h2 align='center'>Change/View Information<h2>";
        title = new JLabel(titleText);
        
        
        
        // Text Fields
        infoInput = new JTextField();
        
        
        
        // Drop down menu
        selection = new Choice();
        
        selection.add("Please select");
        selection.add("Address");
        selection.add("First Name");
        selection.add("Last Name");
        selection.add("Password");
        selection.add("Gender");
        
        
        
        // Listeners
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
        
        
        selection.addItemListener(listener -> {
            userSelection = selection.getSelectedItem();
        });
        
        
        changeInfo.addItemListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
        });
        
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
        
        
        contentSend.addActionListener(listener -> {
            try {
                if (userSelection.equals("Address")) {
                    data = infoInput.getText();
                    DBRequests.changeAddress(data);
                } else if (userSelection.equals("First Name")) {
                    data = infoInput.getText();
                    DBRequests.changeFirstName(data);
                    SystemInfo.setFirstName(data);
                } else if (userSelection.equals("Last Name")) {
                data = infoInput.getText();
                    DBRequests.changeLastName(data);
                    SystemInfo.setLastName(data);
                } else if (userSelection.equals("Gender")) {
                    data = infoInput.getText();
                    DBRequests.changeGender(data);
                    SystemInfo.setGender(data);
                } else if (userSelection.equals("Password")) {
                    data = infoInput.getText();
                    DBRequests.changePassword(data);
                }
            } catch (Exception e) {}
        });
        
        
        
        // Quickbar positioning and adding
        logout.setBounds(0, 0, 65, 20);
        quickMenu.add(logout);
        
        welcome.setBounds(0, 15, 230, 15);
        quickMenu.add(welcome);
        
        changeInfo.setBounds(50, 55, 135, 45);
        quickMenu.add(changeInfo);
        
        holidays.setBounds(50, 105, 135, 45);
        quickMenu.add(holidays);
        
        switchType.setBounds(55, 415, 120, 45);
        quickMenu.add(switchType);
        
        
        
        // Content positioning
        title.setBounds(160, 20, 251, 35);
        content.add(title);
        
        dropdownLabel.setBounds(40, 85, 140, 25);
        content.add(dropdownLabel);
        
        selection.setBounds(350, 85, 140, 25);
        content.add(selection);
        
        infoInputLabel.setBounds(40, 155, 220, 25);
        content.add(infoInputLabel);
        
        infoInput.setBounds(330, 155, 160, 25);
        content.add(infoInput);
        
        contentSend.setBounds(230, 206, 100, 25);
        content.add(contentSend);
        
        
        
        // Panel positioning & styling
        quickMenu.setBounds(0, 0, 230, 500);
        quickMenu.setBackground(Color.LIGHT_GRAY);
        
        content.setBounds(231, 0, 569, 500);
        
        
        
        // Add content
        menu.add(content);
        menu.add(quickMenu);
    }

}
