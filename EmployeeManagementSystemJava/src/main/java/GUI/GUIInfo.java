package GUI;

import java.awt.*;
import javax.swing.*;

public class GUIInfo {
    private JFrame window;
    private static JPanel container;
    private static CardLayout cl = new CardLayout();
    
    public static CardLayout getCL() {
        return cl;
    }
    
    public static JPanel getCont() {
        return container;
    }

    public GUIInfo() {
        window = new JFrame();
        container = new JPanel();
        container.setLayout(cl);
        
        // Initalise pages
        new LoginPage();
        new NonHRMenu();
        new HRMenu();
        
        
        // Add scenes to Frame
        container.add(LoginPage.getPage(), "Login");
        container.add(NonHRMenu.getPage(), "NonHRMenu");
        container.add(HRMenu.getPage(), "HRMenu");
        cl.show(container, "Login");
        
        
        // Add contianer to window
        window.add(container);
        
        
        // JFrame window layout
        window.setVisible(true);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Login");
    }

}