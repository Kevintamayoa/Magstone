/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstone;

import Classes.*;
import Classes.Save;
import Conexion.Conexion;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbook
 */
public class NuevaVenta extends javax.swing.JFrame {

    /**
     * Creates new form NuevaVenta
     */
    public NuevaVenta() {
        initComponents();
        setIconImage (new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
          ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Guardar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnTerminar.setIcon(fondo1);
        con=new Conexion();
        con.Conectar();
          try {
        clientes=con.GetClients();
        service_type=con.GetServiceType();
        inventory_type=con.GetInventoryTypes();
        accounts=con.GetAccounts();
        } catch (SQLException ex) {}     
        con.Desconectar();
               
        
        
        for(Client obj : clientes){
        vectorCliente.add(obj.Description);
        }
        cbxCliente.setModel(new DefaultComboBoxModel(vectorCliente));		
JTextField text = (JTextField)cbxCliente.getEditor().getEditorComponent();
		text.setFocusable(true);
		text.setText("");
		text.addKeyListener(new ComboListener(cbxCliente,vectorCliente));
                
          for(Service_Type obj : service_type){
        vectorServicio.add(obj.Description);
        }
             cbxServicio.setModel(new DefaultComboBoxModel(vectorServicio));		
JTextField text1 = (JTextField)cbxServicio.getEditor().getEditorComponent();
		text1.setFocusable(true);
		text1.setText("");
		text1.addKeyListener(new ComboListener(cbxServicio,vectorServicio));
   
            for(Inventory_Type obj : inventory_type){
        vectorProducto.add(obj.Description);
        }
               cbxProducto.setModel(new DefaultComboBoxModel(vectorProducto));		
JTextField text2 = (JTextField)cbxProducto.getEditor().getEditorComponent();
		text2.setFocusable(true);
		text2.setText("");
		text2.addKeyListener(new ComboListener(cbxProducto,vectorProducto));
   
            
              for(Account obj : accounts){
        vectorCuenta.add(obj.Description);
        }
                 cbxCuenta.setModel(new DefaultComboBoxModel(vectorCuenta));		
JTextField text3 = (JTextField)cbxCuenta.getEditor().getEditorComponent();
		text3.setFocusable(true);
		text3.setText("");
		text3.addKeyListener(new ComboListener(cbxCuenta,vectorCuenta));
          
                dtDate.getDateEditor().setEnabled(false);
                dtDate.setDate(Date.valueOf(LocalDate.now()));
                txtMontoTotal.setEditable(false);
                txtSaldo.setEditable(false);
                formatea = new DecimalFormat("$###,###.##");
                if(Save.status==0){
                  MontoTotal=0;  
                MontoPagado=0;
                }
                txtMontoTotal.setText(  formatea.format(MontoTotal));
                txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));
                tableProductos.setAutoResizeMode(tableProductos.AUTO_RESIZE_OFF);
                tableServicios.setAutoResizeMode(tableServicios.AUTO_RESIZE_OFF);
                tablePago.setAutoResizeMode(tablePago.AUTO_RESIZE_OFF);
tableProductos.doLayout();
tableServicios.doLayout();
tablePago.doLayout();

        modelPagos=(DefaultTableModel)tablePago.getModel();
        modelProductos=(DefaultTableModel)tableProductos.getModel();
        modelServicios=(DefaultTableModel)tableServicios.getModel();
        tablePago.setModel(modelPagos);
        tableProductos.setModel(modelProductos);
        tableServicios.setModel(modelServicios);
                 txtFactura.setEditable(false); 
                 sale_inventory=new ArrayList<Sale_Inventory>();
                  sale_services=new ArrayList<Sale_Service>();
                   pagos=new ArrayList<Income>();
                   
                     
    }
      Conexion con;
     DecimalFormat formatea;
    double MontoTotal;
    double MontoPagado;
    List<Income> pagos;
    List<Sale_Inventory> sale_inventory;
    List<Sale_Service> sale_services;
    List<Sale_Inventory> sale_inventory2;
    List<Sale_Service> sale_services2;
List<Client> clientes;
List<Service_Type> service_type;
List<Inventory_Type> inventory_type;
List<Account> accounts;
Client client;
@SuppressWarnings("rawtypes")
Vector vectorCliente = new Vector();
Vector vectorProducto = new Vector();
Vector vectorServicio = new Vector();
Vector vectorCuenta = new Vector();
 private DefaultTableModel modelPagos;
 private DefaultTableModel modelProductos;
 private DefaultTableModel modelServicios;
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel3 = new java.awt.Panel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePago = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        btnEliminarPago = new javax.swing.JButton();
        cbxCuenta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMontoPago = new javax.swing.JTextField();
        checkFactura = new javax.swing.JCheckBox();
        txtMontoTotal = new javax.swing.JTextField();
        btnAddPago = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dtDate = new com.toedter.calendar.JDateChooser();
        btnTerminar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnAddCliente = new javax.swing.JButton();
        txtVenta = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        panel4 = new java.awt.Panel();
        cbxServicio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAddServicios = new javax.swing.JButton();
        txtMontoServicio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableServicios = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnEliminarServicios = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        panel5 = new java.awt.Panel();
        cbxProducto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nupCantidad = new javax.swing.JSpinner();
        txtMontoProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAddInsumos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        btnEliminarProductos = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva venta");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        tablePago.setBackground(new java.awt.Color(245, 245, 245));
        tablePago.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        tablePago.setForeground(new java.awt.Color(0, 0, 0));
        tablePago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Cuenta", "Monto sin IVA", "Factura", "IVA", "Monto ", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePago.setColumnSelectionAllowed(true);
        tablePago.setGridColor(new java.awt.Color(153, 153, 153));
        tablePago.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tablePago.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablePago.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablePago);
        tablePago.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablePago.getColumnModel().getColumnCount() > 0) {
            tablePago.getColumnModel().getColumn(0).setMinWidth(0);
            tablePago.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablePago.getColumnModel().getColumn(0).setMaxWidth(0);
            tablePago.getColumnModel().getColumn(6).setMinWidth(0);
            tablePago.getColumnModel().getColumn(6).setPreferredWidth(0);
            tablePago.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jToolBar3.setRollover(true);

        btnEliminarPago.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        btnEliminarPago.setText("Eliminar");
        btnEliminarPago.setFocusable(false);
        btnEliminarPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarPago.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPagoActionPerformed(evt);
            }
        });
        jToolBar3.add(btnEliminarPago);

        cbxCuenta.setBackground(new java.awt.Color(255, 248, 245));
        cbxCuenta.setEditable(true);
        cbxCuenta.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        cbxCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cuenta");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Monto del pago");

        txtMontoPago.setBackground(new java.awt.Color(245, 245, 245));
        txtMontoPago.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtMontoPago.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtMontoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoPagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoPagoKeyReleased(evt);
            }
        });

        checkFactura.setBackground(new java.awt.Color(255, 255, 255));
        checkFactura.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        checkFactura.setForeground(new java.awt.Color(102, 102, 102));
        checkFactura.setText("Factura");
        checkFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFacturaActionPerformed(evt);
            }
        });

        txtMontoTotal.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtMontoTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));

        btnAddPago.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        btnAddPago.setText("Agregar");
        btnAddPago.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnAddPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPagoActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(55, 55, 55));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Forma de pago");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Monto total a pagar");
        jLabel16.setToolTipText("");

        txtSaldo.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtSaldo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Saldo");
        jLabel17.setToolTipText("");

        txtFactura.setBackground(new java.awt.Color(245, 245, 245));
        txtFactura.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtFactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacturaKeyPressed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Factura");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMontoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddPago, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(399, 399, 399)
                                .addComponent(checkFactura))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAddPago, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        txtComentarios.setBackground(new java.awt.Color(245, 245, 245));
        txtComentarios.setColumns(20);
        txtComentarios.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtComentarios.setRows(5);
        txtComentarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jScrollPane1.setViewportView(txtComentarios);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Comentario");

        cbxCliente.setBackground(new java.awt.Color(245, 245, 245));
        cbxCliente.setEditable(true);
        cbxCliente.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        cbxCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Cliente");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Fecha");

        dtDate.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N

        btnTerminar.setBackground(new java.awt.Color(255, 255, 255));
        btnTerminar.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        btnTerminar.setForeground(new java.awt.Color(51, 51, 51));
        btnTerminar.setText("Terminar venta");
        btnTerminar.setToolTipText("");
        btnTerminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(217, 234, 220));
        jLabel12.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(55, 55, 55));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Información básica");

        btnAddCliente.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        btnAddCliente.setText("...");
        btnAddCliente.setToolTipText("");
        btnAddCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        txtVenta.setBackground(new java.awt.Color(245, 245, 245));
        txtVenta.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtVenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVentaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVentaKeyReleased(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Venta");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panel4.setBackground(new java.awt.Color(255, 255, 255));

        cbxServicio.setBackground(new java.awt.Color(245, 245, 245));
        cbxServicio.setEditable(true);
        cbxServicio.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        cbxServicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        cbxServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicioActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Categoría");

        btnAddServicios.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        btnAddServicios.setText("Agregar");
        btnAddServicios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnAddServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiciosActionPerformed(evt);
            }
        });

        txtMontoServicio.setBackground(new java.awt.Color(245, 245, 245));
        txtMontoServicio.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtMontoServicio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtMontoServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoServicioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoServicioKeyReleased(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Monto");

        tableServicios.setBackground(new java.awt.Color(245, 245, 245));
        tableServicios.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        tableServicios.setForeground(new java.awt.Color(0, 0, 0));
        tableServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Servicio", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableServicios.setColumnSelectionAllowed(true);
        tableServicios.setGridColor(new java.awt.Color(153, 153, 153));
        tableServicios.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tableServicios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableServicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableServicios);
        tableServicios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableServicios.getColumnModel().getColumnCount() > 0) {
            tableServicios.getColumnModel().getColumn(0).setMinWidth(0);
            tableServicios.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableServicios.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jToolBar1.setRollover(true);

        btnEliminarServicios.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        btnEliminarServicios.setText("Eliminar");
        btnEliminarServicios.setFocusable(false);
        btnEliminarServicios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarServicios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServiciosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminarServicios);

        jLabel15.setBackground(new java.awt.Color(217, 234, 220));
        jLabel15.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(55, 55, 55));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Costos extra");
        jLabel15.setToolTipText("");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(txtMontoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123))
                            .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panel5.setBackground(new java.awt.Color(255, 255, 255));

        cbxProducto.setBackground(new java.awt.Color(245, 245, 245));
        cbxProducto.setEditable(true);
        cbxProducto.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        cbxProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        cbxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoActionPerformed(evt);
            }
        });
        cbxProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxProductoKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Producto");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Cantidad");

        nupCantidad.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        nupCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        nupCantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        nupCantidad.setMinimumSize(new java.awt.Dimension(270, 0));
        nupCantidad.setName(""); // NOI18N
        nupCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nupCantidadStateChanged(evt);
            }
        });

        txtMontoProducto.setBackground(new java.awt.Color(245, 245, 245));
        txtMontoProducto.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        txtMontoProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtMontoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoProductoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoProductoKeyReleased(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Monto");

        btnAddInsumos.setFont(new java.awt.Font("InaiMathi", 0, 16)); // NOI18N
        btnAddInsumos.setText("Agregar");
        btnAddInsumos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        btnAddInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsumosActionPerformed(evt);
            }
        });

        tableProductos.setBackground(new java.awt.Color(245, 245, 245));
        tableProductos.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        tableProductos.setForeground(new java.awt.Color(0, 0, 0));
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Productos", "Cantidad", "Monto "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableProductos.setColumnSelectionAllowed(true);
        tableProductos.setGridColor(new java.awt.Color(153, 153, 153));
        tableProductos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableProductos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableProductos);
        tableProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableProductos.getColumnModel().getColumnCount() > 0) {
            tableProductos.getColumnModel().getColumn(0).setMinWidth(0);
            tableProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jToolBar2.setRollover(true);

        btnEliminarProductos.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        btnEliminarProductos.setText("Eliminar");
        btnEliminarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductosActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEliminarProductos);

        jLabel14.setBackground(new java.awt.Color(217, 234, 220));
        jLabel14.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(55, 55, 55));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Productos");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nupCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMontoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(164, 164, 164))
                            .addComponent(btnAddInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nupCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAddInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsumosActionPerformed
        try{
            if(txtMontoProducto.getText().length()<1){
                return;
            }
    Inventory_Type producto = inventory_type.stream()
  .filter(obj -> cbxProducto.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
//               int a = tableProductos.getRowCount()-1;
//               int contador=0;
//        for (int i = a; i >= 0; i--) {  
//            if(Integer.parseInt(tableProductos.getValueAt(i, 0).toString())==producto.Id){
//                contador+=Integer.parseInt(tableProductos.getValueAt(i, 2).toString());
//            }
//        } 
//    if(Integer.parseInt(nupCantidad.getValue().toString())<=(producto.PuntoVentaStock)-contador)
//    {
        sale_inventory.add(new Sale_Inventory(producto.Id,Integer.parseInt(nupCantidad.getValue().toString()),MontoProduct,0));
        modelProductos.addRow(new Object[]{producto.Id,producto.Description,Integer.parseInt(nupCantidad.getValue().toString()),formatea.format(MontoProduct)});
    
     MontoTotal+=MontoProduct;
     MontoProduct=0;
      txtMontoProducto.setText(null);
      
                txtMontoTotal.setText(  formatea.format(MontoTotal));
                txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));
                 
//    }else{
//         JOptionPane.showMessageDialog(this,"Inventario insuficiente en punto de venta .");
//    }
       }catch(Exception e){
       return;}finally{}
    }//GEN-LAST:event_btnAddInsumosActionPerformed

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        Save.status2=0;
        AddClient form=new AddClient();
        form.setModal(true);
        form.setVisible(true);
                 con=new Conexion();
        con.Conectar();
          try {
        clientes=con.GetClients();
             } catch (SQLException ex) {}     
        con.Desconectar();   
        vectorCliente.removeAllElements();
         for(Client obj : clientes){
        vectorCliente.add(obj.Description);
        }
        cbxCliente.setModel(new DefaultComboBoxModel(vectorCliente));		
JTextField text = (JTextField)cbxCliente.getEditor().getEditorComponent();
		text.setFocusable(true);
		text.setText("");
		text.addKeyListener(new ComboListener(cbxCliente,vectorCliente));
                
    }//GEN-LAST:event_btnAddClienteActionPerformed
double MontoService;
double MontoProduct;
double MontoPago;
    private void txtMontoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoProductoKeyPressed
        
    }//GEN-LAST:event_txtMontoProductoKeyPressed

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
   try{
         modelPagos=(DefaultTableModel)tablePago.getModel();
     
       int fila = tablePago.getSelectedRow();
        if (fila >= 0) {
           int []filasselec  = tablePago.getSelectedRows();
           MontoPagado-=pagos.get(filasselec[0]).Amount;
                txtMontoTotal.setText(  formatea.format(MontoTotal));
                txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));
               pagos.remove(filasselec[0]);  
    modelPagos.removeRow(filasselec[0]);
        } else {
            JOptionPane.showMessageDialog(this, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
     }
catch(Exception e){}finally{}
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnEliminarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductosActionPerformed
     try{
         modelProductos=(DefaultTableModel)tableProductos.getModel();
     
       int fila = tableProductos.getSelectedRow();
        if (fila >= 0) {
           int []filasselec  = tableProductos.getSelectedRows();
            MontoTotal-=sale_inventory.get(filasselec[0]).Amount;
                txtMontoTotal.setText(  formatea.format(MontoTotal));
                txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));
              sale_inventory.remove(filasselec[0]);
              modelProductos.removeRow(filasselec[0]);
 
        } else {
            JOptionPane.showMessageDialog(this, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
     }
catch(Exception e){}finally{}
    }//GEN-LAST:event_btnEliminarProductosActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        try{   
    Client cliente = clientes.stream()
  .filter(obj -> cbxCliente.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
    
   int clienteid= cliente.Id;
    if(txtVenta.getText().length()<2){
        return;
    }
    int n = JOptionPane.showConfirmDialog(this,
"¿Desea guardar esta venta? ","",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
      con=new Conexion();
        con.Conectar();   
        Sale sale=new Sale(0,dtDate.getDate(),txtVenta.getText(),clienteid,txtComentarios.getText(),MontoTotal,0);
        try{
        con.AddSale(sale, sale_inventory, sale_services,pagos);
             } catch (SQLException ex) {}  
        con.Desconectar();

        JOptionPane.showMessageDialog(this,"Venta agregada con éxito.");
           Interfaz.NuevaVentaBool=false;
        this.dispose();
   
   }       
        } catch (NumberFormatException e) {}finally{}
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void txtMontoPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoPagoKeyPressed

    }//GEN-LAST:event_txtMontoPagoKeyPressed

    private void btnAddPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPagoActionPerformed
         try{
            if(txtMontoPago.getText().length()<1){
                return;
            }
    Account account = accounts.stream()
  .filter(obj -> cbxCuenta.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
     int fact=0;
     double siniva=MontoPago;
     if(checkFactura.isSelected()){
         fact=1;
         siniva=MontoPago/1.16;
     }
        pagos.add(new Income(account.Id,fact,txtFactura.getText(),MontoPago));
        modelPagos.addRow(new Object[]{account.Id,account.Description,formatea.format(siniva),txtFactura.getText(),checkFactura.isSelected(),formatea.format(MontoPago)});
      MontoPagado+=MontoPago;
        MontoPago=0;
    txtMontoPago.setText(null);
    
                txtMontoTotal.setText(  formatea.format(MontoTotal));
                txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));
                  
       }catch(Exception e){
       return;}finally{}
    }//GEN-LAST:event_btnAddPagoActionPerformed

    private void txtFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaKeyPressed

    private void checkFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFacturaActionPerformed
       if(checkFactura.isSelected()){
           txtFactura.setEditable(true);
       }else{
                txtFactura.setEditable(false); 
                txtFactura.setText(null);
       }
    }//GEN-LAST:event_checkFacturaActionPerformed

    private void txtMontoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoProductoKeyTyped
  
    }//GEN-LAST:event_txtMontoProductoKeyTyped

    private void txtMontoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoProductoKeyReleased
         try {
                MontoProduct = Double.parseDouble(txtMontoProducto.getText());
            } catch (NumberFormatException e) {
                MontoProduct = 0;
                txtMontoProducto.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoProductoKeyReleased

    private void txtMontoPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoPagoKeyReleased
          try {
                MontoPago = Double.parseDouble(txtMontoPago.getText());
            } catch (NumberFormatException e) {
                MontoPago = 0;
                txtMontoPago.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoPagoKeyReleased

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed
      try {
                 Inventory_Type producto = inventory_type.stream()
  .filter(obj -> cbxProducto.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                  MontoProduct=producto.Price*Double.parseDouble(nupCantidad.getValue().toString()); 
                 txtMontoProducto.setText(String.valueOf(MontoProduct));
               
            } catch (Exception e) {

            }finally{}
    }//GEN-LAST:event_cbxProductoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       Interfaz.NuevaVentaBool=false;
    }//GEN-LAST:event_formWindowClosing

    private void cbxProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxProductoKeyPressed
    
    }//GEN-LAST:event_cbxProductoKeyPressed

    private void btnEliminarServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServiciosActionPerformed

        try{
            modelServicios=(DefaultTableModel)tableServicios.getModel();

            int fila = tableServicios.getSelectedRow();
            if (fila >= 0) {
                int []filasselec  = tableServicios.getSelectedRows();
                MontoTotal-=sale_services.get(filasselec[0]).Amount;
                txtMontoTotal.setText(  formatea.format(MontoTotal));
                txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));
                sale_services.remove(filasselec[0]);

                modelServicios.removeRow(filasselec[0]);
            } else {
                JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){}finally{}
    }//GEN-LAST:event_btnEliminarServiciosActionPerformed

    private void txtMontoServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoServicioKeyReleased
        try {
            MontoService = Double.parseDouble(txtMontoServicio.getText());
        } catch (NumberFormatException e) {
            MontoService = 0;
            txtMontoServicio.setText(null);
        }finally{}
    }//GEN-LAST:event_txtMontoServicioKeyReleased

    private void txtMontoServicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoServicioKeyPressed

    }//GEN-LAST:event_txtMontoServicioKeyPressed

    private void btnAddServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiciosActionPerformed
        try{
            if(txtMontoServicio.getText().length()<1){
                return;
            }
            Service_Type service = service_type.stream()
            .filter(obj -> cbxServicio.getSelectedItem().toString().equals(obj.Description))
            .findAny()
            .orElse(null);

            sale_services.add(new Sale_Service(service.Id,MontoService));
            modelServicios.addRow(new Object[]{service.Id,service.Description,formatea.format(MontoService)});
            MontoTotal+=MontoService;
            MontoService=0;
            txtMontoServicio.setText(null);

            txtMontoTotal.setText(  formatea.format(MontoTotal));
            txtSaldo.setText(  formatea.format(MontoTotal-MontoPagado));

        }catch(Exception e){
            return;}finally{}
    }//GEN-LAST:event_btnAddServiciosActionPerformed

    private void cbxServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicioActionPerformed
        try {
            Service_Type producto = service_type.stream()
            .filter(obj -> cbxServicio.getSelectedItem().toString().equals(obj.Description))
            .findAny()
            .orElse(null);
            MontoService=producto.Price;

            txtMontoServicio.setText(""+MontoService);
        } catch (Exception e) {

        }finally{}
    }//GEN-LAST:event_cbxServicioActionPerformed

    private void txtVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentaKeyTyped

    private void txtVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentaKeyPressed

    private void txtVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVentaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentaKeyReleased

    private void nupCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nupCantidadStateChanged
               try {
                      Inventory_Type producto = inventory_type.stream()
  .filter(obj -> cbxProducto.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                MontoProduct = Double.parseDouble(nupCantidad.getValue().toString())*producto.Price;
                      txtMontoProducto.setText(MontoProduct+"");
            } catch (NumberFormatException e) {
                MontoProduct = 0;
                txtMontoProducto.setText(null);
            }finally{}
    }//GEN-LAST:event_nupCantidadStateChanged

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
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddInsumos;
    private javax.swing.JButton btnAddPago;
    private javax.swing.JButton btnAddServicios;
    private javax.swing.JButton btnEliminarPago;
    private javax.swing.JButton btnEliminarProductos;
    private javax.swing.JButton btnEliminarServicios;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxCuenta;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JComboBox<String> cbxServicio;
    private javax.swing.JCheckBox checkFactura;
    private com.toedter.calendar.JDateChooser dtDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JSpinner nupCantidad;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Panel panel5;
    private javax.swing.JTable tablePago;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTable tableServicios;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtMontoPago;
    private javax.swing.JTextField txtMontoProducto;
    private javax.swing.JTextField txtMontoServicio;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtVenta;
    // End of variables declaration//GEN-END:variables
}
