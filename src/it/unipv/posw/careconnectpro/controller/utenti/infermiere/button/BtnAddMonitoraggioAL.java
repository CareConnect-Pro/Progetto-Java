package it.unipv.posw.careconnectpro.controller.utenti.infermiere.button;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BtnAddMonitoraggioAL implements ActionListener {

    private ViewController view;
    private IRSA model;
    private CartellaClinica cc;
    private int rigaSelezionata;
   

    public  BtnAddMonitoraggioAL(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        view.getGestionePazPanel().setVisible(false);
        view.getMonitoraggioPanel().setVisible(true);

        JTable tabella = view.getGestionePazPanel().getPazienteTable();
        rigaSelezionata =  tabella.getSelectedRow();

        if(rigaSelezionata != -1){
            String cfPaziente = (String) tabella.getValueAt(rigaSelezionata, 0);
            String idInfermiere = model.getUtenteLoggato().getCodiceFiscale();
            cc = model.cercaCartellaClinicaByCf(cfPaziente);

            view.getMonitoraggioPanel().getCfPazienteField().setText(cfPaziente);
            view.getMonitoraggioPanel().getIdInfermiereField().setText(idInfermiere);
            view.getMonitoraggioPanel().getIdCartellaField().setText(String.valueOf(cc.getIdCartellaClinica()));
        } else {
            PopUp.infoBox("Seleziona una riga dalla tabella prima di procedere!", "Nessuna Selezione");
        }

    }
    
   

    public CartellaClinica getCc() {
        return cc;
    }

    public int getRigaSelezionata() {
        return rigaSelezionata;
    }
}
