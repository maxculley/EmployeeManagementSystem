package GUI.General;

import GUI.NonHR.Holidays.*;
import GUI.HR.AddRemoveEmp.*;
import GUI.HR.*;
import GUI.HR.Holidays.*;
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
        new HREmployeeInfoSearch();
        new HRAddRemoveHome();
        new HRAddEmployee();
        new HRRemoveEmployee();
        new NonHRHolidayHome();
        new NonHRAddHoliday();
        new NonHRViewHoliday();
        new HRHolidayHomeMenu();
        new HRHolidayActions();
        new HRViewHoliday();
        

        // Add scenes to Frame
        container.add(LoginPage.getPage(), "Login");
        container.add(NonHREmployeeInfo.getPage(), "NonHRMenu");
        container.add(HREmployeeInfoSearch.getPage(), "HRMenu");
        container.add(HRAddRemoveHome.getPage(), "HRAddRemove");
        container.add(HRAddEmployee.getPage(), "HRAdd");
        container.add(HRRemoveEmployee.getPage(), "HRRemove");
        container.add(NonHRHolidayHome.getPage(), "NonHRHolidayHome");
        container.add(NonHRAddHoliday.getPage(), "NonHRAddHoliday");
        container.add(NonHRViewHoliday.getPage(), "NonHRViewHoliday");
        container.add(HRHolidayHomeMenu.getPage(), "HRHolidayHome");
        container.add(HRViewHoliday.getPage(), "HRViewHoliday");
        container.add(HRHolidayActions.getPage(), "HRHolidayActions");
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