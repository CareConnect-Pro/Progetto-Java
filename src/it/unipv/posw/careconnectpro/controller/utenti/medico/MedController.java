package it.unipv.posw.careconnectpro.controller.utenti.medico;


import it.unipv.posw.careconnectpro.controller.utenti.medico.btn.BtnMonitoraggioActionListener;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.util.List;

public class MedController {
    private IRSA model;
    private ViewController view;
    private BtnMonitoraggioActionListener monitoraggioBtn;
    private MonitoraggioController monitoraggioController;
    private TerapiaController terapiaController;
    private List<Monitoraggio> monitoraggiList;



    public MedController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        monitoraggioBtn = new BtnMonitoraggioActionListener(view);
        view.getMedPanel().getOpenButton().addActionListener(monitoraggioBtn);
        monitoraggioController = new MonitoraggioController(model, view);
        terapiaController = new TerapiaController (model, view);


    }


}
