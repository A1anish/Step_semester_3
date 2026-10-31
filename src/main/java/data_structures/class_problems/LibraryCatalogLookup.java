package data_structures.class_problems;

public class LibraryCatalogLookup {

    public static class BookRecord {
        public final String isbn;
        public final String title;

        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    /**
     * Binary search on a catalog sorted by ISBN in ascending order.
     * Time Complexity: O(log n) per query
     * Space Complexity: O(1) auxiliary space
     * Why appropriate: Since the catalog is already sorted and queries vastly outnumber updates,
     * binary search achieves logarithmic lookup without needing extra memory for a hash table.
     */
    public static String findBook(BookRecord[] catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid].title;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        BookRecord[] catalog = {
            new BookRecord("0001112223", "Introduction to Algebra"),
            new BookRecord("0002223334", "Beginning Python"),
            new BookRecord("0003334445", "Classic Mythology"),
            new BookRecord("0004445556", "Data and Society"),
            new BookRecord("0005556667", "European History")
        };
        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}
