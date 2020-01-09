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
public class Sale_Inventory {
    public int Id;
    public int Inventory_id;
     public int Sale_id;
    public int Qty;
    public double Amount;
       public int Status_Id;
public String Inventory;
    public Sale_Inventory(int Id, int Inventory_id, int Sale_id, int Qty, double Amount,int Status_Id) {
        this.Id = Id;
        this.Inventory_id = Inventory_id;
        this.Sale_id = Sale_id;
        this.Qty = Qty;
        this.Amount = Amount;
        this.Status_Id=Status_Id;
    }
        public Sale_Inventory(int Id, int Inventory_id,String Inventory, int Qty, double Amount,int Status_Id) {
        this.Id = Id;
        this.Inventory_id = Inventory_id;
        this.Inventory = Inventory;
        this.Qty = Qty;
        this.Amount = Amount;
         this.Status_Id=Status_Id;
    }
    public Sale_Inventory(int Inventory_id, int Qty, double Amount,int Status_Id) {
        this.Inventory_id = Inventory_id;
        this.Qty = Qty;
        this.Amount = Amount;
         this.Status_Id=Status_Id;
    }
      public Boolean Entregado(){
        if(Status_Id==0){
            return false;
        }else{
            return true;
        }
    }
    
}
