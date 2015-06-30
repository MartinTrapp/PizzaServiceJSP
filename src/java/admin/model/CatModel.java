// Model zum anlegen, editieren und lösches einer Kategorie

package admin.model;

import helper.SQLHelper;

public class CatModel{
    
    SQLHelper sql;
    
    public CatModel() throws Exception{
        sql = new SQLHelper();
    }
    
    //löschen
    public void deleteCat(int id) throws Exception{
        sql.openCon();
            sql.execNonQuery("DELETE FROM `category` WHERE ID = "+ id); 
        sql.closeCon();
    }
    //anlegen
    public void addCat(String name, int seqNr) throws Exception{
        sql.openCon();
            sql.execNonQuery("INSERT INTO `category` (name, seqNr) VALUES ( '"+ name +"' , "+ seqNr +")");
        sql.closeCon();
    }
    //editieren
    public void editCat(int id, String name, int seqNr) throws Exception{ 
        sql.openCon();
            sql.execNonQuery("UPDATE `category` SET name = '"+ name +"', seqNr = "+ seqNr +" WHERE ID =" + id);
        sql.closeCon();
    }
}
