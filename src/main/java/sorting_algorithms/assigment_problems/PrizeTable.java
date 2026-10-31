package sorting_algorithms.assigment_problems;

public class PrizeTable {

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

    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }
        System.out.println(formatArray(marks) + " swaps = " + swaps);
        return swaps;
    }

    public static void main(String[] args) {
        prizeTable(new int[]{45, 90, 60, 75});
        prizeTable(new int[]{80, 70, 60});
        prizeTable(new int[]{55, 88, 95, 72, 64});
    }
}
