package ayana;

import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CurrencyCellRenderer extends DefaultTableCellRenderer {
 
    private static final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        final Component result = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            setHorizontalAlignment(JLabel.RIGHT);
            setText(FORMAT.format(value));
        } else {
            setText("");
        }
        return result;
    }
        @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(SwingConstants.LEFT); //To change body of generated methods, choose Tools | Templates.
    }
}
