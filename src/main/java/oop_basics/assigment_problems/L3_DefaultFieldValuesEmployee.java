package oop_basics.assigment_problems;

class Employee {
    String empName;
    double salary;
    boolean permanent;
}

public class L3_DefaultFieldValuesEmployee {
    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println("Name: " + emp.empName);
        System.out.println("Salary: " + emp.salary);
        System.out.println("Permanent: " + emp.permanent);
    }
}
