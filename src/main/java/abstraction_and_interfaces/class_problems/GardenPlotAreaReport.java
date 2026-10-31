package abstraction_and_interfaces.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GardenPlotAreaReport {

    abstract static class Plot {
        protected final String owner;
        protected final String shape;

        public Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }

        public String getOwner() {
            return owner;
        }

        public String getShape() {
            return shape;
        }

        public abstract double calculateArea();
    }

    static class CirclePlot extends Plot {
        private final double radius;

        public CirclePlot(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    static class RectanglePlot extends Plot {
        private final double length;
        private final double width;

        public RectanglePlot(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    static class TrianglePlot extends Plot {
        private final double base;
        private final double height;

        public TrianglePlot(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        String sampleInput = "3\nCIRCLE Asha 5\nRECTANGLE Ravi 4 6\nTRIANGLE Neha 10 3\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if ("CIRCLE".equals(shape)) {
                plots.add(new CirclePlot(owner, sc.nextDouble()));
            } else if ("RECTANGLE".equals(shape)) {
                plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            } else if ("TRIANGLE".equals(shape)) {
                plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            }
        }

        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
