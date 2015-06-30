package app.beans;

// Basket hat ArrayListe aus BasketEntity Objekten
// Berechnet Gesamtpreis

import java.io.Serializable;
import java.util.*;


public class Basket implements Serializable {
    
    private ArrayList<BasketEntity> b;
    private float totalPrice;
    private int amount;

    public Basket() { 
        b = new ArrayList<BasketEntity>();
    }
    
    public int getAmount() {
        return b.size();
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    // Berechnet komplettpreis der Bestellung
    public float getTotalPrice() {
        float sum = 0;
        for(BasketEntity i : b){
            sum += i.getTotalPrice();
        }
        return sum;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void flushBasket(){
        this.b.removeAll(b);
        this.amount = 0;
    }
   
    public ArrayList<BasketEntity> getB() {
        return b;
    }

    public void setB(ArrayList<BasketEntity> b) {
        this.b = b;
    }  
}
