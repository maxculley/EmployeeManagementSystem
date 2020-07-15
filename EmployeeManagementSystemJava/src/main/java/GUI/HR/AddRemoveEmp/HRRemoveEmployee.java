package GUI.HR.AddRemoveEmp;

import Database.DBRequests;
import GUI.General.GUIInfo;
import SystemAndGeneral.SystemInfo;
import java.awt.*;
import javax.swing.*;

/**
 * This class <b>HRRemoveEmployee</b> holds all the components, styling and logic for
 * the HR remove employee page.
 * 
 */
public class HRRemoveEmployee {
 
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton switchType, logout, userSearch, addRemoveEmployee, searchConfirm, deleteButton, holidays, meetings, overtime;
    private final JLabel id, firstName, lastName, address, age, gender, salary, infoInputLabel;
    private static JLabel idInfo, firstNameInfo, lastNameInfo, addressInfo, ageInfo, genderInfo, salaryInfo;
    private final JLabel welcome, title;
    private final String switchTypeText, titleText, userSearchText, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private int inputValue;
    private static JTextField infoInput;
    private static boolean refresh = false;
   
    /**
    * Initialises the code for the HR remove employee page
    */
    public HRRemoveEmployee() {
       
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
        
        searchConfirm = new JButton("Search");
        
        deleteButton = new JButton("Delete");
        
        
        
        // Text Fields
        infoInput = new JTextField();
       
       
       
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
       
        titleText = "<html><h2 align='center'>Remove Employee<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
        
        infoInputLabel = new JLabel("Please enter an ID:");
        
        id = new JLabel("ID:");
        firstName = new JLabel("First Name:");
        lastName = new JLabel("Last Name:");
        address = new JLabel("Address:");
        age = new JLabel("Age:");
        gender = new JLabel("Gender:");
        salary = new JLabel("Salary:");
        
        idInfo = new JLabel();
        firstNameInfo = new JLabel();
        lastNameInfo = new JLabel();
        addressInfo = new JLabel();
        ageInfo = new JLabel();
        genderInfo = new JLabel();
        salaryInfo = new JLabel();
       
       
       
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
        
        
        searchConfirm.addActionListener(listener -> {
            try {
                inputValue = Integer.parseInt(infoInput.getText());
                try {
                    if (DBRequests.isEmployee(inputValue).equals("1") || DBRequests.isEmployee(inputValue).equals("0")) {
                        idInfo.setText(inputValue + "");
                        firstNameInfo.setText(DBRequests.getFirstName(inputValue));
                        lastNameInfo.setText(DBRequests.getLastName(inputValue));
                        addressInfo.setText(DBRequests.getAddress(inputValue));
                        ageInfo.setText(DBRequests.getAge(inputValue));
                        genderInfo.setText(DBRequests.getGender(inputValue));
                        salaryInfo.setText(DBRequests.getSalary(inputValue));
                    }

                } catch (Exception e) {
                    HRRemoveRefresh();
                    idInfo.setText("Employee does not exist");
                }
            } catch (Exception e) {
                HRRemoveRefresh();
                idInfo.setText("Please enter a valid ID");
            }
        });
        
        
        deleteButton.addActionListener(listener -> {
            try {
                HRRemoveRefresh();
                idInfo.setText("Employee " + inputValue + " has been deleted");
                DBRequests.deleteEmployee(inputValue);
            } catch (Exception e) {
                HRRemoveRefresh();
                idInfo.setText("Employee does not exist");
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
        
        infoInputLabel.setBounds(70, 85, 140, 25);
        content.add(infoInputLabel);
        
        infoInput.setBounds(330, 85, 160, 25);
        content.add(infoInput);
        
        searchConfirm.setBounds(230, 130, 100, 25);
        content.add(searchConfirm);
        
        deleteButton.setBounds(230, 385, 100, 25);
        content.add(deleteButton);
        
        
        
        id.setBounds(70, 182, 50, 15);
        content.add(id);
        
        firstName.setBounds(70, 208, 100, 15);
        content.add(firstName);
        
        lastName.setBounds(70, 234, 100, 15);
        content.add(lastName);
        
        address.setBounds(70, 260, 100, 15);
        content.add(address);
        
        age.setBounds(70, 286, 50, 15);
        content.add(age);
        
        gender.setBounds(70, 314, 100, 15);
        content.add(gender);
        
        salary.setBounds(70, 340, 100, 15);
        content.add(salary);
        
        
        content.add(idInfo);
        
        content.add(firstNameInfo);
        
        content.add(lastNameInfo);
        
        content.add(addressInfo);
        
        content.add(ageInfo);
        
        content.add(genderInfo);
        
        content.add(salaryInfo);
       
       
       
       
        // Panel positioning & styling and adding
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.GRAY);
       
        content.setBounds(231, 0, 800, 500);
       
       
       
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>HRrefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void HRRemoveRefresh() {
        if (!refresh) {
            idInfo.setText("");
            idInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            idInfo.setBounds(250, 182, 235, 15);

            firstNameInfo.setText("");
            firstNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            firstNameInfo.setBounds(250, 208, 235, 15);

            lastNameInfo.setText("");
            lastNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            lastNameInfo.setBounds(250, 234, 235, 15);

            addressInfo.setText("");
            addressInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            addressInfo.setBounds(250, 260, 235, 15);

            ageInfo.setText("");
            ageInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            ageInfo.setBounds(250, 286, 235, 15);

            genderInfo.setText("");
            genderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            genderInfo.setBounds(250, 314, 235, 15);

            salaryInfo.setText("");
            salaryInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            salaryInfo.setBounds(250, 340, 235, 15);
            refresh = true;
        } else {
            idInfo.setText("");
            firstNameInfo.setText("");
            lastNameInfo.setText("");
            addressInfo.setText("");
            ageInfo.setText("");
            genderInfo.setText("");
            salaryInfo.setText("");
        }
    }
    
    /**
     * This method <b>getPage</b> returns the <b>HRRemoveEmployee</b> JPanel.
     * 
     * @return HRRemoveEmployee JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
    
    /**
     * This method <b>clearEntry</b> is used to clear the JTextField after leaving
     * this page
     * 
     */
    public static void clearEntry() {
        infoInput.setText("");
    }
}
