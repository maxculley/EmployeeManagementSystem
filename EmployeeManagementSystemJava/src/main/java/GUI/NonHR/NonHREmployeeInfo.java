package GUI.NonHR;

import GUI.General.GUIInfo;
import java.awt.Color;
import javax.swing.*;
import Database.DBRequests;
import SystemAndGeneral.General;
import SystemAndGeneral.SystemInfo;
import java.awt.Choice;

/**
 * This class <b>NonHREmployeeInfo</b> holds all the components, styling and logic for
 * the NonHR employee info page.
 * 
 */
public class NonHREmployeeInfo {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, dropdownLabel, infoInputLabel, title, id, firstName, lastName, address, age, gender, salary;
    private static JLabel idInfo, firstNameInfo, lastNameInfo, addressInfo, ageInfo, genderInfo, salaryInfo;
    private final JButton changeInfo, holidays, switchType, logout, contentSend, meetings, overtime;
    private final JTextField infoInput;
    private String changeInfoText, holidaysText, switchTypeText, userSelection, titleText, data, meetingsText, overtimeText;
    private Choice selection;
    private static boolean refresh = false;

    /**
    * Initialises the code for the NonHR employee info page
    */
    public NonHREmployeeInfo() {
        
        // Panels
        menu = new JPanel();
        menu.setLayout(null);
        
        quickmenu = new JPanel();
        quickmenu.setLayout(null);
        
        content = new JPanel();
        content.setLayout(null);
        
        
        
        // Buttons
        changeInfoText = "View/Change\nInformation";
        changeInfo = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeInfoText.replaceAll("\\n", "<br>") + "</p></html>");
        
        holidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");
        
        switchTypeText = "Switch to \nManagement";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
       
        meetingsText = "View/Change\nMeetings";
        meetings = new JButton("<html><style>p {text-align: center;}</style> <p>" + meetingsText.replaceAll("\\n", "<br>") + "</p></html>");
       
        overtimeText = "View/Change\nOvertime";
        overtime = new JButton("<html><style>p {text-align: center;}</style> <p>" + overtimeText.replaceAll("\\n", "<br>") + "</p></html>");
        
        contentSend = new JButton("Confirm");
        
        logout = new JButton("Logout");
        
        
        
        // Labels
        welcome = new JLabel("Non HR MENU", SwingConstants.CENTER);
        dropdownLabel = new JLabel("Select an option:");
        infoInputLabel = new JLabel("Information to be changed to:");
        
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
        
        titleText = "<html><h2 align='center'>Change/View Information<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);
        
        
        
        // Text Fields
        infoInput = new JTextField();
        
        
        
        // Drop down menu
        selection = new Choice();
        
        selection.add("Please select");
        selection.add("Address");
        selection.add("First Name");
        selection.add("Last Name");
        selection.add("Password");
        selection.add("Gender");
        
        
        
        // Listeners
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
        
        
        selection.addItemListener(listener -> {
            userSelection = selection.getSelectedItem();
        });
        
        
        changeInfo.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
        });
        
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "HRMenu");
                } else {}
            } catch (ClassNotFoundException ex) {}
        });
        
        holidays.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRHolidayHome");
        });
        
        
        meetings.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMeetingsHome");
        });
        
        
        overtime.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "NonHROvertimeHome");
        });
        
        
        contentSend.addActionListener(listener -> {
            try {
                switch (userSelection) {
                    case "Address":
                        data = infoInput.getText();
                        DBRequests.changeAddress(data);
                        break;
                    case "First Name":
                        data = infoInput.getText();
                        DBRequests.changeFirstName(data);
                        SystemInfo.setFirstName(data);
                        break;
                    case "Last Name":
                        data = infoInput.getText();
                        DBRequests.changeLastName(data);
                        SystemInfo.setLastName(data);
                        break;
                    case "Gender":
                        data = infoInput.getText();
                        DBRequests.changeGender(data);
                        SystemInfo.setGender(data);
                        break;
                    case "Password":
                        data = infoInput.getText();
                        DBRequests.changePassword(data);
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {}
            try {
                General.DBRefresh();
                idInfo.setText("" + SystemInfo.getID());
                firstNameInfo.setText(SystemInfo.getFirstName());
                lastNameInfo.setText(SystemInfo.getLastName());
                addressInfo.setText(SystemInfo.getAddress());
                ageInfo.setText("" + SystemInfo.getAge());
                genderInfo.setText(SystemInfo.getGender());
                salaryInfo.setText("" + SystemInfo.getSalary());
            }catch (Exception e){}
        });
        
        
        
        // Quickbar positioning and adding
        logout.setBounds(0, 0, 65, 20);
        quickmenu.add(logout);
        
        welcome.setBounds(0, 15, 230, 15);
        quickmenu.add(welcome);
        
        changeInfo.setBounds(50, 55, 135, 45);
        quickmenu.add(changeInfo);
        
        holidays.setBounds(50, 105, 135, 45);
        quickmenu.add(holidays);
       
        meetings.setBounds(50, 155, 135, 45);
        quickmenu.add(meetings);
        
        overtime.setBounds(50, 205, 135, 45);
        quickmenu.add(overtime);
        
        switchType.setBounds(55, 415, 120, 45);
        quickmenu.add(switchType);
        
        
        
        // Content positioning & adding
        title.setBounds(0, 20, 570, 35);
        content.add(title);
        
        dropdownLabel.setBounds(70, 85, 140, 25);
        content.add(dropdownLabel);
        
        selection.setBounds(350, 85, 140, 25);
        content.add(selection);
        
        infoInputLabel.setBounds(70, 125, 220, 25);
        content.add(infoInputLabel);
        
        infoInput.setBounds(330, 125, 160, 25);
        content.add(infoInput);
        
        contentSend.setBounds(230, 170, 100, 25);
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
        
        
        
        // Panel positioning & styling
        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);
        
        content.setBounds(231, 0, 569, 500);
        
        
        
        // Add content
        menu.add(content);
        menu.add(quickmenu);
    }
    
    /**
     * This method <b>NonHRrefresh</b> sets the position of the data if the page has
     * not yet been accessed and sets it blank as default. Otherwise it will just
     * set the fields blank.
     * 
     * This is used for clearing data off the screen when you exit a page.
     */
    public static void NonHRrefresh() {
        if (!refresh) {
            idInfo.setText("" + SystemInfo.getID());
            idInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            idInfo.setBounds(250, 212, 235, 15);

            firstNameInfo.setText(SystemInfo.getFirstName());
            firstNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            firstNameInfo.setBounds(250, 238, 235, 15);

            lastNameInfo.setText(SystemInfo.getLastName());
            lastNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            lastNameInfo.setBounds(250, 264, 235, 15);

            addressInfo.setText(SystemInfo.getAddress());
            addressInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            addressInfo.setBounds(250, 290, 235, 15);

            ageInfo.setText("" + SystemInfo.getAge());
            ageInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            ageInfo.setBounds(250, 316, 235, 15);

            genderInfo.setText(SystemInfo.getGender());
            genderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            genderInfo.setBounds(250, 342, 235, 15);

            salaryInfo.setText("" + SystemInfo.getSalary());
            salaryInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            salaryInfo.setBounds(250, 368, 235, 15);
            refresh = true;
        } else {
            try {
                General.DBRefresh();

                idInfo.setText("" + SystemInfo.getID());
                firstNameInfo.setText(SystemInfo.getFirstName());
                lastNameInfo.setText(SystemInfo.getLastName());
                addressInfo.setText(SystemInfo.getAddress());
                ageInfo.setText("" + SystemInfo.getAge());
                genderInfo.setText(SystemInfo.getGender());
                salaryInfo.setText("" + SystemInfo.getSalary());
            } catch (ClassNotFoundException ex) {
            }
        }
    }
    
    /**
     * This method <b>getPage</b> returns the <b>NonHREmployeeInfo</b> JPanel.
     * 
     * @return NonHREmployeeInfo JPanel
     */
    public static JPanel getPage() {
        return menu;
    }


}