package data_structures.class_problems;

public class PairSumInSortedArray {

    /**
     * Two-pointer scan on a sorted array.
     * Time Complexity: O(n), Space Complexity: O(1)
     * Compared to O(n^2) brute-force or O(n) HashSet with O(n) space, two pointers on a sorted array
     * achieves linear time with constant extra space.
     */
    public static String pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return "(" + nums[left] + ", " + nums[right] + ")";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        System.out.println(pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4));
        System.out.println(pairSumSorted(new int[]{1, 2, 3}, 100));
    }
}
