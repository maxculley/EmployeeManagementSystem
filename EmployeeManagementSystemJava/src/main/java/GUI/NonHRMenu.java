
package GUI;

import javax.swing.*;

public class NonHRMenu {
    
    private static JPanel menu;
    private JButton loginButton;
    
    
    public static JPanel getPage() {
        return menu;
    }
    
    
    public NonHRMenu() {
        menu = new JPanel();
        menu.setLayout(null);
        
        loginButton = new JButton("Non HR Login page");
        
        loginButton.setBounds(315, 120, 171, 30);
        menu.add(loginButton);
        
        loginButton.addActionListener(listener -> {
            GUIInfo.getCL().show(GUIInfo.getCont(), "Login");
        });
        
    }
    
}
