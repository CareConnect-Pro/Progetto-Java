package it.unipv.posw.careconnectpro.view.dipendenti.amministratore;

import javax.swing.*;
import java.awt.*;

public class AmmPanel extends JPanel {
    
	private static final long serialVersionUID = 1L;
	
	private JButton registraButton, eliminaButton, logoutButton;

    public AmmPanel() {
        Font mediumFont = new Font("Arial", 0, 16);

        setVisible(true);
        registraButton = new JButton("Registra Utente");
        eliminaButton = new JButton("Elimina Utente");
        logoutButton = new JButton("Logout");

        registraButton.setFont(mediumFont);
        eliminaButton.setFont(mediumFont);
        logoutButton.setFont(mediumFont);

        add(registraButton);
        add(eliminaButton);
        add(logoutButton, BorderLayout.SOUTH);

    }

    public JButton getEliminaButton() {
        return eliminaButton;
    }
    public JButton getRegistraButton() {
        return registraButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
}
