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
public class Request {
    public int Id;
    public Date Date; 
    public String Comentario;
    public int Provider_Id;
    public String Provider;
    public int Account_Id;
    public String Account;
    public int State_Id;
      public double Monto;
    public Boolean Recibido(){
      
        if(State_Id==0||State_Id==2){
            return false;
        }else{
            return true;
        }
    }
      public Boolean Pagado(){
        if(State_Id==0||State_Id==1){
            return false;
        }else{
            return true;
        }
    }
    public Request( Date Date, String Comentario, int Provider_Id,int Account_Id, int State_Id) {
        this.Date = Date;
        this.Comentario = Comentario;
        this.Provider_Id = Provider_Id;
        this.Account_Id=Account_Id;
        this.State_Id = State_Id;
    }

    public Request(int Id, Date Date, String Comentario, String Provider, int Account_Id, String Account, int State_Id,double Monto) {
        this.Id = Id;
        this.Date = Date;
        this.Comentario = Comentario;
        this.Provider = Provider;
        this.Account_Id = Account_Id;
        this.Account = Account;
        this.State_Id = State_Id;
        this.Monto=Monto;
    }
    
   
       
}
