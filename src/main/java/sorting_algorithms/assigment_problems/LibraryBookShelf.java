package sorting_algorithms.assigment_problems;

public class LibraryBookShelf {

    private static String formatArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int currentBook = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > currentBook) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = currentBook;
            System.out.println("After placing " + currentBook + ": " + formatArray(books));
        }
    }

    public static void main(String[] args) {
        shelf(new int[]{30, 10, 40, 20});
        System.out.println();
        shelf(new int[]{50, 25, 35, 15, 45});
    }
}
