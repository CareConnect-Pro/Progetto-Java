package it.unipv.posw.careconnectpro.controller.utenti.medico;

import java.util.List;

import it.unipv.posw.careconnectpro.controller.utenti.medico.button.AlertActionListener;
import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnAddTerapiaActionListener;
import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnBackActionListener;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.model.rsa.ProxyRSA;
import it.unipv.posw.careconnectpro.view.ViewController;


public class MonitoraggioController {
    private ViewController view;
    private IRSA model;
    private BtnAddTerapiaActionListener terapiaBtn;
    private BtnBackActionListener backBtn;
    private AlertActionListener alert;


    public MonitoraggioController(IRSA model, ViewController view) {

        this.model = ProxyRSA.getProxy();
        this.setView(view);

        terapiaBtn = new BtnAddTerapiaActionListener(model,view);
        backBtn = new BtnBackActionListener(view);
        alert = new AlertActionListener(model, view);

        view.getListMonitoraggioPanel().getTerapiaButton().addActionListener(terapiaBtn);
        view.getListMonitoraggioPanel().getBackButton().addActionListener(backBtn);
        view.getListMonitoraggioPanel().getAlertButton().addActionListener(alert);
        
    }

    public void updateMonitoraggi()	{
        List<Monitoraggio> monitoraggi = model.getMonitoraggiConAlertAttivo();        
        view.getListMonitoraggioPanel().setTabellaMonitoraggi(monitoraggi);
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
