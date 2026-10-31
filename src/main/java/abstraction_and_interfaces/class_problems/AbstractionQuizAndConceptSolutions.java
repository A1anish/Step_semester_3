package abstraction_and_interfaces.class_problems;

public class AbstractionQuizAndConceptSolutions {

    public static void printQuizAnswers() {
        System.out.println("=== Part B — Quiz Answers (Abstraction & Interfaces) ===");
        System.out.println("Q1: C (Hiding how an object performs its operations and showing only what it does)");
        System.out.println("Q2: C (It cannot be instantiated directly)");
        System.out.println("Q3: B (The class must be declared abstract, or the code will not compile)");
        System.out.println("Q4: C (private)");
        System.out.println("Q5: C (public, static, and final)");
        System.out.println("Q6: C (Any number of interfaces)");
        System.out.println("Q7: D (public)");
        System.out.println("Q8: C (Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance)");
        System.out.println("Q9: D (A compile-time error occurs until the class overrides the method)");
        System.out.println("Q10: B (Abstract classes can have constructors that run when a subclass object is created)");
    }

    public static void printConceptAnswers() {
        System.out.println("\n=== Part C — Concept Question Answers ===");
        System.out.println("1. Abstraction & Real-Life Example: Abstraction exposes essential operations while hiding complex internal mechanics. Example: A coffee vending machine exposes buttons ('Espresso', 'Cappuccino') to the user while hiding water heating, bean grinding, and pressure control.");
        System.out.println("2. Abstraction vs Encapsulation: Abstraction focuses on *what* an object does (design/interface level), whereas encapsulation focuses on *how* data is bundled and protected using private fields and controlled methods (implementation level). Within a class, public abstract/interface methods define the contract, while private fields guard internal state.");
        System.out.println("3. Constructors in Abstract Classes: An abstract class defines constructors to initialize common fields declared in the abstract base class. It is executed via super(...) whenever a concrete subclass is instantiated.");
        System.out.println("4. Why Abstract Methods Cannot Be private, static, or final: 'private' methods are invisible to subclasses and cannot be overridden; 'static' methods belong to the class rather than an instance and are resolved at compile time; 'final' methods forbid overriding, contradicting 'abstract' which requires overriding.");
        System.out.println("5. The Diamond Problem: Occurs when a class inherits from two superclasses that share a common ancestor with conflicting state/implementations. Java avoids state conflicts by allowing only single class inheritance while permitting multiple interfaces (which hold no mutable instance fields) and requiring explicit disambiguation if two interfaces provide conflicting default methods.");
    }

    public static void main(String[] args) {
        printQuizAnswers();
        printConceptAnswers();
    }
}
