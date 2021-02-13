package Exam.P16December2020.Opening;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        int indexToRemove = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                indexToRemove = i;
                break;
            }

        }
        if (indexToRemove != -1) {
            employees.remove(indexToRemove);
            return true;
        }
        return false;

        //  return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmploy() {
        Employee employee = null;
        for (Employee e : employees) {
            if (employee == null || employee.getAge() < e.getAge()) {
                employee = e;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder out = new StringBuilder("Employees working at Bakery "+ name);
        out.append(System.lineSeparator());
        for (Employee employee : employees) {
            out.append(employee.toString())
                    .append(System.lineSeparator());

        }
        return out.toString().trim();

    }
}
