package it.unipv.posw.careconnectpro.view.login;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
	private JLabel cfLabel, passwordLabel;
    private JTextField cfField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel contenitorePanel;

    public LoginPanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);

        setVisible(true);
        setLayout(new GridLayout(4,2, 10,10));
        contenitorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contenitorePanel.setOpaque(false);

        cfLabel = new JLabel("Codice Fiscale:");
        cfField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Accedi");

        cfLabel.setFont(mediumFont);
        passwordLabel.setFont(mediumFont);
        loginButton.setFont(largeFont);
//        loginButton.setContentAreaFilled(true);
//        loginButton.setOpaque(true);
//        loginButton.setBackground(new Color(173, 216, 230));
//        loginButton.setBorderPainted(false);


        add(cfLabel);
        add(cfField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel(""));
        add(loginButton);
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    public JPasswordField getPasswordField() {
        return passwordField;
    }
    public JTextField getCfField() {
        return cfField;
    }
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }
    public JLabel getCfLabel() {
        return cfLabel;
    }



}
