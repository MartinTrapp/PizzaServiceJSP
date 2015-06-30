
//Beeinhaltet einzelnes Produkt
//summiert anzahl * preis des einzelnen Produktes

package app.beans;

import java.io.Serializable;

public class BasketEntity implements Serializable {
    
    private int modelID;
    private String name;
    private int amount;
    private String size;
    private float price;
    private float totalPrice;

    public float getTotalPrice() {
        return this.amount * this.price;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public BasketEntity() {     
        amount = 0;
    }
    
    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = this.amount + amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
