package data_structures.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    /**
     * Problem 8: Duty Roster Rotation
     * Time Complexity: O(n), Space Complexity: O(n) for the rotated array.
     * Why rotating one place at a time k times is slow: Rotating one step takes O(n), so repeating it
     * k times takes O(n * k) time (up to 100 * 10^9 = 10^11 operations when k = 10^9).
     * Using k % n reduces full turns in O(1) and places each element directly at (i + k) % n in O(n).
     */
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
