package it.unipv.posw.careconnectpro.controller.utenti.infermiere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.StatoSomministrazione;
import it.unipv.posw.careconnectpro.model.rsa.GestoreSessione;
import it.unipv.posw.careconnectpro.model.rsa.infermiere.ProxyInfermiere;
import it.unipv.posw.careconnectpro.view.PopUp;
import it.unipv.posw.careconnectpro.view.ViewController;

public class TerapieOdierneController {

    private ViewController view;

    public TerapieOdierneController(ViewController view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        view.getInfPanel().getTerapieOdierneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getInfPanel().setVisible(false);          
                view.getListTerapieOdiernePanel().setVisible(true);  
            }
        });

        view.getListTerapieOdiernePanel().getIndietroBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getListTerapieOdiernePanel().setVisible(false); 
                view.getInfPanel().setVisible(true);          
            }
        });

        view.getListTerapieOdiernePanel().getInserisciSomministrazioneBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestisciInserimentoSomministrazione();
            }
        });

        view.getListTerapieOdiernePanel().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                caricaTerapieOggi();
            }
        });
    }

    private void caricaTerapieOggi() {
        List<TerapiaDB> terapieAttive = ProxyInfermiere.getProxy().getTerapieAttiveOggi();
        List<Somministrazione> tutteLeSomministrazioniDB = ProxyInfermiere.getProxy().getSomministrazioni();
        
        List<Somministrazione> listaScomposta = new ArrayList<>();

        if (terapieAttive != null) {
            for (TerapiaDB tDb : terapieAttive) {
                int freq = tDb.getFrequenzaGiornaliera();
                LocalTime[] orariPrevisti;
                
                // ASSEGNAZIONE DEGLI SLOT ORARI 
                if (freq == 1) {
                    orariPrevisti = new LocalTime[]{LocalTime.of(9, 0)};
                } else if (freq == 2) {
                    orariPrevisti = new LocalTime[]{LocalTime.of(9, 0), LocalTime.of(21, 0)};
                } else if (freq == 3) {
                    orariPrevisti = new LocalTime[]{LocalTime.of(9, 0), LocalTime.of(15, 0), LocalTime.of(21, 0)};
                } else if (freq == 4) {
                    orariPrevisti = new LocalTime[]{LocalTime.of(8, 0), LocalTime.of(12, 0), LocalTime.of(16, 0), LocalTime.of(20, 0)};
                } else {
                    orariPrevisti = new LocalTime[freq]; 
                    int oreDiIntervallo = 24 / freq; 
                    
                    for (int i = 0; i < freq; i++) {
                        int oraCalcolata = (8 + (i * oreDiIntervallo)) % 24; 
                        orariPrevisti[i] = LocalTime.of(oraCalcolata, 0);
                    }
                }

                List<Somministrazione> eseguiteOggi = new ArrayList<>();
                if (tutteLeSomministrazioniDB != null) {
                    for (Somministrazione sDB : tutteLeSomministrazioniDB) {
                        if (sDB.getTerapia() == tDb.getIdTerapia() && sDB.getData().equals(LocalDate.now())) {
                            eseguiteOggi.add(sDB);
                        }
                    }
                }
                
                eseguiteOggi.sort((s1, s2) -> s1.getOra().compareTo(s2.getOra()));
                int indiceEseguite = 0; 

                for (LocalTime orario : orariPrevisti) {
                    Somministrazione giaEseguita = null;
                    
                    if (indiceEseguite < eseguiteOggi.size()) {
                        giaEseguita = eseguiteOggi.get(indiceEseguite);
                        indiceEseguite++;
                    }

                    if (giaEseguita != null) {
                        giaEseguita.setOra(orario); 
                        listaScomposta.add(giaEseguita);
                    } else {
                        LocalTime adesso = LocalTime.now();
                        StatoSomministrazione statoCalcolato;

      
                        if (orario.isBefore(adesso.minusHours(1))) {
                            statoCalcolato = StatoSomministrazione.NON_SOMMINISTRATA; 
                        } else {
                            statoCalcolato = StatoSomministrazione.DA_SOMMINISTRARE; 
                        }

                        Somministrazione sVirtuale = new Somministrazione(
                            tDb.getIdTerapia(),                     
                            tDb.getIdPaziente(),                    
                            "",                                     
                            LocalDate.now(),                        
                            orario,                                 
                            statoCalcolato,
                            "" 
                        );
                        
                        sVirtuale.setSomministrazione(0); 
                        listaScomposta.add(sVirtuale);
                    }
                }
            }
        }

        view.getListTerapieOdiernePanel().getModelloTabella().setDati(listaScomposta, terapieAttive);
    }

    private void gestisciInserimentoSomministrazione() {
        JTable tabella = view.getListTerapieOdiernePanel().getTerapieTable();
        int rigaSelezionata = tabella.getSelectedRow();

        if (rigaSelezionata == -1) {
            PopUp.infoBox("Seleziona una terapia dalla tabella prima di procedere!", "Nessuna Selezione");
            return;
        }

        try {
            Somministrazione s = view.getListTerapieOdiernePanel().getModelloTabella().getSomministrazioneSelezionata(rigaSelezionata);
            String idOperatore = GestoreSessione.getIstanza().getUtenteLoggato().getCodiceFiscale();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String dataOraAttuale = LocalDateTime.now().format(formatter);

            view.getSomministrazionePanel().getIdSommField().setText(String.valueOf(s.getSomministrazione()));
            view.getSomministrazionePanel().getIdTerapiaField().setText(String.valueOf(s.getTerapia()));
            view.getSomministrazionePanel().getIdPazienteField().setText(s.getPaziente());
            view.getSomministrazionePanel().getIdOperatoreField().setText(idOperatore);
            view.getSomministrazionePanel().getDataField().setText(dataOraAttuale); 
            view.getSomministrazionePanel().getNoteField().setText(s.getNote() != null ? s.getNote() : "");

            view.getListTerapieOdiernePanel().setVisible(false);
            view.getSomministrazionePanel().setVisible(true);

        } catch (Exception ex) {
            PopUp.infoBox("Errore nel caricamento dei dati per la somministrazione.", "Errore");
            ex.printStackTrace();
        }
    }
}