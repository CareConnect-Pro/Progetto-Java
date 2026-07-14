package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.controller.utenti.medico.button.AlertActionListener;
import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnAddTerapiaActionListener;
import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnBackActionListener;
import it.unipv.posw.careconnectpro.view.ViewController;

public class MonitoraggioController {
    
    private ViewController view;
    private BtnAddTerapiaActionListener terapiaBtn;
    private BtnBackActionListener backBtn;
    private AlertActionListener alert;

    public MonitoraggioController(ViewController view) {
        this.setView(view);

        terapiaBtn = new BtnAddTerapiaActionListener(view);
        backBtn = new BtnBackActionListener(view);
        alert = new AlertActionListener(view);

        view.getListMonitoraggioPanel().getTerapiaButton().addActionListener(terapiaBtn);
        view.getListMonitoraggioPanel().getBackButton().addActionListener(backBtn);
        view.getListMonitoraggioPanel().getAlertButton().addActionListener(alert);
    }

    public ViewController getView() {
        return view;
    }

    public void setView(ViewController view) {
        this.view = view;
    }
}