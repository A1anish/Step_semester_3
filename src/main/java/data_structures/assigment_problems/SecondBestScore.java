package data_structures.assigment_problems;

public class SecondBestScore {

    /**
     * Problem 7: Second-Best Score
     * Time Complexity: O(n) single pass, Space Complexity: O(1).
     * Compared to sorting first (O(n log n) time), tracking highest and second-highest in one pass
     * is faster and does not mutate the input array.
     */
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}
