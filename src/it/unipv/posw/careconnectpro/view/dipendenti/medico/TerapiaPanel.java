package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.StatoTerapia;
import it.unipv.posw.careconnectpro.model.cartellaclinica.terapia.TipoSomministrazione;

import javax.swing.*;
import java.awt.*;

public class TerapiaPanel extends JPanel {

    private static final long serialVersionUID = 1L;

	private JLabel somministrazioneLabel, farmacoLabel, materialeLabel, dosaggioLabel, frequenzaLabel, statoLabel,
                    durataLabel, dataInizioLabel, dataFineLabel, noteLabel, idCartellaLabel, idPazienteLabel, idMedicoLabel,
                    idMonitoraggioLabel;

    private JTextField farmacoField, materialeField, dosaggioField, frequenzaField, durataField,
                        dataInizioField, dataFineField, noteField, idCartellaField, idPazienteField, idMedicoField,
                            idMonitoraggioField ;
    private JComboBox<StatoTerapia> statoBox;
    private JComboBox<TipoSomministrazione> somministrazioneBox;
    private JButton addTerapiaButton, backButton;

    public TerapiaPanel(){
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);

        setVisible(true);
        setLayout(new GridLayout(16,2,10,
                10));

        somministrazioneLabel = new JLabel("Somministrazione");
        somministrazioneBox = new JComboBox<> (TipoSomministrazione.values());
        farmacoLabel = new JLabel("Nome farmaco");
        farmacoField = new JTextField();
        materialeLabel = new JLabel("Materiale utilizzato");
        materialeField = new JTextField();
        dosaggioLabel = new JLabel("Quantità del dosaggio");
        dosaggioField = new JTextField();
        frequenzaLabel = new JLabel("Frequenza (numero volte al giorno)" );
        frequenzaField = new JTextField();
        statoLabel = new JLabel("Stato");
        statoBox = new JComboBox<>(StatoTerapia.values());
        durataLabel = new JLabel("Durata (numero giorni)");
        durataField = new JTextField();
        dataInizioLabel = new JLabel("Data Inizio");
        dataInizioField = new JTextField();
        dataFineLabel = new JLabel("Data Fine");
        dataFineField = new JTextField();
        noteLabel = new JLabel("Note");
        noteField = new JTextField();
        addTerapiaButton = new JButton("Aggiungi Terapia");
        backButton = new JButton("Indietro");
        idCartellaLabel = new JLabel("Id cartella");
        idCartellaField = new JTextField();
        idCartellaField.setEditable(false);
        idPazienteLabel = new JLabel("CF paziente");
        idPazienteField = new JTextField();
        idPazienteField.setEditable(false);
        idMedicoLabel = new JLabel("CF medico");
        idMedicoField = new JTextField();
        idMedicoField.setEditable(false);
        idMonitoraggioLabel = new JLabel("ID monitoraggio");
        idMonitoraggioField = new JTextField();
        idMonitoraggioField.setEditable(false);

        idCartellaLabel.setFont(mediumFont);
        idPazienteLabel.setFont(mediumFont);
        idMedicoLabel.setFont(mediumFont);
        idMonitoraggioLabel.setFont(mediumFont);
        somministrazioneLabel.setFont(mediumFont);
        somministrazioneBox.setFont(mediumFont);
        farmacoLabel.setFont(mediumFont);
        materialeLabel.setFont(mediumFont);
        dosaggioLabel.setFont(mediumFont);
        frequenzaLabel.setFont(mediumFont);
        statoLabel.setFont(mediumFont);
        statoBox.setFont(mediumFont);
        durataLabel.setFont(mediumFont);
        dataInizioLabel.setFont(mediumFont);
        dataFineLabel.setFont(mediumFont);
        noteLabel.setFont(mediumFont);
        addTerapiaButton.setFont(largeFont);
        backButton.setFont(largeFont);


        add(idMonitoraggioLabel);
        add(idMonitoraggioField);
        add(idCartellaLabel);
        add(idCartellaField);
        add(idPazienteLabel);
        add(idPazienteField);
        add(idMedicoLabel);
        add(idMedicoField);
        add(somministrazioneLabel);
        add(somministrazioneBox);
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
        add(backButton);

    }

    public JButton getAddTerapiaButton() {
        return addTerapiaButton;
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
    public JTextField getIdMonitoraggioField() {
        return idMonitoraggioField;
    }

    public JComboBox<StatoTerapia> getStatoBox() {
        return statoBox;
    }

    public JTextField getNoteField() {
        return noteField;
    }

    public JTextField getDataFineField() {
        return dataFineField;
    }

    public JTextField getDataInizioField() {
        return dataInizioField;
    }

    public JTextField getDurataField() {
        return durataField;
    }

    public JTextField getFrequenzaField() {
        return frequenzaField;
    }

    public JTextField getDosaggioField() {
        return dosaggioField;
    }

    public JTextField getMaterialeField() {
        return materialeField;
    }

    public JTextField getFarmacoField() {
        return farmacoField;
    }

    public JComboBox<TipoSomministrazione> getSomministrazioneBox() {
        return somministrazioneBox;
    }

    public JLabel getSomministrazioneLabel() {
        return somministrazioneLabel;
    }

    public JButton getBackButton() {
        return backButton;
    }

}
