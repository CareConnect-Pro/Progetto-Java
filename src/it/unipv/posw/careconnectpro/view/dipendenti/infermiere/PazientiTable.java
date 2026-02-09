package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import it.unipv.posw.careconnectpro.model.persona.Paziente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PazientiTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
	List<Paziente> pazienti;
    private final String[] columnNames ={"CODICE FISCALE", "NOME", "COGNOME", "DATA DI NASCITA"};

    public PazientiTable(List<Paziente> pazienti) {
        this.pazienti = pazienti;
    }

    @Override
    public int getRowCount() {
    		if(pazienti == null) {
    			return 0;
    		}
        return pazienti.size();
    }

    @Override
    public int getColumnCount() {
    	
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paziente p = pazienti.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getCodiceFiscale();
            case 1: return p.getNome();
            case 2: return p.getCognome();
            case 3: return p.getDataNascita();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Paziente getPaziente(int row) {
        return pazienti.get(row);
    }
    
    
}
