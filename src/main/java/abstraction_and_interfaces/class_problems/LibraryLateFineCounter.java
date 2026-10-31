package abstraction_and_interfaces.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryLateFineCounter {

    abstract static class LibraryItem {
        protected final String title;
        protected final int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public String getTitle() {
            return title;
        }

        public abstract double calculateFine();
    }

    static class BookItem extends LibraryItem {
        public BookItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return 2.0 * daysLate;
        }
    }

    static class DvdItem extends LibraryItem {
        public DvdItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return Math.min(50.0, 5.0 * daysLate);
        }
    }

    static class MagazineItem extends LibraryItem {
        public MagazineItem(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return 1.0 * daysLate;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nBOOK Algebra 4\nDVD Inception 12\nMAGAZINE Sports 3\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            if ("BOOK".equals(type)) {
                items.add(new BookItem(title, daysLate));
            } else if ("DVD".equals(type)) {
                items.add(new DvdItem(title, daysLate));
            } else if ("MAGAZINE".equals(type)) {
                items.add(new MagazineItem(title, daysLate));
            }
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
