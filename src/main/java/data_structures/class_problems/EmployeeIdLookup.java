package data_structures.class_problems;

import java.util.HashMap;
import java.util.Map;

public class EmployeeIdLookup {

    /**
     * Builds a HashMap from unsorted (employeeId, department) records.
     * Build Time Complexity: O(n)
     * Query Time Complexity (getDepartment): O(1) average time
     * Space Complexity: O(n) to store the HashMap of n employee records.
     * Justification: Because queries happen dozens of times per day while updates happen only a few
     * times per month, paying a one-time O(n) build cost and O(n) memory yields instant O(1) lookups.
     */
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };
        Map<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
