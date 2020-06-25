package GUI.General;

import GUI.NonHR.Holidays.HolidayHome;
import GUI.NonHR.Holidays.ViewHoliday;
import GUI.NonHR.Holidays.AddHoliday;
import GUI.HR.AddRemoveEmp.AddEmployee;
import GUI.HR.AddRemoveEmp.RemoveEmployee;
import GUI.HR.AddRemoveEmp.AddRemoveHome;
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
        new EmployeeInfo();
        new EmployeeInfoSearch();
        new AddRemoveHome();
        new AddEmployee();
        new RemoveEmployee();
        new HolidayHome();
        new AddHoliday();
        new ViewHoliday();

        // Add scenes to Frame
        container.add(LoginPage.getPage(), "Login");
        container.add(EmployeeInfo.getPage(), "NonHRMenu");
        container.add(EmployeeInfoSearch.getPage(), "HRMenu");
        container.add(AddRemoveHome.getPage(), "HRAddRemove");
        container.add(AddEmployee.getPage(), "HRAdd");
        container.add(RemoveEmployee.getPage(), "HRRemove");
        container.add(HolidayHome.getPage(), "NonHRHolidayHome");
        container.add(AddHoliday.getPage(), "NonHRAddHoliday");
        container.add(ViewHoliday.getPage(), "NonHRViewHoliday");
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