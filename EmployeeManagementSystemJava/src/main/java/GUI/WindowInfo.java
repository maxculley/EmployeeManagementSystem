package GUI;

import java.awt.*;
import javax.swing.*;

public class WindowInfo {
    private JFrame window;
    private JPanel container;

    public WindowInfo() {
        window = new JFrame();
        container = new JPanel();
        new LoginPage();
        
        // Add JFrame to container
        container.add(LoginPage.getLogin());
        
        
        // Add contianer to window
        window.add(container);
        
        
        // JFrame layout
        window.setVisible(true);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Login");
    }

}