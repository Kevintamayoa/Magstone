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
public class Client {
      public int Id;
    public String Description;
    public String Direccion;
    public String Email;
    public String Telefono; 

    public Client(){}
    public Client( String Description, String Direccion, String Email, String Telefono) {
        this.Description = Description;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Telefono = Telefono;
    }
    public Client(int id, String Description, String Direccion, String Email, String Telefono) {
       this.Id=id;
        this.Description = Description;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Telefono = Telefono;
    }
    public double Monto;
    public double MontoPagado;
    public double Saldo(){
        return Monto-MontoPagado;
    }

    public Client(int Id, String Description, String Direccion, String Email, String Telefono, double Monto, double MontoPagado) {
        this.Id = Id;
        this.Description = Description;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Telefono = Telefono;
        this.Monto = Monto;
        this.MontoPagado = MontoPagado;
    }

    
}
