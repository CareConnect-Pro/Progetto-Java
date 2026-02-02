package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnAddTerapiaActionListener;
import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnBackActionListener;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;


public class MonitoraggioController {
    private ViewController view;
    private IRSA model;
    private BtnAddTerapiaActionListener terapiaBtn;
    private BtnBackActionListener backBtn;
    private AlertActionListener alert;


    public MonitoraggioController(IRSA model, ViewController view) {

        this.setModel(model);
        this.setView(view);

        terapiaBtn = new BtnAddTerapiaActionListener(model,view);
        backBtn = new BtnBackActionListener(view);
        alert = new AlertActionListener(model, view);

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


	public IRSA getModel() {
		return model;
	}


	public void setModel(IRSA model) {
		this.model = model;
	}
}
