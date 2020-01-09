package magstone;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class SegVentas extends JLabel implements TableCellRenderer {
 
    private static final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();
  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
//        if(column==5||column==6||column==7){
//        if (value instanceof Number) {
//            setHorizontalAlignment(JLabel.RIGHT);
//            setText(FORMAT.format(value));
//        } else {
//            setText("");
//        }}else if(column==1){
//              if (formatter == null) {
//            formatter = DateFormat.getDateInstance();
//        }
//        setText((value == null) ? "" : formatter.format(value));
//        }else{
//            setFont(new Font("InaiMathi", 0, 18));
//            setText( value.toString());
//        }
      //  table.getTableHeader().setBackground(Color.white);
      //  table.getTableHeader().setForeground(Color.black);
       setBackground((row==1)?Color.red : Color.blue);
       // table.getTableHeader().setFont(new Font("InaiMathi", 0, 20));
  
           return this;
    }
        @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(SwingConstants.LEFT); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void setBackground(Color bg) {
        super.setBackground( Color.blue);
        
    }

   
   
}