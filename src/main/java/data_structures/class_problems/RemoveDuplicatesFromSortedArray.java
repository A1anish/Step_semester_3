package data_structures.class_problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    /**
     * Removes consecutive duplicates in-place from a sorted array using two pointers.
     * Time Complexity: O(n)
     * Additional Space Complexity: O(1), qualifying as in-place because elements are overwritten
     * directly in the input array without allocating a second array.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int writeIdx = 1;
        for (int readIdx = 1; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != nums[writeIdx - 1]) {
                nums[writeIdx++] = nums[readIdx];
            }
        }
        return writeIdx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
