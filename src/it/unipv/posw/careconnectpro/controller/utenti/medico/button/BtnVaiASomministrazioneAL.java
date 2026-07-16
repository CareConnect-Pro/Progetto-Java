package it.unipv.posw.careconnectpro.controller.utenti.medico.button;

import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.view.dipendenti.medico.SomministrazioneTable;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;

import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BtnVaiASomministrazioneAL implements ActionListener {

    private ViewController view;

    public BtnVaiASomministrazioneAL(ViewController view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JTable tabella = view.getListSomministrazionePanel().getSomministrazioneList();
            int riga = tabella.getSelectedRow();

            if (riga != -1) {
                SomministrazioneTable model = (SomministrazioneTable) tabella.getModel();
                Somministrazione s = model.getSomministrazione(riga);
                
                String idOperatore = GestoreSessione.getIstanza().getUtenteLoggato().getCodiceFiscale();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String dataOraAttuale = LocalDateTime.now().format(formatter);

                view.getSomministrazionePanel().getIdSommField().setText(String.valueOf(s.getSomministrazione()));
                view.getSomministrazionePanel().getIdTerapiaField().setText(String.valueOf(s.getTerapia()));
                view.getSomministrazionePanel().getIdPazienteField().setText(s.getPaziente());
                view.getSomministrazionePanel().getIdOperatoreField().setText(idOperatore);
                view.getSomministrazionePanel().getDataField().setText(dataOraAttuale); 
                view.getSomministrazionePanel().getNoteField().setText("");

                view.getListSomministrazionePanel().setVisible(false);
                view.getSomministrazionePanel().setVisible(true);

            } else {
                PopUp.infoBox("Seleziona una somministrazione dalla tabella prima di procedere!", "Nessuna Selezione");
            }
        } catch (Exception ex) {
            PopUp.infoBox("Errore imprevisto nel caricamento dei dati.", "Errore");
            ex.printStackTrace();
        }
    }
}