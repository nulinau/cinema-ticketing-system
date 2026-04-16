public class ConcessionItem {
    private String itemId;
    private String name;
    private double price;

    public ConcessionItem(String itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public void createItem() {
        System.out.println("Item created: " + name);
    }

    public void updateItem(String newName, double newPrice) {
        this.name = newName;
        this.price = newPrice;
        System.out.println("Item updated.");
    }

    public void deleteItem() {
        System.out.println("Item deleted: " + name);
    }

    public ConcessionItem getItem() {
        return this;
    }

    public double getPrice() {
        return price;
    }
}
