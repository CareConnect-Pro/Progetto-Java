package it.unipv.posw.careconnectpro.view.dipendenti.infermiere;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SomministrazioneRowRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    private final Color verdePastello = new Color(200, 240, 200);
    private final Color rossoPastello = new Color(255, 200, 200);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        int colonnaStato = 5; 
        Object statoObj = table.getValueAt(row, colonnaStato);

        if (statoObj != null) {
            String stato = statoObj.toString();

            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            } else {
                if (stato.equalsIgnoreCase("SOMMINISTRATA")) {
                    c.setBackground(verdePastello);
                    c.setForeground(Color.BLACK); 
                } else if (stato.equalsIgnoreCase("NON_SOMMINISTRATA")) {
                    c.setBackground(rossoPastello);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(table.getBackground());
                    c.setForeground(table.getForeground());
                }
            }
        }

        return c;
    }
}