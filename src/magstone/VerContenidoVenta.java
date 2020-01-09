/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstone;

import Classes.Account;
import Classes.Client;
import Classes.ComboListener;
import Classes.Income;
import Classes.Inventory_Type;
import Classes.Sale;
import Classes.Sale_Inventory;
import Classes.Sale_Service;
import Classes.Save;
import Classes.Service_Type;
import Conexion.Conexion;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
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
public class VerContenidoVenta extends javax.swing.JDialog {

    /**
     * Creates new form VerContenidoVenta
     */
    public VerContenidoVenta() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEliminarServicio.setIcon(fondo1);
        btnEliminar.setIcon(fondo1);
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("Images/Agregar.png"));
        Icon fondo3 = new ImageIcon(imagen3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEntregar.setIcon(fondo3);
        
        con = new Conexion();
        con.Conectar();
        try {

            client = con.GetClientById2(Save.Sale2.Client_Id);
            sale_inventory = con.GetSaleInventoryBySale(Save.Sale2.Id);
            sale_services = con.GetSaleServicesBySale(Save.Sale2.Id);
            clientes = con.GetClients();
            inventory_type=con.GetInventoryTypes();
        } catch (SQLException ex) {
        }
        con.Desconectar();

        for (Client obj : clientes) {
            vectorCliente.add(obj.Description);
        }
        cbxCliente.setModel(new DefaultComboBoxModel(vectorCliente));
        JTextField text = (JTextField) cbxCliente.getEditor().getEditorComponent();
        text.setFocusable(true);
        text.setText("");
        text.addKeyListener(new ComboListener(cbxCliente, vectorCliente));

        dtDate.setDate(Save.Sale2.Date);
        
        int i=0;
        for(Client obj : clientes){
        if(obj.Id==Save.Sale2.Client_Id)
        {
            break;
        }
        i++;
        }
        cbxCliente.setSelectedIndex(i);
        txtComentarios.setText(Save.Sale2.Comentario);
        txtVentas.setText(Save.Sale2.Description);
          formatea = new DecimalFormat("$###,###.##");
   MontoTotal=0;
   MontoServicios=0;
   MontoProductos=0;
        tableProductos.setAutoResizeMode(tableProductos.AUTO_RESIZE_OFF);
        tableServicios.setAutoResizeMode(tableServicios.AUTO_RESIZE_OFF);
        tableProductos.doLayout();
        tableServicios.doLayout();
        modelProductos = (DefaultTableModel) tableProductos.getModel();
        modelServicios = (DefaultTableModel) tableServicios.getModel();
        tableProductos.setModel(modelProductos);
        tableServicios.setModel(modelServicios);
        tableServicios.getColumnModel().getColumn(2).setCellRenderer(new CurrencyCellRenderer());
        tableProductos.getColumnModel().getColumn(3).setCellRenderer(new CurrencyCellRenderer());
        for(Sale_Service obj :sale_services){
        modelServicios.addRow(new Object[]{obj.Id,obj.Service,obj.Amount});
        MontoTotal+=obj.Amount;
        MontoServicios+=obj.Amount;
        }
    txtMontoServicios.setText(formatea.format(MontoServicios));
     for(Sale_Inventory obj :sale_inventory){
     modelProductos.addRow(new Object[]{obj.Id,obj.Inventory,obj.Qty,obj.Amount,obj.Entregado()});
     MontoTotal+=obj.Amount;
     MontoProductos+=obj.Amount;
     }
    txtMontoProductos.setText(formatea.format(MontoProductos));
           txtMontoTotal.setText(formatea.format(MontoTotal));
    }

    Conexion con;
    DecimalFormat formatea;
    double MontoTotal;
    double MontoProductos;
    double MontoServicios;
    List<Income> pagos;
    List<Sale_Inventory> sale_inventory;
    List<Sale_Service> sale_services;

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

        MenuProductos = new javax.swing.JPopupMenu();
        btnEntregar = new javax.swing.JMenuItem();
        btnEliminar = new javax.swing.JMenuItem();
        MenuServicios = new javax.swing.JPopupMenu();
        btnEliminarServicio = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        panel4 = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableServicios = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregarServicio = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        panel5 = new java.awt.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
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
        txtVentas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        txtMontoServicios = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMontoProductos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel6 = new javax.swing.JLabel();

        btnEntregar.setText("Marcar entregado");
        btnEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarActionPerformed(evt);
            }
        });
        MenuProductos.add(btnEntregar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        MenuProductos.add(btnEliminar);

        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });
        MenuServicios.add(btnEliminarServicio);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contenido de la venta");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        panel4.setBackground(new java.awt.Color(255, 255, 255));

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
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableServicios.setGridColor(new java.awt.Color(153, 153, 153));
        tableServicios.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableServicios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableServicios.getTableHeader().setReorderingAllowed(false);
        tableServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableServiciosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableServicios);

        jToolBar1.setRollover(true);

        btnAgregarServicio.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        btnAgregarServicio.setText("Agregar servicio");
        btnAgregarServicio.setToolTipText("");
        btnAgregarServicio.setFocusable(false);
        btnAgregarServicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarServicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregarServicio);

        jLabel15.setBackground(new java.awt.Color(217, 234, 220));
        jLabel15.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(55, 55, 55));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Costos extra");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        panel5.setBackground(new java.awt.Color(255, 255, 255));

        tableProductos.setBackground(new java.awt.Color(245, 245, 245));
        tableProductos.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        tableProductos.setForeground(new java.awt.Color(0, 0, 0));
        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Productos", "Cantidad", "Monto ", "Entregado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductos.setColumnSelectionAllowed(true);
        tableProductos.setGridColor(new java.awt.Color(153, 153, 153));
        tableProductos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableProductos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableProductos.getTableHeader().setReorderingAllowed(false);
        tableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableProductosMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tableProductos);
        tableProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jToolBar2.setRollover(true);

        btnAgregarProducto.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAgregarProducto);

        jLabel14.setBackground(new java.awt.Color(217, 234, 220));
        jLabel14.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(55, 55, 55));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Productos");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        txtComentarios.setBackground(new java.awt.Color(245, 245, 245));
        txtComentarios.setColumns(20);
        txtComentarios.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtComentarios.setRows(5);
        jScrollPane1.setViewportView(txtComentarios);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Comentario");

        cbxCliente.setBackground(new java.awt.Color(245, 245, 245));
        cbxCliente.setEditable(true);
        cbxCliente.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Cliente");

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Fecha");

        dtDate.setBackground(new java.awt.Color(245, 245, 245));

        btnTerminar.setBackground(new java.awt.Color(255, 255, 255));
        btnTerminar.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        btnTerminar.setForeground(new java.awt.Color(51, 51, 51));
        btnTerminar.setText("Guardar");
        btnTerminar.setToolTipText("");
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

        txtVentas.setBackground(new java.awt.Color(245, 245, 245));
        txtVentas.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Total de productos");
        jLabel19.setToolTipText("");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVentas)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(dtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N

        txtMontoServicios.setEditable(false);
        txtMontoServicios.setBackground(new java.awt.Color(245, 245, 245));
        txtMontoServicios.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N

        jLabel13.setBackground(new java.awt.Color(217, 234, 220));
        jLabel13.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(55, 55, 55));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Desglose ecónomico");

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Total de servicios");
        jLabel16.setToolTipText("");

        txtMontoProductos.setEditable(false);
        txtMontoProductos.setBackground(new java.awt.Color(245, 245, 245));
        txtMontoProductos.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N

        jLabel17.setBackground(new java.awt.Color(102, 102, 102));
        jLabel17.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Total de productos");
        jLabel17.setToolTipText("");

        txtMontoTotal.setEditable(false);
        txtMontoTotal.setBackground(new java.awt.Color(245, 245, 245));
        txtMontoTotal.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N

        jLabel18.setBackground(new java.awt.Color(102, 102, 102));
        jLabel18.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Monto total de la venta");
        jLabel18.setToolTipText("");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(49, 49, 49)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("InaiMathi", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Contenido de la venta");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
       try{
           AddSaleService form = new AddSaleService();
        form.setModal(true);
        form.setVisible(true);
    modelServicios=(DefaultTableModel)tableServicios.getModel(); 
    int count= modelServicios.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelServicios.removeRow(0);   
        }
            con = new Conexion();
        con.Conectar();
        try {
           sale_services = con.GetSaleServicesBySale(Save.Sale2.Id);
       
        } catch (SQLException ex) {
        }
        con.Desconectar();
         MontoTotal-=MontoServicios;
     MontoServicios=0;
          for(Sale_Service obj :sale_services){
     modelServicios.addRow(new Object[]{obj.Id,obj.Service,obj.Amount});
     MontoServicios+=obj.Amount;
     }
    txtMontoServicios.setText(formatea.format(MontoServicios));
    MontoTotal+=MontoServicios;
   txtMontoTotal.setText(formatea.format(MontoTotal));
   
        }catch(Exception e){}
    }//GEN-LAST:event_btnAgregarServicioActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        try{
        AddSaleProduct form = new AddSaleProduct();
        form.setModal(true);
        form.setVisible(true);
         modelProductos=(DefaultTableModel)tableProductos.getModel(); 
    int count= modelProductos.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelProductos.removeRow(0);   
        }
            con = new Conexion();
        con.Conectar();
        try {
         sale_inventory = con.GetSaleInventoryBySale(Save.Sale2.Id);
        } catch (SQLException ex) {
        }
        con.Desconectar();
         MontoTotal-=MontoProductos;
     MontoProductos=0;
          for(Sale_Inventory obj :sale_inventory){
     modelProductos.addRow(new Object[]{obj.Id,obj.Inventory,obj.Qty,obj.Amount,obj.Entregado()});
     MontoProductos+=obj.Amount;
     }
    txtMontoProductos.setText(formatea.format(MontoProductos));
    MontoTotal+=MontoProductos;
   txtMontoTotal.setText(formatea.format(MontoTotal));
   
        }catch(Exception e){}
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        try {
            Client cliente = clientes.stream()
                    .filter(obj -> cbxCliente.getSelectedItem().toString().equals(obj.Description))
                    .findAny()
                    .orElse(null);

            int clienteid = cliente.Id;

            int n = JOptionPane.showConfirmDialog(this,
                    "¿Desea guardar los cambios realizados de esta venta? ", "Confirmación",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                con = new Conexion();
                con.Conectar();
                Sale sale = new Sale(Save.Sale2.Id,dtDate.getDate(),txtVentas.getText(), clienteid, txtComentarios.getText(), MontoTotal,0);
                try {
                    con.UpdateSale(sale);
                } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(this, "Error");
                }
                con.Desconectar();

                JOptionPane.showMessageDialog(this, "Venta modificada con éxito.");
                   Interfaz.VerContenidoVentaBool=false;
                this.dispose();

            }
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
             int n = JOptionPane.showConfirmDialog(this,
                    "¿Desea eliminar productos de la venta?, si ya están terminados se regresarán al inventario. ", "Confirmación",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
            modelProductos = (DefaultTableModel) tableProductos.getModel();

            int fila = tableProductos.getSelectedRow();
            if (fila >= 0) {
                int[] filasselec = tableProductos.getSelectedRows();
                MontoTotal -= sale_inventory.get(filasselec[0]).Amount;
                MontoProductos -= sale_inventory.get(filasselec[0]).Amount;
                txtMontoProductos.setText(formatea.format(MontoProductos));
                txtMontoTotal.setText(formatea.format(MontoTotal));
                con = new Conexion();
                con.Conectar();
                try {
                    con.DeleteSaleInventory(sale_inventory.get(tableProductos.getSelectedRow()).Id,sale_inventory.get(tableProductos.getSelectedRow()).Status_Id,Save.Sale2.Id);
                      inventory_type=con.GetInventoryTypes();
                } catch (SQLException ex) {
                }
                con.Desconectar();
                sale_inventory.remove(filasselec[0]);
                modelProductos.removeRow(filasselec[0]);
                JOptionPane.showMessageDialog(this,"Inventario actualizado con éxito.");
             
            } else {
                JOptionPane.showMessageDialog(this, "No seleccionó ningun producto", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        try {
            modelServicios = (DefaultTableModel) tableServicios.getModel();

            int fila = tableServicios.getSelectedRow();
            if (fila >= 0) {
                int[] filasselec = tableServicios.getSelectedRows();
                MontoTotal -= sale_services.get(filasselec[0]).Amount;
                MontoServicios -= sale_services.get(filasselec[0]).Amount;
                txtMontoServicios.setText(formatea.format(MontoServicios));
                txtMontoTotal.setText(formatea.format(MontoTotal));
                con = new Conexion();
                con.Conectar();
                try {
                    con.DeleteSaleService(sale_services.get(tableServicios.getSelectedRow()).Id);
                } catch (SQLException ex) {
                }
                con.Desconectar();
                sale_services.remove(filasselec[0]);

                modelServicios.removeRow(filasselec[0]);
                    JOptionPane.showMessageDialog(this,"Eliminado con éxito.");
             
            } else {
                JOptionPane.showMessageDialog(this, "No seleccionó ningun servicio", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Interfaz.VerContenidoVentaBool=false;
    }//GEN-LAST:event_formWindowClosing

    private void tableProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductosMouseReleased
            
   if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
           MenuProductos.show(tableProductos, evt.getX(), evt.getY());
           }
    }//GEN-LAST:event_tableProductosMouseReleased

    private void tableServiciosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServiciosMouseReleased
       if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
           MenuServicios.show(tableServicios, evt.getX(), evt.getY());
           }
    }//GEN-LAST:event_tableServiciosMouseReleased

    private void btnEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarActionPerformed
       try{
           if(Boolean.parseBoolean(tableProductos.getValueAt(tableProductos.getSelectedRow(), 4).toString())){
               return;
           }
           int n = JOptionPane.showConfirmDialog(this, "¿Marcar este producto cómo entregado?, se descontará del inventario actual. ", "Confirmación de entrega",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
            Inventory_Type producto = inventory_type.stream()
            .filter(obj -> tableProductos.getValueAt(tableProductos.getSelectedRow(), 1).toString().equals(obj.Description))        
            .findAny()
            .orElse(null);

            if(Integer.parseInt(tableProductos.getValueAt(tableProductos.getSelectedRow(), 2).toString())<=(producto.TotalStock)||producto.Id==1||producto.Id==2||producto.Id==10)
           {
                try{
                con=new Conexion();
                con.Conectar();
              con.EntregarSaleInventory(new Sale_Inventory(Integer.parseInt(tableProductos.getValueAt(tableProductos.getSelectedRow(), 0).toString()),producto.Id,Save.Sale2.Id,Integer.parseInt(tableProductos.getValueAt(tableProductos.getSelectedRow(), 2).toString()),0,0));
              sale_inventory = con.GetSaleInventoryBySale(Save.Sale2.Id);
              inventory_type=con.GetInventoryTypes();
              con.Desconectar();}catch (SQLException ex) {}     
                tableProductos.setValueAt(true,tableProductos.getSelectedRow(), 4);
              tableProductos.setValueAt(true,tableProductos.getSelectedRow(), 4);
              sale_inventory.get(tableProductos.getSelectedRow()).Status_Id=1;
              
                   JOptionPane.showMessageDialog(this,"Inventario actualizado con éxito.");
              
            }else{
                JOptionPane.showMessageDialog(this,"Inventario insuficiente .","Inventario insuficiente",JOptionPane.ERROR_MESSAGE);
            }}
        }catch(Exception e){
               JOptionPane.showMessageDialog(this,"Error de carga de info.","Error",JOptionPane.ERROR_MESSAGE);
       }finally{}
    }//GEN-LAST:event_btnEntregarActionPerformed

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
            java.util.logging.Logger.getLogger(VerContenidoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerContenidoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerContenidoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerContenidoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerContenidoVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuProductos;
    private javax.swing.JPopupMenu MenuServicios;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JMenuItem btnEliminar;
    private javax.swing.JMenuItem btnEliminarServicio;
    private javax.swing.JMenuItem btnEntregar;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JComboBox<String> cbxCliente;
    private com.toedter.calendar.JDateChooser dtDate;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Panel panel5;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTable tableServicios;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtMontoProductos;
    private javax.swing.JTextField txtMontoServicios;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
