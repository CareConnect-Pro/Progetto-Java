package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutActionListener implements ActionListener {
    private IRSA model;
    private ViewController view;

    public LogoutActionListener(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setUtenteLoggato(null);
        view.getAmmPanel().setVisible(false);
        view.getMedPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        view.getLoginPanel().setVisible(true);


    }
}
