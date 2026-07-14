package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.StatoSomministrazione;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;
import it.unipv.posw.careconnectpro.model.rsa.infermiere.ProxyInfermiere;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

import java.time.LocalDate;
import java.time.LocalTime;

public class SomministrazioneController {

    private ViewController view;

    public SomministrazioneController(ViewController view) {
        this.view = view;
        view.getSomministrazionePanel().getConfermaButton().addActionListener(e -> confermaSomministrazione());
        view.getSomministrazionePanel().getBackButton().addActionListener(e -> backToLista());
    }

    private void backToLista() {
        view.getSomministrazionePanel().setVisible(false);
        TipoUtente ruolo = GestoreSessione.getIstanza().getUtenteLoggato().getTipoUtente();

        if (ruolo == TipoUtente.INFERMIERE) {
            view.getListTerapiePanel().setVisible(true);
        } else {
            view.getListSomministrazionePanel().setVisible(true);
        }
    }

    private void confermaSomministrazione() {
        try {
            int idSomm = Integer.parseInt(view.getSomministrazionePanel().getIdSommField().getText());
            int idTerapia = Integer.parseInt(view.getSomministrazionePanel().getIdTerapiaField().getText());
            String idPaziente = view.getSomministrazionePanel().getIdPazienteField().getText();
            String idOperatore = view.getSomministrazionePanel().getIdOperatoreField().getText();
            String dataOraStr = view.getSomministrazionePanel().getDataField().getText();
            StatoSomministrazione stato = (StatoSomministrazione) view.getSomministrazionePanel().getStatoBox().getSelectedItem();
            String note = view.getSomministrazionePanel().getNoteField().getText();

            if (note == null || note.trim().isEmpty()) {
                PopUp.infoBox("È obbligatorio inserire una nota clinica per confermare la somministrazione.", "Nota Obbligatoria");
                return;
            }

            String[] parti = dataOraStr.split(" ");
            LocalDate data = LocalDate.parse(parti[0]);
            LocalTime ora = LocalTime.parse(parti[1]);

            Somministrazione s = new Somministrazione(idTerapia, idPaziente, idOperatore, data, ora, stato, note);
            s.setSomministrazione(idSomm);

            TipoUtente ruolo = GestoreSessione.getIstanza().getUtenteLoggato().getTipoUtente();
            boolean successo = false;

            if (ruolo == TipoUtente.MEDICO) {
                successo = ProxyMedico.getProxy().confermaSomministrazione(s);
            } else if (ruolo == TipoUtente.INFERMIERE) {
                successo = ProxyInfermiere.getProxy().confermaSomministrazione(s);
            }

            if (successo) {
                PopUp.infoBox("Somministrazione confermata e registrata con successo.", "Operazione Completata");
                backToLista();
            } else {
                PopUp.infoBox("Errore durante l'aggiornamento del database.", "Errore DB");
            }

        } catch (Exception e) {
            PopUp.infoBox("Controllare i campi inseriti.", "Errore");
        }
    }
}