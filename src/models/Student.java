package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        ArrayList<Double> gradesGpa = new ArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            gradesGpa.add((grades.get(i) >= 60) ? Math.max(0, Math.min(4.0, 4.0 - 3.0 * (100 - grades.get(i)) / 40.0)) : 0.0);
        }

        if (gradesGpa.isEmpty()) return 0.0;
        int total = 0;
        for (double grade : gradesGpa) {
            total += grade;
        }
        return total / (double) grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}
