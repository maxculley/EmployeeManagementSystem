package GUI;

import Database.DBRequests;
import Employee.HR;
import Employee.NonHR;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

public class LoginPage {

    private static JPanel login;
    private JTextField username;
    private JPasswordField password;
    private JButton sendLogin;
    private JLabel data;

    public static JPanel getLogin() {
        return login;
    }

    public LoginPage() {

        login = new JPanel();
        login.setLayout(null);
        //login.setBackground(Color.GRAY);

        username = new JTextField("Username", 15);
        password = new JPasswordField("Password", 15);
        sendLogin = new JButton("Login");
        data = new JLabel();

        sendLogin.addActionListener(listener -> {
            String userName = "";
            String password = "";
            int id;
            try {
                userName = username.getText();
                password = this.password.getText();
                id = Integer.parseInt(userName);
                String accountType = DBRequests.isEmployee(id);
                try {
                    if (accountType.equals("1") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new HR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getGender(id)));
                        data.setText("Successful Login to HR");
                        data.setBounds(330, 250, 401, 27);
                    } else if (accountType.equals("0") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new NonHR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getGender(id)));
                        data.setText("Successful Login to NonHR");
                        data.setBounds(317, 250, 401, 27);
                    } else if (accountType.equalsIgnoreCase("User does not exist")) {
                        data.setText(accountType);
                        data.setBounds(340, 250, 401, 27);
                    } else {
                        data.setText("Incorrect password");
                        data.setBounds(340, 250, 401, 27);
                    }
                }catch (Exception e){}
            } catch (Exception e) {
                data.setText("A valid ID does not include letters");
                data.setBounds(300, 250, 401, 27);
            }

        });

        username.setBounds(315, 120, 171, 30);
        login.add(username);
        password.setBounds(315, 150, 171, 30);
        login.add(password);
        sendLogin.setBounds(355, 200, 91, 27);
        login.add(sendLogin);
        login.add(data);
    }

}
