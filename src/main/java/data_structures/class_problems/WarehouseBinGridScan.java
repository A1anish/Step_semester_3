package data_structures.class_problems;

public class WarehouseBinGridScan {

    /**
     * Scans an m x n grid of bin counts to compute total items and coordinates of the maximum bin.
     * Time Complexity: O(m * n), as every cell in the m x n grid is visited once.
     * Additional Space Complexity: O(1) beyond the input grid.
     */
    public static String warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return "total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        System.out.println(warehouseSummary(grid));
    }
}
