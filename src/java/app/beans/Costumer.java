//beeinhaltet Kundendaten aus Formular
//Grundlegende Fehlerprüfung der eingegebenen Daten
//ggf Fehlermeldung eintragen in error HashMap

package app.beans;

import java.io.Serializable;
import java.util.HashMap;

public class Costumer implements Serializable {
    
    private String title, firstName, lastName, street, number, town, tel, wish;
    private int zip;
    private HashMap error;
    private final String _EMPTY = "Bitte Ausfüllen!";
    
    public Costumer() {
        error = new HashMap();
    }
    
    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
           this.title = title;     
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(!firstName.equals("")){
            this.firstName = firstName;
        }
        else{
            error.put("firstName",_EMPTY);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!lastName.equals("")){
            this.lastName = lastName;
        }
        else{
            error.put("lastName",_EMPTY);
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(!street.equals("")){
            this.street = street;
        }
        else{
            error.put("street",_EMPTY);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if(!number.equals("")){
            this.number = number;
        }
        else{
            error.put("number",_EMPTY);
        }
    }

    public int getZip() {
        return zip;
    }

    public void setZip(String zip) {
        if(!zip.equals("")){
            try  
            {  
               this.zip = Integer.parseInt(zip);  
            }  
            catch( Exception e )  
            {  
               error.put("zip","Keine Zahl");  
            }  
        }
        else{
            error.put("zip",_EMPTY);
        } 
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if(!town.equals("")){
            this.town = town;
        }
        else{
            error.put("town",_EMPTY);
        }
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        if(!tel.equals("")){
            this.tel = tel;  
        }
        else{
            error.put("tel",_EMPTY);
        }  
    }
    
    public HashMap getErrors(){
        return error;
    }
}
