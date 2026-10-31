package data_structures.assigment_problems;

public class BusiestBusRow {

    /**
     * Problem 10: Busiest Bus Row
     * Time Complexity: O(r * c), where r is the number of rows and c is the number of columns.
     * Additional Space Complexity: O(1).
     */
    public static String busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowSum += grid[r][c];
            }
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRow = r;
            }
        }
        return "Row " + bestRow + ", Total " + maxTotal;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        System.out.println(busiestRow(grid));
    }
}
