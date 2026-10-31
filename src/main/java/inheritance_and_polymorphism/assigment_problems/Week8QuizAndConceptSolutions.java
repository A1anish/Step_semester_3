package inheritance_and_polymorphism.assigment_problems;

public class Week8QuizAndConceptSolutions {

    public static void printQuizAnswers() {
        System.out.println("=== Week 8 Quiz Answers (Inheritance & Polymorphism) ===");
        System.out.println("Q1: C (Polymorphism)");
        System.out.println("Q2: A, B, C (Car is-a Vehicle, Rectangle is-a Shape, DatabaseConnection is-a NetworkResource)");
        System.out.println("Q3: C (Runtime method dispatch)");
        System.out.println("Q4: C (Inheritance-based polymorphism)");
        System.out.println("Q5: A, C, D");
        System.out.println("Q6: A, C");
        System.out.println("Q7: C (It allows adding WalletPayment without modifying existing PaymentProcessor iteration logic)");
        System.out.println("Q8: A (It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid)");
        System.out.println("Q9: A, C");
        System.out.println("Q10: A, B, C");
    }

    public static void printConceptAnswers() {
        System.out.println("\n=== Week 8 Concept Question Answers ===");
        System.out.println("1. Inheritance Reuse & Extension: Subclasses inherit common attributes/methods from a base class (e.g., BankAccount with deposit/getBalance) and override or add specialized logic (e.g., SavingsAccount adding interest calculation, CurrentAccount adding overdraft rules).");
        System.out.println("2. 'Is-A' Relationship: Defines a subtype relationship where a subclass is a specialized version of a superclass (Liskov Substitution Principle). Without a true 'is-a' relationship, subclasses inherit irrelevant operations and break polymorphic substitutability.");
        System.out.println("3. Method Overriding: Redefining a base class method in a derived class with the exact same signature. Example: Employee.calculateSalary() overridden by FullTimeEmployee (base + bonus) and ContractEmployee (hours * hourlyRate).");
        System.out.println("4. Runtime Polymorphism (Dynamic Dispatch): The JVM inspects the actual runtime object type (via its vtable), not the reference variable's declared type, to invoke the appropriate overridden method at runtime.");
        System.out.println("5. Polymorphic Collections: A List<Shape> or Payment[] array stores references to diverse subclasses (Circle, Rectangle). Loops process all elements uniformly without knowing concrete types.");
        System.out.println("6. Polymorphism vs Type-Based Conditionals: Replacing if-else/instanceof chains with polymorphic method calls adheres to the Open/Closed Principle, keeping logic localized in each subclass and avoiding fragile central switch blocks.");
        System.out.println("7. Extensibility (Open/Closed Principle): Introducing UpiPayment extends Payment and implements process(); PaymentProcessor iterating over List<Payment> works automatically with zero changes.");
        System.out.println("8. Inherited vs Overridden Behavior: Inherited methods (e.g., LibraryItem.getTitle()) are used unchanged when behavior is identical across subclasses; overridden methods (e.g., LibraryItem.getLoanPeriod()) replace base logic when rules differ per subtype.");
        System.out.println("9. Pitfalls of Inheritance for Code Reuse Only: Violating 'is-a' (e.g., Stack extending Vector) exposes inappropriate superclass methods, tightly couples subclasses to base implementation details, and breaks encapsulation (favor composition over inheritance).");
        System.out.println("10. VehicleRental Scenario: Base class VehicleRental holds rentalId, customerName, daysRented, and base rate calculation; CarRental adds luxury/insurance options and TruckRental adds payload/mileage surcharges by overriding calculateRentalCost().");
    }

    public static void main(String[] args) {
        printQuizAnswers();
        printConceptAnswers();
    }
}
