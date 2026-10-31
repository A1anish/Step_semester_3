package abstraction_and_interfaces.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double calculateInsurance();
    }

    abstract static class Parcel {
        protected final String type;
        protected final double weightKg;
        protected final double declaredValue;

        public Parcel(String type, double weightKg, double declaredValue) {
            this.type = type;
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateShippingCharge();
    }

    static class StandardParcel extends Parcel {
        public StandardParcel(double weightKg, double declaredValue) {
            super("STANDARD", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 40.0 + (10.0 * weightKg);
        }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weightKg, double declaredValue) {
            super("EXPRESS", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 80.0 + (15.0 * weightKg);
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weightKg, double declaredValue) {
            super("FRAGILE", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return (40.0 + (10.0 * weightKg)) + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSTANDARD 3 500\nEXPRESS 2 1000\nFRAGILE 4 2000\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            if ("STANDARD".equals(type)) {
                parcels.add(new StandardParcel(weight, value));
            } else if ("EXPRESS".equals(type)) {
                parcels.add(new ExpressParcel(weight, value));
            } else if ("FRAGILE".equals(type)) {
                parcels.add(new FragileParcel(weight, value));
            }
        }

        double grandTotal = 0.0;
        for (Parcel p : parcels) {
            double charge = p.calculateShippingCharge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance() : 0.0;
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
