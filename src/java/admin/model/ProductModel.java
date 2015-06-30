// Model zum anlegen, editieren und löschen eines Produktes


package admin.model;
import helper.SQLHelper;
import admin.beans.Product;
import java.sql.ResultSet;

public class ProductModel {
    
    SQLHelper sql;
    
    public ProductModel(){
        sql = new SQLHelper();
    }
    //löschen
    public void deleteProduct(int id) throws Exception{
        sql.openCon();      
            sql.execNonQuery("DELETE FROM `product` WHERE ID = "+ id); 
        sql.closeCon();
    }
    //anlegen
    public void addProduct(Product p) throws Exception{
        sql.openCon();
            sql.execNonQuery("INSERT INTO `product` (name, extras, catID) VALUES ( '"+ p.getName() +"' , '"+ p.getExtras() +"', "+ p.getCategory() +")"); 
            // String dekonstruieren
            String[] pair = p.getSize().split(";");
            int lastID = sql.getLastID();    
                for(String tupel : pair){
                    String[] elem = tupel.split(":");
                    sql.execNonQuery("INSERT INTO `model` (productID, size, price) VALUES ( '"+ lastID +"' , '"+ elem[0] +"', "+ elem[1] +")");
                } 
        sql.closeCon();
    }
    //editieren
    public void editProduct(Product p) throws Exception{
        sql.openCon();
            sql.execNonQuery("UPDATE `product` SET name = '"+ p.getName() +"', extras = '"+ p.getExtras() +"', catID = "+ p.getCategory() +" WHERE ID =" + p.getId());
            sql.execNonQuery("DELETE FROM `model` WHERE productID = "+ p.getId());
            
            String str = p.getSize();
            //String dekonstruieren
            String[] pair = str.split(";");
                for(String tupel : pair){
                    String[] elem = tupel.split(":");
                    sql.execNonQuery("INSERT INTO `model` (productID, size, price) VALUES ( '"+ p.getId() +"' , '"+ elem[0] +"', "+ elem[1] +")");
                } 
        sql.closeCon();
    }
    // zusammengesetzter String wird über Controller an editProduct zurückgegeben.
    public String getSizesString(int id) throws Exception{
       String size = "";
       sql.openCon();
            ResultSet rs = sql.execQuery("SELECT size, price FROM model WHERE productID = "+ id); 
                while(rs.next()){
                    // size wird in der Form size:price;size:price zurückgeben
                    size += rs.getString("size") + ":" + rs.getString("price");
                    if(rs.isLast() != true){
                        size += ";";
                    }
                }                
       sql.closeCon();
        
       return size;
    }
}
