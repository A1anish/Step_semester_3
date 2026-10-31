package data_structures.class_problems;

import java.util.Arrays;

public class DataStructurePracticeSolutions {

    // Problem 1: Vowel and Consonant Counter
    public static void countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    // Problem 2: Word Reverser and Palindrome Checker
    public static void checkPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        boolean isPalindrome = word.equals(reversed);
        System.out.println(reversed + " - " + (isPalindrome ? "palindrome" : "not a palindrome"));
    }

    // Problem 3: Even and Odd Numbers in a List
    public static void countEvenOdd(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    // Problem 4: In-Place Array Reversal
    public static void reverseArrayInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Problem 5: Digit Sum and Number Reversal
    public static void digitSumAndReverse(int num) {
        int sum = 0;
        int reversed = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    // Problem 6: Prime Number Checker
    public static void checkPrime(int n) {
        boolean isPrime = n > 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(n + (isPrime ? " is prime" : " is not prime"));
    }

    // Problem 7: Factorial Calculation
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Problem 8: Student Grade Assignment
    public static String assignGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 60) {
            return "Grade C";
        } else if (marks >= 40) {
            return "Grade D";
        } else {
            return "Grade F";
        }
    }

    // Problem 9: Leap Year Detector
    public static String checkLeapYear(int year) {
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return isLeap ? "Leap year" : "Not a leap year";
    }

    // Problem 10: Student Result Card Generator
    public static class StudentResultCard {
        private final String name;
        private final int[] marks;

        public StudentResultCard(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public double calculateAverage() {
            double sum = 0;
            for (int m : marks) {
                sum += m;
            }
            return sum / marks.length;
        }

        public char assignGrade() {
            double avg = calculateAverage();
            if (avg >= 90) {
                return 'A';
            } else if (avg >= 75) {
                return 'B';
            } else if (avg >= 60) {
                return 'C';
            } else if (avg >= 40) {
                return 'D';
            } else {
                return 'F';
            }
        }

        public void printResultCard() {
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), calculateAverage(), assignGrade());
        }
    }

    public static void printQuizAndConceptAnswers() {
        System.out.println("\n=== Data Structures Practice Problems Quiz Answers (Q1-Q10) ===");
        System.out.println("Q1: B | Q2: D | Q3: C (O(1)) | Q4: C (O(n^2)) | Q5: B (O(m + n))");
        System.out.println("Q6: A, C, D (Deletion, Traversal, Updating) | Q7: C | Q8: D (Sorted Array) | Q9: C | Q10: C");

        System.out.println("\n=== Java & Data Structures Revision Quiz Answers (Q1-Q20) ===");
        System.out.println("Q1: D | Q2: B | Q3: B | Q4: D | Q5: C | Q6: A | Q7: B | Q8: A | Q9: C | Q10: B");
        System.out.println("Q11: B | Q12: B | Q13: A | Q14: A | Q15: B | Q16: A | Q17: B | Q18: C | Q19: C | Q20: C");
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Programming");
        checkPalindrome("level");
        checkPalindrome("java");
        countEvenOdd(new int[]{3, 8, 12, 5, 7, 10});

        int[] rev = {11, 22, 33, 44};
        reverseArrayInPlace(rev);
        System.out.println(Arrays.toString(rev));

        digitSumAndReverse(4721);
        checkPrime(29);
        checkPrime(21);
        System.out.println(factorial(5));
        System.out.println(factorial(0));
        System.out.println(assignGrade(72));
        System.out.println(assignGrade(95));
        System.out.println(assignGrade(35));
        System.out.println(checkLeapYear(2024));
        System.out.println(checkLeapYear(1900));
        System.out.println(checkLeapYear(2000));

        new StudentResultCard("Asha", new int[]{80, 90, 70}).printResultCard();
        new StudentResultCard("Ravi", new int[]{60, 55, 50}).printResultCard();

        printQuizAndConceptAnswers();
    }
}
