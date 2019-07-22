/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicional;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
  
/**
 * @version 1.0 11/22/98
 */
public class MultiFontCellTableExample extends JFrame {
  
  public MultiFontCellTableExample() {
    super( "Multi-Font Cell Example" );
      
    AttributiveCellTableModel ml = new AttributiveCellTableModel(8,3);
    CellFont cellAtt =(CellFont)ml.getCellAttribute();
    JTable table = new JTable( ml );
    table.setRowHeight(26);
    table.setCellSelectionEnabled(true);
    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
   ///////// table.setDefaultRenderer(Object.class ,new TableCellRendered());
    JScrollPane scroll = new JScrollPane( table );
  
    FontPanel fontPanel = new FontPanel(table, cellAtt);
     
    Box box = new Box(BoxLayout.X_AXIS);
    box.add(scroll);
    box.add(new JSeparator(SwingConstants.HORIZONTAL));
    box.add(fontPanel);
    getContentPane().add( box );
    setSize( 400, 200 );
    setVisible(true);
  }
  
  class FontPanel extends JPanel {
    String[] str_size  = {"10","12","14","16","20","24"};
    String[] str_style = {"PLAIN","BOLD","ITALIC"};
    JComboBox name,style,size;
  
    FontPanel(final JTable table, final CellFont cellAtt) {
      setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
      Box box = new Box(BoxLayout.X_AXIS);
      JPanel p2 = new JPanel(new GridLayout(3,1));
      JPanel p3 = new JPanel(new GridLayout(3,1));
      JPanel p4 = new JPanel(new FlowLayout());
      p2.add(new JLabel("Name:"));
      p2.add(new JLabel("Style:"));   
      p2.add(new JLabel("Size:"));
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      name  = new JComboBox(toolkit.getFontList());
      style = new JComboBox(str_style);
      size  = new JComboBox(str_size);
      size.setEditable(true);
      JButton b_apply   = new JButton("Apply");
      b_apply.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int[] columns = table.getSelectedColumns();
          int[] rows    = table.getSelectedRows();
          if ((rows == null) || (columns == null)) return;
          if ((rows.length<1)||(columns.length<1)) return;
          Font font = new Font((String)name.getSelectedItem(),
                              style.getSelectedIndex(),
              Integer.parseInt((String)size.getSelectedItem()));
          cellAtt.setFont(font, rows, columns);
          table.clearSelection();
          table.revalidate();
          table.repaint();       
        }
      });
      p3.add(name);
      p3.add(style);
      p3.add(size);
      p4.add(b_apply);
      box.add(p2);
      box.add(p3);
      add(box);
      add(p4);
    }
  }
}
