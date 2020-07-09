package GUI.General;

import GUI.NonHR.Holidays.*;
import GUI.HR.AddRemoveEmp.*;
import GUI.HR.*;
import GUI.HR.Holidays.*;
import GUI.HR.Meetings.*;
import GUI.HR.Overtime.*;
import GUI.NonHR.*;
import GUI.NonHR.Meetings.*;
import GUI.NonHR.Overtime.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>GUIInfo</b> has all the information about the GUI window,
 * including all the layout options for the JFrame. 
 * 
 */
public class GUIInfo {

    private final JFrame window;
    private static JPanel container;
    private static final CardLayout cl = new CardLayout();

    /**
     * Instantiates the GUIIfo class initialising the code for the window.
     * 
     * @throws ClassNotFoundException - if the JPanel classes are not found
     */
    public GUIInfo() throws ClassNotFoundException {
        window = new JFrame();
        container = new JPanel();
        container.setLayout(cl);

        
        
        // Initalise pages
        new LoginPage();
        new NonHREmployeeInfo();
        new NonHRHolidaysHome();
        new NonHRHolidaysAdd();
        new NonHRHolidaysView();
        new NonHRMeetingsAdd();
        new NonHRMeetingsHome();
        new NonHRMeetingsView();
        new NonHROvertimeAdd();
        new NonHROvertimeHome();
        new NonHROvertimeView();
        
        
        new HREmployeeInfoSearch();
        new HRAddRemoveHome();
        new HRAddEmployee();
        new HRRemoveEmployee();
        new HRHolidayHomeMenu();
        new HRHolidayActions();
        new HRHolidayView();
        new HRMeetingsActions();
        new HRMeetingsHomeMenu();
        new HRMeetingsView();
        new HROvertimeActions();
        new HROvertimeHomeMenu();
        new HROvertimeView();
        

        
        // Add scenes to Frame
        container.add(LoginPage.getPage(), "Login");
        
        
        container.add(NonHREmployeeInfo.getPage(), "NonHRMenu");
        container.add(NonHRHolidaysHome.getPage(), "NonHRHolidayHome");
        container.add(NonHRHolidaysAdd.getPage(), "NonHRAddHoliday");
        container.add(NonHRHolidaysView.getPage(), "NonHRViewHoliday");
        container.add(NonHRMeetingsAdd.getPage(), "NonHRMeetingsAdd");
        container.add(NonHRMeetingsHome.getPage(), "NonHRMeetingsHome");
        container.add(NonHRMeetingsView.getPage(), "NonHRMeetingsView");
        container.add(NonHROvertimeAdd.getPage(), "NonHROvertimeAdd");
        container.add(NonHROvertimeHome.getPage(), "NonHROvertimeHome");
        container.add(NonHROvertimeView.getPage(), "NonHROvertimeView");
        
        
        container.add(HREmployeeInfoSearch.getPage(), "HRMenu");
        container.add(HRAddRemoveHome.getPage(), "HRAddRemove");
        container.add(HRAddEmployee.getPage(), "HRAdd");
        container.add(HRRemoveEmployee.getPage(), "HRRemove");
        container.add(HRHolidayHomeMenu.getPage(), "HRHolidayHome");
        container.add(HRHolidayView.getPage(), "HRViewHoliday");
        container.add(HRHolidayActions.getPage(), "HRHolidayActions");
        container.add(HRMeetingsActions.getPage(), "HRMeetingsActions");
        container.add(HRMeetingsHomeMenu.getPage(), "HRMeetingsHomeMenu");
        container.add(HRMeetingsView.getPage(), "HRMeetingsView");
        container.add(HROvertimeActions.getPage(), "HROvertimeActions");
        container.add(HROvertimeHomeMenu.getPage(), "HROvertimeHomeMenu");
        container.add(HROvertimeView.getPage(), "HROvertimeView");
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
    

    /**
     * This method <b>getCont</b> returns the JPanel which is used as a container
     * to hold all interactive JFrames in.
     * 
     * @return JFrame container for the JPanel
     */
    public static JPanel getCont() {
        return container;
    }
    
    /**
     * This method <b>getCL</b> returns the CardLayout object used for adding
     * different JFrames to the container.
     * 
     * @return Container's CardLayout
     */
    public static CardLayout getCL() {
        return cl;
    }

}