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
public class Tickets_Contains {
        public int Id;
    public int Product_Id;
    public int Cantidad;
    public int Ticket_Id;
public String Product;

    public Tickets_Contains(int Id, int Product_Id, int Cantidad, int Ticket_Id) {
        this.Id = Id;
        this.Product_Id = Product_Id;
        this.Cantidad = Cantidad;
        this.Ticket_Id = Ticket_Id;
    }

    public Tickets_Contains(int Id, int Product_Id, int Cantidad, int Ticket_Id, String Product) {
        this.Id = Id;
        this.Product_Id = Product_Id;
        this.Cantidad = Cantidad;
        this.Ticket_Id = Ticket_Id;
        this.Product = Product;
    }
    
    
}
