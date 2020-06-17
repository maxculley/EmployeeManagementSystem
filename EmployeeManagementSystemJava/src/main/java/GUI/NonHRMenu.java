package GUI;

import Database.DBRequests;
import java.awt.Color;
import javax.swing.*;
import Database.DBRequests;
import SystemAndGeneral.SystemInfo;


public class NonHRMenu {

    private static JPanel menu;
    private JPanel layover;
    private JLabel welcome;
    private JButton changeInfo, holidays;

    public static JPanel getPage() {
        return menu;
    }

    public NonHRMenu() throws ClassNotFoundException {
        
        menu = new JPanel();
        menu.setLayout(null);
        
        layover = new JPanel();
        layover.setLayout(null);
        
        
        String changeInfoText = "View/Change\nInformation";
        changeInfo = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeInfoText.replaceAll("\\n", "<br>") + "</p></html>");
        String changeHolidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeHolidaysText.replaceAll("\\n", "<br>") + "</p></html>");
        
        
        welcome = new JLabel("Welcome!", SwingConstants.CENTER);
        
        
        welcome.setBounds(0, 15, 230, 15);
        layover.add(welcome);
        
        changeInfo.setBounds(50, 55, 135, 45);
        layover.add(changeInfo);
        
        holidays.setBounds(50, 105, 135, 45);
        layover.add(holidays);
        
        layover.setBounds(0, 0, 230, 500);
        layover.setBackground(Color.LIGHT_GRAY);
        menu.add(layover);
        

    }

}
