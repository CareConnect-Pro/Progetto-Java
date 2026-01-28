package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import javax.swing.*;
import java.awt.*;

public class MedPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	
	private JButton logoutButton, openButton;


    public MedPanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        setVisible(true);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(mediumFont);
        openButton = new JButton("Monitoraggio Alert");
        openButton.setFont(mediumFont);

        add(openButton);
        add(logoutButton);


    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getOpenButton() {
        return openButton;
    }
}
