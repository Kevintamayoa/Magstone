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
public class Flujo {
    public int Month;
    public double Amount;
    public double Product;
    public double Giftcard;
    public double Facial;
    public double BTL;
    public double Masaje;
    public double Medico;
        public double Amount2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
                return tot;
            
                    
        }
    public double Product2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
            if(tot==0){
                return 0;
            }else{
            return (Product/tot)*Amount;
                    }
        }
    public double Facial2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
            if(tot==0){
                return 0;
            }else{
            return (Facial/tot)*Amount;
                    }
        }
    public double Giftcard2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
            if(tot==0){
                return 0;
            }else{
            return (Giftcard/tot)*Amount;
                    }
        }
    public double BTL2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
            if(tot==0){
                return 0;
            }else{
            return (BTL/tot)*Amount;
                    }
        }
    public double Masaje2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
            if(tot==0){
                return 0;
            }else{
            return (Masaje/tot)*Amount;
                    }
        }
    public double Medico2(){
   
            double tot=Product+Giftcard+Facial+BTL+Masaje+Medico;
            if(tot==0){
                return 0;
            }else{
            return (Medico/tot)*Amount;
                    }
        }
    public Flujo(int Month, double Amount) {
        this.Month = Month;
        this.Amount = Amount;
    }
    public Flujo(int Month, double Amount, double Product, double Giftcard, double Facial, double BTL, double Masaje, double Medico) {
        this.Month = Month;
        this.Amount = Amount;
        this.Product = Product;
        this.Giftcard = Giftcard;
        this.Facial = Facial;
        this.BTL = BTL;
        this.Masaje = Masaje;
        this.Medico = Medico;
    }
    
}
