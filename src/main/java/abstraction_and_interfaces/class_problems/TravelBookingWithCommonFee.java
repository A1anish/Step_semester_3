package abstraction_and_interfaces.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelBookingWithCommonFee {

    abstract static class TravelBooking {
        private static final double BOOKING_FEE = 50.0;
        protected final String mode;
        protected final double distanceKm;

        public TravelBooking(String mode, double distanceKm) {
            this.mode = mode;
            this.distanceKm = distanceKm;
        }

        public String getMode() {
            return mode;
        }

        protected abstract double calculateBaseFare();

        public final double calculateTotalFare() {
            return calculateBaseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends TravelBooking {
        public BusBooking(double distanceKm) {
            super("BUS", distanceKm);
        }

        @Override
        protected double calculateBaseFare() {
            return 2.0 * distanceKm;
        }
    }

    static class TrainBooking extends TravelBooking {
        public TrainBooking(double distanceKm) {
            super("TRAIN", distanceKm);
        }

        @Override
        protected double calculateBaseFare() {
            return 1.5 * distanceKm;
        }
    }

    static class FlightBooking extends TravelBooking {
        public FlightBooking(double distanceKm) {
            super("FLIGHT", distanceKm);
        }

        @Override
        protected double calculateBaseFare() {
            return 2500.0 + (4.0 * distanceKm);
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nBUS 200\nTRAIN 300\nFLIGHT 500\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            if ("BUS".equals(mode)) {
                bookings.add(new BusBooking(distance));
            } else if ("TRAIN".equals(mode)) {
                bookings.add(new TrainBooking(distance));
            } else if ("FLIGHT".equals(mode)) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.calculateTotalFare());
        }
    }
}
