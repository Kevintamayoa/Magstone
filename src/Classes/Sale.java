/*
 * To change this license header, choose License Headers in Sale Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author macbook
 */
public class Sale {
    
     public int Id;
     public Date Date;
     public int Client_Id;    
     public String Client;
     public String Comentario;
     public double Monto;

    public Sale(Date Date, int Client_Id, String Comentario, double Monto) {
        this.Date = Date;
        this.Client_Id = Client_Id;
        this.Comentario = Comentario; 
        this.Monto = Monto;
    }

    public Sale(int Id, Date Date, int Client_Id, String Client, String Comentario, double Monto) {
        this.Id = Id;
        this.Date = Date;
        this.Client_Id = Client_Id;
        this.Client = Client;
        this.Comentario = Comentario;
        this.Monto = Monto;
    }
    
        public Sale(int Id, Date Date, int Client_Id,String Comentario, double Monto) {
        this.Id = Id;
        this.Date = Date;
        this.Client_Id = Client_Id;
        this.Comentario = Comentario;
        this.Monto = Monto;
    }
  
}
