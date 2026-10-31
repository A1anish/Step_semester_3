package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

public class HomeApplianceEnergyReport {

    interface SaverMode {
        default double applySaverReduction(double units) {
            return units * 0.75;
        }
    }

    abstract static class Appliance {
        protected final String name;
        protected final double hours;

        public Appliance(String name, double hours) {
            this.name = name;
            this.hours = hours;
        }

        public String getName() {
            return name;
        }

        protected abstract double powerRatingWatts();

        public final double baseUnitsKwh() {
            return (powerRatingWatts() * hours) / 1000.0;
        }
    }

    static class Fridge extends Appliance {
        public Fridge(double hours) {
            super("FRIDGE", hours);
        }

        @Override
        protected double powerRatingWatts() {
            return 150.0;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        public AirConditioner(double hours) {
            super("AC", hours);
        }

        @Override
        protected double powerRatingWatts() {
            return 1500.0;
        }
    }

    static class Television extends Appliance {
        public Television(double hours) {
            super("TV", hours);
        }

        @Override
        protected double powerRatingWatts() {
            return 100.0;
        }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        public WashingMachine(double hours) {
            super("WASHER", hours);
        }

        @Override
        protected double powerRatingWatts() {
            return 500.0;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "4\nFRIDGE 24\nAC 8 SAVER\nTV 5\nWASHER 2 SAVER\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = (parts.length > 2 && "SAVER".equals(parts[2]));

            Appliance app;
            switch (type) {
                case "FRIDGE":
                    app = new Fridge(hours);
                    break;
                case "AC":
                    app = new AirConditioner(hours);
                    break;
                case "TV":
                    app = new Television(hours);
                    break;
                default:
                    app = new WashingMachine(hours);
                    break;
            }

            if (saverRequested && !(app instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported%n", app.getName());
            } else {
                double units = app.baseUnitsKwh();
                if (saverRequested) {
                    units = ((SaverMode) app).applySaverReduction(units);
                }
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
