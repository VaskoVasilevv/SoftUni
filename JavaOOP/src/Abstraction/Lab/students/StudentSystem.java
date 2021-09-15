package Abstraction.Lab.students;


import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {

        return this.studentsByName;
    }

    public String parseCommand(String[] args) {

        String name = args[1];
        if (args[0].equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!studentsByName.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentsByName.put(name, student);
            }
        } else if (args[0].equals("Show")) {

            if (studentsByName.containsKey(name)) {
                Student student = studentsByName.get(name);

                return getString(student);
            }
        }
            return null;
    }

    private String getString(Student student) {
        String out;

        if (student.getGrade() >= 5.00) {
            out = "Excellent student.";
        } else if (student.getGrade() >= 3.50) {
            out = "Average student.";
        } else {
            out = "Very nice person.";
        }
        return String.format("%s is %s years old. %s", student.getName(), student.getAge(), out);
    }
}
