package data_structures.assigment_problems;

public class ExamScoreBandCounter {

    /**
     * Problem 4: Exam Score Band Counter
     * Linear Scan Complexity: O(n) time, O(1) space.
     * Modified Binary Search Complexity: O(log n) time, O(1) space.
     * Handling duplicates at band edges:
     * A standard binary search stops at an arbitrary duplicate. Instead, lowerBound finds the
     * first index with score >= low, and upperBound finds the first index with score > high.
     * Their difference (upperBound - lowerBound) counts all occurrences in [low, high] inclusively.
     */
    private static int firstAtLeast(int[] scores, int low) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= low) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int firstGreaterThan(int[] scores, int high) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > high) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
