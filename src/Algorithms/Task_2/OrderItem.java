package Algorithms.Task_2;

public class OrderItem {
    private Product p;
    private int quantity;
    public OrderItem(Product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }
    public Product getP() {
        return p;
    }
    public void setP(Product p) {
        this.p = p;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "p=" + p +
                ", quantity=" + quantity +
                '}';
    }
}
