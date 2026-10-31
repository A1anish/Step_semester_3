package string.class_problems;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person   | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-2d| %-10.2f | %-11.2f | %-5.2f | %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.72, 1.68, 1.62};
        double[] weights = {70.0, 90.0, 55.0, 68.0, 82.0, 48.0, 95.0, 74.0, 62.0, 85.0};
        printWellnessReport(heights, weights);
    }
}
