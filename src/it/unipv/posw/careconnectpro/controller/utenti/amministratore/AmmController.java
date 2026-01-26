package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

public class AmmController {

    private IRSA model;
    private ViewController view;
    private BtnRegistraUtenteActionListener btn;

    public AmmController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        btn = new BtnRegistraUtenteActionListener(view);
        view.getAmmPanel().getRegistraButton().addActionListener(btn);



    }

    private void addActionListenerButtons(){

    }
}
