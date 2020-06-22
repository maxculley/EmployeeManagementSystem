package GUI.General;

import GUI.HR.*;
import GUI.NonHR.*;
import java.awt.*;
import javax.swing.*;

public class GUIInfo {

    private JFrame window;
    private static JPanel container;
    private static CardLayout cl = new CardLayout();

    public GUIInfo() throws ClassNotFoundException {
        window = new JFrame();
        container = new JPanel();
        container.setLayout(cl);

        // Initalise pages
        new LoginPage();
        new NonHREmployeeInfo();
        new HREmployeeInfo();
        new HRAddRemove();
        new HRAdd();
        new HRRemove();

        // Add scenes to Frame
        container.add(LoginPage.getPage(), "Login");
        container.add(NonHREmployeeInfo.getPage(), "NonHRMenu");
        container.add(HREmployeeInfo.getPage(), "HRMenu");
        container.add(HRAddRemove.getPage(), "HRAddRemove");
        container.add(HRAdd.getPage(), "HRAdd");
        container.add(HRRemove.getPage(), "HRRemove");
        cl.show(container, "Login");

        // Add contianer to window
        window.add(container);

        // JFrame window layout
        window.setVisible(true);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Employee Management System");
    }

    public static CardLayout getCL() {
        return cl;
    }

    public static JPanel getCont() {
        return container;
    }

}