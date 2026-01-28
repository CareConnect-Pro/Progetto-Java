package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import javax.swing.*;
import java.awt.*;

public class InfPanel extends JPanel{
	
    private static final long serialVersionUID = 1L;
    
	private JButton monitoraggioButton, logoutButton;

    public InfPanel(){
        Font mediumFont = new Font("Arial", 0, 16);
        setVisible(true);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(mediumFont);
        monitoraggioButton = new JButton("Aggiungi monitoraggio");
        monitoraggioButton.setFont(mediumFont);

        add(monitoraggioButton);
        add(logoutButton);
    }

    public JButton getMonitoraggioButton() {
        return monitoraggioButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }

}
