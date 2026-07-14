package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import javax.swing.*;
import java.awt.*;

public class InfPanel extends JPanel {
	
    private static final long serialVersionUID = 1L;
    
	private JButton logoutButton, gestionePazientiButton, terapieOdierneButton;

    public InfPanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        setVisible(true);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(mediumFont);
        gestionePazientiButton = new JButton("Gestione Pazienti");
        gestionePazientiButton.setFont(mediumFont);
        terapieOdierneButton = new JButton("Visualizza Terapie Odierne");
        terapieOdierneButton.setFont(mediumFont);

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        add(gestionePazientiButton);
        add(terapieOdierneButton);
        add(logoutButton);
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JButton getGestionePazientiButton() {
        return gestionePazientiButton;
    }

	public JButton getTerapieOdierneButton() {
		return terapieOdierneButton;
	}
}