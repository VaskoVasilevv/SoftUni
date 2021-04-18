package JavaOOP.Encapsulation.Lab.salaryIncrease_02;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age,double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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


    public void increaseSalary(double bonus) {
        if (this.getAge() < 30){
            this.salary = this.salary * (1.00 + bonus/200);
        }else {
            this.salary = this.salary * (1.00 + bonus/100);
        }
    }
    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",this.firstName,this.lastName,this.getSalary());
    }
}
