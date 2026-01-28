package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnAddMonitoraggioAL;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnOpenActionListener;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.InfPanel;

public class InfController {

    private IRSA model;
    private ViewController view;

    private GestioniPazientiController gestioneController;
    private AddMonitoraggioController addMonitoraggioController;
    private BtnOpenActionListener btnOpenActionListener;


    public InfController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;


        btnOpenActionListener = new BtnOpenActionListener(view);
        gestioneController = new GestioniPazientiController(view, model);
        addMonitoraggioController = new AddMonitoraggioController(model, view);
        view.getInfPanel().getMonitoraggioButton().addActionListener(btnOpenActionListener);




    }



}
