package it.unipv.posw.careconnectpro.controller.login;

import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.RSAService;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoBtnActionListener implements ActionListener {

    private ViewController view;
    private RSAService model;

    public GoBtnActionListener(ViewController view, RSAService model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cf = view.getLoginPanel().getCfField().getText();
        String password = String.valueOf(view.getLoginPanel().getPasswordField().getPassword());;

        Dipendente utenteLoggato = model.getDipendenteByCf(cf);
        TipoUtente ruolo = utenteLoggato.getTipoUtente();
        pulisciTextField();
        view.getLoginPanel().setVisible(false);
        model.setUtenteLoggato(utenteLoggato);

//        if(utenteLoggato != null) {
            switch (ruolo) {
                case AMMINISTRATORE:
                    view.getLoginPanel().setVisible(false);
                    view.getAmmPanel().setVisible(true);
                    break;
                case PAZIENTE:
                    break;
                case MEDICO:
                    break;


                case INFERMIERE:
                    break;
                default:
                    break;
            }
        }
//        else {
//            PopUp.infoBox("Username o password incorretti", "Errore");
//        }

    private void pulisciTextField(){
        view.getLoginPanel().getCfField().setText(null);
        view.getLoginPanel().getPasswordField().setText(null);
    }




    }

//}
