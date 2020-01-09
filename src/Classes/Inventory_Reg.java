/*
 * To change this license header, choose License Headers in Project Properties.
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
public class Inventory_Reg {
    public int Id;
    public Date Date;
    public String Detalle;

    public Inventory_Reg(Date Date, String Detalle) {
        this.Date = Date;
        this.Detalle = Detalle;
    }

    public Inventory_Reg(int Id, Date Date, String Detalle) {
        this.Id = Id;
        this.Date = Date;
        this.Detalle = Detalle;
    }
    public List<Inventory_Moves> list;

    public Inventory_Reg(int Id, Date Date, String Detalle, List<Inventory_Moves> list) {
        this.Id = Id;
        this.Date = Date;
        this.Detalle = Detalle;
        this.list = list;
    }
    
}
