package abstraction_and_interfaces.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeeklyStaffPay {

    abstract static class StaffMember {
        protected final String name;

        public StaffMember(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double calculatePay();
    }

    static class FullTimeStaff extends StaffMember {
        private final double weeklySalary;

        public FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double calculatePay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends StaffMember {
        private final double hours;
        private final double rate;

        public HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }

    static class InternStaff extends StaffMember {
        private final double stipend;

        public InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nFULLTIME Asha 12000\nHOURLY Ravi 45 200\nINTERN Neha 5000\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if ("FULLTIME".equals(type)) {
                staff.add(new FullTimeStaff(name, sc.nextDouble()));
            } else if ("HOURLY".equals(type)) {
                staff.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()));
            } else if ("INTERN".equals(type)) {
                staff.add(new InternStaff(name, sc.nextDouble()));
            }
        }

        double totalPayroll = 0.0;
        for (StaffMember member : staff) {
            double pay = member.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", member.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
    }
}
