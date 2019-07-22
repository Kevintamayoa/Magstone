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
public class Sale_Service {
      public int Id;
    public int Service_id;
     public int Sale_id;
      public int Qty;
    public double Amount;
public String Service;
  public Sale_Service(int Id, int Service_id, int Sale_id,int Qty, double Amount) {
        this.Id = Id;
        this.Service_id = Service_id;
        this.Sale_id = Sale_id;
        this.Amount = Amount;
        this.Qty=Qty;
    }
    public Sale_Service(int Id, int Service_id,String Service, int Sale_id,int Qty, double Amount) {
        this.Id = Id;
        this.Service_id = Service_id;
        this.Sale_id = Sale_id;
        this.Service=Service;
        this.Amount = Amount;
        this.Qty=Qty;
    }
       public Sale_Service(int Id, int Service_id,String Service,int Qty, double Amount) {
        this.Id = Id;
        this.Service_id = Service_id;
        this.Service=Service;
        this.Amount = Amount;
        this.Qty=Qty;
    }
  public Sale_Service( int Service_id,int Qty, double Amount) {
        this.Service_id = Service_id;
        this.Qty=Qty;
        this.Amount = Amount;
    }

}
