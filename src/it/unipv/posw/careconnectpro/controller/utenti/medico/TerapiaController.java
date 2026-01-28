package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnAddTerapiaActionListener;

import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnIndietroTerapiaAL;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.StatoTerapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.Terapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.TipoSomministrazione;
import it.unipv.posw.careconnectpro.model.persona.Paziente;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.model.persona.dipendente.Dipendente;
import it.unipv.posw.careconnectpro.model.cartellaclinica.CartellaClinica;

import java.sql.Date;
import java.time.LocalDate;

public class TerapiaController {
    private IRSA model;
    private ViewController view;
    private BtnIndietroTerapiaAL indietroTerapia;

    private boolean successo = false;
    private BtnAddTerapiaActionListener terapiaAL = new BtnAddTerapiaActionListener(model, view);

    public TerapiaController(IRSA model, ViewController view){
        this.model = model;
        this.view = view;

        indietroTerapia = new BtnIndietroTerapiaAL(view);


        view.getTerapiaPanel().getAddTerapiaButton().addActionListener(e-> addTerapia());
        view.getTerapiaPanel().getBackButton().addActionListener(indietroTerapia);


    }

    private void addTerapia(){
        try{
            String idCartella = view.getTerapiaPanel().getIdCartellaField().getText();
            String idPaziente = view.getTerapiaPanel().getIdPazienteField().getText();
            String idMedico =  view.getTerapiaPanel().getIdMedicoField().getText();
            int idMonitoraggio = Integer.parseInt(view.getTerapiaPanel().getIdMonitoraggioField().getText());
            TipoSomministrazione somministrazione = (TipoSomministrazione) view.getTerapiaPanel().getSomministrazioneBox().getSelectedItem();
            String farmaco = view.getTerapiaPanel().getFarmacoField().getText();
            String materiale = view.getTerapiaPanel().getMaterialeField().getText();
            String dosaggio = view.getTerapiaPanel().getDosaggioField().getText();
            int freq  = Integer.parseInt( view.getTerapiaPanel().getFrequenzaField().getText());
            StatoTerapia stato = (StatoTerapia) view.getTerapiaPanel().getStatoBox().getSelectedItem();
            int durata = Integer.parseInt(view.getTerapiaPanel().getDurataField().getText());
            LocalDate dataInizio = Date.valueOf(view.getTerapiaPanel().getDataInizioField().getText()).toLocalDate();
            LocalDate dataFine = Date.valueOf(view.getTerapiaPanel().getDataFineField().getText()).toLocalDate();
            String note = view.getTerapiaPanel().getNoteField().getText();
            Paziente p = model.cercaPazienteByCf(idPaziente);
            Dipendente med = model.cercaDipendenteByCf(idMedico);
            CartellaClinica cc = model.cercaCartellaClinicaByCf(idPaziente);
            Terapia t = new Terapia(cc, p, med, somministrazione, farmaco, materiale, dosaggio,
                                    freq, stato, durata,dataInizio, dataFine, note);

            model.creaTerapia(t);
            Monitoraggio m = model.cercaMonitoraggioById(idMonitoraggio);

            successo = model.risolviAlertMonitoraggio(m);
            int riga = terapiaAL.getRigaSelezionata();

            if(successo){
                pulisciTextField();
                view.getListMonitoraggioPanel().getMonitoraggiTable().rimuoviMonitoraggio(riga);
                PopUp.infoBox("Terapia aggiunta nel database.", "Successo");
            } else {
                PopUp.infoBox("Errore nell'aggiornamento del Database.", "Errore DB");
            }

        } catch (Exception e){
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
