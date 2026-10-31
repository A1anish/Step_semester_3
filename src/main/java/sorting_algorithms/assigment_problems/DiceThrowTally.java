package sorting_algorithms.assigment_problems;

public class DiceThrowTally {

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

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        StringBuilder countsLine = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            countsLine.append("  ").append(v).append(":").append(count[v]);
        }
        System.out.println(countsLine.toString().replaceFirst("  ", " "));

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }
        System.out.println("Sorted: " + formatArray(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
        System.out.println();
        diceSort(new int[]{6, 5, 3, 2, 6, 1, 3, 5});
    }
}
