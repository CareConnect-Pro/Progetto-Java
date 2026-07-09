package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import javax.swing.*;
import java.awt.*;

public class MedPanel extends JPanel {
	
    private static final long serialVersionUID = 1L;
    
	private JButton logoutButton, openButton, somministrazioneButton;


    public MedPanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        setVisible(true);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(mediumFont);
        openButton = new JButton("Visualizza Monitoraggi");
        openButton.setFont(mediumFont);
        somministrazioneButton = new JButton("Visualizza Somministrazioni");
        somministrazioneButton.setFont(mediumFont);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        add(openButton);
        add(somministrazioneButton);
        add(logoutButton);


    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getOpenButton() {
        return openButton;
    }

	public JButton getSomministrazioneButton() {
		return somministrazioneButton;
	}
    
    
}
