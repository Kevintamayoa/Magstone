package ayana;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TimestampCellRenderer extends DefaultTableCellRenderer {

    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public TimestampCellRenderer() {
        super();
    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(SwingConstants.LEFT); //To change body of generated methods, choose Tools | Templates.
    }
    public void setValue(Object value) {
        if (formatter == null) {
            formatter = DateFormat.getDateInstance();
        }
        setText((value == null) ? "" : formatter.format(value));
    }
}