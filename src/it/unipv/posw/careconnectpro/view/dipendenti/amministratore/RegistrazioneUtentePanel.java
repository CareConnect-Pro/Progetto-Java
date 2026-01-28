package it.unipv.posw.careconnectpro.view.dipendenti.amministratore;

import it.unipv.posw.careconnectpro.model.persona.TipoUtente;

import javax.swing.*;
import java.awt.*;

public class RegistrazioneUtentePanel extends JPanel {

    private JLabel cfLabel, nomeLabel, cognomeLabel, dataNascitaLabel, emailLabel, cellulareLabel,
                    passwordLabel, tipoUtenteLabel;
    private JTextField cfField, nomeField, cognomeField, dataNascitaField, emailField, cellulareField,
                        passwordField, tipoUtenteField;
    private JComboBox<TipoUtente> tipoUtenteComboBox;
    private JButton confermaButton, uscitaButton;

    public RegistrazioneUtentePanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);

        setVisible(true);
        setLayout(new GridLayout(9,2,10,10));

        cfLabel = new JLabel("Codice Fiscale");
        cfField = new JTextField();
        nomeLabel = new JLabel("Nome");
        nomeField = new JTextField();
        cognomeLabel = new JLabel("Cognome");
        cognomeField = new JTextField();
        dataNascitaLabel = new JLabel("Data di Nascita");
        dataNascitaField = new JTextField();
        emailLabel = new JLabel("Email");
        emailField = new JTextField();
        cellulareLabel = new JLabel("Cellulare");
        cellulareField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        tipoUtenteLabel = new JLabel("Tipo utente");
        tipoUtenteComboBox = new JComboBox<>(TipoUtente.values());
        uscitaButton = new JButton("Indietro");
        confermaButton = new JButton("Registra");

//        confermaButton.setBackground(new Color(173, 216, 230));
//        confermaButton.setOpaque(true);
//        confermaButton.setBorderPainted(false);


        cfLabel.setFont(mediumFont);
        nomeLabel.setFont(mediumFont);
        cognomeLabel.setFont(mediumFont);
        dataNascitaLabel.setFont(mediumFont);
        emailLabel.setFont(mediumFont);
        cellulareLabel.setFont(mediumFont);
        passwordLabel.setFont(mediumFont);
        tipoUtenteLabel.setFont(mediumFont);
        tipoUtenteComboBox.setFont(mediumFont);
        uscitaButton.setFont(mediumFont);
        confermaButton.setFont(largeFont);

        add(cfLabel);
        add(cfField);
        add(nomeLabel);
        add(nomeField);
        add(cognomeLabel);
        add(cognomeField);
        add(dataNascitaLabel);
        add(dataNascitaField);
        add(emailLabel);
        add(emailField);
        add(cellulareLabel);
        add(cellulareField);
        add(passwordLabel);
        add(passwordField);
        add(tipoUtenteLabel);
        add(tipoUtenteComboBox);
        add(uscitaButton);
        add(confermaButton);

    }

    public JLabel getCfLabel() {
        return cfLabel;
    }
    public JLabel getNomeLabel() {
        return nomeLabel;
    }
    public JLabel getCognomeLabel() {
        return cognomeLabel;
    }
    public JLabel getDataNascitaLabel() {
        return dataNascitaLabel;
    }
    public JLabel getEmailLabel() {
        return emailLabel;
    }
    public JLabel getCellulareLabel() {
        return cellulareLabel;
    }
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }
    public JLabel getTipoUtenteLabel() {
        return tipoUtenteLabel;
    }
    public JTextField getCfField() {
        return cfField;
    }
    public JTextField getNomeField() {
        return nomeField;
    }
    public JTextField getCognomeField() {
        return cognomeField;
    }
    public JTextField getDataNascitaField() {
        return dataNascitaField;
    }
    public JTextField getEmailField() {
        return emailField;
    }
    public JTextField getCellulareField() {
        return cellulareField;
    }
    public JTextField getPasswordField() {
        return passwordField;
    }
    public JTextField getTipoUtenteField() {
        return tipoUtenteField;
    }
    public JButton getConfermaButton() {
        return confermaButton;
    }
    public JComboBox<TipoUtente> getTipoUtenteComboBox() {
        return tipoUtenteComboBox;
    }
    public JButton getUscitaButton() {
        return uscitaButton;
    }
}
