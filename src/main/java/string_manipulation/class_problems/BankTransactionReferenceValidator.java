package string_manipulation.class_problems;

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be 14 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence body must be 11 digits";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(reference.substring(0, 3)).append("] ")
          .append("DATE: ").append(reference.substring(3, 5)).append("/")
          .append(reference.substring(5, 7)).append("/").append(reference.substring(7, 9))
          .append(" | SEQ: ").append(reference.substring(9, 14));
        return sb.toString();
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref1));

        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));
    }
}
