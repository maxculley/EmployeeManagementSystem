
package GUI;

import javax.swing.*;

public class HRMenu {
    
    private static JPanel menu;
    private JButton loginButton;
    
    
    public static JPanel getPage() {
        return menu;
    }
    
    
    public HRMenu() {
        menu = new JPanel();
        menu.setLayout(null);
        
        loginButton = new JButton("HR Login page");
        
        loginButton.setBounds(315, 120, 171, 30);
        menu.add(loginButton);
        
        loginButton.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
        
    }
    
}
