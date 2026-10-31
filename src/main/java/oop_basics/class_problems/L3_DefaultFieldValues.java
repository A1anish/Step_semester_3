package oop_basics.class_problems;

class LibraryCard {
    String holderName;
    int booksIssued;
    boolean active;
}

public class L3_DefaultFieldValues {
    public static void main(String[] args) {
        LibraryCard card = new LibraryCard();
        System.out.println("Holder: " + card.holderName);
        System.out.println("Books Issued: " + card.booksIssued);
        System.out.println("Active: " + card.active);
    }
}
