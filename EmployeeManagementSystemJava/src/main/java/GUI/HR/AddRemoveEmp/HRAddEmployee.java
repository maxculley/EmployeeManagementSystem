package GUI.HR.AddRemoveEmp;

import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRAddEmployee</b> holds all the components, styling and logic for
 * the HR add employee page.
 * 
 */
public class HRAddEmployee {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, submit, holidays, meetings, overtime;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private final JLabel welcome, title, firstNameText, lastNameText, addressText, ageText, baseText, salaryText, passwordText;
    private static JTextField firstName, lastName, address, age, baseSalary, salary, password;
    private final JRadioButton male, female, other, hr, nonhr;
   
   /**
    * Initialises the code for the HR add employee page
    */
    public HRAddEmployee() {
       
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
       
        quickmenu = new JPanel();
        quickmenu.setLayout(null);
       
        content = new JPanel();
        content.setLayout(null);
       
       
       
        // Buttons
        switchTypeText = "Switch to \npersonal";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        userSearchText = "Employee\nSearch/Edit";
        userSearch = new JButton("<html><style>p {text-align: center;}</style> <p>" + userSearchText.replaceAll("\\n", "<br>") + "</p></html>");
       
        addRemoveEmployeeText = "Add/Remove\nEmployee";
        addRemoveEmployee = new JButton("<html><style>p {text-align: center;}</style> <p>" + addRemoveEmployeeText.replaceAll("\\n", "<br>") + "</p></html>");
        
        holidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");
       
        meetingsText = "View/Change\nMeetings";
        meetings = new JButton("<html><style>p {text-align: center;}</style> <p>" + meetingsText.replaceAll("\\n", "<br>") + "</p></html>");
       
        overtimeText = "View/Change\nOvertime";
        overtime = new JButton("<html><style>p {text-align: center;}</style> <p>" + overtimeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        logout = new JButton("Logout");
        
        submit = new JButton("Submit");
        
        
        
        // Radio Buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        gender.add(other);
        
        
        hr = new JRadioButton("HR");
        nonhr = new JRadioButton("Not HR");
        
        ButtonGroup employeeType = new ButtonGroup();
        employeeType.add(hr);
        employeeType.add(nonhr);
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        firstNameText = new JLabel("First name:");
        lastNameText = new JLabel("Last name:");
        addressText = new JLabel("Address:");
        ageText = new JLabel("Age:");
        baseText = new JLabel("Base salary:");
        salaryText = new JLabel("Employee salary:");
        passwordText = new JLabel("Password:");
        
        
       
        titleText = "<html><h2 align='center'>Add Employee<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
        
        
        
        // Text Fields
        firstName = new JTextField();
        lastName = new JTextField();
        address = new JTextField();
        age = new JTextField();
        baseSalary = new JTextField();
        salary = new JTextField();
        password = new JTextField();
        
        
        
        // Action Listeners
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
       
       
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
 
           
        userSearch.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
        });
       
       
        addRemoveEmployee.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRAddRemove");
        });
        
        
        holidays.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRHolidayHome");
        });
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HRMeetingsHomeMenu");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "HROvertimeHomeMenu");
        });
        
        
        submit.addActionListener(listener -> {
            String choice;
            int type;
            if (male.isSelected()) {
                choice = "M";
            } else if (female.isSelected()) {
                choice = "F";
            } else if (other.isSelected()) {
                choice = "O";
            } else {
                choice = "-";
            }
            
            if (hr.isSelected()) {
                type = 1;
            } else {
                type = 0;
            }
            
            try {
                DBRequests.addEmployee(firstName.getText(), lastName.getText(), address.getText(), Integer.parseInt(age.getText()), choice, type, Integer.parseInt(baseSalary.getText()), Integer.parseInt(salary.getText()), password.getText());
                HRAddRefresh();
                firstName.setText("Employee id: " + DBRequests.getCount());
            } catch (Exception e) {
                HRAddRefresh();
                firstName.setText("Information incorrect type");
            }
        });
       
       
       
        // Quickbar positioning & adding
        logout.setBounds(0, 0, 65, 20);
        quickmenu.add(logout);
       
        welcome.setBounds(0, 15, 230, 15);
        quickmenu.add(welcome);
       
        switchType.setBounds(60, 415, 110, 45);
        quickmenu.add(switchType);
       
        userSearch.setBounds(50, 55, 135, 45);
        quickmenu.add(userSearch);
       
        addRemoveEmployee.setBounds(50, 105, 135, 45);
        quickmenu.add(addRemoveEmployee);
        
        holidays.setBounds(50, 155, 135, 45);
        quickmenu.add(holidays);
       
        meetings.setBounds(50, 205, 135, 45);
        quickmenu.add(meetings);
        
        overtime.setBounds(50, 255, 135, 45);
        quickmenu.add(overtime);
       
       
       
        // Content positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        firstNameText.setBounds(70, 75, 140, 25);
        content.add(firstNameText);
        
        lastNameText.setBounds(70, 110, 140, 25);
        content.add(lastNameText);
        
        addressText.setBounds(70, 145, 140, 25);
        content.add(addressText);
        
        ageText.setBounds(70, 180, 140, 25);
        content.add(ageText);
        
        baseText.setBounds(70, 215, 140, 25);
        content.add(baseText);
        
        salaryText.setBounds(70, 250, 140, 25);
        content.add(salaryText);
        
        passwordText.setBounds(70, 285, 140, 25);
        content.add(passwordText);
        
        male.setBounds(120, 330, 75, 25);
        content.add(male);
        
        female.setBounds(235, 330, 100, 25);
        content.add(female);
        
        other.setBounds(365, 330, 75, 25);
        content.add(other);
        
        hr.setBounds(180, 385, 75, 25);
        content.add(hr);
        
        nonhr.setBounds(305, 385, 100, 25);
        content.add(nonhr);
        
        submit.setBounds(230, 430, 100, 25);
        content.add(submit);
        
        
        
        firstName.setBounds(350, 75, 140, 25);
        content.add(firstName);
        
        lastName.setBounds(350, 110, 140, 25);
        content.add(lastName);
        
        address.setBounds(350, 145, 140, 25);
        content.add(address);
        
        age.setBounds(350, 180, 140, 25);
        content.add(age);
        
        baseSalary.setBounds(350, 215, 140, 25);
        content.add(baseSalary);
        
        salary.setBounds(350, 250, 140, 25);
        content.add(salary);
        
        password.setBounds(350, 285, 140, 25);
        content.add(password);
        
       
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
       
 
    }
    
    /**
     * This method <b>HRAddRefresh</b> sets the fields blank when called.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void HRAddRefresh() {
        firstName.setText("");

        lastName.setText("");

        address.setText("");

        age.setText("");

        baseSalary.setText("");

        salary.setText("");
        
        password.setText("");
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HREmployeeAdd</b> JPanel.
     * 
     * @return HREmployeeAdd JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
    
}
