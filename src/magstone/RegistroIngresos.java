/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstone;

import Adicional.CreatePDF;
import Adicional.ExportExc;
import Classes.Client;
import Classes.Income;
import Classes.Sale;
import Classes.Save;
import Conexion.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;
/**
 *
 * @author macbook
 */
public class RegistroIngresos extends javax.swing.JDialog { 

    /**
     * Creates new form RegistroIngresos
     */
  
   public RegistroIngresos() {
        initComponents();
         setIconImage (new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
         
  ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEliminar.setIcon(fondo1);
          ImageIcon imagen4 = new ImageIcon(getClass().getResource("Images/Buscar.png"));
        Icon fondo4 = new ImageIcon(imagen4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        txtBuscar.setIcon(fondo4);
    tableIngresos.getTableHeader().setBackground(Color.white);
        tableIngresos.getTableHeader().setForeground(Color.black);
        tableIngresos.getTableHeader().setFont(new Font("InaiMathi", 0, 20)); 
        tableIngresos.getColumnModel().getColumn(9).setCellRenderer(new CurrencyCellRenderer());
        tableIngresos.getColumnModel().getColumn(10).setCellRenderer(new CurrencyCellRenderer());
        tableIngresos.getColumnModel().getColumn(11).setCellRenderer(new CurrencyCellRenderer());
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tableIngresos.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tableIngresos.getColumnModel().getColumn(1).setCellRenderer(new TimestampCellRenderer());
        tableIngresos.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tableIngresos.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tableIngresos.getColumnModel().getColumn(4).setCellRenderer(tcr); 
        tableIngresos.getColumnModel().getColumn(5).setCellRenderer(tcr);
        tableIngresos.getColumnModel().getColumn(6).setCellRenderer(tcr);
           tableIngresos.getColumnModel().getColumn(8).setCellRenderer(tcr);
        con=new Conexion();
             con.Conectar();       
        model=(DefaultTableModel)tableIngresos.getModel();
        try{
     if(Save.ingreso ==1){
         jLabel6.setText("Registro de pagos de "+Save.Clienttext);
         this.setTitle("Registro de pagos de "+Save.Clienttext);
           client=con.GetClientById(Save.Client);
           sale=con.GetSalesById(Save.Sale);
           DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(sale.Saldo()));

         incomes=con.GetIncomesBySale(Save.Sale);

     }else if(Save.ingreso ==2){
         jLabel6.setText("Registro de pagos de "+Save.Clienttext);
         this.setTitle("Registro de pagos de "+Save.Clienttext);
           client=con.GetClientById(Save.Client);
           sale=con.GetSalesById(Save.Sale);
           DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(client.Saldo()));

         incomes=con.GetIncomesByClient(Save.Client);
   btnAgregarPago.setVisible(false);
     }else{
         lblSaldo.setVisible(false);
         txtSaldo.setVisible(false);
         jScrollPane7.setVisible(false);
         btnAgregarPago.setVisible(false);
         incomes=con.GetIncomes();
     }
      } catch (SQLException ex) {
                    Logger.getLogger(RegistroIngresos.class.getName()).log(Level.SEVERE, null, ex);
                }
     con.Desconectar();
        for(Income obj: incomes)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Expense_Type,obj.Client,obj.Sale,obj.Concept,obj.Account,
            obj.Bill(),obj.BillsNumber,obj.Amount,obj.Iva(),obj.AmountSinIva()});
        }
            
              trs=new TableRowSorter(model);
        tableIngresos.setRowSorter(trs);
       tableIngresos.doLayout();
    
    
    } 
    Conexion con;
      private DefaultTableModel model;
    public List<Income> incomes; 
  public Client client;
    public Sale sale;
      TableRowSorter trs;                                 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubMenu = new javax.swing.JPopupMenu();
        btnEliminar = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtBusqueda = new javax.swing.JTextPane();
        txtBuscar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarPago = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtSaldo = new javax.swing.JTextPane();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableIngresos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        SubMenu.add(btnEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de ingresos");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registro de ingresos");

        txtBusqueda.setBackground(new java.awt.Color(245, 245, 245));
        txtBusqueda.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txtBusqueda.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(51, 51, 51));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(txtBusqueda);

        txtBuscar.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setText("Buscar:");

        cbxFiltro.setBackground(new java.awt.Color(245, 245, 245));
        cbxFiltro.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        cbxFiltro.setForeground(new java.awt.Color(51, 51, 51));
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Fecha", "Categoría", "Cliente", "Venta", "Detalle", "Tipo de pago", "Cuenta", "Factura", "No. de Factura", "Monto Total", "Iva", "Monto sin iva" }));

        jLabel8.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("En:");

        btnAgregarPago.setBackground(new java.awt.Color(153, 153, 153));
        btnAgregarPago.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        btnAgregarPago.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarPago.setText("Agregar nuevo pago");
        btnAgregarPago.setToolTipText("");
        btnAgregarPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(145, 146, 147)));
        btnAgregarPago.setFocusTraversalPolicyProvider(true);
        btnAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPagoActionPerformed(evt);
            }
        });

        txtSaldo.setEditable(false);
        txtSaldo.setBackground(new java.awt.Color(255, 255, 255));
        txtSaldo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txtSaldo.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtSaldo.setForeground(new java.awt.Color(51, 51, 51));
        txtSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(txtSaldo);

        lblSaldo.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(51, 51, 51));
        lblSaldo.setText("Saldo:");

        tableIngresos.setBackground(new java.awt.Color(245, 245, 245));
        tableIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tableIngresos.setForeground(new java.awt.Color(0, 0, 0));
        tableIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Categoría", "Cliente", "Venta", "Detalle", "Cuenta", "Factura", "No. de Factura", "Monto Total", "Iva", "Monto Sin Iva"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableIngresos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableIngresos.setGridColor(new java.awt.Color(153, 153, 153));
        tableIngresos.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        tableIngresos.setRowHeight(22);
        tableIngresos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableIngresos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableIngresos.setShowGrid(true);
        tableIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableIngresosMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tableIngresos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnAgregarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAgregarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(245, 245, 245));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jMenu2.setBackground(new java.awt.Color(245, 245, 245));
        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("Exportar");

        jMenuItem3.setBackground(new java.awt.Color(245, 245, 245));
        jMenuItem3.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setText("Archivo de Excel");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(245, 245, 245));
        jMenuItem4.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem4.setText("Archivo PDF");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        txtBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusqueda.getText(),cbxFiltro.getSelectedIndex()));
            }
        });
        trs=new TableRowSorter(model);
        tableIngresos.setRowSorter(trs);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased

    }//GEN-LAST:event_jPanel4MouseReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int n = JOptionPane.showConfirmDialog(this,
            "¿Desea eliminar el registro "+ tableIngresos.getValueAt(tableIngresos.getSelectedRow(), 0).toString() +"?","Confirmación",
            JOptionPane.YES_NO_OPTION);
        if(n==JOptionPane.YES_OPTION){

            con=new Conexion();
            con.Conectar();
            try{
                con.DeleteIncome(Integer.parseInt( tableIngresos.getValueAt(tableIngresos.getSelectedRow(), 0).toString()));
               if(Save.ingreso ==1){
         incomes=con.GetIncomesBySale(Save.Sale);
   sale=con.GetSalesById(Save.Sale);
    DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(sale.Saldo()));
     }      else   if(Save.ingreso ==2){
         incomes=con.GetIncomesByClient(Save.Client);
   client=con.GetClientById(Save.Client);
    DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(client.Saldo()));
     }else{
         incomes=con.GetIncomes();
     }
            } catch (SQLException ex) {
            }
         
              
            con.Desconectar();
            JOptionPane.showMessageDialog(this,"Ingreso eliminado con éxito.");

            int j=model.getRowCount();
            for(int i=0;i<j;i++){
                model.removeRow(j-i-1);
            }
            for(Income obj: incomes)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Expense_Type,obj.Client,obj.Sale,obj.Concept,obj.Account,
            obj.Bill(),obj.BillsNumber,obj.Amount,obj.Iva(),obj.AmountSinIva()});
        }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tableIngresosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIngresosMousePressed
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
        SubMenu.show(tableIngresos, evt.getX(), evt.getY());
        }      
    }//GEN-LAST:event_tableIngresosMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     Interfaz.RegistroIngresosBool=false;
    }//GEN-LAST:event_formWindowClosing

    private void btnAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPagoActionPerformed

     
       try{
        AddPagoCliente form=new AddPagoCliente();
           form.setModal(true);
        form.setVisible(true);
       }catch(Exception e){}         
        int j=model.getRowCount();
        for(int i=0;i<j;i++){
            model.removeRow(j-i-1);
        }
        con=new Conexion();
        con.Conectar();
        try{
   client=con.GetClientById(Save.Client);
               DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(client.Saldo()));

         incomes=con.GetIncomesBySale(Save.Sale);

        } catch (SQLException ex) {
        }
        con.Desconectar();
          for(Income obj: incomes)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Expense_Type,obj.Client,obj.Sale,obj.Concept,obj.Account,
            obj.Bill(),obj.BillsNumber,obj.Amount,obj.Iva(),obj.AmountSinIva()});
        }
            
    }//GEN-LAST:event_btnAgregarPagoActionPerformed

    private void txtSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoKeyTyped

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ExportExc j=new ExportExc();
        try{
            j.exportarExcel(tableIngresos);}
        catch(IOException e){}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      CreatePDF a=new CreatePDF();
      if(Save.ingreso==0){
         a.ReporteIngresos(incomes); 
      }else{
         a.ReporteIngresosCliente(incomes,Save.Clienttext); 
       
      }
      
    }//GEN-LAST:event_jMenuItem4ActionPerformed
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                    new RegistroIngresos().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu SubMenu;
    private javax.swing.JButton btnAgregarPago;
    private javax.swing.JMenuItem btnEliminar;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTable tableIngresos;
    private javax.swing.JLabel txtBuscar;
    private javax.swing.JTextPane txtBusqueda;
    private javax.swing.JTextPane txtSaldo;
    // End of variables declaration//GEN-END:variables
}
