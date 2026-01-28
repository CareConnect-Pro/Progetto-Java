package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnIndietroTerapiaAL implements ActionListener {
    private ViewController view;
    public BtnIndietroTerapiaAL(ViewController view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getMedPanel().setVisible(true);
        view.getTerapiaPanel().setVisible(false);


    }
}
