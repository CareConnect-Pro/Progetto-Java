package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.login.IRSALogin;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoBtnActionListener implements ActionListener {

	private ViewController view;
	private IRSALogin model;

	public GoBtnActionListener(ViewController view, IRSALogin model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cf = view.getLoginPanel().getCfField().getText();
		String password = String.valueOf(view.getLoginPanel().getPasswordField().getPassword());
		Dipendente utenteLoggato = model.login(cf, password);

		if (utenteLoggato == null) {
			PopUp.infoBox("Username e/o password non validi", "Login non valido");
			pulisciTextField();
			return;
		}

		TipoUtente ruolo = utenteLoggato.getTipoUtente();

		pulisciTextField();
		view.getLoginPanel().setVisible(false);

		switch (ruolo) {
		case AMMINISTRATORE:
			view.getAmmPanel().setVisible(true);
			break;
		case MEDICO:
			view.getMedPanel().setVisible(true);
			break;
		case INFERMIERE:
			view.getInfPanel().setVisible(true);
			break;
		case PAZIENTE:
			throw new RuntimeException("Non hai le autorizzazioni per accedere");
		default:
			break;
		}
	}

	private void pulisciTextField() {
		view.getLoginPanel().getCfField().setText(null);
		view.getLoginPanel().getPasswordField().setText(null);
	}

}
