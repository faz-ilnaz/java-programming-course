package repository;

import model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    Employee getEmployeeByLogin(String login);
}
