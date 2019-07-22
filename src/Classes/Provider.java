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
public class Provider {
    
    public int Id;
    public String Description;
    public String Contacto;
    public String Email;
    public String Detalle; 

    public Provider(String Description, String Contacto, String Email, String Detalle) {
        this.Description = Description;
        this.Contacto = Contacto;
        this.Email = Email;
        this.Detalle = Detalle;
    }

    public Provider(int Id, String Description, String Contacto, String Email, String Detalle) {
        this.Id = Id;
        this.Description = Description;
        this.Contacto = Contacto;
        this.Email = Email;
        this.Detalle = Detalle;
    }
    public Provider(){}
    public double Monto;
    public double MontoPagado;
    public double Saldo(){
        return Monto-MontoPagado;
    }
    public Provider(int Id, String Description, String Contacto, String Email, String Detalle, double Monto, double MontoPagado) {
        this.Id = Id;
        this.Description = Description;
        this.Contacto = Contacto;
        this.Email = Email;
        this.Detalle = Detalle;
        this.Monto = Monto;
        this.MontoPagado = MontoPagado;
    }
    
}
