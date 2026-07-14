package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BtnMonitoraggioActionListener implements ActionListener {

    private ViewController view;

    public BtnMonitoraggioActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getMedPanel().setVisible(false);
        updateMonitoraggi();
        view.getListMonitoraggioPanel().setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void updateMonitoraggi() {
        List<Monitoraggio> monitoraggi = ProxyMedico.getProxy().getMonitoraggiConAlertAttivo();        
        view.getListMonitoraggioPanel().setTabellaMonitoraggi(monitoraggi);
    }
}