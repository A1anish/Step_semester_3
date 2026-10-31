package abstraction_and_interfaces.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000.0;

        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    abstract static class Student {
        protected final String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateBaseFee();
    }

    static class DayScholar extends Student implements BusUser {
        public DayScholar(String name) {
            super(name);
        }

        @Override
        public double calculateBaseFee() {
            return 40000.0;
        }
    }

    static class Hosteller extends Student {
        public Hosteller(String name) {
            super(name);
        }

        @Override
        public double calculateBaseFee() {
            return 40000.0 + 60000.0;
        }
    }

    static class ScholarStudent extends Student implements BusUser {
        public ScholarStudent(String name) {
            super(name);
        }

        @Override
        public double calculateBaseFee() {
            return 20000.0;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nDAY_SCHOLAR Asha\nHOSTELLER Ravi\nSCHOLAR Neha\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if ("DAY_SCHOLAR".equals(type)) {
                students.add(new DayScholar(name));
            } else if ("HOSTELLER".equals(type)) {
                students.add(new Hosteller(name));
            } else if ("SCHOLAR".equals(type)) {
                students.add(new ScholarStudent(name));
            }
        }

        double totalCollected = 0.0;
        for (Student s : students) {
            double fee = s.calculateBaseFee();
            if (s instanceof BusUser) {
                fee += ((BusUser) s).getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}
