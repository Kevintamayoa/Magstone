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
public class User {
   public int Id;
   public String Name;
   public String Password;
   public int Type_Id;
   public User(int id,String name, String password,int userType)
   {
       Id=id;
       Name=name;
       Password=password;
       Type_Id=userType;
   }
    
}
