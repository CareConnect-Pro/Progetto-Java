package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListMonitoraggioPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
	private JTable monitoraggiList;
    private JButton terapiaButton, backButton, alertButton;
    private MonitoraggioTable monitoraggiTable;


    public  ListMonitoraggioPanel()  {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);
        setVisible(true);

        monitoraggiTable = new MonitoraggioTable(new ArrayList<>());

        monitoraggiList = new JTable(monitoraggiTable);
        monitoraggiList.setFont(mediumFont);
        monitoraggiList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        monitoraggiList.getColumnModel().getColumn(0).setPreferredWidth(50);
        monitoraggiList.getColumnModel().getColumn(1).setPreferredWidth(50);
        monitoraggiList.getColumnModel().getColumn(2).setPreferredWidth(100);
        monitoraggiList.getColumnModel().getColumn(3).setPreferredWidth(100);
        monitoraggiList.getColumnModel().getColumn(4).setPreferredWidth(250);
        monitoraggiList.getColumnModel().getColumn(5).setPreferredWidth(100);
        monitoraggiList.getColumnModel().getColumn(6).setPreferredWidth(100);
        monitoraggiList.getColumnModel().getColumn(7).setPreferredWidth(100);
        monitoraggiList.getColumnModel().getColumn(8).setPreferredWidth(150);


        JScrollPane scrollPane = new JScrollPane(monitoraggiList);

        setLayout(new BorderLayout());

        terapiaButton = new JButton("Inserisci terapia");
        terapiaButton.setFont(largeFont);
        backButton = new JButton("Indietro");
        backButton.setFont(largeFont);
        alertButton = new JButton("Risolvi alert");
        alertButton.setFont(largeFont);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(terapiaButton);
        buttonPanel.add(backButton);
        buttonPanel.add(alertButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }


    public JButton getBackButton() {
        return backButton;
    }

    public JButton getTerapiaButton() {
        return terapiaButton;
    }

    public JButton getAlertButton() {
        return alertButton;
    }

    public MonitoraggioTable getMonitoraggiTable() {
        return monitoraggiTable;
    }

    public JTable getMonitoraggiList() {
        return monitoraggiList;
    }
    
    public void setTabellaMonitoraggi(List<Monitoraggio> cercaMonitoraggio) {
		if (cercaMonitoraggio == null) {
			cercaMonitoraggio = new ArrayList<>();
		} 
		this.monitoraggiTable= new MonitoraggioTable(cercaMonitoraggio);
		this.monitoraggiList.setModel(monitoraggiTable);
		
	}
}
