package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;

public class ListTerapiePanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    private JButton inserisciSomministrazioneBtn, indietroBtn; 
    private JTable terapieTable; 
    private TerapiaTable modelloTabella; 

    public ListTerapiePanel() {
        Font mediumFont = new Font("Arial", 0, 16);

        setLayout(new BorderLayout(10, 10)); 
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        
        JLabel titoloLabel = new JLabel("Dashboard Infermiere - Terapie Odierne", SwingConstants.CENTER);
        titoloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(titoloLabel, BorderLayout.NORTH);

        modelloTabella = new TerapiaTable(
            new ArrayList<Somministrazione>(),
            new ArrayList<TerapiaDB>()
        );
        
        terapieTable = new JTable(modelloTabella);
        terapieTable.setDefaultRenderer(Object.class, new SomministrazioneRowRenderer());
        
        terapieTable.getColumnModel().getColumn(0).setPreferredWidth(50);  
        terapieTable.getColumnModel().getColumn(1).setPreferredWidth(120); 
        terapieTable.getColumnModel().getColumn(2).setPreferredWidth(120); 
        terapieTable.getColumnModel().getColumn(3).setPreferredWidth(80);  
        terapieTable.getColumnModel().getColumn(4).setPreferredWidth(100); 
        terapieTable.getColumnModel().getColumn(5).setPreferredWidth(140); 
        terapieTable.getColumnModel().getColumn(6).setPreferredWidth(180); 
        
        terapieTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        terapieTable.setRowHeight(25);
        terapieTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        JScrollPane scrollPane = new JScrollPane(terapieTable);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        
        inserisciSomministrazioneBtn = new JButton("Inserisci Somministrazione");
        inserisciSomministrazioneBtn.setFont(mediumFont);
        
        indietroBtn = new JButton("Indietro");
        indietroBtn.setFont(mediumFont);

        buttonPanel.add(inserisciSomministrazioneBtn);
        buttonPanel.add(indietroBtn);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getInserisciSomministrazioneBtn() { return inserisciSomministrazioneBtn; }
    public JButton getIndietroBtn() { return indietroBtn; }
    public JTable getTerapieTable() { return terapieTable; }
    public TerapiaTable getModelloTabella() { return modelloTabella; }
}