package it.unipv.posw.careconnectpro.controller;

import it.unipv.posw.careconnectpro.controller.login.LoginController;
import it.unipv.posw.careconnectpro.controller.utenti.amministratore.AmmController;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.InfController;
import it.unipv.posw.careconnectpro.controller.utenti.medico.MedController;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

public class FacadeController {

    private LoginController loginController;
    private AmmController ammController;
    private MedController medController;
    private RSAService model;
    private ViewController view;
    private InfController infController;

    public FacadeController(RSAService model, ViewController view) {

        loginController = new LoginController(model, view);
        ammController = new AmmController(model, view);
        medController = new MedController(model, view);
        infController = new InfController(model, view);

    }


}
