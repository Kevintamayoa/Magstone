/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author macbook
 */
public class Tickets {
    public int Id;
    public Date Date;
    public int Sale_Id;
    public String Comentario;
    public String Chofer;
    public int Ticket_Num;

    public Tickets(int Id, Date Date, int Sale_Id, String Comentario, String Chofer, int Ticket_Num) {
        this.Id = Id;
        this.Date = Date;
        this.Sale_Id = Sale_Id;
        this.Comentario = Comentario;
        this.Chofer = Chofer;
        this.Ticket_Num = Ticket_Num;
    }
    public List<Tickets_Contains> list;

    public Tickets(int Id, Date Date, int Sale_Id, String Comentario, String Chofer, int Ticket_Num, ArrayList<Tickets_Contains> list) {
        this.Id = Id;
        this.Date = Date;
        this.Sale_Id = Sale_Id;
        this.Comentario = Comentario;
        this.Chofer = Chofer;
        this.Ticket_Num = Ticket_Num;
        this.list =new ArrayList<Tickets_Contains>();
        this.list=list;
    }
    
}
