package classes_and_objects_revision.assigment_problems;

class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_EmployeeAndCompanyInfoManagement {
    public static void main(String[] args) {
        new CompanyEmployee("Asha", 55000);
        new CompanyEmployee("Ravi", 62000);
        new CompanyEmployee("Neha", 70000);
        CompanyEmployee.printCompanyInfo();
    }
}
