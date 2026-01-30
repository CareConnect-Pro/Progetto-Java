package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.controller.utenti.infermiere.button.BtnBackHomeInfAL;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.StrategyAlert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.paramentroVitale.TipiParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

public class AddMonitoraggioController {
    private IRSA model;
    private ViewController view;
    private BtnBackHomeInfAL  btnBackHomeInfAL;
    private JTextField campoValore;


    public AddMonitoraggioController(IRSA model, ViewController view) {
        this.model = model;
        this.view = view;

        btnBackHomeInfAL = new BtnBackHomeInfAL(view);

        view.getMonitoraggioPanel().getConfermaButton().addActionListener(e->addMonitoraggio());
        view.getMonitoraggioPanel().getBackButton().addActionListener(btnBackHomeInfAL);

        campoValore = view.getMonitoraggioPanel().getValoreFiel();
        documentListener();
    }


    private void addMonitoraggio() {

        try{
            String idPaziente = view.getMonitoraggioPanel().getCfPazienteField().getText();
            String idInfermiere = view.getMonitoraggioPanel().getIdInfermiereField().getText();
            TipiParametroVitale parametroVitale = (TipiParametroVitale) view.getMonitoraggioPanel().getParamentriBox().getSelectedItem();
            String valore = view.getMonitoraggioPanel().getValoreFiel().getText();
            LocalDate data = Date.valueOf(view.getMonitoraggioPanel().getDataFiel().getText()).toLocalDate();
            String note =  view.getMonitoraggioPanel().getNoteFiel().getText();

            Paziente p = model.cercaPazienteByCf(idPaziente);
            Dipendente inf = model.cercaDipendenteByCf(idInfermiere);
            CartellaClinica cc = model.cercaCartellaClinicaByCf(idPaziente);

            Monitoraggio m = new Monitoraggio(cc, p, inf,parametroVitale, valore, data, note);

            int successo = model.creaMonitoraggio(m);

            if(successo >=0) {
                pulisciText();
                PopUp.infoBox("Monitoraggio aggiunto nel database.", "Successo");
            } else {
            PopUp.infoBox("Errore nell'aggiornamento del Database.", "Errore DB");
        }

    } catch (Exception e){

        e.printStackTrace();
        }

    }


    private void pulisciText(){
        view.getMonitoraggioPanel().getIdCartellaField().setText(null);
        view.getMonitoraggioPanel().getCfPazienteField().setText(null);
        view.getMonitoraggioPanel().getIdInfermiereField().setText(null);
        view.getMonitoraggioPanel().getValoreFiel().setText(null);
        view.getMonitoraggioPanel().getDataFiel().setText(null);
        view.getMonitoraggioPanel().getNoteFiel().setText(null);
    }

    public Alert verificaIstantanea(TipiParametroVitale tipo, String valore){
        if(valore == null || valore.isEmpty()){
            view.getMonitoraggioPanel().getAlertField().setText(null);
            PopUp.infoBox("Valore non valido", "Errore");
            return null;
        }
        return StrategyAlert.controlla(tipo, valore);

    }
    private void aggiornaStato() {

        TipiParametroVitale tipo = (TipiParametroVitale) view.getMonitoraggioPanel().getParamentriBox().getSelectedItem();
        String valore = view.getMonitoraggioPanel().getValoreFiel().getText();
        Alert stato = verificaIstantanea(tipo, valore);


        if (stato != null) {
            view.getMonitoraggioPanel().getAlertField().setText(stato.name());


            if (stato == Alert.ATTIVO) {
                view.getMonitoraggioPanel().getAlertField().setForeground(Color.RED);
            } else {
                view.getMonitoraggioPanel().getAlertField().setForeground(Color.GREEN);
            }
        }
    }

    public void documentListener(){
        campoValore.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                aggiornaStato();
            }
            public void removeUpdate(DocumentEvent e) {
                aggiornaStato();
            }
            public void insertUpdate(DocumentEvent e) { aggiornaStato();}
        });
    }


}
