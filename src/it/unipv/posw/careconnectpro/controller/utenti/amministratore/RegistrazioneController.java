package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;



public class RegistrazioneController {
    private ViewController view;
    private IRSA model;

    public RegistrazioneController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

    }

    private void addRegistrazioneActionListener(){
        BtnRegistraUtenteActionListener button = new BtnRegistraUtenteActionListener(view);
        view.getAmmPanel().getRegistraButton().addActionListener(button);
    }
}
