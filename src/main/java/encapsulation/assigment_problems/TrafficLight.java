package encapsulation.assigment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        if ("RED".equals(this.color)) {
            this.color = "GREEN";
        } else if ("GREEN".equals(this.color)) {
            this.color = "YELLOW";
        } else {
            this.color = "RED";
        }
        return this.color;
    }

    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
