package sorting_algorithms.assigment_problems;

public class HeightLineUp {

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

    public static void lineUp(int[] heights) {
        int pass = 1;
        while (true) {
            boolean swapped = false;
            for (int j = 0; j < heights.length - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + formatArray(heights));
            if (!swapped) {
                break;
            }
            pass++;
        }
    }

    public static void main(String[] args) {
        lineUp(new int[]{4, 2, 5, 1});
        System.out.println();
        lineUp(new int[]{1, 3, 2, 4});
        System.out.println();
        lineUp(new int[]{150, 142, 148, 139});
    }
}
