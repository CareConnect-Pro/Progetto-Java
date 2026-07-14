package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutActionListener implements ActionListener {
    private ViewController view;

    public LogoutActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestoreSessione.getIstanza().setUtenteLoggato(null);
        view.getAmmPanel().setVisible(false);
        view.getMedPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        view.getLoginPanel().setVisible(true);
    }
}