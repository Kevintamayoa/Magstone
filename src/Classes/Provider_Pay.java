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
public class Provider_Pay {
    public int Id;
    public int Provider_Id;
    public int Expense_Id;

    public Provider_Pay(int Id, int Provider_Id, int Expense_Id) {
        this.Id = Id;
        this.Provider_Id = Provider_Id;
        this.Expense_Id = Expense_Id;
    }
    
}
