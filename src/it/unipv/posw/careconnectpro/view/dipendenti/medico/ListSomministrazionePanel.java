package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListSomministrazionePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private JTable somministrazioneList;
    private SomministrazioneTable somministrazioneTable;
    private JButton backButton, gestisciButton, eliminaButton;

    public ListSomministrazionePanel() {
    	Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);
        
        setLayout(new BorderLayout());

        somministrazioneTable = new SomministrazioneTable(new ArrayList<Somministrazione>()); 
        
        somministrazioneList = new JTable(somministrazioneTable);
        somministrazioneList.setFont(mediumFont);
        somministrazioneList.setRowHeight(25);
        somministrazioneList.getTableHeader().setFont(mediumFont);
        
        JScrollPane scrollPane = new JScrollPane(somministrazioneList);
        
        gestisciButton = new JButton("Inserisci Somministrazione");
        gestisciButton.setFont(largeFont);
      
        eliminaButton = new JButton("Elimina Record");
        eliminaButton.setFont(largeFont);
        
        backButton = new JButton("Indietro");
        backButton.setFont(largeFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(gestisciButton);
        buttonPanel.add(eliminaButton);
        buttonPanel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTable getSomministrazioneList() { return somministrazioneList; }
    public JButton getGestisciButton() { return gestisciButton; }
    public JButton getEliminaButton() { return eliminaButton; }
    public JButton getBackButton() { return backButton; }
    
    public void setListaSomministrazioni(List<Somministrazione> lista) {
        if (lista == null) {
            lista = new ArrayList<Somministrazione>();
        } 
        this.somministrazioneTable = new SomministrazioneTable(lista);
        this.somministrazioneList.setModel(somministrazioneTable);
    }
}