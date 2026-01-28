package it.unipv.posw.careconnectpro.controller.utenti.infermiere.button;

import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnOpenActionListener implements ActionListener {

    private ViewController view;

    public BtnOpenActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getInfPanel().setVisible(false);
        view.getGestionePazPanel().setVisible(true);

    }
}
