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
public class Account {
      public int Id;
   public String Description;
   public int Type_Id;
   public double Inicial;
   public String Categoria;

    public Account(int Id, String Description, int Type_Id, double Ppt, String Categoria) {
        this.Id = Id;
        this.Description = Description;
        this.Type_Id = Type_Id;
        this.Inicial = Ppt;
        this.Categoria = Categoria;
    }

   
}
