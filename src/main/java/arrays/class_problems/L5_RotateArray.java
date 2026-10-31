package arrays.class_problems;

import java.util.Arrays;

public class L5_RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        k = k % n;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));
    }
}
