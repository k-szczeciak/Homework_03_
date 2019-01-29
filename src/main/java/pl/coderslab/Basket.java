package pl.coderslab;

public class Basket {
    private String item;
    private int qty;
    private double price;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Basket(String item, int qty, double price) {
        this.item = item;
        this.qty = qty;
        this.price = price;
    }
}
