package it.unipv.posw.careconnectpro.controller.utenti.infermiere.button;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.GestioniPazientiController;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnOpenActionListener implements ActionListener {

    private ViewController view;
    private IRSA model;
    private GestioniPazientiController gpc;

    public BtnOpenActionListener(ViewController view, IRSA model) {
        this.view = view;
        this.setModel(model);
        this.gpc = new GestioniPazientiController (view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        gpc.updatePazienti();
        view.getGestionePazPanel().setVisible(true);

    }

	public IRSA getModel() {
		return model;
	}

	public void setModel(IRSA model) {
		this.model = model;
	}
}
