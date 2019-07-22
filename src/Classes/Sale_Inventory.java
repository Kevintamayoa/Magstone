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
public String Inventory;
    public Sale_Inventory(int Id, int Inventory_id, int Sale_id, int Qty, double Amount) {
        this.Id = Id;
        this.Inventory_id = Inventory_id;
        this.Sale_id = Sale_id;
        this.Qty = Qty;
        this.Amount = Amount;
    }
        public Sale_Inventory(int Id, int Inventory_id,String Inventory, int Qty, double Amount) {
        this.Id = Id;
        this.Inventory_id = Inventory_id;
        this.Inventory = Inventory;
        this.Qty = Qty;
        this.Amount = Amount;
    }
    public Sale_Inventory(int Inventory_id, int Qty, double Amount) {
        this.Inventory_id = Inventory_id;
        this.Qty = Qty;
        this.Amount = Amount;
    }
    
    
}
