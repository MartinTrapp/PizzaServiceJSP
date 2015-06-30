// Model zum abschließen einer Bestellung

package admin.model;
import helper.SQLHelper;

public class OrderModel {
    // Update der Bestellungstabelle = Bestellung abgeschlossen
    public void finishOrder(int id) throws Exception{
        SQLHelper sql = new SQLHelper();
        sql.openCon();
            sql.execNonQuery("UPDATE `order` SET done = 1 WHERE ID = '"+ id +"'");
        sql.closeCon();
    } 
}
