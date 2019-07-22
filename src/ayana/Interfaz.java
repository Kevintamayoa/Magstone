package ayana;


import Adicional.FixedRowExample;
import Adicional.FixedRowExample2;
import Classes.Account;
import Classes.ComboListener;
import Classes.*;
import Classes.Income;
import Classes.Income_Type;
import Classes.Sale;
import Classes.Save;
import Conexion.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author macbook
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
        ImageIcon imagen00 = new ImageIcon(getClass().getResource("iconn.jpg"));
        Icon fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
        ImageLogo.setIcon(fondo00);
        imagen00 = new ImageIcon(getClass().getResource("Images/Ventas.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        btnVentas.setIcon(fondo00);
        if(Save.TemporalUser.Id==2){
            btnRentabilidadComercializadora.setVisible(false);
                  btnFlujoComercializadora.setVisible(false);
                   btnResumenVentas.setVisible(false);
                     jLabel47.setVisible(false);
                         jLabel21.setVisible(false);
                             jLabel29.setVisible(false);
        }
////inicia panel ventas
        pnlMov.setVisible(false);
        pnlVentas.setVisible(false);
        pnlInventarios.setVisible(false);
        pnlEmpresa.setVisible(false);
        ImageIcon imagen = new ImageIcon(getClass().getResource("Images/NewSale.png"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnNuevaVenta.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Recarga.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnActualizarVentas.setIcon(fondo);

        tableVentas.getTableHeader().setBackground(Color.white);
        tableVentas.getTableHeader().setForeground(Color.black);
        tableVentas.getTableHeader().setFont(new Font("InaiMathi", 0, 20));
        tableMovProducto.getTableHeader().setBackground(Color.white);
        tableMovProducto.getTableHeader().setForeground(Color.black);
        tableMovProducto.getTableHeader().setFont(new Font("InaiMathi", 0, 16));
        tablePedido.getTableHeader().setBackground(Color.white);
        tablePedido.getTableHeader().setForeground(Color.black);
        tablePedido.getTableHeader().setFont(new Font("InaiMathi", 0, 16));
        tableVentas.getColumnModel().getColumn(4).setCellRenderer(new CurrencyCellRenderer());
        tableVentas.getColumnModel().getColumn(1).setCellRenderer(new TimestampCellRenderer());
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tableVentas.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tableVentas.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tableVentas.getColumnModel().getColumn(3).setCellRenderer(tcr);

        ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEliminarVenta.setIcon(fondo1);
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("Images/Info.png"));
        Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnVerDetalle.setIcon(fondo2);
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("Images/Agregar.png"));
        Icon fondo3 = new ImageIcon(imagen3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnPagoVenta.setIcon(fondo3);
        imagen = new ImageIcon(getClass().getResource("Images/VerPagos.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnRegPagos.setIcon(fondo);
        ImageIcon imagen4 = new ImageIcon(getClass().getResource("Images/Buscar.png"));
        Icon fondo4 = new ImageIcon(imagen4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        lblBuscarVentas.setIcon(fondo4);
        //// terminar panel ventas     
        ////inicia panel inventarios
        imagen = new ImageIcon(getClass().getResource("Images/Inventario2.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        btnInventario.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Guardar.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnGuardarMovProducto.setIcon(fondo);
        btnCompraInsumosAdd.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        jButton6.setIcon(fondo);
        jButton4.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Pedidos.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnCompraInsumos.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Movimientos.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnMovimientoInsumos.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/VerPed.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnRegComprasInsumos.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/VerMov.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnRegInsumos.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Inventarioss.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnCompraInsumos3.setIcon(fondo);
        //// terminar panel inventarios     
        ////inicia panel empresa
        imagen = new ImageIcon(getClass().getResource("Images/Reporte3.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        btnEmpresa.setIcon(fondo);
        imagen00 = new ImageIcon(getClass().getResource("Images/Clientes.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        btnHistorialCliente.setIcon(fondo00);
        imagen00 = new ImageIcon(getClass().getResource("Images/Rentabilidad.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        btnRentabilidadComercializadora.setIcon(fondo00);
        imagen00 = new ImageIcon(getClass().getResource("Images/Imagen.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        btnCajas.setIcon(fondo00);
        imagen00 = new ImageIcon(getClass().getResource("Images/Flujo.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        btnFlujoComercializadora.setIcon(fondo00);
        imagen00 = new ImageIcon(getClass().getResource("Images/Proveedores.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        btnSaldoProveedores.setIcon(fondo00);
        imagen00 = new ImageIcon(getClass().getResource("Images/ReporteVentas.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
        btnResumenVentas.setIcon(fondo00);
        //// terminar panel empresa     
        ////inicia panel movimientos
        imagen00 = new ImageIcon(getClass().getResource("Images/Mov.png"));
        fondo00 = new ImageIcon(imagen00.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        btnMovimientos.setIcon(fondo00);
        imagen = new ImageIcon(getClass().getResource("Images/MovCajas.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnMovCajas.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Ingresos.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnIngresos.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Egresos.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnEgresos.setIcon(fondo);
        imagen = new ImageIcon(getClass().getResource("Images/Reportes.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        btnRegistros.setIcon(fondo);
           imagen = new ImageIcon(getClass().getResource("Images/Guardar.png"));
        fondo = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        btnCapturaEgresos.setIcon(fondo);
          btnCapturaIngresos.setIcon(fondo);
            btnCapturaMov.setIcon(fondo);
        //// terminar panel movimientos

        con = new Conexion();
        con.Conectar();
        try {
            incomes = con.GetIncomeTypes();
            accounts = con.GetAccounts2();
            expenses = con.GetExpenseTypes();
            clients = con.GetClients();
            providers = con.GetRegProviders();
            inventory_type = con.GetInventoryTypes2();
            sourcetype = con.GetSources();

        } catch (SQLException ex) {
        }finally{}
        con.Desconectar();
        for (Provider obj : providers) {
            vectorProvider.add(obj.Description);
        }
        cbxProveedorCompra.setModel(new DefaultComboBoxModel(vectorProvider));
        JTextField text0 = (JTextField) cbxProveedorCompra.getEditor().getEditorComponent();
        text0.setFocusable(true);
        text0.setText("");
        text0.addKeyListener(new ComboListener(cbxProveedorCompra, vectorProvider));

        for (Inventory_Type obj : inventory_type) {
            vectorProductoMov.add(obj.Description);
        }
        cbxProductoMovProducto.setModel(new DefaultComboBoxModel(vectorProductoMov));
        JTextField text = (JTextField) cbxProductoMovProducto.getEditor().getEditorComponent();
        text.setFocusable(true);
        text.setText("");
        text.addKeyListener(new ComboListener(cbxProductoMovProducto, vectorProductoMov));

        for (Income_Type obj : incomes) {
            vectorIngresos.add(obj.Description);
        }
        cbxCatIngresos.setModel(new DefaultComboBoxModel(vectorIngresos));
        JTextField text1 = (JTextField) cbxCatIngresos.getEditor().getEditorComponent();
        text1.setFocusable(true);
        text1.setText("");
        text1.addKeyListener(new ComboListener(cbxCatIngresos, vectorIngresos));

        for (Expense_Type obj : expenses) {
            vectorEgresos.add(obj.Description);
        }
        cbxCatEgresos.setModel(new DefaultComboBoxModel(vectorEgresos));
        JTextField text2 = (JTextField) cbxCatEgresos.getEditor().getEditorComponent();
        text2.setFocusable(true);
        text2.setText("");
        text2.addKeyListener(new ComboListener(cbxCatEgresos, vectorEgresos));

        for (SourceType obj : sourcetype) {
            if (obj.Id != 0) {
                cbxSourceSalida.addItem(obj.Description);
            }
            cbxSourceEntrada.addItem(obj.Description);
        }

        for (Account obj : accounts) {
            vectorCuentaIng.add(obj.Description);
            vectorCuentaEgr.add(obj.Description);
            vectorCuentaSalida.add(obj.Description);
            vectorCuentaEntrada.add(obj.Description);
            vectorCuentaCompra.add(obj.Description);
        }
        cbxCuentaIngresos.setModel(new DefaultComboBoxModel(vectorCuentaIng));
        JTextField text3 = (JTextField) cbxCuentaIngresos.getEditor().getEditorComponent();
        text3.setFocusable(true);
        text3.setText("");
        text3.addKeyListener(new ComboListener(cbxCuentaIngresos, vectorCuentaIng));
        cbxCuentaEgresos.setModel(new DefaultComboBoxModel(vectorCuentaEgr));
        JTextField text4 = (JTextField) cbxCuentaEgresos.getEditor().getEditorComponent();
        text4.setFocusable(true);
        text4.setText("");
        text4.addKeyListener(new ComboListener(cbxCuentaEgresos, vectorCuentaEgr));
        cbxCuentaSalida.setModel(new DefaultComboBoxModel(vectorCuentaSalida));
        JTextField text5 = (JTextField) cbxCuentaSalida.getEditor().getEditorComponent();
        text5.setFocusable(true);
        text5.setText("");
        text5.addKeyListener(new ComboListener(cbxCuentaSalida, vectorCuentaSalida));
        cbxCuentaEntrada.setModel(new DefaultComboBoxModel(vectorCuentaEntrada));
        JTextField text6 = (JTextField) cbxCuentaEntrada.getEditor().getEditorComponent();
        text6.setFocusable(true);
        text6.setText("");
        text6.addKeyListener(new ComboListener(cbxCuentaEntrada, vectorCuentaEntrada));
        cbxCuentaCompra.setModel(new DefaultComboBoxModel(vectorCuentaCompra));
        JTextField text30 = (JTextField) cbxCuentaCompra.getEditor().getEditorComponent();
        text30.setFocusable(true);
        text30.setText("");
        text30.addKeyListener(new ComboListener(cbxCuentaCompra, vectorCuentaCompra));

        dtCompraInsumos.getDateEditor().setEnabled(false);
        dtCompraInsumos.setDate(Date.valueOf(LocalDate.now()));
        dtMovProducto.getDateEditor().setEnabled(false);
        dtMovProducto.setDate(Date.valueOf(LocalDate.now()));
        dtMov.getDateEditor().setEnabled(false);
        dtMov.setDate(Date.valueOf(LocalDate.now()));
        dtEgresos.getDateEditor().setEnabled(false);
        dtEgresos.setDate(Date.valueOf(LocalDate.now()));
        dtIngresos.getDateEditor().setEnabled(false);
        dtIngresos.setDate(Date.valueOf(LocalDate.now()));
        formatea = new DecimalFormat("$###,###.##");
        txtFacturaIngresos.setEditable(false);
        txtFacturaEgresos.setEditable(false);
        MontoMov = 0;
        MontoIng = 0;
        MontoEgr = 0;
        MontoCompra = 0;
        MontoCompraPago = 0;
        listauxinv = new ArrayList<Inventory>();
        NuevaVentaBool=false;
         RegistroIngresosBool=false;
          RegistroEgresosBool=false;
           RegistroMovimientosBool=false;
            SaldoProveedoresBool=false;
             SaldoClientesBool=false;
              TotalCajasBool=false;
               InventariosBool=false;
                RegMovimientosInventariosBool=false;
                RegInventarioBool=false;
                VerContenidoVentaBool=false;
        }
public static boolean NuevaVentaBool;
public static boolean VerContenidoVentaBool;
public static boolean RegistroEgresosBool;
public static boolean RegistroIngresosBool;
public static boolean RegistroMovimientosBool;
public static boolean SaldoClientesBool;
public static boolean SaldoProveedoresBool;
public static boolean TotalCajasBool;
public static boolean InventariosBool;
public static boolean RegMovimientosInventariosBool;
public static boolean RegInventarioBool;
 TableRowSorter trs;
 public int opcionegreso;
 private DefaultTableModel model;
 private DefaultTableModel modelCompras;
  private DefaultTableModel modelMovimientos;
    public double MontoMov;  
    public double MontoIng;
    public double MontoEgr;
 List<Sale> Sales;
 List<Client> clients;
  List<Inventory_Type> inventory_type;
  List<Provider> providers;
  List<SourceType> sourcetype;
 DecimalFormat formatea;
@SuppressWarnings("rawtypes")
Vector vectorIngresos = new Vector();
Vector vectorEgresos = new Vector();
Vector vectorCuentaIng = new Vector();
Vector vectorCuentaEgr = new Vector();
Vector vectorCuentaEntrada = new Vector();
Vector vectorCuentaSalida = new Vector();
Vector vectorCuentaCompra= new Vector();
Vector vectorSourceSalida = new Vector();
Vector vectorSourceEntrada = new Vector();
Vector vectorProvider = new Vector();
Vector vectorProductoMov = new Vector();
Vector vectorProductoCompra = new Vector();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jMenuItem2 = new javax.swing.JMenuItem();
        MenuVentas = new javax.swing.JPopupMenu();
        btnVerDetalle = new javax.swing.JMenuItem();
        btnRegPagos = new javax.swing.JMenuItem();
        btnPagoVenta = new javax.swing.JMenuItem();
        btnEliminarVenta = new javax.swing.JMenuItem();
        MenuRentabilidad = new javax.swing.JPopupMenu();
        btnRentSpa = new javax.swing.JMenuItem();
        btnRentComercializadora = new javax.swing.JMenuItem();
        btnRentGrupo = new javax.swing.JMenuItem();
        MenuFlujo = new javax.swing.JPopupMenu();
        btnRentSpa1 = new javax.swing.JMenuItem();
        btnRentComercializadora1 = new javax.swing.JMenuItem();
        btnRentGrupo1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        ImageLogo = new javax.swing.JLabel();
        btnVentas = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnEmpresa = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pnlInventarios = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCompraInsumos = new javax.swing.JButton();
        btnMovimientoInsumos = new javax.swing.JButton();
        btnCompraInsumos3 = new javax.swing.JButton();
        btnRegInsumos = new javax.swing.JButton();
        btnRegComprasInsumos = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        pnlMovInsumos = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        cbxProductoMovProducto = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        cbxSourceSalida = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btnCapturarMovProductos = new javax.swing.JButton();
        btnGuardarMovProducto = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableMovProducto = new javax.swing.JTable();
        cbxSourceEntrada = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        checkMerma = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMovProductoCom = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        dtMovProducto = new com.toedter.calendar.JDateChooser();
        nupCantidadMovProducto = new javax.swing.JSpinner();
        tbVentas2 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        pnlCompraInsumos = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cbxProductoCompra = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cbxProveedorCompra = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtMontoCompra = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        btnCompraInsumosAdd = new javax.swing.JButton();
        btnCapturaEgresos4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePedido = new javax.swing.JTable();
        txtMontoCompraTotal = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        cbxCuentaCompra = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        checkPagarCompra = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        txtMontoPagoCompra = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        dtCompraInsumos = new com.toedter.calendar.JDateChooser();
        nupCantidadCompra = new javax.swing.JSpinner();
        checkCompraIVA = new javax.swing.JCheckBox();
        tbVentas1 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel26 = new javax.swing.JLabel();
        tbFacturaIngresos1 = new javax.swing.JToggleButton();
        txtFacturaIngresos1 = new javax.swing.JTextField();
        pnlMov = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnEgresos = new javax.swing.JButton();
        btnMovCajas = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();
        btnIngresos = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelCapturaIngresos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbxCatIngresos = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbxCuentaIngresos = new javax.swing.JComboBox<>();
        txtDescripcionIngresos = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tbFacturaIngresos = new javax.swing.JToggleButton();
        txtFacturaIngresos = new javax.swing.JTextField();
        txtMontoIngresos = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTipoPagoIngresos = new javax.swing.JTextField();
        btnCapturaIngresos = new javax.swing.JButton();
        dtIngresos = new com.toedter.calendar.JDateChooser();
        jLabel56 = new javax.swing.JLabel();
        panelCapturaEgresos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxCatEgresos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcionEgresos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxCuentaEgresos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tbFacturaEgresos = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMontoEgresos = new javax.swing.JTextField();
        txtFacturaEgresos = new javax.swing.JTextField();
        txtTipoPagoEgresos = new javax.swing.JTextField();
        btnCapturaEgresos = new javax.swing.JButton();
        dtEgresos = new com.toedter.calendar.JDateChooser();
        jLabel58 = new javax.swing.JLabel();
        panelCapturaMov = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbxCuentaSalida = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbxCuentaEntrada = new javax.swing.JComboBox<>();
        txtMovDetalle = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMontoMov = new javax.swing.JTextField();
        btnCapturaMov = new javax.swing.JButton();
        dtMov = new com.toedter.calendar.JDateChooser();
        jLabel59 = new javax.swing.JLabel();
        pnlVentas = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnNuevaVenta = new javax.swing.JButton();
        btnActualizarVentas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBusqueda = new javax.swing.JTextPane();
        lblBuscarVentas = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        pnlEmpresa = new javax.swing.JPanel();
        btnCajas = new javax.swing.JButton();
        btnResumenVentas = new javax.swing.JButton();
        btnHistorialCliente = new javax.swing.JButton();
        btnSaldoProveedores = new javax.swing.JButton();
        btnRentabilidadComercializadora = new javax.swing.JButton();
        btnFlujoComercializadora = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem2.setText("jMenuItem2");

        btnVerDetalle.setText("Ver detalle");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });
        MenuVentas.add(btnVerDetalle);

        btnRegPagos.setText("Ver pagos del cliente");
        btnRegPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPagosActionPerformed(evt);
            }
        });
        MenuVentas.add(btnRegPagos);

        btnPagoVenta.setText("Realizar pago");
        btnPagoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoVentaActionPerformed(evt);
            }
        });
        MenuVentas.add(btnPagoVenta);

        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });
        MenuVentas.add(btnEliminarVenta);

        btnRentSpa.setText("Spa");
        btnRentSpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentSpaActionPerformed(evt);
            }
        });
        MenuRentabilidad.add(btnRentSpa);

        btnRentComercializadora.setText("Comercializadora");
        btnRentComercializadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentComercializadoraActionPerformed(evt);
            }
        });
        MenuRentabilidad.add(btnRentComercializadora);

        btnRentGrupo.setText("Grupo Ayana");
        btnRentGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentGrupoActionPerformed(evt);
            }
        });
        MenuRentabilidad.add(btnRentGrupo);

        btnRentSpa1.setText("Spa");
        btnRentSpa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentSpa1ActionPerformed(evt);
            }
        });
        MenuFlujo.add(btnRentSpa1);

        btnRentComercializadora1.setText("Comercializadora");
        btnRentComercializadora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentComercializadora1ActionPerformed(evt);
            }
        });
        MenuFlujo.add(btnRentComercializadora1);

        btnRentGrupo1.setText("Grupo Ayana");
        btnRentGrupo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentGrupo1ActionPerformed(evt);
            }
        });
        MenuFlujo.add(btnRentGrupo1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ayana spa manager");
        setBackground(new java.awt.Color(255, 248, 245));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);

        jPanel2.setBackground(new java.awt.Color(232, 210, 187));
        jPanel2.setToolTipText("Inventarios");

        ImageLogo.setBackground(new java.awt.Color(255, 248, 245));
        ImageLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageLogo.setSize(new java.awt.Dimension(50, 50));

        btnVentas.setBackground(new java.awt.Color(232, 210, 187));
        btnVentas.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnVentas.setToolTipText("Punto de venta");
        btnVentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVentas.setBorderPainted(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVentas.setSize(new java.awt.Dimension(80, 80));
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistroIngresosClick(evt);
            }
        });
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnMovimientos.setBackground(new java.awt.Color(232, 210, 187));
        btnMovimientos.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnMovimientos.setForeground(new java.awt.Color(0, 0, 0));
        btnMovimientos.setToolTipText("Movimientos");
        btnMovimientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMovimientos.setBorderPainted(false);
        btnMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMovimientos.setSize(new java.awt.Dimension(80, 80));
        btnMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMovimientosRegistroIngresosClick(evt);
            }
        });
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        btnInventario.setBackground(new java.awt.Color(232, 210, 187));
        btnInventario.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(0, 0, 0));
        btnInventario.setToolTipText("Inventario");
        btnInventario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInventario.setBorderPainted(false);
        btnInventario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventarioRegistroIngresosClick(evt);
            }
        });
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnEmpresa.setBackground(new java.awt.Color(232, 210, 187));
        btnEmpresa.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        btnEmpresa.setToolTipText("Reportes");
        btnEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpresa.setBorderPainted(false);
        btnEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpresaRegistroIngresosClick(evt);
            }
        });
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(55, 55, 55));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Punto de venta");

        jLabel41.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(55, 55, 55));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Movimientos");

        jLabel42.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(55, 55, 55));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Inventarios");

        jLabel43.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(55, 55, 55));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Reportes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ImageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(ImageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        btnVentas.getAccessibleContext().setAccessibleName("btnVentas");

        jLayeredPane2.setMinimumSize(new java.awt.Dimension(885, 620));
        jLayeredPane2.setRequestFocusEnabled(false);
        jLayeredPane2.setSize(new java.awt.Dimension(885, 620));

        pnlInventarios.setBackground(new java.awt.Color(255, 255, 255));
        pnlInventarios.setPreferredSize(new java.awt.Dimension(885, 620));
        pnlInventarios.setSize(new java.awt.Dimension(885, 620));

        jPanel1.setBackground(new java.awt.Color(253, 239, 229));

        btnCompraInsumos.setBackground(new java.awt.Color(253, 239, 229));
        btnCompraInsumos.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnCompraInsumos.setForeground(new java.awt.Color(0, 0, 0));
        btnCompraInsumos.setToolTipText("");
        btnCompraInsumos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompraInsumos.setBorderPainted(false);
        btnCompraInsumos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCompraInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompraInsumosRegistroIngresosClick(evt);
            }
        });
        btnCompraInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraInsumosActionPerformed(evt);
            }
        });

        btnMovimientoInsumos.setBackground(new java.awt.Color(253, 239, 229));
        btnMovimientoInsumos.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnMovimientoInsumos.setForeground(new java.awt.Color(0, 0, 0));
        btnMovimientoInsumos.setToolTipText("");
        btnMovimientoInsumos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMovimientoInsumos.setBorderPainted(false);
        btnMovimientoInsumos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMovimientoInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMovimientoInsumosRegistroIngresosClick(evt);
            }
        });
        btnMovimientoInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientoInsumosActionPerformed(evt);
            }
        });

        btnCompraInsumos3.setBackground(new java.awt.Color(253, 239, 229));
        btnCompraInsumos3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnCompraInsumos3.setForeground(new java.awt.Color(0, 0, 0));
        btnCompraInsumos3.setToolTipText("");
        btnCompraInsumos3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompraInsumos3.setBorderPainted(false);
        btnCompraInsumos3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCompraInsumos3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompraInsumos3RegistroIngresosClick(evt);
            }
        });
        btnCompraInsumos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraInsumos3ActionPerformed(evt);
            }
        });

        btnRegInsumos.setBackground(new java.awt.Color(253, 239, 229));
        btnRegInsumos.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnRegInsumos.setForeground(new java.awt.Color(0, 0, 0));
        btnRegInsumos.setToolTipText("");
        btnRegInsumos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegInsumos.setBorderPainted(false);
        btnRegInsumos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegInsumosRegistroIngresosClick(evt);
            }
        });
        btnRegInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegInsumosActionPerformed(evt);
            }
        });

        btnRegComprasInsumos.setBackground(new java.awt.Color(253, 239, 229));
        btnRegComprasInsumos.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnRegComprasInsumos.setForeground(new java.awt.Color(0, 0, 0));
        btnRegComprasInsumos.setToolTipText("");
        btnRegComprasInsumos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegComprasInsumos.setBorderPainted(false);
        btnRegComprasInsumos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegComprasInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegComprasInsumosRegistroIngresosClick(evt);
            }
        });
        btnRegComprasInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegComprasInsumosActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Pedidos de producto");

        jLabel27.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Movimientos de producto");

        jLabel36.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Ver pedidos");
        jLabel36.setToolTipText("");

        jLabel45.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Ver mov. de producto");
        jLabel45.setToolTipText("");

        jLabel46.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("Ver inventario");
        jLabel46.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnCompraInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(btnMovimientoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnRegComprasInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(btnRegInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(btnCompraInsumos3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCompraInsumos3, btnRegComprasInsumos, btnRegInsumos});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMovimientoInsumos, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCompraInsumos, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCompraInsumos3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(btnRegInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(btnRegComprasInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel36)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(jLabel46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCompraInsumos3, btnRegComprasInsumos, btnRegInsumos});

        pnlMovInsumos.setBackground(new java.awt.Color(255, 255, 255));
        pnlMovInsumos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlMovInsumosComponentShown(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("Fecha");
        jLabel30.setToolTipText("");

        cbxProductoMovProducto.setEditable(true);
        cbxProductoMovProducto.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxProductoMovProducto.setForeground(new java.awt.Color(51, 51, 51));
        cbxProductoMovProducto.setToolTipText("");
        cbxProductoMovProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoMovProductoActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel49.setText("Salida");
        jLabel49.setToolTipText("");

        cbxSourceSalida.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxSourceSalida.setForeground(new java.awt.Color(51, 51, 51));
        cbxSourceSalida.setToolTipText("");
        cbxSourceSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSourceSalidaActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel50.setText("Producto");
        jLabel50.setToolTipText("");

        jLabel51.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel51.setText("Cantidad");
        jLabel51.setToolTipText("");

        btnCapturarMovProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturarMovProductos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturarMovProductos.setForeground(new java.awt.Color(102, 102, 102));
        btnCapturarMovProductos.setText("Agregar");
        btnCapturarMovProductos.setToolTipText("");
        btnCapturarMovProductos.setBorder(null);
        btnCapturarMovProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturarMovProductosActionPerformed(evt);
            }
        });

        btnGuardarMovProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarMovProducto.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnGuardarMovProducto.setForeground(new java.awt.Color(102, 102, 102));
        btnGuardarMovProducto.setText("Guardar");
        btnGuardarMovProducto.setToolTipText("");
        btnGuardarMovProducto.setBorder(null);
        btnGuardarMovProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMovProductoActionPerformed(evt);
            }
        });

        tableMovProducto.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        tableMovProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Salida", "Entrada", "Categoría", "Producto", "Cantidad", "Merma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tableMovProducto);

        cbxSourceEntrada.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxSourceEntrada.setForeground(new java.awt.Color(51, 51, 51));
        cbxSourceEntrada.setToolTipText("");
        cbxSourceEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSourceEntradaActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel57.setText("Entrada");
        jLabel57.setToolTipText("");

        checkMerma.setBackground(new java.awt.Color(255, 255, 255));
        checkMerma.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        checkMerma.setForeground(new java.awt.Color(51, 51, 51));
        checkMerma.setText("Merma");
        checkMerma.setToolTipText("");
        checkMerma.setEnabled(false);

        txtMovProductoCom.setColumns(20);
        txtMovProductoCom.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMovProductoCom.setForeground(new java.awt.Color(51, 51, 51));
        txtMovProductoCom.setRows(5);
        txtMovProductoCom.setToolTipText("");
        jScrollPane2.setViewportView(txtMovProductoCom);

        jLabel31.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel31.setText("Comentario");
        jLabel31.setToolTipText("");

        dtMovProducto.setForeground(new java.awt.Color(51, 51, 51));
        dtMovProducto.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N

        nupCantidadMovProducto.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        nupCantidadMovProducto.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        tbVentas2.setRollover(true);
        tbVentas2.setBorderPainted(false);

        jButton6.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        jButton6.setText("Eliminar");
        jButton6.setFocusable(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        tbVentas2.add(jButton6);
        tbVentas2.add(jSeparator2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMovInsumosLayout = new javax.swing.GroupLayout(pnlMovInsumos);
        pnlMovInsumos.setLayout(pnlMovInsumosLayout);
        pnlMovInsumosLayout.setHorizontalGroup(
            pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dtMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProductoMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxSourceSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxSourceEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nupCantidadMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addComponent(checkMerma))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnGuardarMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapturarMovProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbVentas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        pnlMovInsumosLayout.setVerticalGroup(
            pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                        .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMovInsumosLayout.createSequentialGroup()
                                .addComponent(dtMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(checkMerma))
                            .addGroup(pnlMovInsumosLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxSourceSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxSourceEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProductoMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMovInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nupCantidadMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(btnCapturarMovProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarMovProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbVentas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCompraInsumos.setBackground(new java.awt.Color(255, 255, 255));
        pnlCompraInsumos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlCompraInsumosComponentShown(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel28.setText("Fecha");

        cbxProductoCompra.setEditable(true);
        cbxProductoCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxProductoCompra.setForeground(new java.awt.Color(51, 51, 51));
        cbxProductoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoCompraActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("Proveedor");
        jLabel32.setToolTipText("");

        cbxProveedorCompra.setEditable(true);
        cbxProveedorCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxProveedorCompra.setForeground(new java.awt.Color(51, 51, 51));
        cbxProveedorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorCompraActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel33.setText("Producto");
        jLabel33.setToolTipText("");

        jLabel34.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("Cantidad");

        txtMontoCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoCompra.setForeground(new java.awt.Color(51, 51, 51));
        txtMontoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoCompraActionPerformed(evt);
            }
        });
        txtMontoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoCompraKeyReleased(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel35.setText("Monto sin iva");

        btnCompraInsumosAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnCompraInsumosAdd.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCompraInsumosAdd.setForeground(new java.awt.Color(55, 55, 55));
        btnCompraInsumosAdd.setText("Guardar");
        btnCompraInsumosAdd.setToolTipText("Guardar");
        btnCompraInsumosAdd.setBorder(null);
        btnCompraInsumosAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraInsumosAddActionPerformed(evt);
            }
        });

        btnCapturaEgresos4.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturaEgresos4.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturaEgresos4.setForeground(new java.awt.Color(55, 55, 55));
        btnCapturaEgresos4.setText("Agregar");
        btnCapturaEgresos4.setToolTipText("Agregar");
        btnCapturaEgresos4.setBorder(null);
        btnCapturaEgresos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaEgresos4ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tablePedido.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        tablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría", "Producto", "Cantidad", "Monto total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablePedido);

        txtMontoCompraTotal.setEditable(false);
        txtMontoCompraTotal.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoCompraTotal.setForeground(new java.awt.Color(51, 51, 51));
        txtMontoCompraTotal.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel37.setText("Monto total");

        cbxCuentaCompra.setEditable(true);
        cbxCuentaCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCuentaCompra.setForeground(new java.awt.Color(51, 51, 51));

        jLabel38.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel38.setText("Forma de pago");
        jLabel38.setToolTipText("");

        checkPagarCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        checkPagarCompra.setText("Realizar pago");
        checkPagarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPagarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        txtMontoPagoCompra.setEditable(false);
        txtMontoPagoCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoPagoCompra.setForeground(new java.awt.Color(51, 51, 51));
        txtMontoPagoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoPagoCompraKeyReleased(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel39.setText("Monto a pagar");
        jLabel39.setToolTipText("");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        dtCompraInsumos.setForeground(new java.awt.Color(51, 51, 51));
        dtCompraInsumos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N

        nupCantidadCompra.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        nupCantidadCompra.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        checkCompraIVA.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        checkCompraIVA.setText("Iva");
        checkCompraIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCompraIVAActionPerformed(evt);
            }
        });

        tbVentas1.setRollover(true);
        tbVentas1.setBorderPainted(false);

        jButton4.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        tbVentas1.add(jButton4);
        tbVentas1.add(jSeparator1);

        jLabel26.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel26.setText("Factura");

        tbFacturaIngresos1.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tbFacturaIngresos1.setForeground(new java.awt.Color(51, 51, 51));
        tbFacturaIngresos1.setSelected(true);
        tbFacturaIngresos1.setText("Si");
        tbFacturaIngresos1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbFacturaIngresos1StateChanged(evt);
            }
        });
        tbFacturaIngresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFacturaIngresos1ActionPerformed(evt);
            }
        });

        txtFacturaIngresos1.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtFacturaIngresos1.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnlCompraInsumosLayout = new javax.swing.GroupLayout(pnlCompraInsumos);
        pnlCompraInsumos.setLayout(pnlCompraInsumosLayout);
        pnlCompraInsumosLayout.setHorizontalGroup(
            pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCuentaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtCompraInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nupCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMontoCompraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                                        .addComponent(txtMontoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(checkCompraIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(tbFacturaIngresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtFacturaIngresos1))
                                        .addComponent(txtMontoPagoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                                    .addGap(167, 167, 167)
                                    .addComponent(checkPagarCompra))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompraInsumosLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(btnCapturaEgresos4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnCompraInsumosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6))
                .addGap(7, 7, 7))
        );
        pnlCompraInsumosLayout.setVerticalGroup(
            pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(tbVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCompraInsumosLayout.createSequentialGroup()
                                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtCompraInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxCuentaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxProductoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nupCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkCompraIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoCompraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCapturaEgresos4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkPagarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoPagoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCompraInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFacturaIngresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbFacturaIngresos1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCompraInsumosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );

        jLabel39.getAccessibleContext().setAccessibleName("Monto pagar");

        jLayeredPane3.setLayer(pnlMovInsumos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(pnlCompraInsumos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                    .addComponent(pnlMovInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                    .addComponent(pnlCompraInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlMovInsumos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlCompraInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInventariosLayout = new javax.swing.GroupLayout(pnlInventarios);
        pnlInventarios.setLayout(pnlInventariosLayout);
        pnlInventariosLayout.setHorizontalGroup(
            pnlInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInventariosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLayeredPane3)
                    .addContainerGap()))
        );
        pnlInventariosLayout.setVerticalGroup(
            pnlInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(620, 620, 620))
            .addGroup(pnlInventariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInventariosLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pnlMov.setBackground(new java.awt.Color(255, 248, 245));
        pnlMov.setPreferredSize(new java.awt.Dimension(885, 620));
        pnlMov.setSize(new java.awt.Dimension(885, 620));

        jPanel10.setBackground(new java.awt.Color(253, 239, 229));
        jPanel10.setForeground(new java.awt.Color(253, 239, 229));
        jPanel10.setMinimumSize(new java.awt.Dimension(845, 101));
        jPanel10.setPreferredSize(new java.awt.Dimension(845, 101));
        jPanel10.setSize(new java.awt.Dimension(845, 101));

        btnEgresos.setBackground(new java.awt.Color(253, 239, 229));
        btnEgresos.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        btnEgresos.setForeground(new java.awt.Color(0, 0, 0));
        btnEgresos.setToolTipText("Egresos");
        btnEgresos.setBorderPainted(false);
        btnEgresos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnEgresos.setIconTextGap(1);
        btnEgresos.setPreferredSize(new java.awt.Dimension(73, 65));
        btnEgresos.setRequestFocusEnabled(false);
        btnEgresos.setSize(new java.awt.Dimension(73, 65));
        btnEgresos.setVerifyInputWhenFocusTarget(false);
        btnEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEgresosRegistroIngresosClick(evt);
            }
        });
        btnEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresosActionPerformed(evt);
            }
        });

        btnMovCajas.setBackground(new java.awt.Color(253, 239, 229));
        btnMovCajas.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        btnMovCajas.setForeground(new java.awt.Color(0, 0, 0));
        btnMovCajas.setToolTipText("Movimientos de cajas");
        btnMovCajas.setBorderPainted(false);
        btnMovCajas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMovCajas.setIconTextGap(1);
        btnMovCajas.setPreferredSize(new java.awt.Dimension(73, 65));
        btnMovCajas.setRequestFocusEnabled(false);
        btnMovCajas.setSize(new java.awt.Dimension(73, 65));
        btnMovCajas.setVerifyInputWhenFocusTarget(false);
        btnMovCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMovCajasRegistroIngresosClick(evt);
            }
        });
        btnMovCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovCajasActionPerformed(evt);
            }
        });

        btnRegistros.setBackground(new java.awt.Color(253, 239, 229));
        btnRegistros.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        btnRegistros.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistros.setToolTipText("Ver registro");
        btnRegistros.setBorder(null);
        btnRegistros.setBorderPainted(false);
        btnRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegistros.setIconTextGap(1);
        btnRegistros.setPreferredSize(new java.awt.Dimension(73, 65));
        btnRegistros.setSize(new java.awt.Dimension(73, 65));
        btnRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrosRegistroIngresosClick(evt);
            }
        });
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });

        btnIngresos.setBackground(new java.awt.Color(253, 239, 229));
        btnIngresos.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        btnIngresos.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresos.setToolTipText("Ingresos");
        btnIngresos.setBorderPainted(false);
        btnIngresos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnIngresos.setIconTextGap(1);
        btnIngresos.setPreferredSize(new java.awt.Dimension(73, 65));
        btnIngresos.setRequestFocusEnabled(false);
        btnIngresos.setSize(new java.awt.Dimension(73, 65));
        btnIngresos.setVerifyInputWhenFocusTarget(false);
        btnIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresosRegistroIngresosClick(evt);
            }
        });
        btnIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setText("Ingresos");

        jLabel53.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("Egresos");

        jLabel54.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("Mov de cajas");

        jLabel55.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("Ver registro");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel53)
                    .addComponent(btnEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel54)
                    .addComponent(btnMovCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 687, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel55)
                    .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEgresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovCajas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55))
                .addContainerGap())
        );

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(850, 550));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(850, 550));
        jLayeredPane1.setSize(new java.awt.Dimension(850, 550));

        panelCapturaIngresos.setBackground(new java.awt.Color(255, 255, 255));
        panelCapturaIngresos.setMaximumSize(new java.awt.Dimension(850, 550));
        panelCapturaIngresos.setMinimumSize(new java.awt.Dimension(850, 550));
        panelCapturaIngresos.setPreferredSize(new java.awt.Dimension(850, 550));
        panelCapturaIngresos.setSize(new java.awt.Dimension(850, 550));
        panelCapturaIngresos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelCapturaIngresosComponentShown(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha");

        cbxCatIngresos.setEditable(true);
        cbxCatIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCatIngresos.setForeground(new java.awt.Color(51, 51, 51));
        cbxCatIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCatIngresosActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Categoría");

        jLabel12.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Detalle");

        jLabel13.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Tipo de Pago");

        jLabel14.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cuenta");

        cbxCuentaIngresos.setEditable(true);
        cbxCuentaIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCuentaIngresos.setForeground(new java.awt.Color(51, 51, 51));
        cbxCuentaIngresos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuentaIngresosItemStateChanged(evt);
            }
        });
        cbxCuentaIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentaIngresosActionPerformed(evt);
            }
        });

        txtDescripcionIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtDescripcionIngresos.setForeground(new java.awt.Color(51, 51, 51));

        jLabel15.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Factura");

        tbFacturaIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tbFacturaIngresos.setForeground(new java.awt.Color(51, 51, 51));
        tbFacturaIngresos.setSelected(true);
        tbFacturaIngresos.setText("Si");
        tbFacturaIngresos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbFacturaIngresosStateChanged(evt);
            }
        });
        tbFacturaIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFacturaIngresosActionPerformed(evt);
            }
        });

        txtFacturaIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtFacturaIngresos.setForeground(new java.awt.Color(51, 51, 51));

        txtMontoIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoIngresos.setForeground(new java.awt.Color(51, 51, 51));
        txtMontoIngresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoIngresosKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Monto");

        txtTipoPagoIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtTipoPagoIngresos.setForeground(new java.awt.Color(51, 51, 51));
        txtTipoPagoIngresos.setEnabled(false);

        btnCapturaIngresos.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturaIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturaIngresos.setForeground(new java.awt.Color(51, 51, 51));
        btnCapturaIngresos.setText("Capturar");
        btnCapturaIngresos.setToolTipText("Capturar");
        btnCapturaIngresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCapturaIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaIngresosActionPerformed(evt);
            }
        });

        dtIngresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Captura de ingresos");
        jLabel56.setToolTipText("");

        javax.swing.GroupLayout panelCapturaIngresosLayout = new javax.swing.GroupLayout(panelCapturaIngresos);
        panelCapturaIngresos.setLayout(panelCapturaIngresosLayout);
        panelCapturaIngresosLayout.setHorizontalGroup(
            panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelCapturaIngresosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapturaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCapturaIngresosLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMontoIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoPagoIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCatIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCapturaIngresosLayout.createSequentialGroup()
                        .addComponent(tbFacturaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFacturaIngresos)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        panelCapturaIngresosLayout.setVerticalGroup(
            panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCapturaIngresosLayout.createSequentialGroup()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCatIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescripcionIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTipoPagoIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCuentaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFacturaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tbFacturaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(panelCapturaIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnCapturaIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        panelCapturaEgresos.setBackground(new java.awt.Color(255, 255, 255));
        panelCapturaEgresos.setMaximumSize(new java.awt.Dimension(850, 550));
        panelCapturaEgresos.setPreferredSize(new java.awt.Dimension(850, 550));
        panelCapturaEgresos.setSize(new java.awt.Dimension(850, 550));
        panelCapturaEgresos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelCapturaEgresosComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                panelCapturaEgresosComponentHidden(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Fecha");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        cbxCatEgresos.setEditable(true);
        cbxCatEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCatEgresos.setForeground(new java.awt.Color(51, 51, 51));
        cbxCatEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCatEgresosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Categoría");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txtDescripcionEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtDescripcionEgresos.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Detalle");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel5.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de Pago");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        cbxCuentaEgresos.setEditable(true);
        cbxCuentaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCuentaEgresos.setForeground(new java.awt.Color(51, 51, 51));
        cbxCuentaEgresos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuentaEgresosItemStateChanged(evt);
            }
        });
        cbxCuentaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentaEgresosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cuenta");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        tbFacturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tbFacturaEgresos.setForeground(new java.awt.Color(51, 51, 51));
        tbFacturaEgresos.setSelected(true);
        tbFacturaEgresos.setText("Si");
        tbFacturaEgresos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbFacturaEgresosStateChanged(evt);
            }
        });
        tbFacturaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFacturaEgresosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Factura");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel8.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Monto");

        txtMontoEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoEgresos.setForeground(new java.awt.Color(51, 51, 51));
        txtMontoEgresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoEgresosKeyReleased(evt);
            }
        });

        txtFacturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtFacturaEgresos.setForeground(new java.awt.Color(51, 51, 51));
        txtFacturaEgresos.setEnabled(false);

        txtTipoPagoEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtTipoPagoEgresos.setForeground(new java.awt.Color(51, 51, 51));
        txtTipoPagoEgresos.setEnabled(false);

        btnCapturaEgresos.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturaEgresos.setForeground(new java.awt.Color(55, 55, 55));
        btnCapturaEgresos.setText("Capturar");
        btnCapturaEgresos.setToolTipText("");
        btnCapturaEgresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCapturaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaEgresosActionPerformed(evt);
            }
        });

        dtEgresos.setForeground(new java.awt.Color(51, 51, 51));
        dtEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Captura de egresos");
        jLabel58.setToolTipText("");

        javax.swing.GroupLayout panelCapturaEgresosLayout = new javax.swing.GroupLayout(panelCapturaEgresos);
        panelCapturaEgresos.setLayout(panelCapturaEgresosLayout);
        panelCapturaEgresosLayout.setHorizontalGroup(
            panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelCapturaEgresosLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMontoEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoPagoEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCatEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCapturaEgresosLayout.createSequentialGroup()
                        .addComponent(tbFacturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFacturaEgresos)))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(panelCapturaEgresosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCapturaEgresosLayout.setVerticalGroup(
            panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCapturaEgresosLayout.createSequentialGroup()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCatEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCapturaEgresosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescripcionEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoPagoEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCuentaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbFacturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFacturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelCapturaEgresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCapturaEgresosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMontoEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnCapturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("v");

        panelCapturaMov.setBackground(new java.awt.Color(255, 255, 255));
        panelCapturaMov.setMaximumSize(new java.awt.Dimension(850, 550));
        panelCapturaMov.setMinimumSize(new java.awt.Dimension(850, 550));
        panelCapturaMov.setPreferredSize(new java.awt.Dimension(850, 550));
        panelCapturaMov.setSize(new java.awt.Dimension(850, 550));
        panelCapturaMov.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelCapturaMovComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                panelCapturaMovComponentHidden(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Fecha");

        cbxCuentaSalida.setEditable(true);
        cbxCuentaSalida.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCuentaSalida.setForeground(new java.awt.Color(51, 51, 51));
        cbxCuentaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentaSalidaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Cuenta salida");

        cbxCuentaEntrada.setEditable(true);
        cbxCuentaEntrada.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCuentaEntrada.setForeground(new java.awt.Color(51, 51, 51));

        txtMovDetalle.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMovDetalle.setForeground(new java.awt.Color(51, 51, 51));

        jLabel19.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Cuenta entrada");
        jLabel19.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Comentario");

        jLabel24.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Monto");

        txtMontoMov.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoMov.setForeground(new java.awt.Color(51, 51, 51));
        txtMontoMov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoMovKeyReleased(evt);
            }
        });

        btnCapturaMov.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturaMov.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturaMov.setForeground(new java.awt.Color(55, 55, 55));
        btnCapturaMov.setText("Capturar");
        btnCapturaMov.setToolTipText("Capturar");
        btnCapturaMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCapturaMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaMovActionPerformed(evt);
            }
        });

        dtMov.setForeground(new java.awt.Color(51, 51, 51));
        dtMov.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Captura de movimientos de caja");
        jLabel59.setToolTipText("");

        javax.swing.GroupLayout panelCapturaMovLayout = new javax.swing.GroupLayout(panelCapturaMov);
        panelCapturaMov.setLayout(panelCapturaMovLayout);
        panelCapturaMovLayout.setHorizontalGroup(
            panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelCapturaMovLayout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCuentaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMovDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtMov, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(panelCapturaMovLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapturaMov, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCapturaMovLayout.setVerticalGroup(
            panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCapturaMovLayout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtMov, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMovDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCapturaMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCapturaMov, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(panelCapturaIngresos, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(panelCapturaEgresos, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(panelCapturaMov, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCapturaEgresos, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCapturaMov, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelCapturaIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCapturaEgresos, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCapturaMov, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelCapturaIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout pnlMovLayout = new javax.swing.GroupLayout(pnlMov);
        pnlMov.setLayout(pnlMovLayout);
        pnlMovLayout.setHorizontalGroup(
            pnlMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMovLayout.createSequentialGroup()
                .addGroup(pnlMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                    .addGroup(pnlMovLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMovLayout.setVerticalGroup(
            pnlMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlVentas.setBackground(new java.awt.Color(255, 248, 245));
        pnlVentas.setForeground(new java.awt.Color(255, 255, 255));
        pnlVentas.setMinimumSize(new java.awt.Dimension(885, 620));
        pnlVentas.setPreferredSize(new java.awt.Dimension(885, 620));
        pnlVentas.setSize(new java.awt.Dimension(885, 620));
        pnlVentas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlVentasComponentShown(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(253, 239, 229));
        jPanel11.setMaximumSize(new java.awt.Dimension(1200, 110));
        jPanel11.setPreferredSize(new java.awt.Dimension(885, 110));
        jPanel11.setRequestFocusEnabled(false);
        jPanel11.setSize(new java.awt.Dimension(885, 110));

        btnNuevaVenta.setBackground(new java.awt.Color(253, 239, 229));
        btnNuevaVenta.setFont(new java.awt.Font("Telugu MN", 2, 11)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevaVenta.setToolTipText("Nueva venta");
        btnNuevaVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnNuevaVenta.setBorderPainted(false);
        btnNuevaVenta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnNuevaVenta.setPreferredSize(new java.awt.Dimension(73, 65));
        btnNuevaVenta.setSize(new java.awt.Dimension(73, 65));
        btnNuevaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaVentaRegistroIngresosClick(evt);
            }
        });
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnActualizarVentas.setBackground(new java.awt.Color(253, 239, 229));
        btnActualizarVentas.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnActualizarVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizarVentas.setToolTipText("Actualizar ventas");
        btnActualizarVentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizarVentas.setBorderPainted(false);
        btnActualizarVentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnActualizarVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarVentasRegistroIngresosClick(evt);
            }
        });
        btnActualizarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarVentasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nueva venta");

        jLabel11.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Actualizar");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(btnActualizarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnActualizarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setSize(new java.awt.Dimension(863, 428));

        tableVentas.setAutoCreateRowSorter(true);
        tableVentas.setBackground(new java.awt.Color(253, 239, 229));
        tableVentas.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id venta", "Fecha", "Cliente", "Comentario", "Monto total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class
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
        tableVentas.setToolTipText("");
        tableVentas.setColumnSelectionAllowed(true);
        tableVentas.setComponentPopupMenu(MenuVentas);
        tableVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableVentas.setFocusTraversalPolicyProvider(true);
        tableVentas.setFocusable(false);
        tableVentas.setGridColor(new java.awt.Color(255, 255, 255));
        tableVentas.setOpaque(false);
        tableVentas.setRequestFocusEnabled(false);
        tableVentas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableVentas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableVentas.setShowGrid(true);
        tableVentas.getTableHeader().setResizingAllowed(false);
        tableVentas.getTableHeader().setReorderingAllowed(false);
        tableVentas.setVerifyInputWhenFocusTarget(false);
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVentasMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVentas);
        tableVentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableVentas.getColumnModel().getColumnCount() > 0) {
            tableVentas.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtBusqueda.setBackground(new java.awt.Color(255, 248, 245));
        txtBusqueda.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txtBusqueda.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(0, 0, 0));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtBusqueda);

        lblBuscarVentas.setBackground(new java.awt.Color(255, 255, 255));
        lblBuscarVentas.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        lblBuscarVentas.setForeground(new java.awt.Color(51, 51, 51));
        lblBuscarVentas.setText("Buscar:");

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("En:");

        cbxFiltro.setBackground(new java.awt.Color(255, 248, 245));
        cbxFiltro.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        cbxFiltro.setForeground(new java.awt.Color(0, 0, 0));
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id venta", "Fecha", "Cliente", "Comentario", "Monto" }));
        cbxFiltro.setLightWeightPopupEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbxFiltro, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlVentasLayout = new javax.swing.GroupLayout(pnlVentas);
        pnlVentas.setLayout(pnlVentasLayout);
        pnlVentasLayout.setHorizontalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlVentasLayout.setVerticalGroup(
            pnlVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmpresa.setPreferredSize(new java.awt.Dimension(885, 620));
        pnlEmpresa.setSize(new java.awt.Dimension(885, 620));

        btnCajas.setBackground(new java.awt.Color(255, 255, 255));
        btnCajas.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnCajas.setForeground(new java.awt.Color(0, 0, 0));
        btnCajas.setToolTipText("Cajas");
        btnCajas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCajas.setBorderPainted(false);
        btnCajas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCajasRegistroIngresosClick(evt);
            }
        });
        btnCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajasActionPerformed(evt);
            }
        });

        btnResumenVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnResumenVentas.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnResumenVentas.setForeground(new java.awt.Color(0, 0, 0));
        btnResumenVentas.setToolTipText("Resumen de ventas");
        btnResumenVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnResumenVentas.setBorderPainted(false);
        btnResumenVentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnResumenVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResumenVentasRegistroIngresosClick(evt);
            }
        });
        btnResumenVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenVentasActionPerformed(evt);
            }
        });

        btnHistorialCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnHistorialCliente.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnHistorialCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnHistorialCliente.setToolTipText("Saldo de clientes");
        btnHistorialCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHistorialCliente.setBorderPainted(false);
        btnHistorialCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHistorialCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialClienteRegistroIngresosClick(evt);
            }
        });
        btnHistorialCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialClienteActionPerformed(evt);
            }
        });

        btnSaldoProveedores.setBackground(new java.awt.Color(255, 255, 255));
        btnSaldoProveedores.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnSaldoProveedores.setForeground(new java.awt.Color(0, 0, 0));
        btnSaldoProveedores.setToolTipText("Linea de crèdito de proveedores");
        btnSaldoProveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSaldoProveedores.setBorderPainted(false);
        btnSaldoProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSaldoProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaldoProveedoresRegistroIngresosClick(evt);
            }
        });
        btnSaldoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoProveedoresActionPerformed(evt);
            }
        });

        btnRentabilidadComercializadora.setBackground(new java.awt.Color(255, 255, 255));
        btnRentabilidadComercializadora.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        btnRentabilidadComercializadora.setForeground(new java.awt.Color(0, 0, 0));
        btnRentabilidadComercializadora.setToolTipText("Rentabilidad de la empresa Comercializadora");
        btnRentabilidadComercializadora.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRentabilidadComercializadora.setBorderPainted(false);
        btnRentabilidadComercializadora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRentabilidadComercializadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRentabilidadComercializadoraMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRentabilidadComercializadoraRegistroIngresosClick(evt);
            }
        });
        btnRentabilidadComercializadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentabilidadComercializadoraActionPerformed(evt);
            }
        });

        btnFlujoComercializadora.setBackground(new java.awt.Color(255, 255, 255));
        btnFlujoComercializadora.setFont(new java.awt.Font("InaiMathi", 1, 14)); // NOI18N
        btnFlujoComercializadora.setForeground(new java.awt.Color(145, 146, 147));
        btnFlujoComercializadora.setToolTipText("Flujo económico de comercializadora");
        btnFlujoComercializadora.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnFlujoComercializadora.setBorderPainted(false);
        btnFlujoComercializadora.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFlujoComercializadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFlujoComercializadoraMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFlujoComercializadoraRegistroIngresosClick(evt);
            }
        });
        btnFlujoComercializadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlujoComercializadoraActionPerformed(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(217, 234, 220));
        jLabel21.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(145, 146, 147));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setLabelFor(btnResumenVentas);
        jLabel21.setText("Resumen de ventas");

        jLabel22.setBackground(new java.awt.Color(217, 234, 220));
        jLabel22.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(145, 146, 147));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setLabelFor(btnHistorialCliente);
        jLabel22.setText("Saldo de clientes");
        jLabel22.setToolTipText("");

        jLabel23.setBackground(new java.awt.Color(217, 234, 220));
        jLabel23.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(145, 146, 147));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setLabelFor(btnHistorialCliente);
        jLabel23.setText("Crédito a proveedores");
        jLabel23.setToolTipText("");

        jLabel29.setBackground(new java.awt.Color(217, 234, 220));
        jLabel29.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(145, 146, 147));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setLabelFor(btnResumenVentas);
        jLabel29.setText("Flujo económico");

        jLabel44.setBackground(new java.awt.Color(217, 234, 220));
        jLabel44.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(145, 146, 147));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setLabelFor(btnHistorialCliente);
        jLabel44.setText("Cajas");
        jLabel44.setToolTipText("");

        jLabel47.setBackground(new java.awt.Color(217, 234, 220));
        jLabel47.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(145, 146, 147));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setLabelFor(btnResumenVentas);
        jLabel47.setText("Rentabilidad");

        javax.swing.GroupLayout pnlEmpresaLayout = new javax.swing.GroupLayout(pnlEmpresa);
        pnlEmpresa.setLayout(pnlEmpresaLayout);
        pnlEmpresaLayout.setHorizontalGroup(
            pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRentabilidadComercializadora, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(btnCajas, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHistorialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaldoProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFlujoComercializadora, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnResumenVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(97, 97, 97))
        );

        pnlEmpresaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCajas, btnFlujoComercializadora, btnHistorialCliente, btnRentabilidadComercializadora, btnResumenVentas, btnSaldoProveedores});

        pnlEmpresaLayout.setVerticalGroup(
            pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpresaLayout.createSequentialGroup()
                            .addComponent(btnRentabilidadComercializadora, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpresaLayout.createSequentialGroup()
                            .addComponent(btnFlujoComercializadora, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addComponent(btnResumenVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHistorialCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(btnCajas, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnSaldoProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlEmpresaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCajas, btnFlujoComercializadora, btnHistorialCliente, btnRentabilidadComercializadora, btnResumenVentas, btnSaldoProveedores});

        jLayeredPane2.setLayer(pnlInventarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(pnlMov, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane2.setLayer(pnlVentas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(pnlEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlMov, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addComponent(pnlInventarios, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(pnlEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(pnlVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGap(0, 8, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(pnlMov, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        pnlInventarios.getAccessibleContext().setAccessibleName("");
        pnlMov.getAccessibleContext().setAccessibleName("");
        pnlVentas.getAccessibleContext().setAccessibleName("");
        pnlEmpresa.getAccessibleContext().setAccessibleName("");

        jMenuBar1.setBackground(new java.awt.Color(255, 248, 245));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jMenu2.setBackground(new java.awt.Color(255, 248, 245));
        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("Exportar");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setBackground(new java.awt.Color(255, 248, 245));
        jMenuItem3.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setText("Archivo de Excel");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1058, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(156, 156, 156)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private JPanel getSouthPanel()
    {
        JTextField tf = new JTextField(12);
        JPanel panel = new JPanel();
        panel.add(tf);
        return panel;
    }
  
     
    private void RegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroIngresosClick
      
    }//GEN-LAST:event_RegistroIngresosClick
private JPanel getSpinnerPanel()
    {
        double min = 0.000;
        double value = 0.707;
        double max = 1.000;
        double stepSize = 0.001;
        SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, stepSize);
        JSpinner spinner = new JSpinner(model);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor)spinner.getEditor();
        DecimalFormat format = editor.getFormat();
        format.setMinimumFractionDigits(3);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        Dimension d = spinner.getPreferredSize();
        d.width = 85;
        spinner.setPreferredSize(d);
        JPanel panel = new JPanel();
        panel.add(spinner);
        return panel;
    }
    private void panelCapturaEgresosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCapturaEgresosComponentShown
  
    }//GEN-LAST:event_panelCapturaEgresosComponentShown

    private void tbFacturaEgresosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbFacturaEgresosStateChanged
      
    }//GEN-LAST:event_tbFacturaEgresosStateChanged
    private void cbxCuentaEgresosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuentaEgresosItemStateChanged
     
    }//GEN-LAST:event_cbxCuentaEgresosItemStateChanged
    private void cbxCuentaIngresosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuentaIngresosItemStateChanged
        
    }//GEN-LAST:event_cbxCuentaIngresosItemStateChanged

    private void panelCapturaIngresosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCapturaIngresosComponentShown
       
       
    }//GEN-LAST:event_panelCapturaIngresosComponentShown

    private void tbFacturaIngresosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbFacturaIngresosStateChanged
       
    }//GEN-LAST:event_tbFacturaIngresosStateChanged


    private void cbxCatIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCatIngresosActionPerformed
     
    }//GEN-LAST:event_cbxCatIngresosActionPerformed

    private void btnCapturaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaEgresosActionPerformed
     try{
        Account cuenta= accounts.stream()
  .filter(obj -> cbxCuentaEgresos.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
        Expense_Type expense= expenses.stream()
  .filter(obj -> cbxCatEgresos.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
     
        if(MontoEgr==0){
               JOptionPane.showMessageDialog(this,"Falta ingresar monto.");
               return;
           }
        int fac=0;
        if(tbFacturaEgresos.isSelected()){
            fac=1;
        }
        con=new Conexion();
        con.Conectar();
        con.AddExpense(new Expense(dtEgresos.getDate(),expense.Id,txtDescripcionEgresos.getText(),cuenta.Id,fac,txtFacturaEgresos.getText(),MontoEgr,Save.TemporalUser.Id));
      con.Desconectar();
        JOptionPane.showMessageDialog(this,"Egreso capturado con éxito.");
       MontoEgr=0;
        txtDescripcionEgresos.setText(null);
       txtMontoEgresos.setText(null);
        }catch(Exception e){
               JOptionPane.showMessageDialog(this,"Información faltante.");
            }finally{}

    }//GEN-LAST:event_btnCapturaEgresosActionPerformed

    private void cbxCatEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCatEgresosActionPerformed
       
    }//GEN-LAST:event_cbxCatEgresosActionPerformed

    private void sfCantidadSolicitudInvPanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sfCantidadSolicitudInvPanFocusLost
    
    }//GEN-LAST:event_sfCantidadSolicitudInvPanFocusLost

    private void panelCapturaEgresosComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCapturaEgresosComponentHidden

    }//GEN-LAST:event_panelCapturaEgresosComponentHidden

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        pnlMov.setVisible(false);
        pnlVentas.setVisible(true);
         pnlInventarios.setVisible(false);
        pnlEmpresa.setVisible(false);
    }//GEN-LAST:event_btnVentasActionPerformed
private double Monto5;
    private void btnMovimientosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMovimientosRegistroIngresosClick

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
         panelCapturaEgresos.setVisible(false);
         panelCapturaMov.setVisible(false);
       panelCapturaIngresos.setVisible(false);
        pnlVentas.setVisible(false);
        
       pnlMov.setVisible(true);
        pnlInventarios.setVisible(false);
        pnlEmpresa.setVisible(false);
              btnIngresos.setBackground(new Color(253,239,229));
        btnEgresos.setBackground(new Color(253,239,229));
         btnMovCajas.setBackground(new Color(253,239,229));
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnInventarioRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInventarioRegistroIngresosClick

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        pnlMovInsumos.setVisible(false);
        pnlCompraInsumos.setVisible(false);
        pnlMov.setVisible(false);
           pnlInventarios.setVisible(true); 
        pnlVentas.setVisible(false);
        pnlEmpresa.setVisible(false);
        btnCompraInsumos.setBackground(new Color(253,239,229));
        btnMovimientoInsumos.setBackground(new Color(253,239,229));
     try{
        con = new Conexion();
        con.Conectar();
        try {
            providers = con.GetRegProviders();
            inventory_type = con.GetInventoryTypes2();

        } catch (SQLException ex) {
        }
        con.Desconectar();
        
        vectorProvider.clear();
        vectorProductoMov.clear();
        
          for (Provider obj : providers) {
            vectorProvider.add(obj.Description);
        }
        cbxProveedorCompra.setModel(new DefaultComboBoxModel(vectorProvider));
        JTextField text0 = (JTextField) cbxProveedorCompra.getEditor().getEditorComponent();
        text0.setFocusable(true);
        text0.setText("");
        text0.addKeyListener(new ComboListener(cbxProveedorCompra, vectorProvider));

            for (Inventory_Type obj : inventory_type) {
            vectorProductoMov.add(obj.Description);
        }
            
        cbxProductoMovProducto.setModel(new DefaultComboBoxModel(vectorProductoMov));
        JTextField text = (JTextField) cbxProductoMovProducto.getEditor().getEditorComponent();
        text.setFocusable(true);
        text.setText("");
        text.addKeyListener(new ComboListener(cbxProductoMovProducto, vectorProductoMov));
     }catch(Exception e){}finally{}
     
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnEmpresaRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpresaRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpresaRegistroIngresosClick

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaActionPerformed
   pnlMov.setVisible(false);
    pnlInventarios.setVisible(false); 
        pnlVentas.setVisible(false);
        pnlEmpresa.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpresaActionPerformed

    private void btnIngresosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresosRegistroIngresosClick

    private void btnIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosActionPerformed
     panelCapturaEgresos.setVisible(false);
      pnlInventarios.setVisible(false); 
       panelCapturaIngresos.setVisible(true);
        panelCapturaMov.setVisible(false);
        btnIngresos.setBackground(Color.GRAY);
        btnEgresos.setBackground(new Color(253,239,229));
         btnMovCajas.setBackground(new Color(253,239,229));
    }//GEN-LAST:event_btnIngresosActionPerformed

    private void btnEgresosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEgresosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEgresosRegistroIngresosClick

    private void btnEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresosActionPerformed
      panelCapturaEgresos.setVisible(true);
       panelCapturaIngresos.setVisible(false);
           panelCapturaMov.setVisible(false);
            btnIngresos.setBackground(new Color(253,239,229));
        btnEgresos.setBackground(Color.GRAY);
         btnMovCajas.setBackground(new Color(253,239,229));
    }//GEN-LAST:event_btnEgresosActionPerformed

    private void btnMovCajasRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovCajasRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMovCajasRegistroIngresosClick

    private void btnMovCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovCajasActionPerformed
        panelCapturaEgresos.setVisible(false);
       panelCapturaIngresos.setVisible(false);
           panelCapturaMov.setVisible(true);
               btnIngresos.setBackground(new Color(253,239,229));
        btnEgresos.setBackground(new Color(253,239,229));
         btnMovCajas.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnMovCajasActionPerformed

    private void cbxCuentaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentaSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCuentaSalidaActionPerformed

    private void panelCapturaMovComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCapturaMovComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_panelCapturaMovComponentShown

    private void panelCapturaMovComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelCapturaMovComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_panelCapturaMovComponentHidden

    private void btnRegistrosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrosRegistroIngresosClick

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        if(panelCapturaIngresos.isVisible()){
            Save.ingreso=0;
             if(!RegistroIngresosBool){
           RegistroIngresosBool=true;
        RegistroIngresos form=new RegistroIngresos();
            //        form.setModal(true);
          form.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
          form.setVisible(true);}
        
        }else if(panelCapturaEgresos.isVisible()){
              Save.ingreso=0;
           if(!RegistroEgresosBool){
           RegistroEgresosBool=true;
        RegistroEgresos form=new RegistroEgresos();
         form.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
          form.setVisible(true);}
        } else if(panelCapturaMov.isVisible()){
               if(!RegistroMovimientosBool){
           RegistroMovimientosBool=true;
        RegistroMovimientos form=new RegistroMovimientos();
            form.setExtendedState(JFrame.MAXIMIZED_BOTH);
          form.setVisible(true);}
        }
    }//GEN-LAST:event_btnRegistrosActionPerformed

    private void btnNuevaVentaRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaVentaRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaVentaRegistroIngresosClick

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
          if(!NuevaVentaBool){
        Save.status=0;
           NuevaVentaBool=true;
        NuevaVenta form=new NuevaVenta();
             form.setVisible(true);}
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnActualizarVentasRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarVentasRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarVentasRegistroIngresosClick

    private void btnActualizarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarVentasActionPerformed
     try{
        con=new Conexion();
        con.Conectar();
        try {
            Sales=con.GetSales();
            clients=con.GetClients();
            providers=con.GetRegProviders();
            inventory_type=con.GetInventoryTypes();
        } catch (SQLException ex) {}
    con.Desconectar();

    model=(DefaultTableModel)tableVentas.getModel(); 
    int count= model.getRowCount();
         for(int i=0;i<count;i++)
        {
           model.removeRow(0);   
        }

      for(Sale obj: Sales)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Client,obj.Comentario,obj.Monto});
        }
        trs=new TableRowSorter(model);
        tableVentas.setRowSorter(trs);   
     }catch(Exception e){}finally{}
    }//GEN-LAST:event_btnActualizarVentasActionPerformed

    private void btnCajasRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajasRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCajasRegistroIngresosClick

    private void btnCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajasActionPerformed
          if(!TotalCajasBool){
           TotalCajasBool=true;
        TotalCajas form=new TotalCajas();
           form.setExtendedState(JFrame.MAXIMIZED_BOTH);
         form.setVisible(true);}
    }//GEN-LAST:event_btnCajasActionPerformed

    private void btnResumenVentasRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResumenVentasRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResumenVentasRegistroIngresosClick

    private void btnResumenVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResumenVentasActionPerformed

    private void btnHistorialClienteRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialClienteRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialClienteRegistroIngresosClick

    private void btnHistorialClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialClienteActionPerformed
         if(!SaldoClientesBool){
           SaldoClientesBool=true;
        SaldoClientes form=new SaldoClientes();
           form.setExtendedState(JFrame.MAXIMIZED_BOTH);
         form.setVisible(true);}
    }//GEN-LAST:event_btnHistorialClienteActionPerformed

    private void btnSaldoProveedoresRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoProveedoresRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaldoProveedoresRegistroIngresosClick

    private void btnSaldoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoProveedoresActionPerformed
         if(!SaldoProveedoresBool){
           SaldoProveedoresBool=true;
        SaldoProveedores form=new SaldoProveedores();
           form.setExtendedState(JFrame.MAXIMIZED_BOTH);
         form.setVisible(true);}
       
    }//GEN-LAST:event_btnSaldoProveedoresActionPerformed

    private void btnRentabilidadComercializadoraRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRentabilidadComercializadoraRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRentabilidadComercializadoraRegistroIngresosClick

    private void btnRentabilidadComercializadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentabilidadComercializadoraActionPerformed
       
    }//GEN-LAST:event_btnRentabilidadComercializadoraActionPerformed

    private void btnFlujoComercializadoraRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFlujoComercializadoraRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFlujoComercializadoraRegistroIngresosClick

    private void btnFlujoComercializadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlujoComercializadoraActionPerformed
        
    }//GEN-LAST:event_btnFlujoComercializadoraActionPerformed

    private void btnCompraInsumosAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraInsumosAddActionPerformed
        try{
          
        Account cuenta= accounts.stream()
  .filter(o -> cbxCuentaCompra.getSelectedItem().toString().equals(o.Description))
  .findAny()
  .orElse(null);
         Provider provider= providers.stream()
  .filter(o -> cbxProveedorCompra.getSelectedItem().toString().equals(o.Description))
  .findAny()
  .orElse(null);
         int FACT=0;
         if(tbFacturaIngresos1.isSelected()){
             FACT=1;
         }
          int n = JOptionPane.showConfirmDialog(null,
"¿Desea guardar este pedido? ","",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
         
          if(tablePedido.getRowCount()<1){
                JOptionPane.showMessageDialog(this,"No hay filas agregadas.");
                return;
            }
        if(checkPagarCompra.isSelected()){
            if( txtMontoPagoCompra.getText().length()<1){
              JOptionPane.showMessageDialog(this,"Información faltante.");
              return;
        }else{//conpago
                
                        con=new Conexion();
                con.Conectar();
                try{
                    con.AddRequest(new Request(dtCompraInsumos.getDate(),"",provider.Id,cuenta.Id,0),
                            listauxinv,new Expense(dtCompraInsumos.getDate(),1,"",cuenta.Id,FACT,txtFacturaIngresos1.getText(),MontoCompraPago,Save.TemporalUser.Id));
                      } catch (SQLException ex) {}
                con.Desconectar();
                
                JOptionPane.showMessageDialog(this,"Pedido realizado.");
                MontoCompraPago=0;
                txtMontoPagoCompra.setText(null);
                modelCompras=(DefaultTableModel)tablePedido.getModel(); 
    int count= modelCompras.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelCompras.removeRow(0);   
        }
         listauxinv=new ArrayList<Inventory>();
      tablePedido.setModel(modelCompras);
                
            }
        }else{//sinpago
            
                        con=new Conexion();
                con.Conectar();
                try{
                    con.AddRequest(new Request(dtCompraInsumos.getDate(),"",provider.Id,cuenta.Id,0),
                            listauxinv);
                      } catch (SQLException ex) {}
                con.Desconectar();
                
                JOptionPane.showMessageDialog(this,"Pedido realizado.");
                MontoCompraPago=0;
                txtMontoPagoCompra.setText(null);
                modelCompras=(DefaultTableModel)tablePedido.getModel(); 
    int count= modelCompras.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelCompras.removeRow(0);   
        }
         listauxinv=new ArrayList<Inventory>();
      tablePedido.setModel(modelCompras);
      
        }}
         }
             catch(Exception e){
               JOptionPane.showMessageDialog(this,"Información faltante.");
            }finally{}
    }//GEN-LAST:event_btnCompraInsumosAddActionPerformed

    private void btnCapturaEgresos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaEgresos4ActionPerformed
         try{
        Inventory_Type obj= inventory_type.stream()
  .filter(o -> cbxProductoCompra.getSelectedItem().toString().equals(o.Description))
  .findAny()
  .orElse(null);
        if(Integer.parseInt(nupCantidadCompra.getValue().toString())==0 ||txtMontoCompra.getText().length()<1){
              JOptionPane.showMessageDialog(this,"Información faltante.");
              return;
        }
        listauxinv.add(new Inventory(obj.Id,Integer.parseInt(nupCantidadCompra.getValue().toString()),MontoCompra,0));
        modelCompras.addRow(new Object[]{obj.Category,obj.Description,Integer.parseInt(nupCantidadCompra.getValue().toString()),formatea.format(MontoCompra)});
        MontoCompra=0;
        txtMontoCompra.setText(null);
         txtMontoCompraTotal.setText(null);
         }
             catch(Exception e){
               JOptionPane.showMessageDialog(this,"Información faltante.");
           }finally{}
    }//GEN-LAST:event_btnCapturaEgresos4ActionPerformed
List<Inventory> listauxinv;
    private void btnCapturaIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaIngresosActionPerformed
           try{
        Account cuenta= accounts.stream()
  .filter(obj -> cbxCuentaIngresos.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
        Income_Type income= incomes.stream()
  .filter(obj -> cbxCatIngresos.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
     
        if(MontoIng==0){
               JOptionPane.showMessageDialog(this,"Falta ingresar monto.");
               return;
           }
        int fac=0;
        if(tbFacturaIngresos.isSelected()){
            fac=1;
        }
        con=new Conexion();
        con.Conectar();
        con.AddIncome(new Income(dtIngresos.getDate(),0,income.Id,txtDescripcionIngresos.getText(),cuenta.Id,fac,txtFacturaIngresos.getText(),MontoIng));
        con.Desconectar();
        JOptionPane.showMessageDialog(this,"Ingreso capturado con éxito.");
       MontoIng=0;
        txtDescripcionIngresos.setText(null);
       txtMontoIngresos.setText(null);
        }catch(Exception e){
               JOptionPane.showMessageDialog(this,"Información faltante.");
            }finally{}
    }//GEN-LAST:event_btnCapturaIngresosActionPerformed

    private void btnCapturaMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaMovActionPerformed
        try{
        Account cuentas= accounts.stream()
  .filter(obj -> cbxCuentaSalida.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
        Account cuentae= accounts.stream()
  .filter(obj -> cbxCuentaEntrada.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
    
        con=new Conexion();
         con.Conectar();
        con.AddMovesCajas(new Moves_Account(dtMov.getDate(),cuentas.Id,cuentae.Id,MontoMov,txtMovDetalle.getText(),Save.TemporalUser.Id));
    con.Desconectar();
        JOptionPane.showMessageDialog(this,"Movimiento capturado con éxito.");
       MontoMov=0;
       txtMontoMov.setText(null);
        }catch(Exception e){
               JOptionPane.showMessageDialog(this,"Información faltante.");
            }finally{}
    }//GEN-LAST:event_btnCapturaMovActionPerformed

    private void btnCompraInsumosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraInsumosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCompraInsumosRegistroIngresosClick

    private void btnCompraInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraInsumosActionPerformed
        pnlMovInsumos.setVisible(false);
        pnlCompraInsumos.setVisible(true);
                btnMovimientoInsumos.setBackground(new Color(253,239,229));
         btnCompraInsumos.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnCompraInsumosActionPerformed

    private void btnMovimientoInsumosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientoInsumosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMovimientoInsumosRegistroIngresosClick

    private void btnMovimientoInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientoInsumosActionPerformed
        pnlCompraInsumos.setVisible(false);
        pnlMovInsumos.setVisible(true);
          btnCompraInsumos.setBackground(new Color(253,239,229));
         btnMovimientoInsumos.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnMovimientoInsumosActionPerformed

    private void btnCapturarMovProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturarMovProductosActionPerformed
        try {
                Inventory_Type producto = inventory_type.stream()
  .filter(obj -> cbxProductoMovProducto.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                  SourceType src = sourcetype.stream()
  .filter(obj -> cbxSourceSalida.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                     SourceType src2 = sourcetype.stream()
  .filter(obj -> cbxSourceEntrada.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                   int cantidad=Integer.parseInt(nupCantidadMovProducto.getValue().toString());
                 if(cantidad==0){
                     return;
                 }
                  int qty=0;
                  for(Inventory_Moves obj: moveslist){
                      if(obj.Type_Id==producto.Id&&obj.Out_Id==src.Id){
                          qty+=obj.Qty;
                      }
                       if(obj.Type_Id==producto.Id&&obj.In_Id==src.Id){
                          qty-=obj.Qty;
                      }
                  }
                  
                  int stock=0;
                  if(src.Id==1){//distr
                      stock=producto.TotalStock-producto.CabinaStock-producto.PuntoVentaStock;
                  }else if(src.Id==2){//pv
                      stock=producto.PuntoVentaStock;
                  }else{
                      stock=producto.CabinaStock;
                  }
                  if(stock<(qty+cantidad)){
                 JOptionPane.showMessageDialog(this,"No hay suficientes productos para realizar esta acción.","Error de guardado",JOptionPane.ERROR_MESSAGE);
      return;
                  }
                  int trash=0;
                  if(checkMerma.isSelected()){
                      trash=1;
                  }
                  moveslist.add(new Inventory_Moves(src.Id,src2.Id,producto.Id,cantidad,trash));
                    modelMoves.addRow(new Object[]{src.Description,src2.Description,producto.Category,producto.Description,cantidad,checkMerma.isSelected()});
            
        } catch (Exception e) {
            }finally{}
    }//GEN-LAST:event_btnCapturarMovProductosActionPerformed

    private void btnGuardarMovProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMovProductoActionPerformed
     try{
         
          int n = JOptionPane.showConfirmDialog(this,
"¿Desea guardar estos movimientos? ","",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
         
          if(moveslist.size()<1){
                JOptionPane.showMessageDialog(this,"No hay filas agregadas.");
                return;
            }
        
                
                con=new Conexion();
                con.Conectar();
                try{
                    con.AddMovesProducto(new Inventory_Reg(dtMovProducto.getDate(),txtMovProductoCom.getText()),moveslist);
                     inventory_type = con.GetInventoryTypes2();
           
                } catch (SQLException ex) {}
                con.Desconectar();
                JOptionPane.showMessageDialog(this,"Productos actualizados con éxito.");
           
        vectorProductoMov.clear();
       
            for (Inventory_Type obj : inventory_type) {
            vectorProductoMov.add(obj.Description);
        }
            
        cbxProductoMovProducto.setModel(new DefaultComboBoxModel(vectorProductoMov));
        JTextField text = (JTextField) cbxProductoMovProducto.getEditor().getEditorComponent();
        text.setFocusable(true);
        text.setText("");
        text.addKeyListener(new ComboListener(cbxProductoMovProducto, vectorProductoMov));
        
              modelMoves=(DefaultTableModel)tableMovProducto.getModel(); 
    int count= modelMoves.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelMoves.removeRow(0);   
        }
         moveslist=new ArrayList<Inventory_Moves>();
//      tableMovProducto.setModel(modelMoves);
                
            
        
         }
    }
             catch(Exception e){
               JOptionPane.showMessageDialog(this,"Información faltante.");
            }finally{}
    }//GEN-LAST:event_btnGuardarMovProductoActionPerformed

    private void btnCompraInsumos3RegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompraInsumos3RegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCompraInsumos3RegistroIngresosClick

    private void btnCompraInsumos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraInsumos3ActionPerformed
           if(!InventariosBool){
           InventariosBool=true;
        Inventarios form=new Inventarios();
           form.setExtendedState(JFrame.MAXIMIZED_BOTH);
         form.setVisible(true);}
       
    }//GEN-LAST:event_btnCompraInsumos3ActionPerformed

    private void btnRegInsumosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegInsumosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegInsumosRegistroIngresosClick

    private void btnRegInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegInsumosActionPerformed
            if(!RegMovimientosInventariosBool){
           RegMovimientosInventariosBool=true;
        RegMovimientosInventario form=new RegMovimientosInventario();
           form.setExtendedState(JFrame.MAXIMIZED_BOTH);
         form.setVisible(true);}
       
    }//GEN-LAST:event_btnRegInsumosActionPerformed

    private void cbxSourceEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSourceEntradaActionPerformed
 try {
                SourceType src = sourcetype.stream()
  .filter(obj -> cbxSourceEntrada.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                if(src.Id==0){
                    checkMerma.setEnabled(true);
                }else 
                {
                     checkMerma.setEnabled(false);
                     checkMerma.setSelected(false);
                }
            } catch (Exception e) {
            }      finally{}  
    }//GEN-LAST:event_cbxSourceEntradaActionPerformed
List<Inventory_Moves> moveslist;
    private void btnRegComprasInsumosRegistroIngresosClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegComprasInsumosRegistroIngresosClick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegComprasInsumosRegistroIngresosClick

    private void btnRegComprasInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegComprasInsumosActionPerformed

 if(!RegInventarioBool){
     Save.status2=0;
           RegInventarioBool=true;
        RegInventario form=new RegInventario();
           form.setExtendedState(JFrame.MAXIMIZED_BOTH);
         form.setVisible(true);}
    }//GEN-LAST:event_btnRegComprasInsumosActionPerformed
    Conexion con;
    private void pnlVentasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlVentasComponentShown

        con=new Conexion();
        con.Conectar();
        try {
            Sales=con.GetSales();
        } catch (SQLException ex) {}
    con.Desconectar();

    model=(DefaultTableModel)tableVentas.getModel(); 
    int count= model.getRowCount();
         for(int i=0;i<count;i++)
        {
           model.removeRow(0);   
        }
       
        for(Sale obj: Sales)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Client,obj.Comentario,obj.Monto});
        }
        trs=new TableRowSorter(model);
        tableVentas.setRowSorter(trs);   
   
    }//GEN-LAST:event_pnlVentasComponentShown

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        txtBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusqueda.getText(),cbxFiltro.getSelectedIndex()));
            }
        });
        trs=new TableRowSorter(model);
        tableVentas.setRowSorter(trs);
    }//GEN-LAST:event_txtBusquedaKeyTyped
List<Account> accounts;
List<Income_Type> incomes;
List<Expense_Type> expenses;
@SuppressWarnings("rawtypes")

    private void pnlCompraInsumosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlCompraInsumosComponentShown
     modelCompras=(DefaultTableModel)tablePedido.getModel(); 
    int count= modelCompras.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelCompras.removeRow(0);   
        }
         listauxinv=new ArrayList<Inventory>();
      tablePedido.setModel(modelCompras);
      
    }//GEN-LAST:event_pnlCompraInsumosComponentShown

    private void checkPagarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPagarCompraActionPerformed
       if(checkPagarCompra.isSelected()){
           txtMontoPagoCompra.setEditable(true);
       }else{
            txtMontoPagoCompra.setText(null);
            txtMontoPagoCompra.setEditable(false);
       }
    }//GEN-LAST:event_checkPagarCompraActionPerformed

    private void tbFacturaIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFacturaIngresosActionPerformed
    if(tbFacturaIngresos.isSelected()){
        tbFacturaIngresos.setText("Si");
        txtFacturaIngresos.setEditable(true);
    }else{
          tbFacturaIngresos.setText("No");
            txtFacturaIngresos.setText(null);
        txtFacturaIngresos.setEditable(false); 
    }
    }//GEN-LAST:event_tbFacturaIngresosActionPerformed

    private void txtMontoIngresosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoIngresosKeyReleased
      try {
                MontoIng = Double.parseDouble(txtMontoIngresos.getText());
            } catch (Exception e) {
                MontoIng = 0;
                txtMontoIngresos.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoIngresosKeyReleased

    private void txtMontoMovKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoMovKeyReleased
     try {
                MontoMov = Double.parseDouble(txtMontoMov.getText());
            } catch (Exception e) {
                MontoMov = 0;
                txtMontoMov.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoMovKeyReleased

    private void txtMontoEgresosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoEgresosKeyReleased
           try {
                MontoEgr = Double.parseDouble(txtMontoEgresos.getText());
            } catch (Exception e) {
                MontoEgr = 0;
                txtMontoEgresos.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoEgresosKeyReleased

    private void tbFacturaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFacturaEgresosActionPerformed
        if(tbFacturaEgresos.isSelected()){
        tbFacturaEgresos.setText("Si");
        txtFacturaEgresos.setEditable(true);
    }else{
          tbFacturaEgresos.setText("No");
            txtFacturaEgresos.setText(null);
        txtFacturaEgresos.setEditable(false); 
    }
    }//GEN-LAST:event_tbFacturaEgresosActionPerformed

    private void cbxCuentaIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentaIngresosActionPerformed
         try {
                Account producto = accounts.stream()
  .filter(obj -> cbxCuentaIngresos.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                 txtTipoPagoIngresos.setText(""+producto.Categoria);
          
            } catch (Exception e) {
txtTipoPagoIngresos.setText("");
            }finally{}
    }//GEN-LAST:event_cbxCuentaIngresosActionPerformed

    private void cbxCuentaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentaEgresosActionPerformed
           try {
                Account producto = accounts.stream()
  .filter(obj -> cbxCuentaEgresos.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                 txtTipoPagoEgresos.setText(""+producto.Categoria);
          
            } catch (Exception e) {
txtTipoPagoEgresos.setText("");
            }finally{}
    }//GEN-LAST:event_cbxCuentaEgresosActionPerformed
double MontoCompra;
double MontoCompraPago;
    private void txtMontoCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoCompraKeyReleased
            try {
                MontoCompra= Double.parseDouble(txtMontoCompra.getText());
               if(checkCompraIVA.isSelected()){
                   MontoCompra=MontoCompra*1.16;
                   
               }
               txtMontoCompraTotal.setText(formatea.format(MontoCompra));
            } catch (Exception e) {
                MontoCompra = 0;
                txtMontoCompra.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoCompraKeyReleased

    private void txtMontoPagoCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoPagoCompraKeyReleased
         try {
                MontoCompraPago= Double.parseDouble(txtMontoPagoCompra.getText());
            } catch (Exception e) {
                MontoCompraPago = 0;
                txtMontoPagoCompra.setText(null);
            }finally{}
    }//GEN-LAST:event_txtMontoPagoCompraKeyReleased

    private void cbxProductoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoCompraActionPerformed
     try {
                Inventory_Type producto = inventory_type.stream()
  .filter(obj -> cbxProductoCompra.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                 txtMontoCompra.setText(""+producto.Cost);
          
            } catch (Exception e) {
            }finally{}
    }//GEN-LAST:event_cbxProductoCompraActionPerformed

    private void cbxProveedorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorCompraActionPerformed
         try {
                Provider prov = providers.stream()
  .filter(obj -> cbxProveedorCompra.getSelectedItem().toString().equals(obj.Description))
  .findAny()
  .orElse(null);
                vectorProductoCompra=new Vector();
          con=new Conexion();
          con.Conectar();
          try{
          tipos=con.GetInventoryTypesByProvider(prov.Id);
           } catch (SQLException ex) {}  finally{}
          con.Desconectar();
          vectorProductoCompra.clear();
           for(Inventory_Type obj : tipos){
        vectorProductoCompra.add(obj.Description);
        }
             cbxProductoCompra.setModel(new DefaultComboBoxModel(vectorProductoCompra));		
JTextField text = (JTextField)cbxProductoCompra.getEditor().getEditorComponent();
		text.setFocusable(true);
		text.setText("");
		text.addKeyListener(new ComboListener(cbxProductoCompra,vectorProductoCompra));
                
          
            } catch (Exception e) {
      vectorProductoCompra=new Vector();
      tipos=new ArrayList<Inventory_Type>();
         
             cbxProductoCompra.setModel(new DefaultComboBoxModel(vectorProductoCompra));		
JTextField text = (JTextField)cbxProductoCompra.getEditor().getEditorComponent();
		text.setFocusable(true);
		text.setText("");
		text.addKeyListener(new ComboListener(cbxProductoCompra,vectorProductoCompra));
                
            }finally{}
    }//GEN-LAST:event_cbxProveedorCompraActionPerformed

    private void tbFacturaIngresos1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbFacturaIngresos1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFacturaIngresos1StateChanged

    private void tbFacturaIngresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFacturaIngresos1ActionPerformed
        if(tbFacturaIngresos1.isSelected()){
        tbFacturaIngresos1.setText("Si");
        txtFacturaIngresos1.setEditable(true);
    }else{
          tbFacturaIngresos1.setText("No");
            txtFacturaIngresos1.setText(null);
        txtFacturaIngresos1.setEditable(false); 
    }
    }//GEN-LAST:event_tbFacturaIngresos1ActionPerformed

    private void checkCompraIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCompraIVAActionPerformed
       try {
                MontoCompra= Double.parseDouble(txtMontoCompra.getText());
               if(checkCompraIVA.isSelected()){
                   MontoCompra=MontoCompra*1.16;
                   
               }
               txtMontoCompraTotal.setText(formatea.format(MontoCompra));
            } catch (Exception e) {
         
            }finally{}
    }//GEN-LAST:event_checkCompraIVAActionPerformed
//eliminar de tabla compra
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          Save.ingreso=1;
       try{
       modelCompras.removeRow(tablePedido.getSelectedRows()[0]);
       listauxinv.remove(tablePedido.getSelectedRows()[0]);
     
       }catch(Exception e){}finally{}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pnlMovInsumosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlMovInsumosComponentShown
       moveslist=new ArrayList<Inventory_Moves>();
         modelMoves=(DefaultTableModel)tableMovProducto.getModel(); 
    int count= modelMoves.getRowCount();
         for(int i=0;i<count;i++)
        {
           modelMoves.removeRow(0);   
        }
         listauxinv=new ArrayList<Inventory>();
      tableMovProducto.setModel(modelMoves);
    }//GEN-LAST:event_pnlMovInsumosComponentShown

    private void txtMontoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoCompraActionPerformed

    private void tableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseClicked
     if (evt.getClickCount() == 2 && !evt.isConsumed()) {
     evt.consume();
}
    }//GEN-LAST:event_tableVentasMouseClicked

    private void btnPagoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoVentaActionPerformed
       Save.ingreso=1;
       try{
             Save.Providertext=tableVentas.getValueAt(tableVentas.getSelectedRow(), 2).toString();
     
           Client prov = clients.stream()
  .filter(obj -> Save.Providertext.equals(obj.Description))
  .findAny()
  .orElse(null);
           Save.Client=prov.Id;
        AddPagoCliente form=new AddPagoCliente();
           form.setModal(true);
        form.setVisible(true);
       }catch(Exception e){}finally{}       
        
    }//GEN-LAST:event_btnPagoVentaActionPerformed

    private void btnRegPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPagosActionPerformed
       Save.ingreso=1;
      try{
            Client client = clients.stream()
  .    filter(obj -> tableVentas.getValueAt(tableVentas.getSelectedRow(), 2).toString().equals(obj.Description))
  .    findAny()
  .    orElse(null);
       Save.Clienttext=tableVentas.getValueAt(tableVentas.getSelectedRow(), 2).toString();
        Save.Sale=client.Id;
         Save.Client=client.Id;
         if(!VerContenidoVentaBool){
           RegistroIngresosBool=true;
        RegistroIngresos form=new RegistroIngresos();
                    form.setModal(true);
          form.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
       form.show();}
       
       }catch(Exception e){}finally{}
    }//GEN-LAST:event_btnRegPagosActionPerformed

    private void tableVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseReleased
 
        
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
 
    MenuVentas.show(tableVentas, evt.getX(), evt.getY());
  
           }
    }//GEN-LAST:event_tableVentasMouseReleased

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
      try{
        Save.Sale2=Sales.stream()
  .    filter(obj -> Integer.parseInt(tableVentas.getValueAt(tableVentas.getSelectedRow(), 0).toString())==obj.Id)
  .    findAny()
  .    orElse(null);
          if(!VerContenidoVentaBool){
           VerContenidoVentaBool=true;
         VerContenidoVenta form= new VerContenidoVenta();
         form.setModal(true);
        form.setVisible(true);}
       
      }catch(Exception e){}finally{}
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnRentabilidadComercializadoraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRentabilidadComercializadoraMouseReleased
      if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
           MenuRentabilidad.show(this, evt.getX(), evt.getY());
           }
    }//GEN-LAST:event_btnRentabilidadComercializadoraMouseReleased

    private void btnFlujoComercializadoraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFlujoComercializadoraMouseReleased
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
           MenuFlujo.show(this, evt.getX(), evt.getY());
           }
    }//GEN-LAST:event_btnFlujoComercializadoraMouseReleased

    private void btnRentSpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentSpaActionPerformed
       Save.empresa=0;
      FixedRowExample2 form=new FixedRowExample2("spa");
             form.pack();
    form.setVisible(true); 
    }//GEN-LAST:event_btnRentSpaActionPerformed

    private void btnRentComercializadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentComercializadoraActionPerformed
       Save.empresa=1;
        FixedRowExample2 form=new FixedRowExample2("comercializadora");
             form.pack();
    form.setVisible(true);
    }//GEN-LAST:event_btnRentComercializadoraActionPerformed

    private void btnRentGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentGrupoActionPerformed
       Save.empresa=2;
              FixedRowExample form=new FixedRowExample("grupo");
             form.pack();
    form.setVisible(true); 
    }//GEN-LAST:event_btnRentGrupoActionPerformed

    private void btnRentSpa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentSpa1ActionPerformed
           Save.empresa=0;
      FixedRowExample form=new FixedRowExample("spa");
             form.pack();
    form.setVisible(true); 
    }//GEN-LAST:event_btnRentSpa1ActionPerformed

    private void btnRentComercializadora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentComercializadora1ActionPerformed
              Save.empresa=1;
        FixedRowExample form=new FixedRowExample("comercializadora");
             form.pack();
    form.setVisible(true); 
    }//GEN-LAST:event_btnRentComercializadora1ActionPerformed

    private void btnRentGrupo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentGrupo1ActionPerformed
              Save.empresa=2;
              FixedRowExample form=new FixedRowExample("grupo");
             form.pack();
    form.setVisible(true); 
     //  FlujoEconomico form=new FlujoEconomico();
       
     //  form.setVisible(true);
    }//GEN-LAST:event_btnRentGrupo1ActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
           try{
 int n = JOptionPane.showConfirmDialog(this,
"¿Desea eliminar el pedido número "+tableVentas.getValueAt(tableVentas.getSelectedRow(), 0).toString()+
        " ?, se eliminará todo su contenido a excepción de los pagos. ","",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
      
                
                con=new Conexion();
                con.Conectar();
                try{
                con.DeleteSale(Integer.parseInt(tableVentas.getValueAt(tableVentas.getSelectedRow(), 0).toString()));
                Sales=con.GetSales();
                } catch (SQLException ex) {}
                con.Desconectar();
                JOptionPane.showMessageDialog(this,"Eliminado realizado con éxito.");
             
    model=(DefaultTableModel)tableVentas.getModel(); 
    int count= model.getRowCount();
         for(int i=0;i<count;i++)
        {
           model.removeRow(0);   
        }

      for(Sale obj: Sales)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Client,obj.Comentario,obj.Monto});
        }
        trs=new TableRowSorter(model);
        tableVentas.setRowSorter(trs);   
   }
     }catch(Exception e){}finally{}
            
       
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void cbxSourceSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSourceSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSourceSalidaActionPerformed

    private void cbxProductoMovProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoMovProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProductoMovProductoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     
       try{
            int cantidad = moveslist.get(tableMovProducto.getSelectedRows()[0]).Qty;
           int productoId = moveslist.get(tableMovProducto.getSelectedRows()[0]).Type_Id;
           Inventory_Type producto = inventory_type.stream()
                   .filter(obj -> productoId == obj.Id)
                   .findAny()
                   .orElse(null);
           int qty = 0;
           for (Inventory_Moves obj : moveslist) {
               if (obj.Type_Id == productoId && obj.Out_Id == moveslist.get(tableMovProducto.getSelectedRows()[0]).In_Id) {
                   qty -= obj.Qty;
               }
               if (obj.Type_Id == productoId && obj.In_Id == moveslist.get(tableMovProducto.getSelectedRows()[0]).In_Id) {
                   qty += obj.Qty;
               }
           }

           int stock = 0;
           if (moveslist.get(tableMovProducto.getSelectedRows()[0]).In_Id == 1) {//distr
               stock = producto.TotalStock - producto.CabinaStock - producto.PuntoVentaStock;
           } else if (moveslist.get(tableMovProducto.getSelectedRows()[0]).In_Id == 2) {//pv
               stock = producto.PuntoVentaStock;
           } else {
               stock = producto.CabinaStock;
           } 
           
      
           if ((stock+qty-cantidad)<0 &&moveslist.get(tableMovProducto.getSelectedRows()[0]).In_Id != 0) {
                JOptionPane.showMessageDialog(this,"No hay suficientes productos para realizar esta acción.","Error de eliminación",JOptionPane.ERROR_MESSAGE);
    return;
           }
           modelMoves.removeRow(tableMovProducto.getSelectedRows()[0]);
           moveslist.remove(tableMovProducto.getSelectedRows()[0]);
     
       }catch(Exception e){}finally{}
    }//GEN-LAST:event_jButton6ActionPerformed
List<Inventory_Type> tipos;
DefaultTableModel modelMoves;
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLogo;
    private javax.swing.JPopupMenu MenuFlujo;
    private javax.swing.JPopupMenu MenuRentabilidad;
    private javax.swing.JPopupMenu MenuVentas;
    private javax.swing.JButton btnActualizarVentas;
    private javax.swing.JButton btnCajas;
    private javax.swing.JButton btnCapturaEgresos;
    private javax.swing.JButton btnCapturaEgresos4;
    private javax.swing.JButton btnCapturaIngresos;
    private javax.swing.JButton btnCapturaMov;
    private javax.swing.JButton btnCapturarMovProductos;
    private javax.swing.JButton btnCompraInsumos;
    private javax.swing.JButton btnCompraInsumos3;
    private javax.swing.JButton btnCompraInsumosAdd;
    private javax.swing.JButton btnEgresos;
    private javax.swing.JMenuItem btnEliminarVenta;
    private javax.swing.JButton btnEmpresa;
    private javax.swing.JButton btnFlujoComercializadora;
    private javax.swing.JButton btnGuardarMovProducto;
    private javax.swing.JButton btnHistorialCliente;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMovCajas;
    private javax.swing.JButton btnMovimientoInsumos;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JMenuItem btnPagoVenta;
    private javax.swing.JButton btnRegComprasInsumos;
    private javax.swing.JButton btnRegInsumos;
    private javax.swing.JMenuItem btnRegPagos;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JMenuItem btnRentComercializadora;
    private javax.swing.JMenuItem btnRentComercializadora1;
    private javax.swing.JMenuItem btnRentGrupo;
    private javax.swing.JMenuItem btnRentGrupo1;
    private javax.swing.JMenuItem btnRentSpa;
    private javax.swing.JMenuItem btnRentSpa1;
    private javax.swing.JButton btnRentabilidadComercializadora;
    private javax.swing.JButton btnResumenVentas;
    private javax.swing.JButton btnSaldoProveedores;
    private javax.swing.JButton btnVentas;
    private javax.swing.JMenuItem btnVerDetalle;
    private javax.swing.JComboBox<String> cbxCatEgresos;
    private javax.swing.JComboBox<String> cbxCatIngresos;
    private javax.swing.JComboBox<String> cbxCuentaCompra;
    private javax.swing.JComboBox<String> cbxCuentaEgresos;
    private javax.swing.JComboBox<String> cbxCuentaEntrada;
    private javax.swing.JComboBox<String> cbxCuentaIngresos;
    private javax.swing.JComboBox<String> cbxCuentaSalida;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxProductoCompra;
    private javax.swing.JComboBox<String> cbxProductoMovProducto;
    private javax.swing.JComboBox<String> cbxProveedorCompra;
    private javax.swing.JComboBox<String> cbxSourceEntrada;
    private javax.swing.JComboBox<String> cbxSourceSalida;
    private javax.swing.JCheckBox checkCompraIVA;
    private javax.swing.JCheckBox checkMerma;
    private javax.swing.JCheckBox checkPagarCompra;
    private com.toedter.calendar.JDateChooser dtCompraInsumos;
    private com.toedter.calendar.JDateChooser dtEgresos;
    private com.toedter.calendar.JDateChooser dtIngresos;
    private com.toedter.calendar.JDateChooser dtMov;
    private com.toedter.calendar.JDateChooser dtMovProducto;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JLabel lblBuscarVentas;
    private javax.swing.JSpinner nupCantidadCompra;
    private javax.swing.JSpinner nupCantidadMovProducto;
    private javax.swing.JPanel panelCapturaEgresos;
    private javax.swing.JPanel panelCapturaIngresos;
    private javax.swing.JPanel panelCapturaMov;
    private javax.swing.JPanel pnlCompraInsumos;
    private javax.swing.JPanel pnlEmpresa;
    private javax.swing.JPanel pnlInventarios;
    private javax.swing.JPanel pnlMov;
    private javax.swing.JPanel pnlMovInsumos;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JTable tableMovProducto;
    private javax.swing.JTable tablePedido;
    private javax.swing.JTable tableVentas;
    private javax.swing.JToggleButton tbFacturaEgresos;
    private javax.swing.JToggleButton tbFacturaIngresos;
    private javax.swing.JToggleButton tbFacturaIngresos1;
    private javax.swing.JToolBar tbVentas1;
    private javax.swing.JToolBar tbVentas2;
    private javax.swing.JTextPane txtBusqueda;
    private javax.swing.JTextField txtDescripcionEgresos;
    private javax.swing.JTextField txtDescripcionIngresos;
    private javax.swing.JTextField txtFacturaEgresos;
    private javax.swing.JTextField txtFacturaIngresos;
    private javax.swing.JTextField txtFacturaIngresos1;
    private javax.swing.JTextField txtMontoCompra;
    private javax.swing.JTextField txtMontoCompraTotal;
    private javax.swing.JTextField txtMontoEgresos;
    private javax.swing.JTextField txtMontoIngresos;
    private javax.swing.JTextField txtMontoMov;
    private javax.swing.JTextField txtMontoPagoCompra;
    private javax.swing.JTextField txtMovDetalle;
    private javax.swing.JTextArea txtMovProductoCom;
    private javax.swing.JTextField txtTipoPagoEgresos;
    private javax.swing.JTextField txtTipoPagoIngresos;
    // End of variables declaration//GEN-END:variables
}
