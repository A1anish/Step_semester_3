package oop_basics.assigment_problems;

class Order {
    static int totalOrders = 0;

    public Order() {
        totalOrders++;
    }
}

public class L5_CountingOrdersStatic {
    public static void main(String[] args) {
        new Order();
        new Order();
        new Order();
        new Order();
        System.out.println("Total orders: " + Order.totalOrders);
    }
}
