package it.unipv.posw.careconnectpro.controller;

import it.unipv.posw.careconnectpro.controller.login.LoginController;
import it.unipv.posw.careconnectpro.controller.utenti.amministratore.AmmController;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

public class FacadeController {

    private LoginController loginController;
    private RSAService model;
    private ViewController view;

    public FacadeController(RSAService model, ViewController view) {
        loginController = new LoginController(model, view);
        AmmController ammController = new AmmController(model, view);
    }


}
