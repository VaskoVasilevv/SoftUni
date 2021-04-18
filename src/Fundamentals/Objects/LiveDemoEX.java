package Fundamentals.Objects;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiveDemoEX {
    static class Student{
        String firstName;
        String lastName;
        String age;
        String city;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Student(String firstName, String lastName, String age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %s years old",getFirstName(),getLastName(),getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> allStudents = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"end".equals(input)){
            String [] data = input.split(" ");

            Student s = new Student(data[0],data[1],data[2],data[3]);

            int index = findeStudentIndex(allStudents,s.getFirstName(),s.lastName);
            if (index!= -1){
                allStudents.get(index).setCity(s.city);
                allStudents.get(index).setAge(s.age);
            }else {
                allStudents.add(s);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        for (Student allStudent : allStudents) {
            if (allStudent.getCity().equals(input)){
                System.out.println(allStudent.toString());
            }
        }


    }

    private static int findeStudentIndex(List<Student> allStudents, String firstName, String lastName) {
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getFirstName().equals(firstName)&&
            allStudents.get(i).getLastName().equals(lastName)){
                return i;
            }

        }


        return -1;
    }
}


