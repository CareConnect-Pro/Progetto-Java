package it.unipv.posw.careconnectpro.view;

import it.unipv.posw.careconnectpro.view.dipendenti.amministratore.AmmPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.amministratore.RegistrazioneUtentePanel;
import it.unipv.posw.careconnectpro.view.dipendenti.medico.ListMonitoraggioPanel;
import it.unipv.posw.careconnectpro.view.dipendenti.medico.MedPanel;
import it.unipv.posw.careconnectpro.view.login.LoginPanel;

import javax.swing.*;

public class ViewController extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private LoginPanel loginPanel;
    private AmmPanel ammPanel;
    private RegistrazioneUtentePanel regUtentePanel;
    private MedPanel medPanel;
    private ListMonitoraggioPanel listMonitoraggioPanel;

    public  ViewController() {
        frame = new JFrame();
        panel = new JPanel();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CareConnectPro");
        frame.getContentPane().add(panel);

        loginPanel = new LoginPanel();
        panel.add(loginPanel);

        ammPanel = new AmmPanel();
        panel.add(ammPanel);
        ammPanel.setVisible(false);

        regUtentePanel = new RegistrazioneUtentePanel();
        panel.add(regUtentePanel);
        regUtentePanel.setVisible(false);

        medPanel = new MedPanel();
        panel.add(medPanel);
        medPanel.setVisible(false);

        listMonitoraggioPanel = new ListMonitoraggioPanel();
        panel.add(listMonitoraggioPanel);
        listMonitoraggioPanel.setVisible(false);

        frame.setVisible(true);

    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }
    public AmmPanel getAmmPanel() { return ammPanel; }
    public RegistrazioneUtentePanel getRegUtentePanel() {
        return regUtentePanel;
    }
    public MedPanel getMedPanel() {
        return medPanel;
    }
    public ListMonitoraggioPanel getListMonitoraggioPanel() {
        return listMonitoraggioPanel;
    }
}
