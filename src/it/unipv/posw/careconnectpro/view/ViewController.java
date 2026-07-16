package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.view.dipendenti.amministratore.AmmPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.amministratore.RegistrazioneUtentePanel;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.GestionePazientePanel;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.InfPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.MonitoraggioPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.infermiere.ListTerapieOdiernePanel; // IMPORT AGGIUNTO
import it.unipv.posw.careconnectpro.view.dipendenti.medico.ListMonitoraggioPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.medico.ListSomministrazionePanel;
import it.unipv.posw.careconnectpro.view.dipendenti.medico.MedPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.medico.TerapiaPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.personale_sanitario.SomministrazionePanel;
import it.unipv.posw.careconnectpro.view.login.LoginPanel;

import javax.swing.*;

public class ViewController extends JFrame {
	
    private static final long serialVersionUID = 1L;
    
	private JFrame frame;
    private JPanel panel;
    private LoginPanel loginPanel;
    private AmmPanel ammPanel;
    private RegistrazioneUtentePanel regUtentePanel;
    private MedPanel medPanel;
    private ListMonitoraggioPanel listMonitoraggioPanel;
    private TerapiaPanel terapiaPanel;
    private InfPanel infPanel;
    private GestionePazientePanel GestionePazPanel;
    private MonitoraggioPanel monitoraggioPanel;
    private SomministrazionePanel somministrazionePanel;
    private ListSomministrazionePanel listSomministrazionePanel;
    private ListTerapieOdiernePanel listTerapieOdiernePanel; 


    public  ViewController() {
        frame = new JFrame();
        panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CareConnectPro");
        frame.getContentPane().add(panel);

        // LOGIN
        loginPanel = new LoginPanel();
        panel.add(loginPanel);

        
        //AMMINISTRATORE
        ammPanel = new AmmPanel();
        panel.add(ammPanel);
        ammPanel.setVisible(false);

        regUtentePanel = new RegistrazioneUtentePanel();
        panel.add(regUtentePanel);
        regUtentePanel.setVisible(false);

        
        //MEDICO
        medPanel = new MedPanel();
        panel.add(medPanel);
        medPanel.setVisible(false);

        listMonitoraggioPanel = new ListMonitoraggioPanel();
        panel.add(listMonitoraggioPanel);
        listMonitoraggioPanel.setVisible(false);

        terapiaPanel = new TerapiaPanel();
        panel.add(terapiaPanel);
        terapiaPanel.setVisible(false);
        
        listSomministrazionePanel = new ListSomministrazionePanel();
        panel.add(listSomministrazionePanel);
        listSomministrazionePanel.setVisible(false);

        
        //INFERMIERE
        infPanel = new InfPanel();
        panel.add(infPanel);
        infPanel.setVisible(false);

        GestionePazPanel = new GestionePazientePanel();
        panel.add(GestionePazPanel);
        GestionePazPanel.setVisible(false);

        monitoraggioPanel = new MonitoraggioPanel();
        panel.add(monitoraggioPanel);
        monitoraggioPanel.setVisible(false);

        somministrazionePanel = new SomministrazionePanel();
        panel.add(somministrazionePanel);
        somministrazionePanel.setVisible(false);  
     
        listTerapieOdiernePanel = new ListTerapieOdiernePanel();
        panel.add(listTerapieOdiernePanel);
        listTerapieOdiernePanel.setVisible(false);
        
        frame.setVisible(true);

    }

    public LoginPanel getLoginPanel() { return loginPanel; }
    public AmmPanel getAmmPanel() { return ammPanel; }
    public RegistrazioneUtentePanel getRegUtentePanel() { return regUtentePanel; }
    public MedPanel getMedPanel() { return medPanel; }
    public ListMonitoraggioPanel getListMonitoraggioPanel() { return listMonitoraggioPanel; }
    public TerapiaPanel getTerapiaPanel() { return terapiaPanel; }
    public InfPanel getInfPanel() { return infPanel; }
    public GestionePazientePanel getGestionePazPanel() { return GestionePazPanel; }
    public MonitoraggioPanel getMonitoraggioPanel() { return monitoraggioPanel; }
	public SomministrazionePanel getSomministrazionePanel() { return somministrazionePanel; }
	public ListSomministrazionePanel getListSomministrazionePanel() { return listSomministrazionePanel; }
	public ListTerapieOdiernePanel getListTerapieOdiernePanel() { return listTerapieOdiernePanel; }
}