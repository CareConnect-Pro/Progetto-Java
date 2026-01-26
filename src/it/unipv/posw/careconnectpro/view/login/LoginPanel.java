package it.unipv.posw.careconnectpro.view.login;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JLabel cfLabel, passwordLabel;
    private JTextField cfField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 24);

        setVisible(true);
        setLayout(new GridLayout(4,2, 10,10));

        cfLabel = new JLabel("Codice Fiscale:");
        cfField = new JTextField();
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Accedi");

        cfLabel.setFont(mediumFont);
        passwordLabel.setFont(mediumFont);
        loginButton.setFont(largeFont);

        add(cfLabel);
        add(cfField);
        add(passwordLabel);
        add(passwordField);
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
