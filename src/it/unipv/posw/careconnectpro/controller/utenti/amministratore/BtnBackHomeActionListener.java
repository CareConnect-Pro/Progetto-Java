package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnBackHomeActionListener implements ActionListener {
    private ViewController view;

    public BtnBackHomeActionListener(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.getLoginPanel().setVisible(false);
        view.getAmmPanel().setVisible(true);
        view.getRegUtentePanel().setVisible(false);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
