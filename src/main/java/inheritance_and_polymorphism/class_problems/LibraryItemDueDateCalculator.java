package inheritance_and_polymorphism.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {

    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    abstract static class LibraryItem {
        protected final String title;

        public LibraryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public abstract LocalDate calculateDueDate(LocalDate borrowDate);
    }

    static class Book extends LibraryItem {
        public Book(String title) {
            super(title);
        }

        @Override
        public LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(14);
        }
    }

    static class Dvd extends LibraryItem {
        public Dvd(String title) {
            super(title);
        }

        @Override
        public LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(7);
        }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String title) {
            super(title);
        }

        @Override
        public LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(3);
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nBOOK \"1984\"\nDVD \"The Matrix\"\nMAGAZINE \"Forbes Issue 500\"\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace).trim();
            String title = line.substring(firstSpace + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            switch (type) {
                case "BOOK":
                    items.add(new Book(title));
                    break;
                case "DVD":
                    items.add(new Dvd(title));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title));
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(CURRENT_DATE));
        }
    }
}
