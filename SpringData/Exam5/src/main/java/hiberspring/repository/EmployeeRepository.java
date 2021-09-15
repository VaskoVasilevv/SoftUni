package hiberspring.repository;

import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee existsByBranch_Name(Branch name);


    @Query("SELECT e from Employee e " +
            "join Branch b on e.branch.id = b.id " +
            "where size(b.products) > 0 " +
            "GROUP BY e.id, b.id " +
            "order by e.firstName, e.lastName, LENGTH(e.position)DESC ")
    List<Employee> getEmployeeWorkingInABranchAtLeastOneProduct();

}
