package GUI;

import java.awt.*;
import javax.swing.*;

public class WindowInfo {
    private JFrame window;
    private JPanel container;

    public WindowInfo() {
        window = new JFrame();
        new LoginPage();
        
        // Add scenes to container
        window.add(LoginPage.getLogin());
        
        
        // JFrame layout
        window.setVisible(true);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Login");
    }

}