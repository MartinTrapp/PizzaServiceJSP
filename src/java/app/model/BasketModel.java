// Model zum hinzufügen, abziehen und löschen eines Produktes aus dem Warenkorb

package app.model;

import helper.SQLHelper;
import app.beans.BasketEntity;
import app.beans.Basket;
import java.sql.ResultSet;
import java.util.*;

public class BasketModel {
   
    //hinzufügen
    public void addBean(int modelID, Basket cpy)  throws Exception{
       BasketEntity b = new BasketEntity();
       ArrayList<BasketEntity> c = cpy.getB();
       
       SQLHelper sql = new SQLHelper();
       sql.openCon();
            ResultSet rs = sql.execQuery("SELECT model.size, model.price, product.name FROM model, product WHERE model.ID = "+ modelID +" AND model.productID = product.ID");
            if(rs.next()){
                // wenn produkt bereits in Warenkorb --> Anzahl + 1
                int t = isIn(modelID, c);
                if(t >= 0){
                    c.get(t).setAmount(1);
                }
                // Ansonsten Eintrag zur ArrayList hinzufügen
                else{
                    b.setModelID(modelID);
                    b.setName(rs.getString("name"));
                    b.setSize(rs.getString("size"));
                    b.setPrice(rs.getFloat("price")); 
                    b.setAmount(1);
                    c.add(b);
                }
            }               
            sql.closeCon();
    }
    
    // produktanzahl verringern
    public void subBean(int modelID, Basket cpy){
        ArrayList<BasketEntity> c = cpy.getB();
        // wenn produkt vorhanden
        int t = isIn(modelID, c);
        if(t >= 0){
            // wenn mehr als ein produkt vorhanden
            if(c.get(t).getAmount() > 1){
                c.get(t).setAmount(-1);
            }
            //ansonsten produkt aus ArrayList löschen
            else{
                c.remove(t);
            }                
        }
    }
    
    //löschen eines Produktes 
    public void delBean(int modelID, Basket cpy){
        ArrayList<BasketEntity> c = cpy.getB();
        //wenn produkt in Liste
        int t = isIn(modelID, c);
        if(t >= 0){
            c.remove(t);
        }
    }
    
    // Prüft ob produkt in Liste
    public int isIn(int modelID, ArrayList<BasketEntity>  c){
        for(int i=0; i<c.size(); i++){
            if(c.get(i).getModelID() == modelID){
                return i;
            }
        }
        return -1;
    }
}
