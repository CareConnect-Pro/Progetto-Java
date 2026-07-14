package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnOpenActionListener;
import it.unipv.posw.careconnectpro.view.ViewController;

public class InfController {

    private ViewController view;

    private GestioniPazientiController gestioneController;
    private AddMonitoraggioController addMonitoraggioController;
    private TerapieInfermiereController terapieController; 
    
    private BtnOpenActionListener btnOpenActionListener;

    public InfController(ViewController view) {
        this.setView(view);

        btnOpenActionListener = new BtnOpenActionListener(view);
        setGestioneController(new GestioniPazientiController(view));
        setAddMonitoraggioController(new AddMonitoraggioController(view));
        setTerapieController(new TerapieInfermiereController(view)); 
        
        view.getInfPanel().getGestionePazientiButton().addActionListener(btnOpenActionListener);
    }

	public ViewController getView() { return view; }
	public void setView(ViewController view) { this.view = view; }

	public GestioniPazientiController getGestioneController() { return gestioneController; }
	public void setGestioneController(GestioniPazientiController gestioneController) { this.gestioneController = gestioneController; }

	public AddMonitoraggioController getAddMonitoraggioController() { return addMonitoraggioController; }
	public void setAddMonitoraggioController(AddMonitoraggioController addMonitoraggioController) { this.addMonitoraggioController = addMonitoraggioController; }

	public TerapieInfermiereController getTerapieController() { return terapieController; } 
	public void setTerapieController(TerapieInfermiereController terapieController) { this.terapieController = terapieController; } 
}