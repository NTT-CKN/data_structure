package Algorithms.Task_2;

import java.util.Arrays;

public class Order {
    private OrderItem[] items;

    public Order(OrderItem[] items) {
        this.items = items;
    }
    public double cost() {
        double cost = 0;
        for (OrderItem item : items) {
           cost += item.getQuantity() * item.getP().getPrice();
        }
        return cost;
    }
    public boolean contains(Product product) {
       int left = 0;
       int right = items.length - 1;
       while (left <= right) {
           int mid = (left+right) / 2;
           int cmp = items[mid].getP().getId().compareTo(product.getId());
           if(cmp == 0) {
               return true;
           }else if(cmp < 0) {
               left = mid + 1;
           }else{
               right = mid - 1;
           }
       }
        return false;
    }
    public Product[] filter(String type) {
        int n = 0;
        Product[] result = new Product[items.length];
        for(int i = 0 ; i < items.length; i++) {
            if(items[i].getP().getType().equals(type)) {
                result[n++] = items[i].getP();
            }
        }
        return Arrays.copyOf(result, n);
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
