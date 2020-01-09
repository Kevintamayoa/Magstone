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
public class Moves_Account {

    public int Id;
    public Date Date;
    public int Out_Id;
    public int In_Id;
    public double Amount;
    public String Description;
    public int User_Id;
    public String AccountOut;
    public String AccountIn;
    public String User;
     public Moves_Account(int id,Date Date, int Out_Id, int In_Id, double Amount, String Description, int User_Id) {
        this.Id=id;
         this.Date = Date;
        this.Out_Id = Out_Id;
        this.In_Id = In_Id;
        this.Amount = Amount;
        this.Description = Description;
        this.User_Id = User_Id;
    } 
    public Moves_Account(Date Date, int Out_Id, int In_Id, double Amount, String Description, int User_Id) {
        this.Date = Date;
        this.Out_Id = Out_Id;
        this.In_Id = In_Id;
        this.Amount = Amount;
        this.Description = Description;
        this.User_Id = User_Id;
    } 
    public Moves_Account(int Id, Date Date, String AccountOut , String AccountIn, double Amount, String Description, String user) {
        this.Id = Id;
        this.Date = Date;
        this.Amount = Amount;
        this.Description = Description;
        this.User=user;
        this.AccountOut = AccountOut;
        this.AccountIn = AccountIn;
    }
       public Moves_Account(int Id, Date Date, int AccountOut , int AccountIn, double Amount, String Description, String user) {
        this.Id = Id;
        this.Date = Date;
        this.Amount = Amount;
        this.Description = Description;
        this.User=user;
        this.Out_Id = AccountOut;
        this.In_Id = AccountIn;
    }
    

}
