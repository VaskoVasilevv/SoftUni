package bg.softuni.fundamentals.Objects;

import bg.softuni.fundamentals.Lists.LIstOfProductsLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05StudentsEX {
    static class Student {

        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        public String studentInfo() {
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> allStudents = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split("\\s+");

            Student student = new Student(data[0], data[1], Double.parseDouble(data[2]));

            allStudents.add(student);

        }
        allStudents.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
                .forEach(student -> System.out.println(student.studentInfo()));

    }
}
