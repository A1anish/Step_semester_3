package data_structures.class_problems;

import java.util.HashSet;
import java.util.Set;

public class TransactionDuplicateCheck {

    /**
     * HashSet-based duplicate check prioritizing runtime for millions of nightly transactions.
     * Time Complexity: O(n) average time
     * Space Complexity: O(n) extra space to store seen transaction IDs
     * Alternative Approach: Sort the array in-place (O(n log n) time, O(1) or O(log n) space)
     * and check adjacent elements, or use nested loops (O(n^2) time, O(1) space), trading slower
     * runtime for lower memory consumption.
     */
    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"}));
        System.out.println(hasDuplicate(new String[]{"TXN2001", "TXN2002", "TXN2003"}));
    }
}
