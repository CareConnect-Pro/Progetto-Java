package it.unipv.posw.careconnectpro.controller.utenti.amministratore;

import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.Persona;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.FactoryDipendente;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.time.LocalDate;


public class RegistrazioneController {
    private ViewController view;
    private IRSA model;;
    private BtnBackHomeActionListener btnBack;

    public RegistrazioneController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        btnBack = new BtnBackHomeActionListener(view);
        addRegistrazioneActionListener();

        view.getRegUtentePanel().getConfermaButton().addActionListener(e -> registrazioneUtente());
        view.getRegUtentePanel().getUscitaButton().addActionListener(btnBack);
    }

    private void addRegistrazioneActionListener(){
        BtnRegistraUtenteActionListener button = new BtnRegistraUtenteActionListener(view);
        view.getAmmPanel().getRegistraButton().addActionListener(button);
    }

    private void registrazioneUtente(){
        try {
            String cf = view.getRegUtentePanel().getCfField().getText();
            String nome = view.getRegUtentePanel().getNomeField().getText();
            String cognome = view.getRegUtentePanel().getCognomeField().getText();
            String dataNascita = view.getRegUtentePanel().getDataNascitaField().getText();
            String email = view.getRegUtentePanel().getEmailField().getText();
            String cell = view.getRegUtentePanel().getCellulareField().getText();
            String pw = view.getRegUtentePanel().getPasswordField().getText();
            TipoUtente tipo = (TipoUtente) view.getRegUtentePanel().getTipoUtenteComboBox().getSelectedItem();

            Persona utente;

            if (tipo == TipoUtente.PAZIENTE){
                utente = new Paziente(cf, nome, cognome, LocalDate.parse(dataNascita),email, cell, LocalDate.now());
            } else{
                utente = FactoryDipendente.getDipendente(tipo.name(), cf,nome, cognome, LocalDate.parse(dataNascita),
                        email, cell, pw, LocalDate.now());
            }

            if(model.registraUtente(utente)){
            	pulisciTextField();
                PopUp.infoBox("Utente registrato con successo", "Risultato");
                backToMenu();
            } else {
                PopUp.infoBox("Utente non registrato", "Risultato");
            }

        } catch(Exception ex){
            PopUp.infoBox("Dati non validi " + ex , "Risultato");
        }
    }

    private void backToMenu(){
        view.getRegUtentePanel().setVisible(false);
        view.getAmmPanel().setVisible(true);
    }
    
    private void pulisciTextField() {
        view.getRegUtentePanel().getCfField().setText(null);
        view.getRegUtentePanel().getNomeField().setText(null);
        view.getRegUtentePanel().getCognomeField().setText(null);
        view.getRegUtentePanel().getDataNascitaField().setText(null);
        view.getRegUtentePanel().getEmailField().setText(null);
        view.getRegUtentePanel().getCellulareField().setText(null);
        view.getRegUtentePanel().getPasswordField().setText(null);
        view.getRegUtentePanel().getTipoUtenteComboBox().setSelectedItem(null);
    }
    

}
