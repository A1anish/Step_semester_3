package oop_basics.class_problems;

class Student {
    String name;
    int marks;
}

public class L1_SimpleStudentRecord {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Divya";
        s.marks = 88;
        System.out.println("Name: " + s.name + " | Marks: " + s.marks);
    }
}
