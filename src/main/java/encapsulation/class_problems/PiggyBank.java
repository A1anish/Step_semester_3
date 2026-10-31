package encapsulation.class_problems;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > this.savings) {
            return false;
        }
        this.savings -= amount;
        return true;
    }

    public int getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit(100) -> savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdraw(30) -> savings = " + pb.getSavings());
        boolean ok = pb.withdraw(500);
        System.out.println("After withdraw(500) -> " + (ok ? "applied" : "rejected") + ", savings stays " + pb.getSavings());
    }
}
