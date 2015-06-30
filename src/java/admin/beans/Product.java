/* Setzt Kundendaten um sie dem Model zu übergeben 
 * und um im Fehlerfall Values des Bestellformulars zu setzen
*/
package admin.beans;


import java.io.Serializable;

public class Product implements Serializable {
    
    private int id, category;
    private String name, extras, size;

    public Product() { 
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
