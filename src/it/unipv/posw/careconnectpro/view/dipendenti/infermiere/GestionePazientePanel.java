package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;

import javax.swing.*;
import java.awt.*;

public class GestionePazientePanel extends JPanel {

    private JTable pazienteTable;
    private JButton inserisciButton, backButton;
    private PazientiTable tabellaPazienti;
    private IRSA model;


    public GestionePazientePanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);
        setVisible(true);
        setLayout(new BorderLayout());

        model = new RSAService();
        tabellaPazienti = new PazientiTable(model.cercaPazienti());

        pazienteTable = new JTable(tabellaPazienti);
        pazienteTable.setFont(mediumFont);
        //pazienteTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pazienteTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        pazienteTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        pazienteTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        pazienteTable.getColumnModel().getColumn(3).setPreferredWidth(150);


        JScrollPane scrollPane = new JScrollPane(pazienteTable);


        JPanel panel = new JPanel();
        inserisciButton = new JButton("Inserisci Monitoraggio");
        inserisciButton.setFont(largeFont);
        backButton = new JButton("Indietro");
        backButton.setFont(largeFont);

        panel.add(inserisciButton);
        panel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

    }

    public JButton getInserisciButton() {
        return inserisciButton;
    }
    public JButton getBackButton() {
        return backButton;
    }
    public JTable getPazienteTable() {
        return pazienteTable;
    }
    public PazientiTable getTabellaPazienti() {
        return tabellaPazienti;
    }
}
