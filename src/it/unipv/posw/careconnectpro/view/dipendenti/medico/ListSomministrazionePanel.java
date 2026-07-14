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
    private JButton backButton, gestisciButton; 

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
      
        backButton = new JButton("Indietro");
        backButton.setFont(largeFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(gestisciButton);
        buttonPanel.add(backButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JTable getSomministrazioneList() { return somministrazioneList; }
    public JButton getGestisciButton() { return gestisciButton; }
    public JButton getBackButton() { return backButton; }

    public void setListaSomministrazioni(List<Somministrazione> lista) {
        if (lista == null) {
            lista = new ArrayList<Somministrazione>();
        } 
        this.somministrazioneTable = new SomministrazioneTable(lista);
        this.somministrazioneList.setModel(somministrazioneTable);
        this.somministrazioneList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
        somministrazioneList.getColumnModel().getColumn(0).setPreferredWidth(100);  
        somministrazioneList.getColumnModel().getColumn(1).setPreferredWidth(150); 	
        somministrazioneList.getColumnModel().getColumn(2).setPreferredWidth(180); 	
        somministrazioneList.getColumnModel().getColumn(3).setPreferredWidth(550); 	
    }
}