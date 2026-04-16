public class ConcessionItem {

    private String itemName;
    private double price;
    private String type; // "Food" or "Beverage"

    // Constructor
    public ConcessionItem(String itemName, double price, String type) {
        this.itemName = itemName;
        this.price = price;
        this.type = type;
    }

    // Getter for itemName
    public String getName() {
        return itemName;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Getter for type
    public String getType() {
        return type;
    }
}
