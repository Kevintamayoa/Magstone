/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author macbook
 */
public class EstadoCuenta {
public Date Date;
public int Type;
public String Category;
public String Client;
public String Detail;
public double Amount;

    public EstadoCuenta() {
    }

    public EstadoCuenta(Date Date, int Type, String Category, String Client, String Detail, double Amount) {
        this.Date = Date;
        this.Type = Type;
        this.Category = Category;
        this.Client = Client;
        this.Detail = Detail;
        this.Amount = Amount;
    }
public List<EstadoCuenta> list;
public void EstadoCuenta(List<Income> incomes,List<Expense> expenses,List<Moves_Account> moves,int account_id,double inicial){
    list=new ArrayList<EstadoCuenta>();
   
  
    for(Expense obj : expenses){
        list.add(new EstadoCuenta(obj.Date,2,obj.Expense_Type,"",obj.Concept,obj.Amount));
    }
       for(Income obj : incomes){
        list.add(new EstadoCuenta(obj.Date,1,obj.Expense_Type,obj.Client,obj.Concept,obj.Amount));
    }
        for(Moves_Account obj : moves){
            if(obj.In_Id==account_id&&obj.Out_Id==account_id){}else{
        if(obj.In_Id==account_id){
         list.add(new EstadoCuenta(obj.Date,1,"Movimiento de cajas","",obj.Description,obj.Amount));
        }
        else if(obj.Out_Id==account_id){
            list.add(new EstadoCuenta(obj.Date,2,"Movimiento de cajas","",obj.Description,obj.Amount));
        }      } 
    }
   	list.sort((EstadoCuenta o1, EstadoCuenta o2)->o1.Date.compareTo(o2.Date));	
}
public double Saldo(double inicial,int i,List<EstadoCuenta> list){
    if(i==0){
        double aux=inicial;
         if(list.get(0).Type==1){
             aux+=list.get(0).Amount;
         }else
         {
               aux-=list.get(0).Amount;
         }
     
     return aux;
    }else{
        double aux=inicial;
     for(int j=0;j<=i;j++){
         if(list.get(j).Type==1){
             aux+=list.get(j).Amount;
         }else
         {
               aux-=list.get(j).Amount;
         }
     }
     return aux;
    }
}
}
