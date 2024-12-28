import models.School;
import models.Student;
import models.Teacher;
import models.Person;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        File studentFile = new File("src/models/Students.txt");
        Scanner studentScanner = new Scanner(studentFile);
        while (studentScanner.hasNextLine()) {
            String[] data = studentScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("male");

            Student student = new Student(name, surname, age, gender);
            for (int i = 4; i < data.length; i++) {
                student.addGrade(Integer.parseInt(data[i]));
            }
            school.addMember(student);
        }
        studentScanner.close();

        File teachersFile = new File("src/models/Teachers.txt");
        Scanner teacherScanner = new Scanner(teachersFile);
        while (teacherScanner.hasNextLine()) {
            String[] data = teacherScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("male");
            String subject = data[4];
            int experience = Integer.parseInt(data[5]);
            int salary = Integer.parseInt(data[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, subject, experience, salary);
            if (experience > 10) {
                teacher.giveRaise(10);
            }
            school.addMember(teacher);
        }
        teacherScanner.close();

        System.out.println(school);

        System.out.println();

        for (Person member : school.getMembers()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.getName() + " GPA: " + student.calculateGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                System.out.println(teacher.getName() + " Salary after raise: " + teacher.getSalary());
            }
        }
    }
}