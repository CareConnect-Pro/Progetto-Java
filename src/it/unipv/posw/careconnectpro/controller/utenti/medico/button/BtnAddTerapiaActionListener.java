package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAddTerapiaActionListener implements ActionListener {

    private ViewController view;

    public BtnAddTerapiaActionListener(ViewController view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JTable tabella = view.getListMonitoraggioPanel().getMonitoraggiList();
            int riga = tabella.getSelectedRow();

          
            if (riga != -1) {
                String idMonitoraggioStr = String.valueOf(tabella.getValueAt(riga, 0));
                String cfPaziente = String.valueOf(tabella.getValueAt(riga, 2)); 
                
                String idMedico = ProxyMedico.getProxy().getUtenteLoggato().getCodiceFiscale();
                CartellaClinica cc = ProxyMedico.getProxy().cercaCartellaClinicaByCf(cfPaziente);

                view.getTerapiaPanel().getIdCartellaField().setText(String.valueOf(cc.getIdCartellaClinica()));
                view.getTerapiaPanel().getIdPazienteField().setText(cfPaziente);
                view.getTerapiaPanel().getIdMedicoField().setText(idMedico);
                view.getTerapiaPanel().getIdMonitoraggioField().setText(idMonitoraggioStr);

                view.getListMonitoraggioPanel().setVisible(false);
                view.getTerapiaPanel().setVisible(true);

            } else {
                PopUp.infoBox("Seleziona una riga dalla tabella prima di procedere!", "Nessuna Selezione");
            }
            
        } catch (Exception ex) {
            PopUp.infoBox("Errore imprevisto durante il caricamento dei dati dalla tabella.", "Errore di Navigazione");
            ex.printStackTrace();
        }
    }
}