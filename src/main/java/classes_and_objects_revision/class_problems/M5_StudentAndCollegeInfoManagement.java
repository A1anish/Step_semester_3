package classes_and_objects_revision.class_problems;

class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class M5_StudentAndCollegeInfoManagement {
    public static void main(String[] args) {
        new Student("Asha", 92);
        new Student("Ravi", 88);
        Student.printCollegeInfo();
    }
}
