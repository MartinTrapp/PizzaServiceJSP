// Stellt app.model und admin.model SQL Funktionen zur Verfügung

package helper;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHelper {
   Statement st;
   Connection con;
   
   //öffnen der Connection
   public void openCon() throws Exception, ClassNotFoundException{
      Class.forName("org.gjt.mm.mysql.Driver");
      con= DriverManager.getConnection("jdbc:mysql://localhost:3306/du16","du16","x+8C");
      st = con.createStatement();
   }
   
   // schließen der Connection
   public void closeCon() throws Exception{
      st.close();
      con.close();
   }
   // SELECT
   public ResultSet execQuery(String statement) throws Exception{
      return st.executeQuery(statement);
   }
   // INSERT, UPDATE, DELETE
   public boolean execNonQuery(String statement) throws Exception{ 
      st.executeUpdate(statement);
      return true; 
   }
   // return letzte eingetragene ID
   public int getLastID() throws Exception{
      ResultSet id = execQuery("SELECT @@IDENTITY");
      if(id.next()){
         return id.getInt(1);
      }  
      return -1;
   }
}
