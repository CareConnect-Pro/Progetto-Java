package it.unipv.posw.careconnectpro.controller.utenti.infermiere.button;


import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BtnOpenActionListener implements ActionListener {

    private ViewController view;
    private IRSA model;
 

    public BtnOpenActionListener(ViewController view, IRSA model) {
        this.view = view;
        this.setModel(model);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        updatePazienti();
        view.getGestionePazPanel().setVisible(true);

    }

    public void updatePazienti()	{
        List<Paziente> pazienti = model.cercaPazienti();        
        view.getGestionePazPanel().setTabellaPazienti(pazienti);
    }
	public IRSA getModel() {
		return model;
	}

	public void setModel(IRSA model) {
		this.model = model;
	}
}
