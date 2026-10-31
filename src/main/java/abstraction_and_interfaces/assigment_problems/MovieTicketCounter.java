package abstraction_and_interfaces.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieTicketCounter {

    abstract static class TicketBooking {
        private static final double CONVENIENCE_FEE = 20.0;
        protected final String seatType;
        protected final int count;

        public TicketBooking(String seatType, int count) {
            this.seatType = seatType;
            this.count = count;
        }

        public String getSeatType() {
            return seatType;
        }

        protected abstract double seatPrice();

        public final double calculateAmount() {
            return count * (seatPrice() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends TicketBooking {
        public RegularTicket(int count) {
            super("REGULAR", count);
        }

        @Override
        protected double seatPrice() {
            return 150.0;
        }
    }

    static class PremiumTicket extends TicketBooking {
        public PremiumTicket(int count) {
            super("PREMIUM", count);
        }

        @Override
        protected double seatPrice() {
            return 250.0;
        }
    }

    static class ReclinerTicket extends TicketBooking {
        public ReclinerTicket(int count) {
            super("RECLINER", count);
        }

        @Override
        protected double seatPrice() {
            return 400.0;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nREGULAR 3\nPREMIUM 2\nRECLINER 1\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<TicketBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            if ("REGULAR".equals(type)) {
                bookings.add(new RegularTicket(count));
            } else if ("PREMIUM".equals(type)) {
                bookings.add(new PremiumTicket(count));
            } else if ("RECLINER".equals(type)) {
                bookings.add(new ReclinerTicket(count));
            }
        }

        double total = 0.0;
        for (TicketBooking booking : bookings) {
            double amount = booking.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", booking.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
