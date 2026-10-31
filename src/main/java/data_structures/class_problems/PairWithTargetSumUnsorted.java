package data_structures.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumUnsorted {

    /**
     * Approach 1 (Implemented): HashSet complement lookup -> O(n) time, O(n) space.
     * Approach 2: Sort + Two Pointers -> O(n log n) time, O(1) auxiliary space.
     * Approach 3: Brute-force nested loops -> O(n^2) time, O(1) space.
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}
