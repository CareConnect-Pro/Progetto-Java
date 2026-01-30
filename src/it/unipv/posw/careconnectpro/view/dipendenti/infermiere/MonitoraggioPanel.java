package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.alert.Alert;
import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.paramentroVitale.TipiParametroVitale;

import javax.swing.*;
import java.awt.*;

public class MonitoraggioPanel extends JPanel {
	
    private static final long serialVersionUID = 1L;

	private JLabel idCartellaLabel, cfPazienteLabel, idInfermiereLabel, parametriLabel,
                    valoreLabel, dataLabel, alertLabel, noteLabel;

    private JTextField idCartellaField,  cfPazienteField, idInfermiereField, valoreFiel, dataFiel, noteFiel, alertField;
    private final JComboBox<TipiParametroVitale> paramentriBox;
    private JComboBox<Alert> alertBox;

    private final JButton confermaButton, backButton;

    public MonitoraggioPanel() {
        Font mediumFont = new Font("Arial", 0, 16);
        Font largeFont = new Font("Arial", 0, 20);
        setVisible(true);

        setLayout(new GridLayout(10,2,10,10));

        idCartellaLabel = new JLabel("ID cartella clinica");
        idCartellaField = new JTextField();
        idCartellaField.setEditable(false);
        cfPazienteLabel = new JLabel("Codice fiscale paziente");
        cfPazienteField = new JTextField();
        cfPazienteField.setEditable(false);
        idInfermiereLabel = new JLabel("ID infermiere");
        idInfermiereField = new JTextField();
        idInfermiereField.setEditable(false);
        parametriLabel = new JLabel("Parametro vitale");
        paramentriBox = new JComboBox<>(TipiParametroVitale.values());
        valoreLabel = new JLabel("Valore del parametro");
        valoreFiel = new JTextField();
        dataLabel = new JLabel("Data del monitoraggio");
        dataFiel = new JTextField();
        alertLabel = new JLabel("Alert del monitoraggio");
        alertField = new JTextField();
        alertField.setEditable(false);
        //alertBox = new JComboBox<>(Alert.values());
        noteLabel = new JLabel("Note");
        noteFiel = new JTextField();
        confermaButton = new JButton("Conferma");
        backButton = new JButton("Indietro");

        idCartellaLabel.setFont(mediumFont);
        cfPazienteLabel.setFont(mediumFont);
        idInfermiereLabel.setFont(mediumFont);
        parametriLabel.setFont(mediumFont);
        paramentriBox.setFont(mediumFont);
        valoreLabel.setFont(mediumFont);
        valoreFiel.setFont(mediumFont);
        dataLabel.setFont(mediumFont);
        alertLabel.setFont(mediumFont);
        noteLabel.setFont(mediumFont);
        confermaButton.setFont(largeFont);
        backButton.setFont(largeFont);

        add(idCartellaLabel);
        add(idCartellaField);
        add(cfPazienteLabel);
        add(cfPazienteField);
        add(idInfermiereLabel);
        add(idInfermiereField);
        add(parametriLabel);
        add(paramentriBox);
        add(valoreLabel);
        add(valoreFiel);
        add(dataLabel);
        add(dataFiel);
        add(alertLabel);
        add(alertField);
        add(noteLabel);
        add(noteFiel);
        add(backButton);
        add(confermaButton);

    }

    public JButton getBackButton() {
        return backButton;
    }
    public JButton getConfermaButton() {
        return confermaButton;
    }
    public JComboBox<Alert> getAlertBox() {
        return alertBox;
    }
    public JComboBox<TipiParametroVitale> getParamentriBox() {
        return paramentriBox;
    }
    public JTextField getNoteFiel() {
        return noteFiel;
    }
    public JTextField getDataFiel() {
        return dataFiel;
    }
    public JTextField getValoreFiel() {
        return valoreFiel;
    }
    public JTextField getIdInfermiereField() {
        return idInfermiereField;
    }
    public JTextField getCfPazienteField() {
        return cfPazienteField;
    }
    public JTextField getIdCartellaField() {
        return idCartellaField;
    }
    public JLabel getNoteLabel() {
        return noteLabel;
    }
    public JLabel getAlertLabel() {
        return alertLabel;
    }
    public JLabel getDataLabel() {
        return dataLabel;
    }
    public JLabel getValoreLabel() {
        return valoreLabel;
    }
    public JLabel getParametriLabel() {
        return parametriLabel;
    }
    public JLabel getIdInfermiereLabel() {
        return idInfermiereLabel;
    }
    public JLabel getCfPazienteLabel() {
        return cfPazienteLabel;
    }
    public JLabel getIdCartellaLabel() {
        return idCartellaLabel;
    }
    public void setIdCartellaField(JTextField idCartellaField) {
        this.idCartellaField = idCartellaField;
    }
    public void setCfPazienteField(JTextField cfPazienteField) {
        this.cfPazienteField = cfPazienteField;
    }
    public void setIdInfermiereField(JTextField idInfermiereField) {
        this.idInfermiereField = idInfermiereField;
    }
    public JTextField getAlertField() {
        return alertField;
    }
}
