package it.unipv.posw.careconnectpro.controller.utenti.medico;

import it.unipv.posw.careconnectpro.controller.utenti.medico.button.BtnMonitoraggioActionListener;
import it.unipv.posw.careconnectpro.view.ViewController;
import it.unipv.posw.careconnectpro.model.rsa.medico.ProxyMedico;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;

import java.util.List;

public class MedController {
    
    private ViewController view;
    private BtnMonitoraggioActionListener monitoraggioBtn;
    private MonitoraggioController monitoraggioController;
    private TerapiaController terapiaController;

    public MedController(ViewController view) {
        this.setView(view);

        monitoraggioBtn = new BtnMonitoraggioActionListener(view);
        view.getMedPanel().getOpenButton().addActionListener(monitoraggioBtn);
        setMonitoraggioController(new MonitoraggioController(view));
        setTerapiaController(new TerapiaController(view));
        
        view.getMedPanel().getSomministrazioneButton().addActionListener(e -> {
            try {
            	
              List<Somministrazione> listaDaFare = ProxyMedico.getProxy().getSomministrazioniNonSomministrate();
               
                view.getListSomministrazionePanel().setListaSomministrazioni(listaDaFare);
                
                view.getMedPanel().setVisible(false);
                view.getListSomministrazionePanel().setVisible(true);
                
            } catch (Exception ex) {
                it.unipv.posw.careconnectpro.view.PopUp.infoBox("Errore nel caricamento delle somministrazioni.", "Errore DB");
                ex.printStackTrace();
            }
        });
    }

    public ViewController getView() {
        return view;
    }

    public void setView(ViewController view) {
        this.view = view;
    }

    public MonitoraggioController getMonitoraggioController() {
        return monitoraggioController;
    }

    public void setMonitoraggioController(MonitoraggioController monitoraggioController) {
        this.monitoraggioController = monitoraggioController;
    }

    public TerapiaController getTerapiaController() {
        return terapiaController;
    }

    public void setTerapiaController(TerapiaController terapiaController) {
        this.terapiaController = terapiaController;
    }
}