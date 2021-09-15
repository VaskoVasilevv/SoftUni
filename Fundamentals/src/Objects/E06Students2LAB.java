package Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06Students2LAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<E05StudentsLAB.Student> students = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("end")) {

            String[] studentsParameters = line.split(" ");
            E05StudentsLAB.Student s = new E05StudentsLAB.Student(studentsParameters[0], studentsParameters[1],
                    Integer.parseInt(studentsParameters[2]), studentsParameters[3]);

            int existIndex = findStudentIndex(students, s.firstName, s.getLastName());
            if (existIndex != -1) {
                students.get(existIndex).setHometown(s.hometown);
                students.get(existIndex).setAge(s.age);
            } else {
                students.add(s);
            }


            line = scanner.nextLine();
        }
        String serchTownName = scanner.nextLine();

        for (E05StudentsLAB.Student student : students) {
            if (student.getHometown().equals(serchTownName)) {
                System.out.print(student);
            }
        }


    }

    static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHometown() {
            return hometown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %d years old%n",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getAge());
        }
    }

    static int findStudentIndex(List<E05StudentsLAB.Student> students, String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName)
                    && students.get(i).getLastName().equals(lastName)) {
                return i;
            }

        }
        return -1;
    }
}
