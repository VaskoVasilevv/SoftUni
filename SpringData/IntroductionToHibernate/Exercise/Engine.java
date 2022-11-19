package IntroductionToHibernate.Exercise;

import IntroductionToHibernate.Exercise.entities.Address;
import IntroductionToHibernate.Exercise.entities.Employee;
import IntroductionToHibernate.Exercise.entities.Project;
import IntroductionToHibernate.Exercise.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        System.out.println("Select exercise number from 2 to 13.");
        try {
            int exNum = Integer.parseInt(bufferedReader.readLine());

            switch (exNum) {
                case 2:
                    exTow();
                    break;
                case 3:
                    exThree();
                    break;
                case 4:
                    exFour();
                    break;
                case 5:
                    exFive();
                    break;
                case 6:
                    exSix();
                    break;
                case 7:
                    exSeven();
                    break;
                case 8:
                    exEight();
                    break;
                case 9:
                    exNine();
                    break;
                case 10:
                    exTen();
                    break;
                case 11:
                    exEleven();
                    break;
                case 12:
                    exTwelve();
                    break;
                case 13:
                    exThirteen();
                    break;
                default:
                    System.out.println("Invalid input try from 2 to 13");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exThirteen() throws IOException {

        System.out.println("Enter Town name to remove");
        System.out.println("For example you can chose Sofia or Seattle");

        String townName = bufferedReader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :t_name",Town.class)
                .setParameter("t_name",townName)
                .getSingleResult();

        int affected = removeAddressesByTownId(town.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted%n",affected,townName);


    }

    private int removeAddressesByTownId(Integer id) {


         List<Address> addresses = entityManager.createQuery("SELECT a from Address a " +
                 "WHERE a.town.id = :p_id",Address.class)
                 .setParameter("p_id",id)
                 .getResultList();

         entityManager.getTransaction().begin();
         addresses.forEach(entityManager::remove);
         entityManager.getTransaction().commit();
         return addresses.size();
    }

    @SuppressWarnings("unchecked")
    private void exTwelve() {

        final BigDecimal lowerLimit = BigDecimal.valueOf(30000);
        final BigDecimal upperLimit = BigDecimal.valueOf(70000);

        this.entityManager.getTransaction().begin();

        var filterDepartments = this.entityManager
                .createQuery("SELECT department.name, MAX(salary) " +
                                "FROM Employee " +
                                "GROUP BY department.name\n" +
                                "HAVING MAX(salary) NOT BETWEEN :low AND :up",
                        Object[].class)
                .setParameter("low", lowerLimit)
                .setParameter("up", upperLimit)
                .getResultList();

        filterDepartments.forEach(empl -> System.out.println(empl[0] + " - " + empl[1]));

        this.entityManager.getTransaction().commit();

    }

    private void exEleven() throws IOException {
        System.out.println(("Enter First 2 Letters from Empoyee's First Name: "));
        System.out.println(("For example you can chose --> SA"));
        String firstName2Letters = bufferedReader.readLine();

        this.entityManager.getTransaction().begin();
        List<Employee> employees = this.entityManager
                .createQuery("FROM Employee "
                        + "WHERE firstName LIKE CONCAT(:letters, '%')", Employee.class)
                .setParameter("letters", firstName2Letters)
                .getResultList();

        employees.forEach(empl -> System.out.printf("%s %s - %s - ($%s)%n",
                empl.getFirstName(),
                empl.getLastName(),
                empl.getJobTitle(),
                empl.getSalary()));

        this.entityManager.getTransaction().commit();

        
    }

    private void exTen() {


        entityManager.getTransaction().begin();

        int affectedRows = entityManager.createQuery("UPDATE Employee e " +
                "set e.salary = e.salary * 1.2 " +
                "where e.department.id IN :ids")
                .setParameter("ids",Set.of(1,2,4,11))
                .executeUpdate();



        entityManager.getTransaction().commit();
    }

    private void exNine() throws IOException {


        List<Project> projects = this.entityManager
                .createQuery("FROM Project ORDER BY startDate Desc,name", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project ->
                        System.out.printf("Project Name: %s%n\tProject Description: %s%n\tProject Start Date: %s%n\tProject End Date: %s%n",
                                project.getName(),
                                project.getDescription(),
                                project.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd H:m")),
                                project.getEndDate()));

    }

    private void exEight() throws IOException {

        System.out.println("Enter employee id");
        System.out.println("For example you can chose 147 or 83");


        int employeeId = Integer.parseInt(bufferedReader.readLine());

        Employee employee = entityManager.find(Employee.class, employeeId);

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        Set<Project> projects = employee.getProjects();
        for (Project project : projects) {
            System.out.println("      " + project.getName());
        }
    }

    private void exSeven() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a from Address a " +
                        "ORDER BY a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(a -> System.out.printf("%s, %s - %d employees%n",
                a.getText(),
                a.getTown() == null ? "Unknown" : a.getTown().getName(),
                a.getEmployees().size()));


    }

    private void exSix() throws IOException {

        System.out.println("Enter employee last name:");
        System.out.println("You can chose --> Zwilling for input");

        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName =:l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {

        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;

    }

    private void exFive() {

        entityManager
                .createQuery("SELECT e from Employee e " +
                        "where  e.department.name = :d_name " +
                        "ORDER BY e.salary,e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n"
                        , e.getFirstName()
                        , e.getLastName()
                        , e.getDepartment().getName()
                        , e.getSalary()));

    }

    private void exFour() {
        entityManager.createQuery("select e from Employee e " +
                " where e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", new BigDecimal(50000))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);


    }

    private void exThree() {
        System.out.println("Enter employee full name:");
        try {
            String[] fullName = bufferedReader.readLine().split("\\s+");

            String firstName = fullName[0];
            String lastName = fullName[1];


            Long singleResult = entityManager.createQuery("SELECT count(e) from Employee e " +
                    "WHERE e.firstName = :f_name and e.lastName = :l_name", Long.class)
                    .setParameter("f_name", firstName)
                    .setParameter("l_name", lastName)
                    .getSingleResult();
            System.out.println(singleResult == 0 ? "No" : "Yes");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    private void exTow() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t SET t.name  = UPPER(t.name) " +
                "WHERE length(t.name) <= 5 ");

        int affectedRows = query.executeUpdate();
        System.out.println(affectedRows);

        entityManager.getTransaction().commit();
    }
}
