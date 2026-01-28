package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.controller.FacadeController;
import it.unipv.posw.careconnectpro.controller.utenti.medico.TerapiaController;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class BtnConfermaTerapiaAL implements ActionListener {

    private ViewController view;
    private IRSA model;

    private TerapiaController  terapia;
    private boolean check;

    public BtnConfermaTerapiaAL(ViewController view) {
        this.view = view;
    }



    @Override
    public void actionPerformed(ActionEvent e){

        check = terapia.isSuccesso();

        if(check){

            System.out.println("Eliminato tutto");
        } else {
            System.out.println("Non eliminato");
            PopUp.infoBox("Prima di confermare aggiungere terapia", "Errore conferma terapia");
        }


    }




}
