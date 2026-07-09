package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import javax.swing.*;
import java.awt.*;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.StatoSomministrazione;

public class SomministrazionePanel extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private JLabel idTerapiaLabel, idPazienteLabel, idOperatoreLabel, dataLabel, noteLabel, statoLabel;
    private JTextField idTerapiaField, idPazienteField, idOperatoreField, dataField, noteField;
    private JComboBox<StatoSomministrazione> statoBox;
    private JButton confermaButton, backButton;

    public SomministrazionePanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);
        setVisible(true);

        setLayout(new GridLayout(7, 2, 10, 10)); 

        idTerapiaLabel = new JLabel("ID Terapia");
        idTerapiaField = new JTextField();
        idTerapiaField.setEditable(false); 

        idPazienteLabel = new JLabel("ID Paziente");
        idPazienteField = new JTextField();
        idPazienteField.setEditable(false);

        idOperatoreLabel = new JLabel("ID Operatore");
        idOperatoreField = new JTextField();
        idOperatoreField.setEditable(false);

        dataLabel = new JLabel("Data e Ora Somministrazione");
        dataField = new JTextField();

        noteLabel = new JLabel("Note");
        noteField = new JTextField();

        statoLabel = new JLabel("Stato Somministrazione");
        statoBox = new JComboBox<>(StatoSomministrazione.values()); 

        confermaButton = new JButton("Conferma");
        backButton = new JButton("Indietro");

        idTerapiaLabel.setFont(mediumFont);
        idTerapiaField.setFont(mediumFont);
        idPazienteLabel.setFont(mediumFont);
        idPazienteField.setFont(mediumFont);
        idOperatoreLabel.setFont(mediumFont);
        idOperatoreField.setFont(mediumFont);
        dataLabel.setFont(mediumFont);
        dataField.setFont(mediumFont);
        noteLabel.setFont(mediumFont);
        noteField.setFont(mediumFont);
        statoLabel.setFont(mediumFont);
        statoBox.setFont(mediumFont);
        confermaButton.setFont(largeFont);
        backButton.setFont(largeFont);

        add(idTerapiaLabel);     
        add(idTerapiaField);
        add(idPazienteLabel);    
        add(idPazienteField);
        add(idOperatoreLabel);   
        add(idOperatoreField);
        add(dataLabel);          
        add(dataField);
        add(statoLabel);         
        add(statoBox);
        add(noteLabel);          
        add(noteField);
        add(backButton);         
        add(confermaButton);
    }

	public JTextField getIdTerapiaField() {
		return idTerapiaField;
	}

	public JTextField getIdPazienteField() {
		return idPazienteField;
	}

	public JTextField getIdOperatoreField() {
		return idOperatoreField;
	}

	public JTextField getDataField() {
		return dataField;
	}

	public JTextField getNoteField() {
		return noteField;
	}

	public JComboBox<StatoSomministrazione> getStatoBox() {
		return statoBox;
	}

	public JButton getConfermaButton() {
		return confermaButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

}



