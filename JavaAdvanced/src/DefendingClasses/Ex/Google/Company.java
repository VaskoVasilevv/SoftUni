package DefendingClasses.Ex.Google;

public class Company {
    private String name;
    private String companyName;
    private String department;
    private double salary;

    public Company(String name, String companyName, String department, double salary) {
        this.name = name;
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", companyName, department, salary);
    }
}
