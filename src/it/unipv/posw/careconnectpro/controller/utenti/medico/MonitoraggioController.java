package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.controller.elementi.BtnBackHomeActionListerner;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.util.List;

public class MonitoraggioController {
    private ViewController view;
    private IRSA model = new RSAService();
    private List<Monitoraggio> monitoraggiList;
    private BtnAddTerapiaActionListener terapiaBtn;
    private BtnBackHomeActionListerner backBtn;
    private AlertActionListener alert;


    public MonitoraggioController(IRSA model, ViewController view) {

        this.model = model;
        this.view = view;

        terapiaBtn = new BtnAddTerapiaActionListener(view);
        backBtn = new BtnBackHomeActionListerner(view);
        alert = new AlertActionListener(model);

        view.getListMonitoraggioPanel().getTerapiaButton().addActionListener(terapiaBtn);
        view.getListMonitoraggioPanel().getBackButton().addActionListener(backBtn);
        view.getListMonitoraggioPanel().getAlertButton().addActionListener(alert);

    }


    public List<Monitoraggio> getMonitoraggiList() {
        return monitoraggiList = model.getMonitoraggiConAlertAttivo();
    }
}
