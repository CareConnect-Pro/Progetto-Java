package it.unipv.posw.careconnectpro.controller.utenti.medico;


import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnMonitoraggioActionListener;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;


public class MedController {
    private IRSA model;
    private ViewController view;
    private BtnMonitoraggioActionListener monitoraggioBtn;
    private MonitoraggioController monitoraggioController;
    private TerapiaController terapiaController;


    public MedController(IRSA model, ViewController view) {
        this.setModel(model);
        this.setView(view);

        monitoraggioBtn = new BtnMonitoraggioActionListener(view);
        view.getMedPanel().getOpenButton().addActionListener(monitoraggioBtn);
        setMonitoraggioController(new MonitoraggioController(model, view));
        setTerapiaController(new TerapiaController (model, view));


    }



	public IRSA getModel() {
		return model;
	}



	public void setModel(IRSA model) {
		this.model = model;
	}



	public ViewController getView() {
		return view;
	}



	public void setView(ViewController view) {
		this.view = view;
	}



	public MonitoraggioController getMonitoraggioController() {
		return monitoraggioController;
	}



	public void setMonitoraggioController(MonitoraggioController monitoraggioController) {
		this.monitoraggioController = monitoraggioController;
	}



	public TerapiaController getTerapiaController() {
		return terapiaController;
	}



	public void setTerapiaController(TerapiaController terapiaController) {
		this.terapiaController = terapiaController;
	}


}
