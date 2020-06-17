package GUI;

import java.awt.Color;
import javax.swing.*;
import Database.DBRequests;
import SystemAndGeneral.SystemInfo;
import java.awt.*;


public class HRMenu {

    private static JPanel menu;
    private JPanel layover, content;
    private JLabel welcome;
    private JButton changeInfo, holidays, switchType, logout;
    String changeInfoText, changeHolidaysText, switchTypeText;

    public static JPanel getPage() {
        return menu;
    }

    public HRMenu() throws ClassNotFoundException {
        
        menu = new JPanel();
        menu.setLayout(null);
        
        layover = new JPanel();
        layover.setLayout(null);
        
        content = new JPanel();
        content.setLayout(null);
        
        welcome = new JLabel("HR MENU", SwingConstants.CENTER);
        
        
        switchTypeText = "Switch to \npersonal";
        switchType = new JButton("<html><style>p {text-align: center;}</style> <p>" + switchTypeText.replaceAll("\\n", "<br>") + "</p></html>");
        logout = new JButton("Logout");
        
        
        logout.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
        
        switchType.addActionListener(listener -> {
            try {
                if ((DBRequests.isEmployee(SystemInfo.getID())).equals("1")) {
                    GUIInfo.getCL().show(GUIInfo.getCont(), "NonHRMenu");
                } else {
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Not working");
            }
        });
        
        
        logout.setBounds(0, 0, 65, 20);
        layover.add(logout);
        
        welcome.setBounds(0, 15, 230, 15);
        layover.add(welcome);
        
        switchType.setBounds(60, 415, 110, 45);
        layover.add(switchType);
        
        
        
        layover.setBounds(0, 0, 230, 500);
        layover.setBackground(Color.LIGHT_GRAY);
        
        content.setBounds(231, 0, 800, 500);
        
        
        menu.add(content);
        menu.add(layover);
    }

}
