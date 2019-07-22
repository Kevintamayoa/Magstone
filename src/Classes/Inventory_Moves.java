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
public class Inventory_Moves {
    public int Id;
    public int Out_Id;
    public int In_Id;
    public int Type_Id;
      public String Out;
    public String In;
    public String Type;
    public int Qty; 
    public int Trash;
    public int Reg_Id; 
 public Inventory_Moves() {
    
      
    }
    public Inventory_Moves(int Out_Id, int In_Id, int Type_Id, int Qty, int Trash) {
        this.Out_Id = Out_Id;
        this.In_Id = In_Id;
        this.Type_Id = Type_Id;
        this.Qty = Qty;
        this.Trash = Trash;
      
    }

    public Inventory_Moves(int Id, String Out, String In, String Type, int Qty, int Trash, int Reg_Id) {
        this.Id = Id;
        this.Out = Out;
        this.In = In;
        this.Type = Type;
        this.Qty = Qty;
        this.Trash = Trash;
        this.Reg_Id = Reg_Id;
    }

   
public int TotalStock;
    public int PuntoVentaStock;
    public int CabinaStock;

    public Inventory_Moves(int Id, int TotalStock, int PuntoVentaStock, int CabinaStock) {
        this.Id = Id;
        this.TotalStock = TotalStock;
        this.PuntoVentaStock = PuntoVentaStock;
        this.CabinaStock = CabinaStock;
    }
   
    
}
