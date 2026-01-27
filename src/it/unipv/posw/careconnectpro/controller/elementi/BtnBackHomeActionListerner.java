package it.unipv.posw.careconnectpro.controller.elementi;

import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnBackHomeActionListerner implements ActionListener {
    private ViewController view;

    public BtnBackHomeActionListerner(ViewController view) {
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
