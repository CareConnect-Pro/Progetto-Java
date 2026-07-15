package it.unipv.posw.careconnectpro.controller.utenti.medico;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import it.unipv.posw.careconnectpro.controller.utenti.personale_sanitario.button.BtnVaiASomministrazioneAL;
import it.unipv.posw.careconnectpro.model.persona.TipoUtente;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico; // <-- IMPORT AGGIUNTO
import it.unipv.posw.careconnectpro.view.ViewController;

public class ListSomministrazioneController {

    private ViewController view;

    public ListSomministrazioneController(ViewController view) {
        this.view = view;
        
        view.getListSomministrazionePanel().getGestisciButton().addActionListener(new BtnVaiASomministrazioneAL(view));
        view.getListSomministrazionePanel().getBackButton().addActionListener(e -> tornaAlMenu());
        view.getListSomministrazionePanel().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                aggiornaTabellaMedico();
            }
        });
    }

    private void aggiornaTabellaMedico() {
        TipoUtente ruolo = GestoreSessione.getIstanza().getUtenteLoggato().getTipoUtente();
        if (ruolo == TipoUtente.MEDICO) {
            view.getListSomministrazionePanel().setListaSomministrazioni(
                ProxyMedico.getProxy().getSomministrazioniNonSomministrate()
            );
        }
    }

    private void tornaAlMenu() {
        view.getListSomministrazionePanel().setVisible(false);
        view.getMedPanel().setVisible(true);
    }
}