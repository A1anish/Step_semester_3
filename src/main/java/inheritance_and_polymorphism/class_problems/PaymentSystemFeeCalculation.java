package inheritance_and_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    abstract static class Payment {
        protected final String type;
        protected final double amount;

        public Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateAdjustedAmount();
    }

    static class CardPayment extends Payment {
        public CardPayment(double amount) {
            super("CARD", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        public WalletPayment(double amount) {
            super("WALLET", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return amount;
        }
    }

    public static void processTransactions(List<Payment> payments) {
        double grandTotal = 0.0;
        for (Payment p : payments) {
            double adjusted = p.calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nCARD 1000\nWALLET 500\nBANKTRANSFER 2000\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
            }
        }
        processTransactions(payments);
    }
}
