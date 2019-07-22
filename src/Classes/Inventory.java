/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author macbook
 */
public class Inventory 
{
    public int Id;
    public int Type_Id;
    public String Type;
      public String Cat;
    public int Request_Id;
    public int Qty;
    public double Cost;
     public int Status;
  public Inventory( ) {
     
    
    }
    public Inventory( int Type_Id, int Qty, double Cost,int Status) {
     
        this.Type_Id = Type_Id;
        this.Qty = Qty;
        this.Cost = Cost;
        this.Status=Status;
    }
   public double CostUnit(){
       if(Qty>0){
           return Cost/Qty;
       }else{
           return 0;
       }
   }
    public boolean Sta(){
       if(Status==0){
           return false;
       }else{
           return true;
       }
   }
    public Inventory(int Id, int Type_Id, String Type,String Cat, int Request_Id, int Qty, double Cost,int Status) {
        this.Id = Id;
        this.Type_Id = Type_Id;
        this.Type = Type;
        this.Cat = Cat;
        this.Request_Id = Request_Id;
        this.Qty = Qty;
        this.Cost = Cost;
             this.Status=Status;
    }
    
}
