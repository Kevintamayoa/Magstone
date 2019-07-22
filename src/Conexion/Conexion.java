/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Classes.*;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author macbook
 */
public class Conexion {

    private Connection con = null;
    String url = "jdbc:mysql://209.59.155.254:3306/firmatio_Ayana_Spa";
    String user = "firmatio_Kevin2";
    String pass = "Kev110797inTam";
    public Conexion() {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public Connection Conectar() {
        return con;
    }
    public void Desconectar() {
        con = null;
    }
//Get//
    public List<User> GetUsers(){
        String sql = "SELECT * FROM user WHERE type_id<>0 ;";
         List<User> list = new ArrayList<User>();
  
        try{
       
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Name = rs.getString(2);
                String Password = rs.getString(3);
                int UserType = rs.getInt(4);
                list.add(new User(Id, Name, Password, UserType));
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Account> GetAccounts() throws SQLException {
        String sql = "SELECT A.id,A.description,A.type_id,A.inicial,B.description "
                + "FROM account A INNER JOIN account_type B ON(B.id=A.type_id) order by A.description asc;";
        List<Account> list = new ArrayList<Account>();
  
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                int AccountsType = rs.getInt(3);
                double Ppt = rs.getDouble(4);
                String categoria = rs.getString(5);
                list.add(new Account(Id, Description, AccountsType, Ppt,categoria));
            }

        return list;
    }
        public List<Account> GetSaldoAccounts() throws SQLException {
        String sql = "SELECT A.id,A.description,A.type_id,(A.inicial-(CASE WHEN (SELECT COUNT(*)"
                + " FROM expense C WHERE C.account_id=A.id)=0 THEN 0 ELSE (SELECT SUM(C.amount) "
                + "FROM expense C WHERE C.account_id=A.id) END)+(CASE WHEN (SELECT COUNT(*) FROM "
                + "income C WHERE C.account_id=A.id)=0 THEN 0 ELSE (SELECT SUM(C.amount) FROM income"
                + " C WHERE C.account_id=A.id) END)+(CASE WHEN (SELECT COUNT(*) FROM moves_account C"
                + " WHERE C.in_id =A.id)=0 THEN 0 ELSE (SELECT SUM(C.amount) FROM moves_account C WHERE"
                + " C.in_id=A.id) END) -(CASE WHEN (SELECT COUNT(*) FROM moves_account C WHERE C.out_id =A.id)=0 "
                + "THEN 0 ELSE (SELECT SUM(C.amount) FROM moves_account C WHERE C.out_id=A.id) END)) as inicial,"
                + "B.description FROM account A INNER JOIN account_type B ON(B.id=A.type_id) "
                + "WHERE A.id<>0 order by A.description asc;";
        List<Account> list = new ArrayList<Account>();
  
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                int AccountsType = rs.getInt(3);
                double Ppt = rs.getDouble(4);
                String categoria = rs.getString(5);
                list.add(new Account(Id, Description, AccountsType, Ppt,categoria));
            }

        return list;
    }
          public List<Account> GetSaldoAccounts2() throws SQLException {
            String sql = "SELECT A.id,A.description,A.type_id,(A.inicial-(CASE WHEN (SELECT COUNT(*)"
                + " FROM expense C WHERE C.account_id=A.id)=0 THEN 0 ELSE (SELECT SUM(C.amount) "
                + "FROM expense C WHERE C.account_id=A.id) END)+(CASE WHEN (SELECT COUNT(*) FROM "
                + "income C WHERE C.account_id=A.id)=0 THEN 0 ELSE (SELECT SUM(C.amount) FROM income"
                + " C WHERE C.account_id=A.id) END)+(CASE WHEN (SELECT COUNT(*) FROM moves_account C"
                + " WHERE C.in_id =A.id)=0 THEN 0 ELSE (SELECT SUM(C.amount) FROM moves_account C WHERE"
                + " C.in_id=A.id) END) -(CASE WHEN (SELECT COUNT(*) FROM moves_account C WHERE C.out_id =A.id)=0 "
                + "THEN 0 ELSE (SELECT SUM(C.amount) FROM moves_account C WHERE C.out_id=A.id) END)) as inicial,"
                + "B.description FROM account A INNER JOIN account_type B ON(B.id=A.type_id) "
                + "WHERE A.id=1 order by A.description asc;";
        List<Account> list = new ArrayList<Account>();
  
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                int AccountsType = rs.getInt(3);
                double Ppt = rs.getDouble(4);
                String categoria = rs.getString(5);
                list.add(new Account(Id, Description, AccountsType, Ppt,categoria));
            }

        return list;
    }
  
    public List<Account> GetAccounts2() throws SQLException {
        String sql = "SELECT A.id,A.description,A.type_id,A.inicial,B.description "
                + "FROM account A INNER JOIN account_type B ON(B.id=A.type_id) WHERE A.id<>0 order by A.description asc;";
        List<Account> list = new ArrayList<Account>();
  
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                int AccountsType = rs.getInt(3);
                double Ppt = rs.getDouble(4);
                String categoria = rs.getString(5);
                list.add(new Account(Id, Description, AccountsType, Ppt,categoria));
            }

        return list;
    }
    public List<Client> GetClients() throws SQLException {
        String sql = "SELECT * FROM client ORDER BY description ASC;";
        List<Client> list = new ArrayList<Client>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                String Direccion = rs.getString(3);
                String Email = rs.getString(4);
                String Telefono = rs.getString(5);
                    list.add(new Client(Id, Description,Direccion,Email,Telefono));
            }
        return list;
    }
        public Client GetClientById2(int idd) throws SQLException {
        String sql = "SELECT * FROM client WHERE id="+idd+" ;";
        List<Client> list = new ArrayList<Client>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                String Direccion = rs.getString(3);
                String Email = rs.getString(4);
                String Telefono = rs.getString(5);
                    return new Client(Id, Description,Direccion,Email,Telefono);
            }
        return null;
    }
     public List<Expense> GetExpensesByProvider(int idd) throws SQLException {
        String sql = "SELECT A.id,A.date,B.description,A.concept,C.description,A.bills,A.billsnumber,A.amount,D.name "
                + "FROM expense A INNER JOIN expense_type B ON(A.type_id=B.id) INNER JOIN account C ON(A.account_id=C.id)"
                + " INNER JOIN user D ON(A.user_id=D.id) INNER JOIN provider_pay E ON(A.id=E.expense_id) WHERE E.provider_id="+idd+";";
        List<Expense> list = new ArrayList<Expense>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                String Type=rs.getString(3);
                String Concept=rs.getString(4);
                String Account=rs.getString(5);
                int Bills=rs.getInt(6);
                String BillsNumber=rs.getString(7);
                double amount=rs.getDouble(8);
                String user=rs.getString(9);
                
                    list.add(new Expense(Id, Date,Type,Concept,Account,Bills,BillsNumber,amount,user));
            }
        return list;
    }  
    public List<Expense> GetExpenses() throws SQLException {
        String sql = "SELECT A.id,A.date,B.description,A.concept,C.description,A.bills,A.billsnumber,A.amount,D.name "
                + "FROM expense A INNER JOIN expense_type B ON(A.type_id=B.id) INNER JOIN account C ON(A.account_id=C.id)"
                + " INNER JOIN user D ON(A.user_id=D.id) ;";
        List<Expense> list = new ArrayList<Expense>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                String Type=rs.getString(3);
                String Concept=rs.getString(4);
                String Account=rs.getString(5);
                int Bills=rs.getInt(6);
                String BillsNumber=rs.getString(7);
                double amount=rs.getDouble(8);
                String user=rs.getString(9);
                
                    list.add(new Expense(Id, Date,Type,Concept,Account,Bills,BillsNumber,amount,user));
            }
        return list;
    }
    public List<Expense_Type> GetExpenseTypes() throws SQLException {
        String sql = "SELECT * FROM expense_type WHERE id<>1 ORDER BY description asc ;";
        List<Expense_Type> list = new ArrayList<Expense_Type>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Type=rs.getString(2);
                double amount=rs.getDouble(3);
                int user=rs.getInt(4);
                 int source=rs.getInt(5);
                    list.add(new Expense_Type(Id, Type,amount,user,source));
            }
        return list;
    }
    public List<Income> GetIncomes() throws SQLException {
        String sql = "SELECT A.id,A.date,E.description,B.description,A.concept,C.description,A.bills,A.billsnumber,A.amount,D.name "
                + "FROM income A INNER JOIN income_type B ON(A.type_id=B.id) INNER JOIN account C ON(A.account_id=C.id)"
                + " INNER JOIN user D ON(A.user_id=D.id) INNER JOIN client E ON(A.client_id=E.id);";
        List<Income> list = new ArrayList<Income>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                 String client=rs.getString(3);
                String Type=rs.getString(4);
                String Concept=rs.getString(5);
                String Account=rs.getString(6);
                int Bills=rs.getInt(7);
                String BillsNumber=rs.getString(8);
                double amount=rs.getDouble(9);
                String user=rs.getString(10);
                
                    list.add(new Income(Id, Date,client,Type,Concept,Account,Bills,BillsNumber,amount,user));
            }
        return list;
    }
   public List<Income> GetIncomesBySale(int idd) throws SQLException {
        String sql = "SELECT A.id,A.date,F.description,B.description,A.concept,C.description,A.bills,A.billsnumber,A.amount,D.name "
                + "FROM income A INNER JOIN income_type B ON(A.type_id=B.id) INNER JOIN account C ON(A.account_id=C.id)"
                + " INNER JOIN user D ON(A.user_id=D.id)  INNER JOIN client F ON(F.id=A.client_id) WHERE F.id="+idd+" ORDER BY A.date;";
        List<Income> list = new ArrayList<Income>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                String client=rs.getString(3);
                String Type=rs.getString(4);
                String Concept=rs.getString(5);
                String Account=rs.getString(6);
                int Bills=rs.getInt(7);
                String BillsNumber=rs.getString(8);
                double amount=rs.getDouble(9);
                String user=rs.getString(10);
                
                    list.add(new Income(Id, Date,client,Type,Concept,Account,Bills,BillsNumber,amount,user));
            }
        return list;
    }  
    public List<Moves_Account> GetMovesCajas() throws SQLException {
        String sql = "SELECT A.id,A.date,B.description,C.description,A.amount,A.description,D.name"
                + " FROM moves_account A INNER JOIN account B ON(A.out_id=B.id) INNER JOIN account C ON(A.in_id=C.id) "
                + "INNER JOIN user D ON(A.user_id=D.id) order by A.date asc ;";
        List<Moves_Account> list = new ArrayList<Moves_Account>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                  String out=rs.getString(3);
                 String in=rs.getString(4);
                double amount=rs.getDouble(5);
                String desc=rs.getString(6);
                 String user=rs.getString(7);
                    list.add(new Moves_Account(Id, Date,out,in,amount,desc,user));
            }
        return list;
    }
    public List<Income_Type> GetIncomeTypes() throws SQLException {
        String sql = "SELECT * FROM income_type WHERE id<>1 ORDER BY description asc;";
        List<Income_Type> list = new ArrayList<Income_Type>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Type=rs.getString(2);
                double amount=rs.getDouble(3);
                int user=rs.getInt(4);
                 int source=rs.getInt(5);
                    list.add(new Income_Type(Id, Type,amount,user,source));
            }
        return list;
    }
       public List<SourceType> GetSources() throws SQLException {
        String sql = "SELECT * FROM sourcetype ;";
        List<SourceType> list = new ArrayList<SourceType>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Type=rs.getString(2);
      
                    list.add(new SourceType(Id, Type));
            }
        return list;
    }
    public List<Request> GetRequestByProvider(int id) throws SQLException {
        String sql = "SELECT A.id,A.date,A.comentario,B.description,A.account_id,C.description,A.state_id,"
               + "CASE WHEN (SELECT COUNT(*) FROM inventory F WHERE F.request_id=A.id)=0 THEN 0 ELSE "
                + "(SELECT SUM(F.cost) FROM inventory F WHERE F.request_id=A.id) END as monto"
                + " FROM request A INNER JOIN provider B ON(A.provider_id=B.id) INNER JOIN account C "
                + "ON(A.account_id=C.id) WHERE A.provider_id="+id+" ORDER BY A.date ASC;";
        List<Request> list = new ArrayList<Request>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                String Comentario=rs.getString(3);
                String provider=rs.getString(4);
                int account_id=rs.getInt(5);
                String account=rs.getString(6);
                int state=rs.getInt(7);
                   double monto=rs.getDouble(8);
                list.add(new Request(Id, Date,Comentario,provider,account_id,account,state,monto));
            }
        return list;
    }
    public List<Request> GetRequest() throws SQLException {
        String sql = "SELECT A.id,A.date,A.comentario,B.description,A.account_id,C.description,A.state_id,"
                + "CASE WHEN (SELECT COUNT(*) FROM inventory F WHERE F.request_id=A.id)=0 THEN 0 ELSE "
                + "(SELECT SUM(F.cost) FROM inventory F WHERE F.request_id=A.id) END as monto"
                + " FROM request A INNER JOIN provider B ON(A.provider_id=B.id) INNER JOIN account C "
                + "ON(A.account_id=C.id) ORDER BY A.date ASC;";
        List<Request> list = new ArrayList<Request>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                String Comentario=rs.getString(3);
                String provider=rs.getString(4);
                int account_id=rs.getInt(5);
                String account=rs.getString(6);
                int state=rs.getInt(7);
                double monto=rs.getDouble(8);
                list.add(new Request(Id, Date,Comentario,provider,account_id,account,state,monto));
            }
        return list;
    }
    public List<Sale> GetSales() throws SQLException {
        String sql = "SELECT A.id,A.date,A.client_id,B.description,A.comentario,A.monto "
                + " FROM sale A INNER JOIN client B ON(A.client_id=B.id) order by A.date asc ;";
        List<Sale> list = new ArrayList<Sale>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                  int client_id=rs.getInt(3);
                 String client=rs.getString(4);
                String comen=rs.getString(5);
                double monto=rs.getDouble(6);
                    list.add(new Sale(Id, Date,client_id,client,comen,monto));
            }
        return list;
    }
     public List<Sale> GetSalesByClient(int idd) throws SQLException {
        String sql = "SELECT A.id,A.date,A.client_id,B.description,A.comentario,A.monto "
                + " FROM sale A INNER JOIN client B ON(A.client_id=B.id) WHERE A.client_id="+idd+" order by A.date asc ;";
        List<Sale> list = new ArrayList<Sale>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                  int client_id=rs.getInt(3);
                 String client=rs.getString(4);
                String comen=rs.getString(5);
                double monto=rs.getDouble(6);
                    list.add(new Sale(Id, Date,client_id,client,comen,monto));
            }
        return list;
    }
    public List<Inventory> GetInventoryByRequest(int id) throws SQLException {
        String sql = "SELECT A.id,A.type_id,B.description,C.description,A.request_id,A.qty,A.cost,A.status "
                + " FROM inventory A INNER JOIN inventory_type B ON(A.type_id=B.id) "
                + "INNER JOIN inventory_category C ON(B.category_id=C.id)  WHERE A.request_id="+id+";";
        List<Inventory> list = new ArrayList<Inventory>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
            int type=rs.getInt(2);
            String typee=rs.getString(3);
            String cat=rs.getString(4);
                 int request=rs.getInt(5);
                int qty=rs.getInt(6);
                 double cost=rs.getDouble(7);
                     int status=rs.getInt(8);
                    list.add(new Inventory(Id, type,typee,cat,request,qty,cost,status));
            }
        return list;
    }
        public Inventory GetInventoryById(int id) throws SQLException {
        String sql = "SELECT A.id,A.type_id,B.description,C.description,A.request_id,A.qty,A.cost,A.status "
                + " FROM inventory A INNER JOIN inventory_type B ON(A.type_id=B.id) "
                + "INNER JOIN inventory_category C ON(B.category_id=C.id)  WHERE A.id="+id+";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
            int type=rs.getInt(2);
            String typee=rs.getString(3);
            String cat=rs.getString(4);
                 int request=rs.getInt(5);
                int qty=rs.getInt(6);
                 double cost=rs.getDouble(7);
                     int status=rs.getInt(8);
                    return new Inventory(Id, type,typee,cat,request,qty,cost,status);
            }
        return null;
    }
    
    public List<Inventory_Reg> GetInventory_Reg() throws SQLException {
        String sql = "SELECT * FROM inventory_reg ORDER BY date asc;";
        List<Inventory_Reg> list = new ArrayList<Inventory_Reg>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
            java.util.Date date=rs.getDate(2);
                 String comentario=rs.getString(3);
                    list.add(new Inventory_Reg(Id,date,comentario));
            }
        return list;
    }
    public List<Inventory_Moves> GetInventoryMovesByRegId(int regid) throws SQLException {
        String sql = "SELECT A.id,B.description,C.description,D.description,A.qty,A.trash,A.reg_id"
                + " FROM inventory_moves A INNER JOIN sourcetype B ON(A.out_id=B.id) INNER JOIN "
                + "sourcetype C ON(A.in_id=C.id) INNER JOIN inventory_type D ON(A.type_id=D.id) "
                + "WHERE A.reg_id="+regid+" ;";
        List<Inventory_Moves> list = new ArrayList<Inventory_Moves>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
           String out=rs.getString(2);
           String in=rs.getString(3);
                 String type=rs.getString(4);
                  int qty = rs.getInt(5);
                   int trash = rs.getInt(6);
                    int reg = rs.getInt(7);
                    list.add(new Inventory_Moves(Id,out,in,type,qty,trash,reg));
            }
        return list;
    } 
        public List<Inventory_Moves> GetInventoryMovesByRegId2(int regid) throws SQLException {
        String sql =   "SELECT B.id,(B.totalstock+(CASE WHEN (Select SUM(C.qty) FROM inventory_moves C WHERE C.type_id=B.id "
                + "AND C.reg_id="+regid+" AND C.in_id=0 )IS NULL THEN 0 ELSE (Select SUM(C.qty) FROM inventory_moves C WHERE"
                + " C.type_id=B.id AND C.reg_id="+regid+" AND C.in_id=0 ) END)) AS TOTALSTOCK,(B.puntoventastock-((CASE WHEN (Select SUM(C.qty) "
                + "FROM inventory_moves C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.in_id=2 ) IS NULL THEN 0 ELSE (Select SUM(C.qty) "
                + "FROM inventory_moves C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.in_id=2 ) END)-(CASE WHEN (Select SUM(C.qty) FROM "
                + "inventory_moves C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.out_id=2 ) IS NULL THEN 0 ELSE (Select SUM(C.qty) FROM"
                + " inventory_moves C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.out_id=2 ) END))) AS PV" 
                + ",(B.cabinastock-((CASE WHEN (Select SUM(C.qty) FROM inventory_moves C WHERE C.type_id=B.id"
                + " AND C.reg_id="+regid+" AND C.in_id=3 ) IS NULL THEN 0 ELSE (Select SUM(C.qty) FROM inventory_moves"
                + " C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.in_id=3 ) END)-(CASE WHEN (Select SUM(C.qty) FROM "
                + "inventory_moves C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.out_id=3 ) IS NULL THEN 0 ELSE "
                + "(Select SUM(C.qty) FROM inventory_moves C WHERE C.type_id=B.id AND C.reg_id="+regid+" AND C.out_id=3 ) END)))"
                + " AS CABINA   FROM inventory_moves A INNER JOIN inventory_type B ON(A.type_id=B.id) WHERE A.reg_id="+regid+" "
                + "GROUP BY A.type_id;";
    
            List<Inventory_Moves> list = new ArrayList<Inventory_Moves>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                int total = rs.getInt(2);
                int punto = rs.getInt(3);
                int cabina = rs.getInt(4);
                list.add(new Inventory_Moves(Id, total, punto, cabina));
            }
        return list;
    } 
           public Inventory_Moves GetInventoryMovesByRegId3(int regid) throws SQLException {
        String sql =   "SELECT B.id,(B.totalstock+(CASE WHEN (Select SUM(C.qty) FROM inventory_moves C WHERE C.type_id=B.id "
                + "AND C.id="+regid+" AND C.in_id=0 )IS NULL THEN 0 ELSE (Select SUM(C.qty) FROM inventory_moves C WHERE"
                + " C.type_id=B.id AND C.id="+regid+" AND C.in_id=0 ) END)) AS TOTALSTOCK,(B.puntoventastock-((CASE WHEN (Select SUM(C.qty) "
                + "FROM inventory_moves C WHERE C.type_id=B.id AND C.id="+regid+" AND C.in_id=2 ) IS NULL THEN 0 ELSE (Select SUM(C.qty) "
                + "FROM inventory_moves C WHERE C.type_id=B.id AND C.id="+regid+" AND C.in_id=2 ) END)-(CASE WHEN (Select SUM(C.qty) FROM "
                + "inventory_moves C WHERE C.type_id=B.id AND C.id="+regid+" AND C.out_id=2 ) IS NULL THEN 0 ELSE (Select SUM(C.qty) FROM"
                + " inventory_moves C WHERE C.type_id=B.id AND C.id="+regid+" AND C.out_id=2 ) END))) AS PV" 
                + ",(B.cabinastock-((CASE WHEN (Select SUM(C.qty) FROM inventory_moves C WHERE C.type_id=B.id"
                + " AND C.id="+regid+" AND C.in_id=3 ) IS NULL THEN 0 ELSE (Select SUM(C.qty) FROM inventory_moves"
                + " C WHERE C.type_id=B.id AND C.id="+regid+" AND C.in_id=3 ) END)-(CASE WHEN (Select SUM(C.qty) FROM "
                + "inventory_moves C WHERE C.type_id=B.id AND C.id="+regid+" AND C.out_id=3 ) IS NULL THEN 0 ELSE "
                + "(Select SUM(C.qty) FROM inventory_moves C WHERE C.type_id=B.id AND C.id="+regid+" AND C.out_id=3 ) END)))"
                + " AS CABINA FROM inventory_moves A INNER JOIN inventory_type B ON(A.type_id=B.id) WHERE A.id="+regid+" "
                + "GROUP BY A.type_id;";
    
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                int total = rs.getInt(2);
                int punto = rs.getInt(3);
                int cabina = rs.getInt(4);
                return new Inventory_Moves(Id, total, punto, cabina);
            }
        return null;
    } 

  public List<Inventory_Type> GetInventoryTypesByProvider(int prov) throws SQLException {
        String sql = "SELECT A.id,A.description,A.cost,A.price,A.minstock,B.description,C.description,"
                + "D.description,A.totalstock,A.puntoventastock,A.cabinastock FROM inventory_type A "
                + "INNER JOIN inventory_category B ON(A.category_id=B.id) INNER JOIN inventory_subcategory "
                + "C ON(A.subcategory_id=C.id) INNER JOIN provider D ON(A.provider_id=D.id) WHERE A.provider_id="+prov+";";
        List<Inventory_Type> list = new ArrayList<Inventory_Type>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description=rs.getString(2);
                double cost=rs.getDouble(3);
                double price=rs.getDouble(4);
            int min=rs.getInt(5);
               String cat=rs.getString(6);
                  String sub=rs.getString(7);
                     String provv=rs.getString(8);
                int total=rs.getInt(9);
                 int punto=rs.getInt(10);
                 int cabina=rs.getInt(11);
                    list.add(new Inventory_Type(Id,Description,cost,price,
                    min,cat,sub,provv,total,punto,cabina));
            }
        return list;
    }  
    public List<Inventory_Type> GetInventoryTypes() throws SQLException {
        String sql = "SELECT A.id,A.description,A.cost,A.price,A.minstock,B.description,C.description,"
                + "D.description,A.totalstock,A.puntoventastock,A.cabinastock,CASE WHEN (SELECT COUNT(*) FROM inventory F"
                + " WHERE F.type_id=A.id )=0 THEN 0 ELSE (SELECT SUM(F.qty) FROM inventory F"
                + " INNER JOIN request G ON(F.request_id=G.id) WHERE F.type_id=A.id AND (G.state_id=0 OR G.state_id=2 )) END as reb FROM inventory_type A "
                + "INNER JOIN inventory_category B ON(A.category_id=B.id) INNER JOIN inventory_subcategory "
                + "C ON(A.subcategory_id=C.id) INNER JOIN provider D ON(A.provider_id=D.id) ORDER BY A.description ASC;";
        List<Inventory_Type> list = new ArrayList<Inventory_Type>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description=rs.getString(2);
                double cost=rs.getDouble(3);
                double price=rs.getDouble(4);
            int min=rs.getInt(5);
               String cat=rs.getString(6);
                  String sub=rs.getString(7);
                     String prov=rs.getString(8);
                int total=rs.getInt(9);
                 int punto=rs.getInt(10);
                 int cabina=rs.getInt(11);
                  int reb=rs.getInt(12);
                    list.add(new Inventory_Type(Id,Description,cost,price,
                    min,cat,sub,prov,total,punto,cabina,reb));
            }
        return list;
    }  
    public List<Inventory_Category> GetInventoryCategory() throws SQLException {
        String sql = "SELECT * FROM inventory_category A WHERE A.id<>0 ORDER BY A.description ASC;";
        List<Inventory_Category> list = new ArrayList<Inventory_Category>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description=rs.getString(2);
          
                    list.add(new Inventory_Category(Id,Description));
            }
        return list;
    }  
    
    public List<Inventory_Type> GetInventoryTypes2() throws SQLException {
        String sql = "SELECT A.id,A.description,A.cost,A.price,A.minstock,B.description,C.description,"
                + "D.description,A.totalstock,A.puntoventastock,A.cabinastock,CASE WHEN (SELECT COUNT(*) FROM inventory F"
                + " WHERE F.type_id=A.id )=0 THEN 0 ELSE (SELECT SUM(F.qty) FROM inventory F"
                + " INNER JOIN request G ON(F.request_id=G.id) WHERE F.type_id=A.id AND (G.state_id=0 OR G.state_id=2 )) END as reb FROM inventory_type A "
                + "INNER JOIN inventory_category B ON(A.category_id=B.id) INNER JOIN inventory_subcategory "
                + "C ON(A.subcategory_id=C.id) INNER JOIN provider D ON(A.provider_id=D.id) WHERE A.id<>0 ORDER BY A.description ASC;";
        List<Inventory_Type> list = new ArrayList<Inventory_Type>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description=rs.getString(2);
                double cost=rs.getDouble(3);
                double price=rs.getDouble(4);
            int min=rs.getInt(5);
               String cat=rs.getString(6);
                  String sub=rs.getString(7);
                     String prov=rs.getString(8);
                int total=rs.getInt(9);
                 int punto=rs.getInt(10);
                 int cabina=rs.getInt(11);
                  int reb=rs.getInt(12);
                    list.add(new Inventory_Type(Id,Description,cost,price,
                    min,cat,sub,prov,total,punto,cabina,reb));
            }
        return list;
    }  
    public List<Service_Type> GetServiceType() throws SQLException {
        String sql = "SELECT * FROM service_type ORDER BY description asc;";
        List<Service_Type> list = new ArrayList<Service_Type>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description=rs.getString(2);
                double cost=rs.getDouble(3);
                 double cost1=rs.getDouble(4);
                double price=rs.getDouble(5);
            int min=rs.getInt(6);
             
                    list.add(new Service_Type(Id,Description,cost,cost1,price,min));
            }
        return list;
    }  
        public List<Sale_Inventory> GetSaleInventoryBySale(int idd) throws SQLException {
        String sql = "SELECT A.id,A.inventory_id,B.description,A.qty,A.amount FROM sale_inventory A INNER JOIN inventory_type B ON(A.inventory_id=B.id) WHERE A.sale_id="+idd+" ORDER BY A.id asc;";
        List<Sale_Inventory> list = new ArrayList<Sale_Inventory>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                 int Type_Id = rs.getInt(2);
                String Description=rs.getString(3);
                int qty=rs.getInt(4);
                 double amount=rs.getDouble(5);
     
                    list.add(new Sale_Inventory(Id,Type_Id,Description,qty,amount));
            }
        return list;
    }  
            public List<Sale_Service> GetSaleServicesBySale(int idd) throws SQLException {
        String sql = "SELECT A.id,A.service_id,B.description,A.qty,A.amount FROM sale_service A INNER JOIN service_type B ON(A.service_id=B.id) WHERE A.sale_id="+idd+" ORDER BY A.id asc;";
        List<Sale_Service> list = new ArrayList<Sale_Service>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                 int Type_Id = rs.getInt(2);
                String Description=rs.getString(3);
                int qty=rs.getInt(4);
                 double amount=rs.getDouble(5);
     
                    list.add(new Sale_Service(Id,Type_Id,Description,qty,amount));
            }
        return list;
    }  
    public List<Provider> GetRegProviders() throws SQLException {
        String sql = "SELECT A.id,A.description,A.contacto,A.email,A.detalle,"
                + "(CASE WHEN (SELECT COUNT(*) FROM request B INNER JOIN inventory C ON(C.request_id=B.id)  WHERE B.provider_id=A.id ) =0 THEN 0"
                + " ELSE (SELECT SUM(C.cost) FROM request B INNER JOIN inventory C ON(C.request_id=B.id)  WHERE B.provider_id=A.id ) END) as monto,"
                + "(CASE WHEN (SELECT COUNT(*) FROM provider_pay D WHERE D.provider_id=A.id) =0 THEN 0"
                + " ELSE (SELECT SUM(E.amount) FROM provider_pay D INNER JOIN expense E ON(D.expense_id=E.id) WHERE D.provider_id=A.id) END) as cobrado"
                + " FROM provider A WHERE A.id<>0 GROUP BY A.id ORDER BY A.description asc;";
        List<Provider> list = new ArrayList<Provider>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String description=rs.getString(2);
                String contacto=rs.getString(3);
                String email=rs.getString(4);
                String detalle=rs.getString(5);
                 double montot=rs.getDouble(6);
                 double montopagado=rs.getDouble(7);
                    list.add(new Provider(Id,description,contacto,email,detalle,montot,montopagado));
            }
        return list;
    }
       public List<Client> GetRegClients() throws SQLException {
        String sql = "SELECT A.id,A.description,A.direccion,A.email,A.telefono,"
                + "(CASE WHEN (SELECT COUNT(*) FROM sale B WHERE B.client_id=A.id ) =0 THEN 0"
                + " ELSE (SELECT SUM(B.monto) FROM sale B WHERE B.client_id=A.id ) END) as monto,"
                + "(CASE WHEN (SELECT COUNT(*) FROM income D WHERE D.client_id=A.id) =0 THEN 0"
                + " ELSE (SELECT SUM(D.amount) FROM income D WHERE D.client_id=A.id) END) as cobrado"
                + " FROM client A GROUP BY A.id ORDER BY A.description asc;";
        List<Client> list = new ArrayList<Client>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String description=rs.getString(2);
                String contacto=rs.getString(3);
                String email=rs.getString(4);
                String detalle=rs.getString(5);
                 double montot=rs.getDouble(6);
                 double montopagado=rs.getDouble(7);
                    list.add(new Client(Id,description,contacto,email,detalle,montot,montopagado));
            }
        return list;
    }

    public Client GetClientById(int id) throws SQLException {
        String sql = "SELECT A.id,A.description,A.direccion,A.email,A.telefono,"
                + "(CASE WHEN (SELECT COUNT(*) FROM sale B WHERE B.client_id=A.id ) =0 THEN 0"
                + " ELSE (SELECT SUM(B.monto) FROM sale B WHERE B.client_id=A.id ) END) as monto,"
                + "(CASE WHEN (SELECT COUNT(*) FROM income D WHERE D.client_id=A.id) =0 THEN 0"
                + " ELSE (SELECT SUM(D.amount) FROM income D WHERE D.client_id=A.id) END) as cobrado"
                + " FROM client A WHERE A.id="+id+" GROUP BY A.id ORDER BY A.description asc;";
        List<Client> list = new ArrayList<Client>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String description=rs.getString(2);
                String contacto=rs.getString(3);
                String email=rs.getString(4);
                String detalle=rs.getString(5);
                 double montot=rs.getDouble(6);
                 double montopagado=rs.getDouble(7);
                    return new Client(Id,description,contacto,email,detalle,montot,montopagado);
            }
        return null;
    }
    
   //////////////
    public Provider GetProviderById(int id) throws SQLException {
             String sql = "SELECT A.id,A.description,A.contacto,A.email,A.detalle,"
                + "(CASE WHEN (SELECT COUNT(*) FROM request B INNER JOIN inventory C ON(C.request_id=B.id)  WHERE B.provider_id=A.id ) =0 THEN 0"
                + " ELSE (SELECT SUM(C.cost) FROM request B INNER JOIN inventory C ON(C.request_id=B.id)  WHERE B.provider_id=A.id ) END) as monto,"
                + "(CASE WHEN (SELECT COUNT(*) FROM provider_pay D WHERE D.provider_id=A.id) =0 THEN 0"
                + " ELSE (SELECT SUM(E.amount) FROM provider_pay D INNER JOIN expense E ON(D.expense_id=E.id) WHERE D.provider_id=A.id) END) as cobrado"
                + " FROM provider A WHERE A.id="+id+";";
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String description=rs.getString(2);
                String contacto=rs.getString(3);
                String email=rs.getString(4);
                String detalle=rs.getString(5);
                 double montot=rs.getDouble(6);
                 double montopagado=rs.getDouble(7);
                    return new Provider(Id,description,contacto,email,detalle,montot,montopagado);
            }
        return null;
    }
       public Provider GetProviderByRequestId(int id) throws SQLException {
   int AUX=0;
        String sql2="SELECT provider_id FROM request WHERE id="+id+";";
        Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            while (rs2.next()) {
                AUX = rs2.getInt(1);
            }
      
             String sql = "SELECT A.id,A.description,A.contacto,A.email,A.detalle,"
                + "(CASE WHEN (SELECT COUNT(*) FROM request B INNER JOIN inventory C ON(C.request_id=B.id)  WHERE B.provider_id=A.id ) =0 THEN 0"
                + " ELSE (SELECT SUM(C.cost) FROM request B INNER JOIN inventory C ON(C.request_id=B.id)  WHERE B.provider_id=A.id ) END) as monto,"
                + "(CASE WHEN (SELECT COUNT(*) FROM provider_pay D WHERE D.provider_id=A.id) =0 THEN 0"
                + " ELSE (SELECT SUM(E.amount) FROM provider_pay D INNER JOIN expense E ON(D.expense_id=E.id) WHERE D.provider_id=A.id) END) as cobrado"
                + " FROM provider A WHERE A.id="+AUX+";";
             Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String description=rs.getString(2);
                String contacto=rs.getString(3);
                String email=rs.getString(4);
                String detalle=rs.getString(5);
                 double montot=rs.getDouble(6);
                 double montopagado=rs.getDouble(7);
                    return new Provider(Id,description,contacto,email,detalle,montot,montopagado);
            }
        return null;
    }
    
 
 //Add//
    public void AddUser(User obj) throws SQLException {         
      String sql = "INSERT INTO user VALUES(null,'"+obj.Name+"','" + obj.Password+"','" +obj.Type_Id+"');";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddAccount(Account obj) throws SQLException {         
      String sql = "INSERT INTO account VALUES(null,'"+obj.Description+"'," + obj.Type_Id+"," +obj.Inicial+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddClient(Client obj) throws SQLException {         
      String sql = "INSERT INTO client VALUES(null,'"+obj.Description+"','" + obj.Direccion+"','" +obj.Email+"','" +obj.Telefono+"');";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddProvider(Provider obj) throws SQLException {         
      String sql = "INSERT INTO provider VALUES(null,'"+obj.Description+"','" + obj.Contacto+"','" +obj.Email+"','" +obj.Detalle+"');";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddExpense(Expense obj) throws SQLException { 
      int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
     String sql = "INSERT INTO expense VALUES(null,'"+dates+"'," + obj.Type_Id+",'"
              +obj.Concept+"'," +obj.Account_Id+"," +obj.Bills+",'" +obj.BillsNumber+
              "'," +obj.Amount+"," +Save.TemporalUser.Id+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddIncome(Income obj) throws SQLException { 
     int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
      String sql = "INSERT INTO income VALUES(null,'"+dates+"'," + obj.Client_Id+"," + obj.Type_Id+",'"
              +obj.Concept+"'," +obj.Account_Id+"," +obj.Bills+",'" +obj.BillsNumber+
              "'," +obj.Amount+"," +Save.TemporalUser.Id+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddInventoryCategory(Inventory_Category obj) throws SQLException { 
      String sql = "INSERT INTO inventory_category VALUES(null,'"+obj.Description+"');";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddInventoryType(Inventory_Type obj) throws SQLException { 
      String sql = "INSERT INTO inventory_type VALUES(null,'"+obj.Description+"'," + obj.Cost+"," + obj.Price+","
              +obj.MinStock+"," +obj.Category_Id+"," +obj.Subcategory_Id+"," +obj.Provider_Id+
              ",0,0,0;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddMovesCajas(Moves_Account obj) throws SQLException { 
     int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
      String sql = "INSERT INTO moves_account VALUES(null,'"+dates+"'," + obj.Out_Id+"," + obj.In_Id+","
              +obj.Amount+",'" +obj.Description+"',"+Save.TemporalUser.Id+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void AddRequest(Request obj,List<Inventory> list,Expense obj2  ) throws SQLException { 
       int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
    
      String sql = "INSERT INTO request VALUES(null,'"+dates+"','" + obj.Comentario+"'," + obj.Provider_Id+","
                            +obj.Account_Id+",2);";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            
         sql = "SELECT MAX(id) FROM request;";
       int request=0;
            Statement st2 = con.createStatement();
            ResultSet rs = st2.executeQuery(sql);
            while (rs.next()) {
                try{
                request = rs.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }         
            
          for(Inventory ob2 : list){
          sql = "INSERT INTO inventory VALUES(null,"+ob2.Type_Id+"," + request+"," + ob2.Qty+","
              +ob2.Cost+",0);";
            PreparedStatement st3 = con.prepareStatement(sql);
            st3.executeUpdate(sql); 
}    
         if(obj2.Type_Id!=0){
           sql = "INSERT INTO expense VALUES(null,'"+dates+"',1,''," +obj.Account_Id+"," +obj2.Bills+",'" +obj2.BillsNumber+
              "'," +obj2.Amount+"," +Save.TemporalUser.Id+");";
            PreparedStatement st4 = con.prepareStatement(sql);
            st4.executeUpdate(sql);   
                     sql = "SELECT MAX(id) FROM expense;";
       int expense=0;
            Statement st5 = con.createStatement();
            ResultSet rs5 = st5.executeQuery(sql);
            while (rs5.next()) {
                try{
                expense = rs5.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }         
             sql = "INSERT INTO provider_pay VALUES(null," +obj.Provider_Id+"," +expense+");";
            PreparedStatement st9 = con.prepareStatement(sql);
            st9.executeUpdate(sql); } 
    }
    public void AddRequest(Request obj,List<Inventory> list) throws SQLException { 
       int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
    
      String sql = "INSERT INTO request VALUES(null,'"+dates+"','" + obj.Comentario+"'," + obj.Provider_Id+","
                            +obj.Account_Id+",0);";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            
         sql = "SELECT MAX(id) FROM request;";
       int request=0;
            Statement st2 = con.createStatement();
            ResultSet rs = st2.executeQuery(sql);
            while (rs.next()) {
                try{
                request = rs.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }         
            
          for(Inventory ob2 : list){
          sql = "INSERT INTO inventory VALUES(null,"+ob2.Type_Id+"," + request+"," + ob2.Qty+","
              +ob2.Cost+",0);";
            PreparedStatement st3 = con.prepareStatement(sql);
            st3.executeUpdate(sql); 
}    
       
    }
////    public void AddRequestRec(Request obj,List<Inventory> list,Expense obj2  ) throws SQLException { 
////       int year=1900+obj.Date.getYear();
////        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
////    
////      String sql = "INSERT INTO request VALUES(null,'"+dates+"','" + obj.Comentario+"'," + obj.Provider_Id+","
////                            +obj.Account_Id+",3);";
////            PreparedStatement st = con.prepareStatement(sql);
////            st.executeUpdate(sql);   
////            
////         sql = "SELECT MAX(id) FROM request;";
////       int request=0;
////            Statement st2 = con.createStatement();
////            ResultSet rs = st2.executeQuery(sql);
////            while (rs.next()) {
////                try{
////                request = rs.getInt(1);
////                }
////                catch(NumberFormatException e)
////                {
////                    
////                }
////            }         
////            
////          for(Inventory ob2 : list){
////          sql = "INSERT INTO inventory VALUES(null,"+ob2.Type_Id+"," + request+"," + ob2.Qty+","
////              +ob2.Cost+",0);";
////            PreparedStatement st3 = con.prepareStatement(sql);
////            st3.executeUpdate(sql); 
////                   sql = "UPDATE inventory_type SET totalstock=totalstock+"+ob2.Qty+" WHERE id=" + ob2.Type_Id+";";
////            PreparedStatement st4 = con.prepareStatement(sql);
////            st4.executeUpdate(sql); 
////}    
////         if(obj2.Type_Id!=0){
////           sql = "INSERT INTO expense VALUES(null,'"+dates+"',1,''," +obj.Account_Id+"," +obj2.Bills+",'" +obj2.BillsNumber+
////              "'," +obj2.Amount+"," +Save.TemporalUser.Id+");";
////            PreparedStatement st4 = con.prepareStatement(sql);
////            st4.executeUpdate(sql);   
////                     sql = "SELECT MAX(id) FROM expense;";
////       int expense=0;
////            Statement st5 = con.createStatement();
////            ResultSet rs5 = st5.executeQuery(sql);
////            while (rs5.next()) {
////                try{
////                expense = rs5.getInt(1);
////                }
////                catch(NumberFormatException e)
////                {
////                    
////                }
////            }         
////             sql = "INSERT INTO provider_pay VALUES(null," +obj.Provider_Id+"," +expense+");";
////            PreparedStatement st9 = con.prepareStatement(sql);
////            st9.executeUpdate(sql); } 
////    }
////    public void AddRequestRec(Request obj,List<Inventory> list) throws SQLException { 
////       int year=1900+obj.Date.getYear();
////        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
////    
////      String sql = "INSERT INTO request VALUES(null,'"+dates+"','" + obj.Comentario+"'," + obj.Provider_Id+","
////                            +obj.Account_Id+",1);";
////            PreparedStatement st = con.prepareStatement(sql);
////            st.executeUpdate(sql);   
////            
////         sql = "SELECT MAX(id) FROM request;";
////       int request=0;
////            Statement st2 = con.createStatement();
////            ResultSet rs = st2.executeQuery(sql);
////            while (rs.next()) {
////                try{
////                request = rs.getInt(1);
////                }
////                catch(NumberFormatException e)
////                {
////                    
////                }
////            }         
////            
////          for(Inventory ob2 : list){
////          sql = "INSERT INTO inventory VALUES(null,"+ob2.Type_Id+"," + request+"," + ob2.Qty+","
////              +ob2.Cost+",0);";
////            PreparedStatement st3 = con.prepareStatement(sql);
////            st3.executeUpdate(sql); 
////            
////             sql = "UPDATE inventory_type SET totalstock=totalstock+"+ob2.Qty+" WHERE id=" + ob2.Type_Id+";";
////            PreparedStatement st4 = con.prepareStatement(sql);
////            st4.executeUpdate(sql); 
////}    
////       
////    }
    public void UpdateInventarioRecibido(int idreq ) throws SQLException { 

           String sql = "UPDATE inventory SET status=1 WHERE id="+idreq+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   

            
 
          sql = "UPDATE inventory_type A INNER JOIN inventory B ON(A.id=B.type_id) SET A.totalstock=A.totalstock+B.qty WHERE B.id="+idreq+";";
            PreparedStatement st3 = con.prepareStatement(sql);
            st3.executeUpdate(sql); 

    }
    public void UpdateRequestPagado(int idreq ) throws SQLException { 

        String sql = "SELECT state_id FROM request WHERE id="+idreq+";";
       int request=0;
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(sql);
            while (rs2.next()) {
                try{
                request = rs2.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }    
            if(request==0){
            sql = "UPDATE request SET state_id=2 WHERE id="+idreq+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            
            }else{
                  sql = "UPDATE request SET state_id=3 WHERE id="+idreq+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            }
            

    }
    public void AddPagoRequest(int idreq,Expense expense ) throws SQLException { 

            AddExpense(expense);
           String sql = "SELECT MAX(id) FROM expense ;";
       int expense_id=0;
            Statement st3 = con.createStatement();
            ResultSet rs3 = st3.executeQuery(sql);
            while (rs3.next()) {
                try{
                expense_id = rs3.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }    
        
            sql = "INSERT INTO provider_pay VALUES(null,"+idreq+","+expense_id+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            
        
            

    }
  
    public void AddSale(Sale obj,List<Sale_Inventory> list,List<Sale_Service> list2,List<Income> list3) throws SQLException { 
     int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
      
      String sql = "INSERT INTO sale VALUES(null,'"+dates+"'," + obj.Client_Id+",'" + obj.Comentario+"',"
                            +obj.Monto+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            
         sql = "SELECT MAX(id) FROM sale;";
       int request=0;
            Statement st2 = con.createStatement();
            ResultSet rs = st2.executeQuery(sql);
            while (rs.next()) {
                try{
                request = rs.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }         
            if(list.size()>0){
          for(Sale_Inventory ob2 : list){
          sql = "INSERT INTO sale_inventory VALUES(null,"+ob2.Inventory_id+"," + request+"," + ob2.Qty+","
              +ob2.Amount+");";
            PreparedStatement st3 = con.prepareStatement(sql);
            st3.executeUpdate(sql); 
             sql = "UPDATE inventory_type SET puntoventastock=puntoventastock-"+ ob2.Qty+", totalstock=totalstock-"+ ob2.Qty+" WHERE id="+ob2.Inventory_id+";";
            PreparedStatement st6 = con.prepareStatement(sql);
            st6.executeUpdate(sql); 
}        }
             if(list2.size()>0){
        for(Sale_Service ob : list2){
          sql = "INSERT INTO sale_service VALUES(null,"+ob.Service_id+"," + request+","+ob.Qty+","
              +ob.Amount+");";
            PreparedStatement st33 = con.prepareStatement(sql);
            st33.executeUpdate(sql); 
}    }
              if(list3.size()>0){
          for(Income ob : list3){
        sql = "INSERT INTO income VALUES(null,'"+dates+"'," + obj.Client_Id+",1,'',"
              +ob.Account_Id+"," +ob.Bills+",'" +ob.BillsNumber+
              "'," +ob.Amount+"," +Save.TemporalUser.Id+");";
            PreparedStatement st34 = con.prepareStatement(sql);
            st34.executeUpdate(sql); 
                sql = "SELECT MAX(id) FROM income;";
       int income=0;
            Statement st7 = con.createStatement();
            ResultSet rs7 = st7.executeQuery(sql);
            while (rs7.next()) {
                try{
                income = rs7.getInt(1);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }         
            sql = "INSERT INTO sale_Pay VALUES(null,"+request+","+income+");";
            PreparedStatement st9 = con.prepareStatement(sql);
            st9.executeUpdate(sql); 
          } } 
    }
    public void UpdateSale(Sale obj) throws SQLException { 
     int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
      
      String sql = "UPDATE sale SET date='"+dates+"',client_id=" + obj.Client_Id+",comentario='" + obj.Comentario+"',monto='"
                            +obj.Monto+"' WHERE id="+obj.Id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
           
    }
  
    public void AddMovesProducto(Inventory_Reg obj,List<Inventory_Moves> list) throws SQLException { 
     int year=1900+obj.Date.getYear();
        String dates=year+"-"+obj.Date.getMonth()+"-"+obj.Date.getDate();
      
      String sql = "INSERT INTO inventory_reg VALUES(null,'"+dates+"','" + obj.Detalle+"');";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
            
         sql = "SELECT MAX(id) FROM inventory_reg;";
       int request=0;
            Statement st2 = con.createStatement();
            ResultSet rs = st2.executeQuery(sql);
            while (rs.next()) {
                try{
                request = rs.getInt(1);
                }
                catch(Exception e)
                {
                    
                }
            }         
            if(list.size()>0){
          for(Inventory_Moves ob2 : list){
          sql = "INSERT INTO inventory_moves VALUES(null,"+ob2.Out_Id+"," +ob2.In_Id+","+ob2.Type_Id+","+ob2.Qty+","+ob2.Trash+","+ request+");";
            PreparedStatement st3 = con.prepareStatement(sql);
            st3.executeUpdate(sql); 
            if(ob2.In_Id==2){
             sql = "UPDATE inventory_type SET puntoventastock=puntoventastock+"+ ob2.Qty+" WHERE id="+ob2.Type_Id+";";
             PreparedStatement st7 = con.prepareStatement(sql);
            st7.executeUpdate(sql);
            }else if(ob2.In_Id==3){
               sql = "UPDATE inventory_type SET cabinastock=cabinastock+"+ ob2.Qty+" WHERE id="+ob2.Type_Id+";";
                        PreparedStatement st7 = con.prepareStatement(sql);
            st7.executeUpdate(sql);
            }else if(ob2.In_Id==0){
               sql = "UPDATE inventory_type SET totalstock=totalstock-"+ ob2.Qty+" WHERE id="+ob2.Type_Id+";";
                      PreparedStatement st7 = con.prepareStatement(sql);
            st7.executeUpdate(sql);
            }
           
             if(ob2.Out_Id==2){
             sql = "UPDATE inventory_type SET puntoventastock=puntoventastock-"+ ob2.Qty+" WHERE id="+ob2.Type_Id+";";
                  PreparedStatement st6 = con.prepareStatement(sql);
            st6.executeUpdate(sql); 
             }else if(ob2.Out_Id==3){
               sql = "UPDATE inventory_type SET cabinastock=cabinastock-"+ ob2.Qty+" WHERE id="+ob2.Type_Id+";";
                          PreparedStatement st6 = con.prepareStatement(sql);
            st6.executeUpdate(sql);  
             }
          
}        }
             
      
    }
  
    public void AddServiceType(Service_Type obj) throws SQLException { 
      String sql = "INSERT INTO service_type VALUES(null,'"+obj.Description+"'," + obj.Cost+","
              +obj.Cost1+"," +obj.Price+"," +obj.Category_Id+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
 //UPDATE //
    public void UpdateUser(User obj) throws SQLException {         
      String sql = "UPDATE user SET name='"+obj.Name+"',password='" + obj.Password+"',1 WHERE id="+obj.Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
    public void UpdateClient(Client obj) throws SQLException {         
      String sql = "UPDATE client SET description='"+obj.Description+"',direccion='" + obj.Direccion+"',email='"+obj.Email+"',telefono='" + obj.Telefono+"' WHERE id="+obj.Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
              public void UpdateProvider(Provider obj) throws SQLException {         
      String sql = "UPDATE provider SET description='"+obj.Description+"',contacto='" + obj.Contacto+"',email='"+obj.Email+"',detalle='" + obj.Detalle+"' WHERE id="+obj.Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
 //DELETE//
    public void DeleteExpense(int id) throws SQLException { 
      String sql = "DELETE FROM expense WHERE id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql); 
            
            sql = "DELETE FROM provider_pay WHERE expense_id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.executeUpdate(sql);  
    }
    public void DeleteRequest(int id) throws SQLException { 
        List<Inventory> list=GetInventoryByRequest(id);
        for(Inventory obj : list){
            if(obj.Status==1){
              String sql = "UPDATE inventory_type SET totalstock=totalstock-"+obj.Qty+" WHERE id="+obj.Type_Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
                      }
          }
                 String sql2 = "DELETE FROM inventory WHERE request_id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
                sql2 = "DELETE FROM request WHERE id="+id+";";
            st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            
            
    }
     public void DeleteRegRequest(int id) throws SQLException { 
        Inventory obj=GetInventoryById(id);
        
            if(obj.Status==1){
              String sql = "UPDATE inventory_type SET totalstock=totalstock-"+obj.Qty+" WHERE id="+obj.Type_Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
                      }
          
                 String sql2 = "DELETE FROM inventory WHERE id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            
            String sql3="SELECT CASE WHEN (SELECT COUNT(*) FROM inventory A WHERE A.request_id="+obj.Request_Id+")="
                    + "(SELECT SUM(A.status) FROM inventory A WHERE A.request_id="+obj.Request_Id+") THEN 1 ELSE 0 END AS DE,B.state_id FROM request B WHERE B.id="+obj.Request_Id+";";
                int request=0;
                int aux=0;
            Statement st3 = con.createStatement();
            ResultSet rs3 = st3.executeQuery(sql3);
            while (rs3.next()) {
                try{
                request = rs3.getInt(1);
                aux=rs3.getInt(2);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }
            String sql4 ="";
            if(request==1){
                if(aux==0){
               sql4 = "UPDATE request SET state_id=1 WHERE id="+obj.Request_Id+";";

                }else if(aux==2){
                  sql4 = "UPDATE request SET state_id=3 WHERE id="+obj.Request_Id+";";

            }
            }else{
                if(aux==1){
               sql4 = "UPDATE request SET state_id=0 WHERE id="+obj.Request_Id+";";

                }else if(aux==3){
                   sql4 = "UPDATE request SET state_id=2 WHERE id="+obj.Request_Id+";";

            }  
            }
                        PreparedStatement st4 = con.prepareStatement(sql4);
            st4.executeUpdate(sql4);
    }
         public void DeleteMovimiento(int id) throws SQLException { 
        Inventory obj=GetInventoryById(id);
        
            if(obj.Status==1){
              String sql = "UPDATE inventory_type SET totalstock=totalstock-"+obj.Qty+" WHERE id="+obj.Type_Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
                      }
          
                 String sql2 = "DELETE FROM inventory WHERE id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            
            String sql3="SELECT CASE WHEN (SELECT COUNT(*) FROM inventory A WHERE A.request_id="+obj.Request_Id+")="
                    + "(SELECT SUM(A.status) FROM inventory A WHERE A.request_id="+obj.Request_Id+") THEN 1 ELSE 0 END AS DE,B.state_id FROM request B WHERE B.id="+obj.Request_Id+";";
                int request=0;
                int aux=0;
            Statement st3 = con.createStatement();
            ResultSet rs3 = st3.executeQuery(sql3);
            while (rs3.next()) {
                try{
                request = rs3.getInt(1);
                aux=rs3.getInt(2);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }
            String sql4 ="";
            if(request==1){
                if(aux==0){
               sql4 = "UPDATE request SET state_id=1 WHERE id="+obj.Request_Id+";";

                }else if(aux==2){
                  sql4 = "UPDATE request SET state_id=3 WHERE id="+obj.Request_Id+";";

            }
            }else{
                if(aux==1){
               sql4 = "UPDATE request SET state_id=0 WHERE id="+obj.Request_Id+";";

                }else if(aux==3){
                   sql4 = "UPDATE request SET state_id=2 WHERE id="+obj.Request_Id+";";

            }  
            }
                        PreparedStatement st4 = con.prepareStatement(sql4);
            st4.executeUpdate(sql4);
    }
      public void DeleteMovimiento2(List<Inventory_Moves> list,int id) throws SQLException { 
        
          for(Inventory_Moves obj:list){
            String sql = "UPDATE inventory_type SET totalstock="+obj.TotalStock+",puntoventastock="+obj.PuntoVentaStock+",cabinastock="+obj.CabinaStock+" WHERE id="+obj.Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
          }
                     
            String sql2 = "DELETE FROM inventory_moves WHERE reg_id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            String sql3 = "DELETE FROM inventory_reg WHERE id="+id+";";
            PreparedStatement st3 = con.prepareStatement(sql3);
            st2.executeUpdate(sql3);
            }
 
            public void DeleteMovimiento3(Inventory_Moves obj,int id) throws SQLException { 
        
            String sql = "UPDATE inventory_type SET totalstock="+obj.TotalStock+",puntoventastock="+obj.PuntoVentaStock+",cabinastock="+obj.CabinaStock+" WHERE id="+obj.Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
                     
            String sql2 = "DELETE FROM inventory_moves WHERE id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            }
       public void RecibirRegRequest(int id) throws SQLException { 
        Inventory obj=GetInventoryById(id);
        
        
              String sql = "UPDATE inventory_type SET totalstock=totalstock+"+obj.Qty+" WHERE id="+obj.Type_Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
                      
          
                 String sql2 = "UPDATE inventory SET status=1 WHERE id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            
           String sql3="SELECT CASE WHEN (SELECT COUNT(*) FROM inventory A WHERE A.request_id="+obj.Request_Id+")="
                    + "(SELECT SUM(A.status) FROM inventory A WHERE A.request_id="+obj.Request_Id+") THEN 1 ELSE 0 END AS DE,B.state_id FROM request B WHERE B.id="+obj.Request_Id+";";
                 int request=0;
                int aux=0;
            Statement st3 = con.createStatement();
            ResultSet rs3 = st3.executeQuery(sql3);
            while (rs3.next()) {
                try{
                request = rs3.getInt(1);
                aux=rs3.getInt(2);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }
            String sql4 ="";
            if(request==1){
                if(aux==0){
               sql4 = "UPDATE request SET state_id=1 WHERE id="+obj.Request_Id+";";

                }else if(aux==2){
                  sql4 = "UPDATE request SET state_id=3 WHERE id="+obj.Request_Id+";";

            }
            }else{
                if(aux==1){
               sql4 = "UPDATE request SET state_id=0 WHERE id="+obj.Request_Id+";";

                }else if(aux==3){
                   sql4 = "UPDATE request SET state_id=2 WHERE id="+obj.Request_Id+";";

            }  
            }
                        PreparedStatement st4 = con.prepareStatement(sql4);
            st4.executeUpdate(sql4);
    }
        public void DesrecibirRegRequest(int id) throws SQLException { 
        Inventory obj=GetInventoryById(id);
        
        
              String sql = "UPDATE inventory_type SET totalstock=totalstock-"+obj.Qty+" WHERE id="+obj.Type_Id+" ;";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
                      
          
                 String sql2 = "UPDATE inventory SET status=0 WHERE id="+id+";";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.executeUpdate(sql2);
            
          String sql3="SELECT CASE WHEN (SELECT COUNT(*) FROM inventory A WHERE A.request_id="+obj.Request_Id+")="
                    + "(SELECT SUM(A.status) FROM inventory A WHERE A.request_id="+obj.Request_Id+") THEN 1 ELSE 0 END AS DE,B.state_id FROM request B WHERE B.id="+obj.Request_Id+";";
                    int request=0;
                int aux=0;
            Statement st3 = con.createStatement();
            ResultSet rs3 = st3.executeQuery(sql3);
            while (rs3.next()) {
                try{
                request = rs3.getInt(1);
                aux=rs3.getInt(2);
                }
                catch(NumberFormatException e)
                {
                    
                }
            }
            String sql4 ="";
            if(request==1){
                if(aux==0){
               sql4 = "UPDATE request SET state_id=1 WHERE id="+obj.Request_Id+";";

                }else if(aux==2){
                  sql4 = "UPDATE request SET state_id=3 WHERE id="+obj.Request_Id+";";

            }
            }else{
                if(aux==1){
               sql4 = "UPDATE request SET state_id=0 WHERE id="+obj.Request_Id+";";

                }else if(aux==3){
                   sql4 = "UPDATE request SET state_id=2 WHERE id="+obj.Request_Id+";";

            }  
            }
                        PreparedStatement st4 = con.prepareStatement(sql4);
            st4.executeUpdate(sql4);
    }
       public void DeleteMov(int id) throws SQLException { 
      String sql = "DELETE FROM moves_account WHERE id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
    }
    public void DeleteIncome(int id) throws SQLException { 
      String sql = "DELETE FROM income WHERE id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
    }
        public void DeleteSale(int id) throws SQLException { 
            
           String sql = " SELECT A.id FROM sale_inventory A WHERE A.sale_id="+id+";";
 List<Integer> list = new ArrayList<Integer>();
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery(sql);
            while (rs.next()) {
                 list.add( rs.getInt(1));
          }
            for(Integer obj : list){
                   sql = "UPDATE inventory_type A INNER JOIN sale_inventory B ON(B.inventory_id=A.id)"
                           + " SET A.totalstock=A.totalstock+B.qty,A.puntoventastock=A.puntoventastock+B.qty WHERE B.id="+obj+";";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.executeUpdate(sql); 
            }

           sql = "DELETE FROM sale WHERE id="+id+";";
            st1= con.prepareStatement(sql);
            st1.executeUpdate(sql);
            
                     sql = "DELETE FROM sale_inventory WHERE sale_id="+id+";";
            st1= con.prepareStatement(sql);
            st1.executeUpdate(sql);
                     sql = "DELETE FROM sale_Pay WHERE sale_id="+id+";";
            st1= con.prepareStatement(sql);
            st1.executeUpdate(sql);
                     sql = "DELETE FROM sale_service WHERE sale_id="+id+";";
            st1= con.prepareStatement(sql);
            st1.executeUpdate(sql);

    }
      public void DeleteClient(int id) throws SQLException { 
      String sql = "DELETE FROM client WHERE id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
    }
       public void DeleteProvider(int id) throws SQLException { 
      String sql = "DELETE FROM provider WHERE id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
    }
    public void UpdateInventoryType(Inventory_Type obj) throws SQLException { 
      String sql = "UPDATE inventory_type SET description=" +obj.Description+"', cost=" + obj.Cost+",price=" + obj.Price+",minstock="
              +obj.MinStock+",category_id=" +obj.Category_Id+",subcategory_id=" +obj.Subcategory_Id+",provider_id=" +obj.Provider_Id+
              " WHERE id="+obj.Id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
        public void DeleteSaleInventory(int id) throws SQLException { 
            String sql = "UPDATE inventory_type A INNER JOIN sale_inventory B ON(B.inventory_id=A.id) SET A.puntoventastock= A.puntoventastock+B.qty,A.totalstock= A.totalstock+B.qty WHERE B.id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
            
      sql = "DELETE FROM sale_inventory WHERE id="+id+";";
        st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
            
    }
       public void DeleteSaleService(int id) throws SQLException { 
      String sql = "DELETE FROM sale_service WHERE id="+id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
    }
            public void AddSaleInventory(Sale_Inventory obj) throws SQLException { 
      String sql = "INSERT INTO sale_inventory VALUES(null,"+obj.Inventory_id+","+obj.Sale_id+","+obj.Qty+","+obj.Amount+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);  
             sql = "UPDATE inventory_type SET puntoventastock= puntoventastock-"+obj.Qty+",totalstock= totalstock-"+obj.Qty+" WHERE id="+obj.Inventory_id+";";
           st = con.prepareStatement(sql);
            st.executeUpdate(sql);
    } 
       public void AddSaleService(Sale_Service obj) throws SQLException { 
      String sql = "INSERT INTO sale_service VALUES(null,"+obj.Service_id+","+obj.Sale_id+","+obj.Qty+","+obj.Amount+");";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);   
    }
           public void AddProduct(Inventory_Type obj) throws SQLException { 
    
               String sql = "INSERT INTO inventory_type VALUES(null,'"+obj.Description+"'," + obj.Cost+"," + obj.Price+","
              +obj.MinStock+"," +obj.Category_Id+",1," +obj.Provider_Id+
              ",0,0,0);";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
                   public void UpdateProduct(Inventory_Type obj) throws SQLException { 
    
               String sql = "UPDATE inventory_type SET description='"+obj.Description+"',cost=" + obj.Cost+",price=" + obj.Price+",minstock="
              +obj.MinStock+",category_id=" +obj.Category_Id+",provider_id=" +obj.Provider_Id+" WHERE id="+obj.Id+";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate(sql);    
    }
             public List<Expense_Type> GetEgresosFlujo2019() throws SQLException {
        String sql = "SELECT A.id,A.description,A.ppt,A.category_id,A.source_id \n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=1 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=1 AND YEAR(B.date)=2019) END) AS ENERO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=2 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=2 AND YEAR(B.date)=2019) END) AS FEBRERO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=3 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=3 AND YEAR(B.date)=2019) END) AS MARZO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=4 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=4 AND YEAR(B.date)=2019) END) AS ABRIL,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=5 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=5 AND YEAR(B.date)=2019) END) AS MAYO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=6 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=6 AND YEAR(B.date)=2019) END) AS JUNIO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=7 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=7 AND YEAR(B.date)=2019) END) AS JULIO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=8 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=8 AND YEAR(B.date)=2019) END) AS AGOSTO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=9 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=9 AND YEAR(B.date)=2019) END) AS SEPTIEMBRE,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=10 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=10 AND YEAR(B.date)=2019) END) AS OCTUBRE,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=11 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=11 AND YEAR(B.date)=2019) END) AS NOVIEMBRE,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=12 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM expense B WHERE B.type_id=A.id AND MONTH(B.date)=12 AND YEAR(B.date)=2019) END) AS DICIEMBRE\n" +
"\n" +
"FROM expense_type A ORDER BY A.category_id,A.description ASC;";
        List<Expense_Type> list = new ArrayList<Expense_Type>();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                     int Id = rs.getInt(1);
                     String Type = rs.getString(2);
                     double amount = rs.getDouble(3);
                     int user = rs.getInt(4);
                     int source = rs.getInt(5);
                     double A1 = rs.getDouble(6);
                     double A2 = rs.getDouble(7);
                     double A3 = rs.getDouble(8);
                     double A4 = rs.getDouble(9);
                     double A5 = rs.getDouble(10);
                     double A6 = rs.getDouble(11);
                     double A7 = rs.getDouble(12);
                     double A8 = rs.getDouble(13);
                     double A9 = rs.getDouble(14);
                     double A10 = rs.getDouble(15);
                     double A11 = rs.getDouble(16);
                     double A12 = rs.getDouble(17);
                     list.add(new Expense_Type(Id, Type, amount, user, source, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12));
                 }
        return list;
    }     
              public List<Income_Type> GetIngresosFlujo2019() throws SQLException {
        String sql = "SELECT A.id,A.description,A.ppt,A.category_id,A.source_id \n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=1 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=1 AND YEAR(B.date)=2019) END) AS ENERO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=2 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=2 AND YEAR(B.date)=2019) END) AS FEBRERO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=3 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=3 AND YEAR(B.date)=2019) END) AS MARZO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=4 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=4 AND YEAR(B.date)=2019) END) AS ABRIL,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=5 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=5 AND YEAR(B.date)=2019) END) AS MAYO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=6 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=6 AND YEAR(B.date)=2019) END) AS JUNIO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=7 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=7 AND YEAR(B.date)=2019) END) AS JULIO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=8 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=8 AND YEAR(B.date)=2019) END) AS AGOSTO,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=9 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=9 AND YEAR(B.date)=2019) END) AS SEPTIEMBRE,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=10 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=10 AND YEAR(B.date)=2019) END) AS OCTUBRE,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=11 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=11 AND YEAR(B.date)=2019) END) AS NOVIEMBRE,\n" +
"\n" +
"(CASE WHEN (Select COUNT(*) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=12 AND YEAR(B.date)=2019)=0 THEN 0 ELSE (Select SUM(B.amount) FROM income B WHERE B.type_id=A.id AND MONTH(B.date)=12 AND YEAR(B.date)=2019) END) AS DICIEMBRE\n" +
"\n" +
"FROM income_type A ORDER BY A.category_id,A.description ASC;";
        List<Income_Type> list = new ArrayList<Income_Type>();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                     int Id = rs.getInt(1);
                     String Type = rs.getString(2);
                     double amount = rs.getDouble(3);
                     int user = rs.getInt(4);
                     int source = rs.getInt(5);
                     double A1 = rs.getDouble(6);
                     double A2 = rs.getDouble(7);
                     double A3 = rs.getDouble(8);
                     double A4 = rs.getDouble(9);
                     double A5 = rs.getDouble(10);
                     double A6 = rs.getDouble(11);
                     double A7 = rs.getDouble(12);
                     double A8 = rs.getDouble(13);
                     double A9 = rs.getDouble(14);
                     double A10 = rs.getDouble(15);
                     double A11 = rs.getDouble(16);
                     double A12 = rs.getDouble(17);
                     list.add(new Income_Type(Id, Type, amount, user, source, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12));
                 }
        return list;
    }     
           public List<Expense_Type> GetExpensesTypesFlujo() {
        String sql = "SELECT * FROM expense_type ORDER BY category_id,description ASC;";
        List<Expense_Type> list = new ArrayList<Expense_Type>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                double Ppt = rs.getDouble(3);
                int ExpensesCategory_Id = rs.getInt(4);
                list.add(new Expense_Type(Id, Description, Ppt, ExpensesCategory_Id,1));
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
            public List<Income_Type> GetIncomesTypesFlujo() {
        String sql = "SELECT * FROM income_type ORDER BY category_id,description ASC;";
        List<Income_Type> list = new ArrayList<Income_Type>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                double Ppt = rs.getDouble(3);
                int ExpensesCategory_Id = rs.getInt(4);
                list.add(new Income_Type(Id, Description, Ppt, ExpensesCategory_Id,1));
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    public List<Income> GetIncomes(int year) {
        String sql = "SELECT * FROM income WHERE YEAR(date)="+year+";";
        List<Income> list = new ArrayList<Income>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                int IncomesType_Id = rs.getInt(3);
                int Proyect_Id = rs.getInt(4);
                String Concept = rs.getString(5);
                int Account_Id = rs.getInt(6);
                int Bills = rs.getInt(7);
                String BillsNumber = rs.getString(8);
                double Amount = rs.getInt(9);
                int User_Id = rs.getInt(10);
                list.add(new Income(Id, Date, IncomesType_Id, Proyect_Id, Concept, Account_Id,
                        Bills, BillsNumber, Amount, User_Id));
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public List<Income_Type> GetIncomesTypesFluj() {
        String sql = "SELECT * FROM income_type ORDER BY category_id,description ASC;";
        List<Income_Type> list = new ArrayList<Income_Type>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                String Description = rs.getString(2);
                double Ppt = rs.getDouble(3);
                int IncomesCategory_Id = rs.getInt(4);
                list.add(new Income_Type(Id, Description, Ppt, IncomesCategory_Id,1));
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      public List<Expense> GetExpenses(int year) {
        String sql = "SELECT * FROM expense WHERE YEAR(date)="+year+";";
        List<Expense> list = new ArrayList<Expense>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int Id = rs.getInt(1);
                java.util.Date Date = rs.getDate(2);
                int ExpensesCategory_Id = rs.getInt(3);
                String Concept = rs.getString(4);
                int Account_Id = rs.getInt(5);
                int Bills = rs.getInt(6);
                String BillsNumber = rs.getString(7);
                double Amount = rs.getInt(8);
                int User_Id = rs.getInt(9);
                list.add(new Expense(Id, Date, ExpensesCategory_Id, Concept, Account_Id,
                        Bills, BillsNumber, Amount, User_Id));
            }
        } catch (SQLException ex) {
            //   Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     }

