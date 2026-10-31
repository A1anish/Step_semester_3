package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

public class CityCabFareMeter {

    interface NightServiceCapable {
        default double applyNightSurcharge(double baseFare) {
            return baseFare * 1.20;
        }
    }

    abstract static class Cab {
        private static final double MINIMUM_FARE = 100.0;
        protected final String cabType;
        protected final double km;

        public Cab(String cabType, double km) {
            this.cabType = cabType;
            this.km = km;
        }

        public String getCabType() {
            return cabType;
        }

        protected abstract double ratePerKm();

        public final double calculateDayFare() {
            return Math.max(MINIMUM_FARE, km * ratePerKm());
        }
    }

    static class MiniCab extends Cab {
        public MiniCab(double km) {
            super("MINI", km);
        }

        @Override
        protected double ratePerKm() {
            return 10.0;
        }
    }

    static class SedanCab extends Cab implements NightServiceCapable {
        public SedanCab(double km) {
            super("SEDAN", km);
        }

        @Override
        protected double ratePerKm() {
            return 14.0;
        }
    }

    static class SuvCab extends Cab implements NightServiceCapable {
        public SuvCab(double km) {
            super("SUV", km);
        }

        @Override
        protected double ratePerKm() {
            return 18.0;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "4\nMINI 8 DAY\nSEDAN 10 NIGHT\nSUV 20 DAY\nMINI 5 NIGHT\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;
            if ("MINI".equals(type)) {
                cab = new MiniCab(km);
            } else if ("SEDAN".equals(type)) {
                cab = new SedanCab(km);
            } else {
                cab = new SuvCab(km);
            }

            if ("NIGHT".equals(time)) {
                if (cab instanceof NightServiceCapable) {
                    double fare = ((NightServiceCapable) cab).applyNightSurcharge(cab.calculateDayFare());
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
                } else {
                    System.out.printf("%s: night service not available%n", cab.getCabType());
                }
            } else {
                double fare = cab.calculateDayFare();
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getCabType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
