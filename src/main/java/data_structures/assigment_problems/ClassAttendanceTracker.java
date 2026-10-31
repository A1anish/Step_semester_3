package data_structures.assigment_problems;

public class ClassAttendanceTracker {

    /**
     * Problem 6: Class Attendance Tracker
     * Time Complexity: O(n) — both present count and longest streak are found in a single pass.
     * Space Complexity: O(1) auxiliary space.
     */
    public static String attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return "Present: " + presentCount + ", Longest streak: " + longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(attendanceSummary(new int[]{0, 0, 0}));
    }
}
