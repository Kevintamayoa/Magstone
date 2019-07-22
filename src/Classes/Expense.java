/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.util.*;
/**
 *
 * @author macbook
 */
public class Expense {
    public int Id;
    public Date Date;
    public int Type_Id;
    public String Concept;
    public int Account_Id;
    public int Bills;
    public String BillsNumber;
    public double Amount;
    public int User_Id;

    public Expense(int Id, Date Date, int Type_Id, String Concept, int Account_Id, int Bills, String BillsNumber, double Amount, int User_Id) {
        this.Id = Id;
        this.Date = Date;
        this.Type_Id = Type_Id;
        this.Concept = Concept;
        this.Account_Id = Account_Id;
        this.Bills = Bills;
        this.BillsNumber = BillsNumber;
        this.Amount = Amount;
        this.User_Id = User_Id;
    }

    public Expense( Date Date, int Type_Id, String Concept, int Account_Id, int Bills, String BillsNumber, double Amount, int User_Id) {
        this.Date = Date;
        this.Type_Id = Type_Id;
        this.Concept = Concept;
        this.Account_Id = Account_Id;
        this.Bills = Bills;
        this.BillsNumber = BillsNumber;
        this.Amount = Amount;
        this.User_Id = User_Id;
    }
        
    public String Expense_Type;
    public String Account;
    public String User;
    public Boolean Bill(){
        if(Bills==0){
            return false;
        }else{
            return true;
        }
    }
     public double AmountSinIva(){
        if(Bills==0){
            return Amount;
        }else{
            return Amount/1.16;
        }
    }
      public double Iva(){
        if(Bills==0){
            return 0;
        }else{
            return Amount -Amount/1.16;
        }
    }
    public Expense(int Id, Date Date, String Type, String Concept, String Account, int Bills, String BillsNumber, double Amount, String User) {
        this.Id = Id;
        this.Date = Date;
        this.Expense_Type = Type;
        this.Concept = Concept;
        this.Account = Account;
        this.Bills = Bills;
        this.BillsNumber = BillsNumber;
        this.Amount = Amount;
        this.User = User;
 
    }
   
    
}
