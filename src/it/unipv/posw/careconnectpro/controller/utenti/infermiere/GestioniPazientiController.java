package it.unipv.posw.careconnectpro.controller.utenti.infermiere;


import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnAddMonitoraggioAL;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnBackHomeInfAL;
import it.unipv.posw.careconnectpro.view.ViewController;

public class GestioniPazientiController {
    private ViewController view;
    private BtnBackHomeInfAL indietroButton;
    private BtnAddMonitoraggioAL addMonitoraggio;

    public GestioniPazientiController(ViewController view) {
        this.setView(view);
        

        indietroButton = new BtnBackHomeInfAL(view);
        addMonitoraggio = new BtnAddMonitoraggioAL(view);

        view.getGestionePazPanel().getInserisciButton().addActionListener(addMonitoraggio);
        view.getGestionePazPanel().getBackButton().addActionListener(indietroButton);

    }
    

	public ViewController getView() {
		return view;
	}

	public void setView(ViewController view) {
		this.view = view;
	}

}
