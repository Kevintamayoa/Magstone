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
public class Inventory_Moves {

    public int Id;
    public int Out_Id;
    public int Qty1;
    public int In_Id;
    public int Qty;
    public String Out;
    public String In;
    public int Req_Id;

    public Inventory_Moves() {

    }

    public Inventory_Moves(int Id, int Out_Id, int Qty1, int In_Id, int Qty) {
        this.Id = Id;
        this.Out_Id = Out_Id;
        this.Qty1 = Qty1;
        this.In_Id = In_Id;
        this.Qty = Qty;
    }

    public Inventory_Moves(int Id, int Out_Id, int Qty1, int In_Id, int Qty, int Req_Id) {
        this.Id = Id;
        this.Out_Id = Out_Id;
        this.Qty1 = Qty1;
        this.In_Id = In_Id;
        this.Qty = Qty;
        this.Req_Id = Req_Id;
    }

    public Inventory_Moves(int Id, int Out_Id, int Qty1, int In_Id, int Qty, String Out, String In, int Req_Id) {
        this.Id = Id;
        this.Out_Id = Out_Id;
        this.Qty1 = Qty1;
        this.In_Id = In_Id;
        this.Qty = Qty;
        this.Out = Out;
        this.In = In;
        this.Req_Id = Req_Id;
    }

}
