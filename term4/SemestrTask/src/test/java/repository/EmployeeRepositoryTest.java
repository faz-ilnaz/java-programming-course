package repository;

import config.DataSourceConfig;
import config.PersistenceConfig;
import model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static repository.fixture.TestData.generalEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, PersistenceConfig.class})
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void testFindAll() {
        employeeRepository.save(generalEmployee());
        Iterable<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);
        assertTrue(employees.iterator().hasNext());
        for(Employee e : employees) {
            assertNotNull(e);
            assertNotNull(e.getId());
        }
        //delete
        employeeRepository.delete(employees);
    }
}
