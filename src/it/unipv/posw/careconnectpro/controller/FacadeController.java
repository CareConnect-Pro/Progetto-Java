package it.unipv.posw.careconnectpro.controller;

import it.unipv.posw.careconnectpro.controller.login.LoginController;
import it.unipv.posw.careconnectpro.controller.utenti.amministratore.AmmController;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.InfController;
import it.unipv.posw.careconnectpro.controller.utenti.medico.MedController;
import it.unipv.posw.careconnectpro.model.rsa.login.IRSALogin;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.ListSomministrazioneController;
import it.unipv.posw.careconnectpro.controller.utenti.infermiere.SomministrazioneController;

public class FacadeController {

    private LoginController loginController;
    private AmmController ammController;
    private MedController medController;
    private IRSALogin model;
    private ViewController view;
    private InfController infController;
    private ListSomministrazioneController listSomministrazioneController;
    private SomministrazioneController somministrazioneController;

    public FacadeController(IRSALogin model, ViewController view) {
        this.model = model;
        this.view = view;

        setLoginController(new LoginController(model, view));
        setAmmController(new AmmController(view));
        setMedController(new MedController(view));
        setInfController(new InfController(view));
       
        setListSomministrazioneController(new ListSomministrazioneController(view));
        setSomministrazioneController(new SomministrazioneController(view));
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

	public IRSALogin getModel() {
        return model;
    }

	public void setModel(IRSALogin model) {
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

	public ListSomministrazioneController getListSomministrazioneController() {
        return listSomministrazioneController;
    }

    public void setListSomministrazioneController(ListSomministrazioneController listSomministrazioneController) {
        this.listSomministrazioneController = listSomministrazioneController;
    }

    public SomministrazioneController getSomministrazioneController() {
        return somministrazioneController;
    }

    public void setSomministrazioneController(SomministrazioneController somministrazioneController) {
        this.somministrazioneController = somministrazioneController;
    }

}
