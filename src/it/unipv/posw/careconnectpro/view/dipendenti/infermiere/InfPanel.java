package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import javax.swing.*;
import java.awt.*;

public class InfPanel extends JPanel{
	
    private static final long serialVersionUID = 1L;
    
	private JButton gestionePazientiButton, logoutButton;

    public InfPanel(){
        Font mediumFont = new Font("Arial", 0, 16);
        setVisible(true);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(mediumFont);
        gestionePazientiButton = new JButton("Gestione Paziente");
        gestionePazientiButton.setFont(mediumFont);

        add(gestionePazientiButton);
        add(logoutButton);
    }

    public JButton getGestionePazientiButton() {
        return gestionePazientiButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }

}
