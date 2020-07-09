package GUI.HR;

import GUI.General.GUIInfo;
import java.awt.Color;
import javax.swing.*;
import Database.DBRequests;
import SystemAndGeneral.SystemInfo;
import java.awt.*;

/**
 * This class <b>HREmployeeInfoSearch</b> holds all the components, styling and logic for
 * the HR employee search page.
 * 
 */
public class HREmployeeInfoSearch {

    private static JPanel menu;
    private static JLabel idInfo, firstNameInfo, lastNameInfo, addressInfo, ageInfo, genderInfo, salaryInfo;
    private final JPanel quickmenu, content;
    private final JLabel welcome, title, idEntryText, infoChangeText, dropdownLabel, id, firstName, lastName, address, age, gender, salary;
    private final JTextField idInput, infoChangeInput;
    private final JButton switchType, logout, userSearch, contentSend, addRemoveEmployee, holidays, meetings, overtime;
    private String userSearchText, switchTypeText, titleText, userSelection, data, addRemoveEmployeeText, holidaysText, meetingsText, overtimeText;
    private Choice selection;
    private int inputResult;
    private static boolean refresh = false;

    
    /**
     * Initialises the code for the HR search page
     * 
     */
    public HREmployeeInfoSearch() {
        
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
        
        contentSend = new JButton("Confirm");
        
        logout = new JButton("Logout");
        
        
        
        // Labels
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        idEntryText = new JLabel("Enter an ID:");
        infoChangeText = new JLabel("Information to be changed to:");
        dropdownLabel = new JLabel("Select an option:");
        
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
        
        titleText = "<html><h2 align='center'>Employee Information<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
        
        
        
        // Drop down menu
        selection = new Choice();
        
        selection.add("Please select");
        selection.add("Address");
        selection.add("First Name");
        selection.add("Last Name");
        selection.add("Password");
        selection.add("Gender");
        selection.add("Salary");
        
        
        
        // Text fields
        idInput = new JTextField();
        infoChangeInput = new JTextField();
        
        
        
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
        
        
        selection.addItemListener(listener -> {
            userSelection = selection.getSelectedItem();
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

        
        contentSend.addActionListener(listener -> {
            try {
                inputResult = Integer.parseInt(idInput.getText());
                try {
                    if (DBRequests.isEmployee(inputResult).equals("1") || DBRequests.isEmployee(inputResult).equals("0")) {
                        idInfo.setText(inputResult + "");
                        firstNameInfo.setText(DBRequests.getFirstName(inputResult));
                        lastNameInfo.setText(DBRequests.getLastName(inputResult));
                        addressInfo.setText(DBRequests.getAddress(inputResult));
                        ageInfo.setText(DBRequests.getAge(inputResult));
                        genderInfo.setText(DBRequests.getGender(inputResult));
                        salaryInfo.setText(DBRequests.getSalary(inputResult));
                        try {
                            switch (userSelection) {
                                case "Address":
                                    data = infoChangeInput.getText();
                                    DBRequests.changeAddress(data, inputResult);
                                    addressInfo.setText(DBRequests.getAddress(inputResult));
                                    break;

                                case "First Name":
                                    data = infoChangeInput.getText();
                                    DBRequests.changeFirstName(data, inputResult);
                                    firstNameInfo.setText(DBRequests.getFirstName(inputResult));
                                    break;
                                case "Last Name":
                                    data = infoChangeInput.getText();
                                    DBRequests.changeLastName(data, inputResult);
                                    lastNameInfo.setText(DBRequests.getLastName(inputResult));
                                    break;
                                case "Gender":
                                    data = infoChangeInput.getText();
                                    DBRequests.changeGender(data, inputResult);
                                    genderInfo.setText(DBRequests.getGender(inputResult));
                                    break;
                                case "Password":
                                    data = infoChangeInput.getText();
                                    DBRequests.changePassword(data, inputResult);
                                    break;
                                case "Salary":
                                    data = infoChangeInput.getText();
                                    DBRequests.changeSalary(Integer.parseInt(data), inputResult);
                                    salaryInfo.setText(DBRequests.getSalary(inputResult));
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                        }
                    } else {
                        HRrefresh();
                        idInfo.setText("Employee does not exist");
                    }

                } catch (Exception e) {}
            } catch (Exception e) {
                HRrefresh();
                idInfo.setText("Invalid input");
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
        
        idEntryText.setBounds(70, 60, 140, 25);
        content.add(idEntryText);
        
        idInput.setBounds(350, 60, 140, 25);
        content.add(idInput);
        
        dropdownLabel.setBounds(70, 97, 140, 25);
        content.add(dropdownLabel);
        
        selection.setBounds(350, 97, 140, 25);
        content.add(selection);
        
        infoChangeText.setBounds(70, 135, 220, 25);
        content.add(infoChangeText);
        
        infoChangeInput.setBounds(330, 135, 160, 25);
        content.add(infoChangeInput);
        
        contentSend.setBounds(230, 177, 100, 25);
        content.add(contentSend);
        
        
        
        id.setBounds(70, 212, 50, 15);
        content.add(id);
        
        firstName.setBounds(70, 238, 100, 15);
        content.add(firstName);
        
        lastName.setBounds(70, 264, 100, 15);
        content.add(lastName);
        
        address.setBounds(70, 290, 100, 15);
        content.add(address);
        
        age.setBounds(70, 316, 50, 15);
        content.add(age);
        
        gender.setBounds(70, 344, 100, 15);
        content.add(gender);
        
        salary.setBounds(70, 370, 100, 15);
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
     * This method <b>getPage</b> returns the <b>HREmployeeInfoSearch</b> JPanel.
     * 
     * @return HREmployeeInfoSearch JPanel
     */
    public static JPanel getPage() {
        return menu;
    }
    
    /**
     * This method <b>HRrefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void HRrefresh() {
        if (!refresh) {
            idInfo.setText("");
            idInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            idInfo.setBounds(250, 212, 235, 15);

            firstNameInfo.setText("");
            firstNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            firstNameInfo.setBounds(250, 238, 235, 15);

            lastNameInfo.setText("");
            lastNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            lastNameInfo.setBounds(250, 264, 235, 15);

            addressInfo.setText("");
            addressInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            addressInfo.setBounds(250, 290, 235, 15);

            ageInfo.setText("");
            ageInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            ageInfo.setBounds(250, 316, 235, 15);

            genderInfo.setText("");
            genderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            genderInfo.setBounds(250, 342, 235, 15);

            salaryInfo.setText("");
            salaryInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            salaryInfo.setBounds(250, 368, 235, 15);
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

}