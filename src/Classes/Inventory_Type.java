/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author macbook
 */
public class Inventory_Type {
    public int Id;
    public String Description;
    public double Cost;
    public double Price;
    public int MinStock;
    public int Category_Id;
    public int Subcategory_Id;
    public int Provider_Id;
    public String Category;
    public String Subcategory;
    public String Provider;
    public int TotalStock;
    public int PuntoVentaStock;
    public int CabinaStock;
        public int Reb;
  public Inventory_Type(){
      
    }

    public Inventory_Type(int Id, String Description, double Cost, double Price, int MinStock, int Category_Id, int Subcategory_Id, int Provider_Id, int TotalStock, int PuntoVentaStock,int cabinastock) {
        this.Id = Id;
        this.Description = Description;
        this.Cost = Cost;
        this.Price = Price;
        this.MinStock = MinStock;
        this.Category_Id = Category_Id;
        this.Subcategory_Id = Subcategory_Id;
        this.Provider_Id = Provider_Id;
        this.CabinaStock=cabinastock;
        this.TotalStock = TotalStock;
        this.PuntoVentaStock = PuntoVentaStock;
    }
  
    public Inventory_Type(String Description, double Cost, double Price, int MinStock, int Category_Id, int Subcategory_Id, int Provider_Id, int TotalStock, int PuntoVentaStock, int CabinaStock) {
        this.Description = Description;
        this.Cost = Cost;
        this.Price = Price;
        this.MinStock = MinStock;
        this.Category_Id = Category_Id;
        this.Subcategory_Id = Subcategory_Id;
        this.Provider_Id = Provider_Id;
        this.TotalStock = TotalStock;
        this.PuntoVentaStock = PuntoVentaStock;
        this.CabinaStock = CabinaStock;
    }
 public Inventory_Type(int Id, String Description, double Cost, double Price, 
         int MinStock, String Category, String Subcategory, String Provider, int TotalStock,
         int PuntoVentaStock, int CabinaStock) {
        this.Id = Id;
        this.Description = Description;
        this.Cost = Cost;
        this.Price = Price;
        this.MinStock = MinStock;
        this.Category = Category;
        this.Subcategory = Subcategory;
        this.Provider = Provider;
        this.TotalStock = TotalStock;
        this.PuntoVentaStock = PuntoVentaStock;
        this.CabinaStock = CabinaStock;

    }
  public Inventory_Type(int Id, String Description, double Cost, double Price, 
         int MinStock, int Category,  int Provider) {
        this.Id = Id;
        this.Description = Description;
        this.Cost = Cost;
        this.Price = Price;
        this.MinStock = MinStock;
        this.Category_Id = Category;
        this.Provider_Id = Provider;

    }
    public Inventory_Type(int Id, String Description, double Cost, double Price, int MinStock, String Category, String Subcategory, String Provider, int TotalStock, int PuntoVentaStock, int CabinaStock,int Reb) {
        this.Id = Id;
        this.Description = Description;
        this.Cost = Cost;
        this.Price = Price;
        this.MinStock = MinStock;
        this.Category = Category;
        this.Subcategory = Subcategory;
        this.Provider = Provider;
        this.TotalStock = TotalStock;
        this.PuntoVentaStock = PuntoVentaStock;
        this.CabinaStock = CabinaStock;
        this.Reb=Reb;
    }

  


   

 

}
