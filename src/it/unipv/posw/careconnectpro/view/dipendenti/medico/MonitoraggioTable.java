package it.unipv.posw.careconnectpro.view.dipendenti.medico;

import it.unipv.posw.careconnectpro.model.cartellaclinica.monitoraggio.Monitoraggio;
import it.unipv.posw.careconnectpro.model.rsa.IRSA;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MonitoraggioTable extends AbstractTableModel {

   private static final long serialVersionUID = 1L;
   
   List<Monitoraggio> monitoraggi;
   private IRSA model;
   private final String[] columnNames = {"ID", "CC", "CF_PAZIENTE", "CF_INFERMIERE", "PARAMENTRO VITALE",
                                            "VALORE", "DATA", "ALERT", "NOTE"};


   public MonitoraggioTable(List <Monitoraggio> monitoraggi) {
       this.monitoraggi = monitoraggi;
   }
   

   @Override
   public int getRowCount() {
       return monitoraggi.size();
   }

  @Override
  public int getColumnCount() {
       return 9;
  }

  @Override
  public String getColumnName(int column) {
       return columnNames[column];
  }

  @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
       Monitoraggio m = monitoraggi.get(rowIndex);
       switch (columnIndex) {
           case 0: return m.getIdMonitoraggio();
           case 1: return m.getCartellaClinica().getIdCartellaClinica();
           case 2: return m.getPaziente().getCodiceFiscale();
           case 3: return m.getInfermiere().getCodiceFiscale();
           case 4: return m.getTipiParametroVitale().name();
           case 5: return m.getValore();
           case 6: return m.getDataMonitoraggio();
           case 7: return m.getAlert().name();
           case 8: return m.getNote();
           default: return null;
       }

  }

  public void rimuoviMonitoraggio(int rowIndex) {
       monitoraggi.remove(rowIndex);
       fireTableRowsDeleted(rowIndex, rowIndex);

  }

    public Monitoraggio getMonitoraggi(int row) {
        return monitoraggi.get(row);
    }
}
