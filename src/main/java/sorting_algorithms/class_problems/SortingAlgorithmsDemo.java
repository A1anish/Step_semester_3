package sorting_algorithms.class_problems;

import sorting_algorithms.assigment_problems.DiceThrowTally;
import sorting_algorithms.assigment_problems.HeightLineUp;
import sorting_algorithms.assigment_problems.LibraryBookShelf;
import sorting_algorithms.assigment_problems.PrizeTable;
import sorting_algorithms.assigment_problems.QueueOrderCheck;

public class SortingAlgorithmsDemo {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Height Line-Up (Bubble Sort) ===");
        HeightLineUp.lineUp(new int[]{4, 2, 5, 1});

        System.out.println("\n=== Problem 2: The Prize Table (Selection Sort) ===");
        PrizeTable.prizeTable(new int[]{45, 90, 60, 75});

        System.out.println("\n=== Problem 3: The Library Book Shelf (Insertion Sort) ===");
        LibraryBookShelf.shelf(new int[]{30, 10, 40, 20});

        System.out.println("\n=== Problem 4: Is the Queue in Order? ===");
        System.out.println("First break index: " + QueueOrderCheck.firstBreak(new int[]{3, 5, 5, 8, 6, 9}));

        System.out.println("\n=== Problem 5: The Dice Throw Tally (Counting Sort) ===");
        DiceThrowTally.diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
    }
}
