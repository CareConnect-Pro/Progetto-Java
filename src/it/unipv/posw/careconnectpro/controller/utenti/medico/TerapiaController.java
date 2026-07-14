package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.StatoTerapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.TipoSomministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;

import javax.swing.JTable;
import java.sql.Date;
import java.time.LocalDate;

public class TerapiaController {
    
    private ViewController view;
    private boolean successo = false;

    public TerapiaController(ViewController view){
        this.view = view;
        
        view.getTerapiaPanel().getAddTerapiaButton().addActionListener(e-> addTerapia());
        view.getTerapiaPanel().getBackButton().addActionListener(e-> backToListaAlert());
    }

    private void backToListaAlert() {
        view.getTerapiaPanel().setVisible(false);
        view.getListMonitoraggioPanel().setVisible(true);
        pulisciTextField(); 
    }

    private void addTerapia(){
        try{
            String idPaziente = view.getTerapiaPanel().getIdPazienteField().getText();
            String idMedico =  view.getTerapiaPanel().getIdMedicoField().getText();
            String idMonitoraggioStr = view.getTerapiaPanel().getIdMonitoraggioField().getText();
            TipoSomministrazione somministrazione = (TipoSomministrazione) view.getTerapiaPanel().getSomministrazioneBox().getSelectedItem();
            String farmaco = view.getTerapiaPanel().getFarmacoField().getText();
            String materiale = view.getTerapiaPanel().getMaterialeField().getText();
            String dosaggio = view.getTerapiaPanel().getDosaggioField().getText();
            String freqStr = view.getTerapiaPanel().getFrequenzaField().getText();
            StatoTerapia stato = (StatoTerapia) view.getTerapiaPanel().getStatoBox().getSelectedItem();
            String durataStr = view.getTerapiaPanel().getDurataField().getText();
            String dataInizioStr = view.getTerapiaPanel().getDataInizioField().getText();
            String dataFineStr = view.getTerapiaPanel().getDataFineField().getText();
            String note = view.getTerapiaPanel().getNoteField().getText();
            
            
            if(farmaco.trim().isEmpty() || freqStr.trim().isEmpty() || durataStr.trim().isEmpty() || dataInizioStr.trim().isEmpty() || dataFineStr.trim().isEmpty()) {
                PopUp.infoBox("Compila tutti i campi obbligatori prima di confermare.", "Dati Mancanti");
                return;
            }

            int idMonitoraggio = Integer.parseInt(idMonitoraggioStr);
            int freq  = Integer.parseInt(freqStr);
            int durata = Integer.parseInt(durataStr);
            LocalDate dataInizio = Date.valueOf(dataInizioStr).toLocalDate();
            LocalDate dataFine = Date.valueOf(dataFineStr).toLocalDate();
            
            Paziente p = ProxyMedico.getProxy().cercaPazienteByCf(idPaziente);
            Dipendente med = ProxyMedico.getProxy().cercaDipendenteByCf(idMedico);
            CartellaClinica cc = ProxyMedico.getProxy().cercaCartellaClinicaByCf(idPaziente);
            
            Terapia t = new Terapia(cc, p, med, somministrazione, farmaco, materiale, dosaggio,
                                    freq, stato, durata, dataInizio, dataFine, note);

            ProxyMedico.getProxy().creaTerapia(t);
            Monitoraggio m = ProxyMedico.getProxy().cercaMonitoraggioById(idMonitoraggio);

            successo = ProxyMedico.getProxy().risolviAlertMonitoraggio(m);
            
            JTable tabella = view.getListMonitoraggioPanel().getMonitoraggiList();
            int riga = tabella.getSelectedRow();

            if(successo){
                if (riga != -1) {
                    view.getListMonitoraggioPanel().getMonitoraggiTable().rimuoviMonitoraggio(riga);
                }
                PopUp.infoBox("Terapia aggiunta nel database e Monitoraggio risolto.", "Successo");
                backToListaAlert();

            } else {
                PopUp.infoBox("Errore nell'aggiornamento del Database.", "Errore DB");
            }

        } catch (NumberFormatException numEx) {
            PopUp.infoBox("Inserisci solo numeri validi nei campi 'Frequenza' e 'Durata'.", "Errore Numerico");
        } catch (IllegalArgumentException dateEx) {
            PopUp.infoBox("Formato data errato. Usa il formato YYYY-MM-DD.", "Errore Data");
        } catch (Exception e){
            PopUp.infoBox("Si è verificato un errore durante il salvataggio. Controlla i dati.", "Errore Generale");
            e.printStackTrace();
        }
    }

    private void pulisciTextField(){
        view.getTerapiaPanel().getIdCartellaField().setText(null);
        view.getTerapiaPanel().getIdPazienteField().setText(null);
        view.getTerapiaPanel().getIdMedicoField().setText(null);
        view.getTerapiaPanel().getIdMonitoraggioField().setText(null);
        view.getTerapiaPanel().getFarmacoField().setText(null);
        view.getTerapiaPanel().getMaterialeField().setText(null);
        view.getTerapiaPanel().getDosaggioField().setText(null);
        view.getTerapiaPanel().getFrequenzaField().setText(null);
        view.getTerapiaPanel().getDurataField().setText(null);
        view.getTerapiaPanel().getDataInizioField().setText(null);
        view.getTerapiaPanel().getDataFineField().setText(null);
        view.getTerapiaPanel().getNoteField().setText(null);
    }

    public boolean isSuccesso() {
        return successo;
    }
}