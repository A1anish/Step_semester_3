package string.assigment_problems;

public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundAny = false;
        StringBuilder duplicates = new StringBuilder();

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    if (foundAny) {
                        duplicates.append(", ");
                    }
                    duplicates.append(seatNumbers[i]);
                    foundAny = true;
                    break;
                }
            }
        }

        if (foundAny) {
            System.out.println("Duplicate Seat Number Found: " + duplicates);
        } else {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
