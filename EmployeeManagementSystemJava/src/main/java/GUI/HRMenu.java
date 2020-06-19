package GUI;

import java.awt.Color;
import javax.swing.*;
import Database.DBRequests;
import SystemAndGeneral.General;
import SystemAndGeneral.SystemInfo;
import java.awt.*;


public class HRMenu {

    private static JPanel menu;
    private static JLabel idInfo, firstNameInfo, lastNameInfo, addressInfo, ageInfo, genderInfo, salaryInfo;
    private final JPanel layover, content;
    private final JLabel welcome, title, idEntryText, id, firstName, lastName, address, age, gender, salary;
    private final JTextField infoInput;
    private final JButton switchType, logout, userSearch, contentSend;
    private String userSearchText, switchTypeText, titleText;
    private int inputResult;
    private static boolean refresh = false;

    public static JPanel getPage() {
        return menu;
    }

    public HRMenu() throws ClassNotFoundException {
        
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
        
        layover = new JPanel();
        layover.setLayout(null);
        
        content = new JPanel();
        content.setLayout(null);
        
        
        
        // Buttons
        switchTypeText = "Switch to \npersonal";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
        
        userSearchText = "Employee\nSearch";
        userSearch = new JButton("<html><style>p {text-align: center;}</style> <p>" + userSearchText.replaceAll("\\n", "<br>") + "</p></html>");
        
        contentSend = new JButton("Confirm");
        
        logout = new JButton("Logout");
        
        
        
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        idEntryText = new JLabel("Enter an ID:");
        
        id = new JLabel("ID:");
        firstName = new JLabel("First Name:");
        lastName = new JLabel("Last Name:");
        address = new JLabel("Address:");
        age = new JLabel("Age:");
        gender = new JLabel("Gender:");
        salary = new JLabel("Salary:");
        
        idInfo = new JLabel();
        firstNameInfo = new JLabel("a");
        lastNameInfo = new JLabel();
        addressInfo = new JLabel();
        ageInfo = new JLabel();
        genderInfo = new JLabel();
        salaryInfo = new JLabel();
        
        titleText = "<html><h2 align='center'>Employee Information<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
        
        
        
        // Text fields
        infoInput = new JTextField();
        
        
        
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
        
        
        userSearch.addItemListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
        });
        
        
        contentSend.addActionListener(listener -> {
            inputResult = Integer.parseInt(infoInput.getText());
            try {
                if (DBRequests.isEmployee(inputResult).equals("1") || DBRequests.isEmployee(inputResult).equals("0")) {
                    idInfo.setText(inputResult + "");
                    firstNameInfo.setText(DBRequests.getFirstName(inputResult));
                    lastNameInfo.setText(DBRequests.getLastName(inputResult));
                    addressInfo.setText(DBRequests.getAddress(inputResult));
                    ageInfo.setText(DBRequests.getAge(inputResult));
                    genderInfo.setText(DBRequests.getGender(inputResult));
                    salaryInfo.setText(DBRequests.getSalary(inputResult));
                } else {
                    HRrefresh();
                    idInfo.setText("Employee does not exist");
                }
                
            } catch (Exception e) {}
        });
        
        
        
        // Quickbar positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        logout.setBounds(0, 0, 65, 20);
        layover.add(logout);
        
        welcome.setBounds(0, 15, 230, 15);
        layover.add(welcome);
        
        switchType.setBounds(60, 415, 110, 45);
        layover.add(switchType);
        
        userSearch.setBounds(50, 55, 135, 45);
        layover.add(userSearch);
        
        
        
        // Content positioning & adding
        idEntryText.setBounds(70, 105, 140, 25);
        content.add(idEntryText);
        
        infoInput.setBounds(350, 105, 140, 25);
        content.add(infoInput);
        
        contentSend.setBounds(230, 170, 100, 25);
        content.add(contentSend);
        
        
        
        id.setBounds(70, 212, 50, 15);
        content.add(id);
        
        firstName.setBounds(70, 238, 100, 15);
        content.add(firstName);
        
        lastName.setBounds(70, 264, 100, 15);
        content.add(lastName);
        
        address.setBounds(70, 290, 100, 15);
        content.add(address);
        
        age.setBounds(70, 316, 50, 15);
        content.add(age);
        
        gender.setBounds(70, 344, 100, 15);
        content.add(gender);
        
        salary.setBounds(70, 370, 100, 15);
        content.add(salary);
        
        
        content.add(idInfo);
        
        content.add(firstNameInfo);
        
        content.add(lastNameInfo);
        
        content.add(addressInfo);
        
        content.add(ageInfo);
        
        content.add(genderInfo);
        
        content.add(salaryInfo);
        
        
        
        // Panel positioning & styling and adding
        layover.setBounds(0, 0, 230, 500);
        layover.setBackground(Color.LIGHT_GRAY);
        
        content.setBounds(231, 0, 800, 500);
        
        
        
        // Add content
        menu.add(content);
        menu.add(layover);
    }
    
    public static void HRrefresh() {
        if (!refresh) {
            idInfo.setText("");
            idInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            idInfo.setBounds(250, 212, 235, 15);

            firstNameInfo.setText("");
            firstNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            firstNameInfo.setBounds(250, 238, 235, 15);

            lastNameInfo.setText("");
            lastNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            lastNameInfo.setBounds(250, 264, 235, 15);

            addressInfo.setText("");
            addressInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            addressInfo.setBounds(250, 290, 235, 15);

            ageInfo.setText("");
            ageInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            ageInfo.setBounds(250, 316, 235, 15);

            genderInfo.setText("");
            genderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            genderInfo.setBounds(250, 342, 235, 15);

            salaryInfo.setText("");
            salaryInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            salaryInfo.setBounds(250, 368, 235, 15);
            refresh = true;
        } else {
            
            idInfo.setText("");
            firstNameInfo.setText("");
            lastNameInfo.setText("");
            addressInfo.setText("");
            ageInfo.setText("");
            genderInfo.setText("");
            salaryInfo.setText("");
        }
    }

}