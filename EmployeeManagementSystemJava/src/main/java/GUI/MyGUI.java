package GUI;

import Database.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import SystemAndGeneral.*;
import Employee.*;
import java.util.logging.*;

public class MyGUI extends JFrame {

    private JPanel login;
    private JTextField username;
    private JButton sendLogin;
    private JLabel data;

    public MyGUI() {

        login = new JPanel();
        username = new JTextField(15);
        sendLogin = new JButton("Login");
        data = new JLabel();

        sendLogin.addActionListener(listener -> {
            String name = "";
            int id = 0;
            try {
                name = username.getText();
                id = Integer.parseInt(name);
                try {
                    String type = DataBaseRequests.isEmployee(id);
                    if (type.equals("1")) {
                        SystemInformation.setUser(new HR(id, DataBaseRequests.getFirstName(id), DataBaseRequests.getLastName(id), DataBaseRequests.getGender(id)));
                        data.setText(SystemInformation.getUser().getLastName());
                    } else {
                        SystemInformation.setUser(new NonHR(id, DataBaseRequests.getFirstName(id), DataBaseRequests.getLastName(id), DataBaseRequests.getGender(id)));
                        data.setText(SystemInformation.getUser().getLastName());
                    }
                } catch (ClassNotFoundException ex) {
                }
            } catch (Exception e) {
                data.setText("A valid ID does not include letters");
            }

        });

        login.add(username);
        login.add(sendLogin);
        login.add(data);
        add(login);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
    }

}
