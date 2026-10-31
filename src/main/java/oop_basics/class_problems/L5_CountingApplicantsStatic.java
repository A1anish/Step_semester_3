package oop_basics.class_problems;

class Applicant {
    static int totalApplicants = 0;

    public Applicant() {
        totalApplicants++;
    }
}

public class L5_CountingApplicantsStatic {
    public static void main(String[] args) {
        new Applicant();
        new Applicant();
        new Applicant();
        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}
