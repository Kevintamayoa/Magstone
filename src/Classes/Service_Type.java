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
public class Service_Type {
        public int Id;
    public String Description;
    public double Cost;
  
    public double Cost1;
      public double Price;
    public int Category_Id;

    public Service_Type(int Id, String Description, double Cost, double Cost1,double Price,  int Category_Id) {
        this.Id = Id;
        this.Description = Description;
        this.Cost = Cost;
        this.Cost1 = Cost1;
        this.Price=Price;
        this.Category_Id = Category_Id;
    }

   
   
}
