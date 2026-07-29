package Algorithms.Task_2;

import java.util.Arrays;
import java.util.Comparator;

public class OrderManager  {
    private Order[] orders;

    public OrderManager(Order[] orders) {
        this.orders = orders;
    }
    public void sortByCost() {
       Arrays.sort(orders, new Comparator<Order>() {
           @Override
            public int compare(Order o1, Order o2) {
              return Double.compare(o2.cost(),o1.cost());
           }
       });
    }
    public Order[] topNOrders(int n) {
        n = Math.min(n,orders.length);
        Order[] result = new Order[n];
        sortByCost();
        for (int i = 0; i < n; i++) {
            result[i] = orders[i];
        }
        return result;
    }

    static void main() {
        Product p1 = new Product("01","Ná Cao Su",25.000, "Súng");
        Product p2 = new Product("02","Cần câu máy",100.000, "Cần câu");
        Product p3 = new Product("03","Mồi hình con nhái",45.500, "Mồi câu");
        Product p4 = new Product("04","Cám câu cá",35.000, "Mồi câu");
        Product p5 = new Product("05","Cần câu kéo giãn",40.000, "Cần câu");
        Product p6 = new Product("06","Dây câu cá sấu",15.000, "Dây câu");
        Product p7 = new Product("07","Dây câu cá mập",20.000, "Dây câu");

        OrderItem item1 = new OrderItem(p2, 2);
        OrderItem item2 = new OrderItem(p3, 3);
        OrderItem item3 = new OrderItem(p4, 7);
        OrderItem[] arrayItem1 =  new OrderItem[]{item1,item2,item3};
        OrderItem item4 = new OrderItem(p1, 1);
        OrderItem item5 = new OrderItem(p5, 5);
        OrderItem item6 = new OrderItem(p6, 5);
        OrderItem[] arrayItem2 =  new OrderItem[]{item4,item5,item6};
        OrderItem item7 = new OrderItem(p7, 1);
        OrderItem item8 = new OrderItem(p2, 4);
        OrderItem[] arrayItem3 =  new OrderItem[]{item7,item8};
        Order order1 = new Order(arrayItem1);
        Order order2 = new Order(arrayItem2);
        Order order3 = new Order(arrayItem3);
        Order[] orders = new Order[]{order1,order2,order3};
        OrderManager manager = new OrderManager(orders);
        System.out.println("Cost Order Item: ");
        System.out.println(order1.cost());
        System.out.println(order2.cost());
        System.out.println(order3.cost());
        System.out.println("Check contains: ");
        System.out.println(order2.contains(new Product("01","Ná Cao Su",25.000, "Súng")));
        System.out.println("Get product by type: ");
        System.out.println(Arrays.toString(order2.filter("Cần câu")));
        System.out.println("Sort orders by cost: ");
        manager.sortByCost();
        System.out.println("Get top N highest orders by cost: ");
        System.out.println(Arrays.toString(manager.topNOrders(2)));
    }
}
