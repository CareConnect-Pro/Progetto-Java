package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.controller.utenti.medico.BtnBackActionListener;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.util.List;

public class MonitoraggioController {
    private ViewController view;
    private IRSA model;
    private List<Monitoraggio> monitoraggiList;
    private BtnAddTerapiaActionListener terapiaBtn;
    private BtnBackActionListener backBtn;
    private AlertActionListener alert;


    public MonitoraggioController(IRSA model, ViewController view) {

        this.model = model;
        this.view = view;

        terapiaBtn = new BtnAddTerapiaActionListener(model,view);
        backBtn = new BtnBackActionListener(view);
        alert = new AlertActionListener(model, view);

        view.getListMonitoraggioPanel().getTerapiaButton().addActionListener(terapiaBtn);
        view.getListMonitoraggioPanel().getBackButton().addActionListener(backBtn);
        view.getListMonitoraggioPanel().getAlertButton().addActionListener(alert);

    }


    public List<Monitoraggio> getMonitoraggiList() {
        return monitoraggiList = model.getMonitoraggiConAlertAttivo();
    }
}
