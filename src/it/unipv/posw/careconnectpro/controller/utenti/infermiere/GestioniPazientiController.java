package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnAddMonitoraggioAL;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnBackHomeInfAL;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnOpenActionListener;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

public class GestioniPazientiController {
    private ViewController view;
    private IRSA model;
    private BtnBackHomeInfAL indietroButton;
    private BtnAddMonitoraggioAL addMonitoraggio;

    public GestioniPazientiController(ViewController view, IRSA model) {
        this.view = view;
        this.model = model;


        indietroButton = new BtnBackHomeInfAL(view);
        addMonitoraggio = new BtnAddMonitoraggioAL(model, view);

        view.getGestionePazPanel().getInserisciButton().addActionListener(addMonitoraggio);
        view.getGestionePazPanel().getBackButton().addActionListener(indietroButton);




    }
}
