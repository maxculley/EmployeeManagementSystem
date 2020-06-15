package GUI;

import Database.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import SystemAndGeneral.*;
import Employee.*;
import java.util.logging.*;

public class LoginScreen {
    private JFrame window;
    private JPanel login;
    private JTextField username, password;
    private JButton sendLogin;
    private JLabel data;

    public LoginScreen() {
        window = new JFrame();
        login = new JPanel();
       
        username = new JTextField("Username", 15);
        password = new JTextField("Password", 15);
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
                    } else if (accountType.equals("0") && password.equals(DBRequests.getPassword(id))) {
                        SystemInfo.setUser(new NonHR(id, DBRequests.getFirstName(id), DBRequests.getLastName(id), DBRequests.getGender(id)));
                        data.setText("Successful Login to NonHR");
                    } else if (accountType.equalsIgnoreCase("User does not exist")) {
                        data.setText(accountType);
                    } else {
                        data.setText("Incorrect password");
                    }
                } catch (ClassNotFoundException ex) {
                    data.setText("This account does not exist");
                }
            } catch (Exception e) {
                data.setText("A valid ID does not include letters");
            }

        });

        login.add(username);
        login.add(password);
        login.add(sendLogin);
        login.add(data);;
        window.add(login);

        window.setLayout(new FlowLayout());
        window.setVisible(true);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Login");
    }

}
