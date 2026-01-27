package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.StatoTerapia;

import javax.swing.*;
import java.awt.*;

public class TerapiaPanel extends JPanel {

    private JLabel somministrazioneLabel, farmacoLabel, materialeLabel, dosaggioLabel, frequenzaLabel, statoLabel,
                    durataLabel, dataInizioLabel, dataFineLabel, noteLabel, idCartellaLabel, idPazienteLabel, idMedicoLabel;

    private JTextField somministrazioneField, farmacoField, materialeField, dosaggioField, frequenzaField, durataField,
                        dataInizioField, dataFineField, noteField, idCartellaField, idPazienteField, idMedicoField;
    private JComboBox<StatoTerapia> statoBox;
    private JButton addTerapiaButton;

    public TerapiaPanel(){
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);

        setVisible(true);
        setLayout(new GridLayout(14,2,10,10));

        somministrazioneLabel = new JLabel("Somministrazione");
        somministrazioneField = new JTextField();
        farmacoLabel = new JLabel("Nome farmaco");
        farmacoField = new JTextField();
        materialeLabel = new JLabel("Materiale utilizzato");
        materialeField = new JTextField();
        dosaggioLabel = new JLabel("Quantità del dosaggio");
        dosaggioField = new JTextField();
        frequenzaLabel = new JLabel("Frequenza");
        frequenzaField = new JTextField();
        statoLabel = new JLabel("Stato");
        statoBox = new JComboBox<>(StatoTerapia.values());
        durataLabel = new JLabel("Durata");
        durataField = new JTextField();
        dataInizioLabel = new JLabel("Data Inizio");
        dataInizioField = new JTextField();
        dataFineLabel = new JLabel("Data Fine");
        dataFineField = new JTextField();
        noteLabel = new JLabel("Note");
        noteField = new JTextField();
        addTerapiaButton = new JButton("Aggiungi Terapia");
        idCartellaLabel = new JLabel("Id cartella");
        idCartellaField = new JTextField();
        idCartellaField.setEditable(false);
        idPazienteLabel = new JLabel("CF paziente");
        idPazienteField = new JTextField();
        idPazienteField.setEditable(false);
        idMedicoLabel = new JLabel("CF medico");
        idMedicoField = new JTextField();
        idMedicoField.setEditable(false);


        somministrazioneLabel.setFont(mediumFont);
        farmacoLabel.setFont(mediumFont);
        materialeLabel.setFont(mediumFont);
        dosaggioLabel.setFont(mediumFont);
        frequenzaLabel.setFont(mediumFont);
        statoBox.setFont(mediumFont);
        durataLabel.setFont(mediumFont);
        dataInizioLabel.setFont(mediumFont);
        dataFineLabel.setFont(mediumFont);
        noteLabel.setFont(mediumFont);

        add(idCartellaLabel);
        add(idCartellaField);
        add(idPazienteLabel);
        add(idPazienteField);
        add(idMedicoLabel);
        add(idMedicoField);
        add(somministrazioneLabel);
        add(somministrazioneField);
        add(farmacoLabel);
        add(farmacoField);
        add(materialeLabel);
        add(materialeField);
        add(dosaggioLabel);
        add(dosaggioField);
        add(frequenzaLabel);
        add(frequenzaField);
        add(statoLabel);
        add(statoBox);
        add(durataLabel);
        add(durataField);
        add(dataInizioLabel);
        add(dataInizioField);
        add(dataFineLabel);
        add(dataFineField);
        add(noteLabel);
        add(noteField);
        add(addTerapiaButton);

    }

    public JTextField getIdCartellaField() {
        return idCartellaField;
    }
    public JTextField getIdPazienteField() {
        return idPazienteField;
    }
    public JTextField getIdMedicoField() {
        return idMedicoField;
    }

}
