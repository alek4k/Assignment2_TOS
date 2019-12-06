////////////////////////////////////////////////////////////////////
// Alessandro Lovo 1142682
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;


public class MenuItem {

    public enum ItemType {PANINI, FRITTI, BEVANDE}
    
    private ItemType type;
    private String name;
    private double price;

    public MenuItem(ItemType type, String nome, double prezzo) {
        setType(type);
        setName(nome);
        setPrice(prezzo);
    }
    
    public ItemType getType() {
        return type;
    }

    private void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
} 
