package it.unipv.posw.careconnectpro.controller.utenti.infermiere.button;

import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.rsa.infermiere.ProxyInfermiere;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BtnOpenActionListener implements ActionListener {

    private ViewController view;

    public BtnOpenActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        updatePazienti();
        view.getGestionePazPanel().setVisible(true);
    }

    public void updatePazienti() {
        List<Paziente> pazienti = ProxyInfermiere.getProxy().cercaPazienti();        
        view.getGestionePazPanel().setTabellaPazienti(pazienti);
    }
}