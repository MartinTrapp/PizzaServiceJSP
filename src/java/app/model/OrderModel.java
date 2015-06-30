// Trägt Bestellung in DB ein

package app.model;

import app.beans.Basket;
import app.beans.BasketEntity;
import app.beans.Costumer;
import helper.SQLHelper;
import java.sql.ResultSet;

public class OrderModel {
    SQLHelper sql;
    
    public OrderModel(){
        sql = new SQLHelper();
    }
    
    public void newOrder(Costumer c, Basket b) throws Exception{
        sql.openCon();
            ResultSet rs = sql.execQuery("SELECT ID FROM `customer` WHERE firstName = '"+ c.getFirstName() +"' AND lastName = '"+ c.getLastName() +"' AND street = '"+ c.getStreet() +"' AND number = '"+ c.getNumber() +"' AND tel = '"+ c.getTel() +"'");    
            // wenn Kunde bereits vorhanden, wird dieser nicht neu angelegt
            int custID = 0;
            if(rs.next()){   // Gibt es bereits einen Kunden mit dieser Signatur?
               custID = rs.getInt("ID"); 
            }
            else{  // Wenn Nein: lege einen neuen Kunden an
                sql.execNonQuery("INSERT INTO `customer` (title,firstName,lastName,street,number,zip,town,tel) VALUES ('"+c.getTitle()+"', '"+c.getFirstName()+"', '"+c.getLastName()+"', '"+c.getStreet()+"', '"+c.getNumber()+"', "+c.getZip()+", '"+c.getTown()+"', '"+c.getTel()+"')");
                custID = sql.getLastID();
            }
            
            // Eintragen der Order
            sql.execNonQuery("INSERT INTO `order` (customerID, wish) VALUES ( "+ custID +" , '"+ c.getWish() +"')");
            
            // Eintragen der Produkte
            int lastID = sql.getLastID();
            for(BasketEntity i : b.getB()){
                sql.execNonQuery("INSERT INTO `producttoorder` (modelID, orderID, amount) VALUES ( '"+ i.getModelID() +"' , '"+ lastID +"' , '"+ i.getAmount() +"')");
            }
    
            b.flushBasket();
        sql.closeCon();
    } 
}
