package abstraction_and_interfaces.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricityConnectionBilling {

    abstract static class ElectricityConnection {
        protected final String type;
        protected final int units;

        public ElectricityConnection(String type, int units) {
            this.type = type;
            this.units = units;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateBill();
    }

    static class HomeConnection extends ElectricityConnection {
        public HomeConnection(int units) {
            super("HOME", units);
        }

        @Override
        public double calculateBill() {
            if (units <= 100) {
                return units * 5.0;
            }
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    static class ShopConnection extends ElectricityConnection {
        public ShopConnection(int units) {
            super("SHOP", units);
        }

        @Override
        public double calculateBill() {
            return (units * 8.0) + 100.0;
        }
    }

    static class FactoryConnection extends ElectricityConnection {
        public FactoryConnection(int units) {
            super("FACTORY", units);
        }

        @Override
        public double calculateBill() {
            return Math.max(1000.0, units * 6.0);
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nHOME 150\nSHOP 90\nFACTORY 120\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if ("HOME".equals(type)) {
                connections.add(new HomeConnection(units));
            } else if ("SHOP".equals(type)) {
                connections.add(new ShopConnection(units));
            } else if ("FACTORY".equals(type)) {
                connections.add(new FactoryConnection(units));
            }
        }

        double total = 0.0;
        for (ElectricityConnection conn : connections) {
            double bill = conn.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", conn.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
