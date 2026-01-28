package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BtnConfermaTerapiaAL implements ActionListener {

    private ViewController view;
    private IRSA model;
    private BtnAddTerapiaActionListener terapiaAL = new BtnAddTerapiaActionListener(model, view);

    public BtnConfermaTerapiaAL(ViewController view) {
        this.view = view;
    }



    @Override
    public void actionPerformed(ActionEvent e){
        pulisciTextField();
        int riga = terapiaAL.getRigaSelezionata();
        view.getListMonitoraggioPanel().getMonitoraggiTable().rimuoviMonitoraggio(riga);



    }

    private void pulisciTextField(){
        view.getTerapiaPanel().getIdCartellaField().setText(null);
        view.getTerapiaPanel().getIdPazienteField().setText(null);
        view.getTerapiaPanel().getIdMedicoField().setText(null);
        view.getTerapiaPanel().getIdMonitoraggioField().setText(null);
        view.getTerapiaPanel().getFarmacoField().setText(null);
        view.getTerapiaPanel().getMaterialeField().setText(null);
        view.getTerapiaPanel().getDosaggioField().setText(null);
        view.getTerapiaPanel().getFrequenzaField().setText(null);
        view.getTerapiaPanel().getDurataField().setText(null);
        view.getTerapiaPanel().getDataInizioField().setText(null);
        view.getTerapiaPanel().getDataFineField().setText(null);
        view.getTerapiaPanel().getNoteField().setText(null);



    }


}
