package GUI.General;

import GUI.NonHR.NonHREmployeeInfo;
import GUI.HR.HREmployeeInfoSearch;
import Database.DBRequests;
import Employee.HR;
import Employee.NonHR;
import SystemAndGeneral.SystemInfo;
import javax.swing.*;

/**
 * This class <b>LoginPage</b> holds all the components, styling and logic for
 * the login page.
 * 
 */
public class LoginPage {

    private static JPanel login;
    private JTextField username;
    private JPasswordField password;
    private JButton sendLogin;
    private JLabel returnMessage, info;
    private String text;

    /**
     * Instantiates the code for the LoginPage.
     */
    public LoginPage() {
        
        // Panels
        login = new JPanel();
        login.setLayout(null);
        
        
        
        // Text fields
        username = new JTextField("Username", 15);
        
        
        
        // Password fields
        password = new JPasswordField("Password", 15);
        
        
        
        // Buttons
        sendLogin = new JButton("Login");
        
        
        
        // Labels
        returnMessage = new JLabel("", SwingConstants.CENTER);
        info = new JLabel();
        
        text = "<html><h3 align = 'center'>Login Info (Username - Password)<br /></h1>";
        text += "<font style=\"font-family: 'Arial'; font-size 12pt;\">";
        text += "1001(HR) - Max<br />";
        text += "1002 - George<br />";
        text += "1003 - Dani<br />";
        info.setText(text);
        
        
        
        // Action Listeners        
        sendLogin.addActionListener(listener -> {
            String userName;
            String password;
            int id;
            try {
                userName = username.getText();
                password = this.password.getText();
                id = Integer.parseInt(userName);
                String accountType = DBRequests.isEmployee(id);
                try {
                    if (accountType.equals("1") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new HR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getAddress(id), Integer.parseInt(DBRequests.getAge(id)), DBRequests.getGender(id), Integer.parseInt(DBRequests.getSalary(id))));
                        GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
                        NonHREmployeeInfo.NonHRrefresh();
                        HREmployeeInfoSearch.HRrefresh();
                    } else if (accountType.equals("0") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new NonHR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getAddress(id), Integer.parseInt(DBRequests.getAge(id)), DBRequests.getGender(id), Integer.parseInt(DBRequests.getSalary(id))));
                        GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
                        NonHREmployeeInfo.NonHRrefresh();
                        HREmployeeInfoSearch.HRrefresh();
                    } else if (accountType.equals("User does not exist")) {
                        returnMessage.setText(accountType);
                    } else {
                        returnMessage.setText("Incorrect password");
                    }
                } catch (Exception e) {}
            } catch (Exception e) {
                returnMessage.setText("A valid ID does not include letters");
            }
        });
        
        
        
        // Component positioning and adding
        info.setBounds(275, 40, 500, 100);
        login.add(info);

        username.setBounds(315, 180, 171, 30);
        login.add(username);

        password.setBounds(315, 220, 171, 30);
        login.add(password);

        sendLogin.setBounds(355, 260, 91, 27);
        login.add(sendLogin);
        
        returnMessage.setBounds(275, 310, 250, 27);
        login.add(returnMessage);
    }
    
    
    /**
     * This method <b>getPage</b> returns the LoginPage JPanel.
     * 
     * @return LoginPage JPanel
     */
    public static JPanel getPage() {
        return login;
    }

}