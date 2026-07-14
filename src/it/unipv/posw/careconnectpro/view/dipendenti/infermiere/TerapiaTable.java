package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import it.unipv.posw.careconnectpro.jdbc.bean.cartellaclinica.terapia.TerapiaDB;
import it.unipv.posw.careconnectpro.model.cartellaclinica.somministrazione.Somministrazione;

public class TerapiaTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private final String[] columnNames = { "ID Terapia", "Paziente", "Farmaco", "Dosaggio", "Ora Prevista", "Stato",
			"Note" };
	private List<Somministrazione> somministrazioniDiOggi;
	private List<TerapiaDB> terapieAttive;

	public TerapiaTable(List<Somministrazione> somministrazioniDiOggi, List<TerapiaDB> terapieAttive) {

		if (somministrazioniDiOggi != null) {
			this.somministrazioniDiOggi = somministrazioniDiOggi;
		} else {
			this.somministrazioniDiOggi = new ArrayList<>();
		}

		if (terapieAttive != null) {
			this.terapieAttive = terapieAttive;
		} else {
			this.terapieAttive = new ArrayList<>();
		}
	}

	@Override
	public int getRowCount() {
		return somministrazioniDiOggi.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	private TerapiaDB getTerapiaById(int id) {
		for (TerapiaDB t : terapieAttive) {
			if (t.getIdTerapia() == id)
				return t;
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Somministrazione s = somministrazioniDiOggi.get(rowIndex);
		TerapiaDB t = getTerapiaById(s.getTerapia());

		switch (columnIndex) {
		case 0:
			return s.getTerapia();
		case 1:
			return s.getPaziente();
		case 2:
			return t != null ? t.getNomeFarmaco() : "-";
		case 3:
			return t != null ? t.getDosaggio() : "-";
		case 4:
			return s.getOra().toString();
		case 5:
			return s.getStato().name();
		case 6:
			return s.getNote();
		default:
			return null;
		}
	}

	
	public Somministrazione getSomministrazioneSelezionata(int rowIndex) {
		return somministrazioniDiOggi.get(rowIndex);
	}

	
	public void setDati(List<Somministrazione> nuoveSomministrazioni, List<TerapiaDB> nuoveTerapie) {

		if (nuoveSomministrazioni != null) {
			this.somministrazioniDiOggi = nuoveSomministrazioni;
		} else {
			this.somministrazioniDiOggi = new ArrayList<>();
		}

		if (nuoveTerapie != null) {
			this.terapieAttive = nuoveTerapie;
		} else {
			this.terapieAttive = new ArrayList<>();
		}

		fireTableDataChanged();
	}
}