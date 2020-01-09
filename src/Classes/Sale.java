/*
 * To change this license header, choose License Headers in Sale Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;
import java.util.List;

/**
 *
 * @author macbook
 */
public class Sale {
    
     public int Id;
     public Date Date;
     public String Description;
     public int Client_Id;    
     public String Client;
     public String Comentario;
     public double Monto;
     public int Status_Id;
     
    public Sale(int Id,Date Date,String Description, int Client_Id, String Comentario, double Monto,int Status_Id) {
        this.Id = Id;
        this.Date = Date;
        this.Description=Description;
        this.Client_Id = Client_Id;
        this.Comentario = Comentario; 
        this.Monto = Monto;
        this.Status_Id = Status_Id;
    }

    public Sale(int Id, Date Date,String Description, int Client_Id, String Client, String Comentario, double Monto,int Status_Id) {
        this.Id = Id;
        this.Date = Date;
        this.Description=Description;
        this.Client_Id = Client_Id;
        this.Client = Client;
        this.Comentario = Comentario;
        this.Monto = Monto;
        this.Status_Id = Status_Id;
    }
      public double MontoCobrado;
        public Sale(int Id, Date Date,String Description, int Client_Id, String Client, String Comentario, double Monto,double MontoCobrado,int Status_Id) {
        this.Id = Id;
        this.Date = Date;
        this.Description=Description;
        this.Client_Id = Client_Id;
        this.Client = Client;
        this.Comentario = Comentario;
        this.Monto = Monto;
          this.MontoCobrado = MontoCobrado;
        this.Status_Id = Status_Id;
    }
      public Boolean Status(){
        if(Status_Id==0){
            return false;
        }else{
            return true;
        }
    }
           public double Saldo(){
   
            return Monto-MontoCobrado;
        
    }
       public Boolean Pagado(){
        if(Math.round(Monto)>Math.round(MontoCobrado)){
            return false;
        }else{
            return true;
        }
    }
  public List<Sale_Inventory> inventory;
   public Sale(int Id, Date Date, String Description, String Client, double Monto) {
        this.Id = Id;
        this.Date = Date;
        this.Description = Description;
        this.Client = Client;
        this.Monto = Monto;
    }
    public Sale(int Id, Date Date, String Description, String Client, double Monto, List<Sale_Inventory> inventory) {
        this.Id = Id;
        this.Date = Date;
        this.Description = Description;
        this.Client = Client;
        this.Monto = Monto;
        this.inventory = inventory;
    }
  
}
