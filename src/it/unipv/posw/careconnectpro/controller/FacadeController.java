package it.unipv.posw.careconnectpro.controller;

import it.unipv.posw.careconnectpro.controller.login.LoginController;
import it.unipv.posw.careconnectpro.controller.utenti.amministratore.AmmController;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.InfController;
import it.unipv.posw.careconnectpro.controller.utenti.medico.MedController;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

public class FacadeController {

    private LoginController loginController;
    private AmmController ammController;
    private MedController medController;
    private RSAService model;
    private ViewController view;
    private InfController infController;

    public FacadeController(RSAService model, ViewController view) {

        setLoginController(new LoginController(model, view));
        setAmmController(new AmmController(model, view));
        setMedController(new MedController(model, view));
        setInfController(new InfController(model, view));

    }

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public AmmController getAmmController() {
		return ammController;
	}

	public void setAmmController(AmmController ammController) {
		this.ammController = ammController;
	}

	public MedController getMedController() {
		return medController;
	}

	public void setMedController(MedController medController) {
		this.medController = medController;
	}

	public RSAService getModel() {
		return model;
	}

	public void setModel(RSAService model) {
		this.model = model;
	}

	public ViewController getView() {
		return view;
	}

	public void setView(ViewController view) {
		this.view = view;
	}

	public InfController getInfController() {
		return infController;
	}

	public void setInfController(InfController infController) {
		this.infController = infController;
	}


}
