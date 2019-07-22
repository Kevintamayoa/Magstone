/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicional;

import java.awt.BorderLayout;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbook
 */
public class RowHeaderExample extends JFrame {
  
  public RowHeaderExample() {
    super( "Row Header Example" );
    setSize( 300, 150 );
          
    ListModel lm = new AbstractListModel() {
      String headers[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
      public int getSize() { return headers.length; }
      public Object getElementAt(int index) {
        return headers[index];
      }
    };
  
    DefaultTableModel dm = new DefaultTableModel(lm.getSize(),10);
    JTable table = new JTable( dm );
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
     
    JList rowHeader = new JList(lm);   
    rowHeader.setFixedCellWidth(50);
     
    rowHeader.setFixedCellHeight(table.getRowHeight()
                               + table.getRowMargin());
//                             + table.getIntercellSpacing().height);
    rowHeader.setCellRenderer(new RowHeaderRenderer(table));
  
    JScrollPane scroll = new JScrollPane( table );
    scroll.setRowHeaderView(rowHeader);
    getContentPane().add(scroll, BorderLayout.CENTER);
  }}