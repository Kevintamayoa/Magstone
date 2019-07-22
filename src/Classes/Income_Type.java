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
public class Income_Type {
    public int Id;
    public String Description;
    public double Ppt;
    public int Category_Id;
   public int Source_Id;

    public Income_Type(int Id, String Description, double Ppt, int Category_Id, int Source_Id) {
        this.Id = Id;
        this.Description = Description;
        this.Ppt = Ppt;
        this.Category_Id = Category_Id;
        this.Source_Id = Source_Id;
    }
       public double Enero;        
    public double Febrero;
    public double Marzo;
    public double Abril;        
    public double Mayo;
    public double Junio;
    public double Julio;        
    public double Agosto;
    public double Septiembre;
    public double Octubre;        
    public double Noviembre;
    public double Diciembre;

    public Income_Type(int Id, String Description, double Ppt, int Category_Id, int Source_Id, double Enero, double Febrero, double Marzo, double Abril, double Mayo, double Junio, double Julio, double Agosto, double Septiembre, double Octubre, double Noviembre, double Diciembre) {
        this.Id = Id;
        this.Description = Description;
        this.Ppt = Ppt;
        this.Category_Id = Category_Id;
        this.Source_Id = Source_Id;
        this.Enero = Enero;
        this.Febrero = Febrero;
        this.Marzo = Marzo;
        this.Abril = Abril;
        this.Mayo = Mayo;
        this.Junio = Junio;
        this.Julio = Julio;
        this.Agosto = Agosto;
        this.Septiembre = Septiembre;
        this.Octubre = Octubre;
        this.Noviembre = Noviembre;
        this.Diciembre = Diciembre;
    }
    
}
