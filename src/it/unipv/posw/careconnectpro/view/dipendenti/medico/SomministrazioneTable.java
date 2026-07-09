package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SomministrazioneTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    private List<Somministrazione> listaSomministrazioni;
    private final String[] columnNames = {"ID Terapia", "ID Paziente", "Data Prevista", "Note"};

    public SomministrazioneTable(List<Somministrazione> listaSomministrazioni) {
        this.listaSomministrazioni = listaSomministrazioni;
    }

    @Override
    public int getRowCount() {
        if (listaSomministrazioni == null) {
            return 0;
        }
        return listaSomministrazioni.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Somministrazione s = listaSomministrazioni.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getTerapia();
            case 1: return s.getPaziente();
            case 2: return s.getData().toString() + " " + s.getOra().toString(); 
            case 3: return s.getNote();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Somministrazione getSomministrazione(int row) {
        return listaSomministrazioni.get(row);
    }
}