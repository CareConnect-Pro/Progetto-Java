package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

public class AmmController {

    private IRSA model;
    private ViewController view;
    private BtnRegistraUtenteActionListener btnRegistrazione;
    private RegistrazioneController regController;
    private DisattivaUtenteActionListener eliminaUtente;


    public AmmController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        btnRegistrazione = new BtnRegistraUtenteActionListener(view);
        eliminaUtente = new DisattivaUtenteActionListener(model);

        view.getAmmPanel().getRegistraButton().addActionListener(btnRegistrazione);
        view.getAmmPanel().getEliminaButton().addActionListener(eliminaUtente);
        regController = new RegistrazioneController(model, view);


    }

}
