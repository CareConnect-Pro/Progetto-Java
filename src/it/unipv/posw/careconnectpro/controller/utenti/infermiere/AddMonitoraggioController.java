package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.StrategyAlert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.paramentroVitale.TipiParametroVitale;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.rsa.infermiere.ProxyInfermiere;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

public class AddMonitoraggioController {
    
    private ViewController view;
    private JTextField campoValore;

    public AddMonitoraggioController(ViewController view) {
        this.view = view;

        view.getMonitoraggioPanel().getConfermaButton().addActionListener(e -> addMonitoraggio());
        view.getMonitoraggioPanel().getBackButton().addActionListener(e -> backToListaPazienti());

        campoValore = view.getMonitoraggioPanel().getValoreFiel();
        documentListener();
    }


    private void backToListaPazienti() {
        view.getMonitoraggioPanel().setVisible(false);
        view.getGestionePazPanel().setVisible(true);
        pulisciText(); 
    }

    private void addMonitoraggio() {
        try {
            String idPaziente = view.getMonitoraggioPanel().getCfPazienteField().getText();
            String idInfermiere = view.getMonitoraggioPanel().getIdInfermiereField().getText();
            TipiParametroVitale parametroVitale = (TipiParametroVitale) view.getMonitoraggioPanel().getParamentriBox().getSelectedItem();
            String valore = view.getMonitoraggioPanel().getValoreFiel().getText();
            String dataStr = view.getMonitoraggioPanel().getDataFiel().getText();
            String note =  view.getMonitoraggioPanel().getNoteFiel().getText();

  
            if (valore == null || valore.trim().isEmpty()) {
                PopUp.infoBox("Inserire un valore valido prima di confermare.", "Dati Mancanti");
                return; 
            }
            if (dataStr == null || dataStr.trim().isEmpty()) {
                PopUp.infoBox("Inserire una data valida (formato YYYY-MM-DD).", "Dati Mancanti");
                return;
            }

            Alert statoAttuale = verificaIstantanea(parametroVitale, valore);
            if (statoAttuale == Alert.ATTIVO && (note == null || note.trim().isEmpty())) {
                PopUp.infoBox("Attenzione: Parametro anomalo rilevato! È obbligatorio inserire una nota clinica per il medico.", "Nota Obbligatoria");
                return; 
            }

            LocalDate data = Date.valueOf(dataStr).toLocalDate();

            Paziente p = ProxyInfermiere.getProxy().cercaPazienteByCf(idPaziente);
            Dipendente inf = ProxyInfermiere.getProxy().cercaDipendenteByCf(idInfermiere);
            CartellaClinica cc = ProxyInfermiere.getProxy().cercaCartellaClinicaByCf(idPaziente);

            Monitoraggio m = new Monitoraggio(cc, p, inf, parametroVitale, valore, data, note);

            int successo = ProxyInfermiere.getProxy().creaMonitoraggio(m);

            if(successo >= 0) {
                pulisciText();
                PopUp.infoBox("Monitoraggio aggiunto nel database.", "Successo");
            } else {
                PopUp.infoBox("Errore nell'aggiornamento del Database.", "Errore DB");
            }

        } catch (IllegalArgumentException ex) {
            PopUp.infoBox("Formato data errato. Usa il formato YYYY-MM-DD.", "Errore Data");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void pulisciText(){
        view.getMonitoraggioPanel().getValoreFiel().setText("");
        view.getMonitoraggioPanel().getNoteFiel().setText("");
        view.getMonitoraggioPanel().getAlertField().setText("");
    }

    public Alert verificaIstantanea(TipiParametroVitale tipo, String valore){
        if(valore == null || valore.trim().isEmpty()){
            view.getMonitoraggioPanel().getAlertField().setText("");
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
            public void changedUpdate(DocumentEvent e) { aggiornaStato(); }
            public void removeUpdate(DocumentEvent e) { aggiornaStato(); }
            public void insertUpdate(DocumentEvent e) { aggiornaStato(); }
        });
    }
}