package inheritance_and_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PublicTransportFareCalculator {

    abstract static class Transport {
        protected final String type;
        protected final double distance;

        public Transport(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFare();
    }

    static class Bus extends Transport {
        public Bus(double distance) {
            super("BUS", distance);
        }

        @Override
        public double calculateFare() {
            return Math.min(10.0, 2.0 + 0.10 * distance);
        }
    }

    static class Train extends Transport {
        public Train(double distance) {
            super("TRAIN", distance);
        }

        @Override
        public double calculateFare() {
            return 3.0 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        private final double peakHourFactor;

        public Metro(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nBUS 15\nTRAIN 50\nMETRO 10 1.5\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                case "METRO":
                    double peakFactor = sc.nextDouble();
                    journeys.add(new Metro(distance, peakFactor));
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
