package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.view.ViewController;

public class AmmController {

    private ViewController view;
    private BtnRegistraUtenteActionListener btnRegistrazione;
    private RegistrazioneController regController;
    private DisattivaUtenteActionListener eliminaUtente;


    public AmmController(ViewController view) {
        this.setView(view);

        btnRegistrazione = new BtnRegistraUtenteActionListener(view);
        eliminaUtente = new DisattivaUtenteActionListener();

        view.getAmmPanel().getRegistraButton().addActionListener(btnRegistrazione);
        view.getAmmPanel().getEliminaButton().addActionListener(eliminaUtente);
        setRegController(new RegistrazioneController(view));


    }



	public ViewController getView() {
		return view;
	}


	public void setView(ViewController view) {
		this.view = view;
	}


	public RegistrazioneController getRegController() {
		return regController;
	}


	public void setRegController(RegistrazioneController regController) {
		this.regController = regController;
	}

}
