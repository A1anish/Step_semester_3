package inheritance_and_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryFeeCalculator {

    abstract static class Delivery {
        protected final String type;
        protected final double weight;
        protected final double distance;

        public Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        public StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        @Override
        public double calculateFee() {
            return 5.0 + (0.50 * weight) + (0.10 * distance);
        }
    }

    static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        @Override
        public double calculateFee() {
            return 15.0 + (1.00 * weight) + (0.20 * distance);
        }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public double calculateFee() {
            return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSTANDARD 10 50\nEXPRESS 5 20\nINTERNATIONAL 20 100 30\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            if ("STANDARD".equals(type)) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if ("EXPRESS".equals(type)) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else if ("INTERNATIONAL".equals(type)) {
                double customs = sc.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customs));
            }
        }

        double grandTotal = 0.0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f%n", d.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
