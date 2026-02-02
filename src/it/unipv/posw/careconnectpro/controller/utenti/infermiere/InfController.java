package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnOpenActionListener;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

public class InfController {

    private IRSA model;
    private ViewController view;

    private GestioniPazientiController gestioneController;
    private AddMonitoraggioController addMonitoraggioController;
    private BtnOpenActionListener btnOpenActionListener;


    public InfController(IRSA model, ViewController view) {
        this.setModel(model);
        this.setView(view);


        btnOpenActionListener = new BtnOpenActionListener(view);
        setGestioneController(new GestioniPazientiController(view, model));
        setAddMonitoraggioController(new AddMonitoraggioController(model, view));
        view.getInfPanel().getMonitoraggioButton().addActionListener(btnOpenActionListener);




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


	public GestioniPazientiController getGestioneController() {
		return gestioneController;
	}


	public void setGestioneController(GestioniPazientiController gestioneController) {
		this.gestioneController = gestioneController;
	}


	public AddMonitoraggioController getAddMonitoraggioController() {
		return addMonitoraggioController;
	}


	public void setAddMonitoraggioController(AddMonitoraggioController addMonitoraggioController) {
		this.addMonitoraggioController = addMonitoraggioController;
	}



}
