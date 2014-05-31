package repository;

import config.DataSourceConfig;
import config.PersistenceConfig;
import model.Attendance;
import model.Employee;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static repository.fixture.TestData.generalEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, PersistenceConfig.class})
public class EmployeeRepositoryTest {

    @Autowired
    private AttendanceRepository attendanceRepository;

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

    @Test
    @Ignore
    public void testCreateData() {
        int n = 4;
        String[] firstnames = {"Jeff", "Ford", "Henry", "Charley"};
        String[] lastnames = {"Gibbs", "Walker", "Forrest", "Fisher"};
        String[] jobs = {"manager", "programmer", "tester", "designer"};
        String[] logins = {"jeff", "ford", "henry", "charley"};
        String[] passwords = {"123", "12345", "password", "qwerty"};

        Calendar calendar = Calendar.getInstance();
        Random r = new Random();
        for( int i = 0; i < n; i++ ) {
            Employee e = new Employee();
            e.setFirstname(firstnames[i]);
            e.setLastname(lastnames[i]);
            e.setJob(jobs[i]);
            e.setLogin(logins[i]);
            e.setPass(passwords[i]);
            employeeRepository.save(e);
            for(int j = 0; j < 30; j++ ) {
                calendar.set(2014, 4, j + 1);
                calendar.set(Calendar.SECOND, 0);
                Attendance a = new Attendance();
                a.setActualDate(calendar.getTime());
                calendar.set(Calendar.HOUR_OF_DAY, 8 + r.nextInt(2) - 1);
                calendar.set(Calendar.MINUTE, r.nextInt(60));
                a.setStart(calendar.getTime());
                calendar.set(Calendar.HOUR_OF_DAY, 17 + r.nextInt(2) - 1);
                calendar.set(Calendar.MINUTE, r.nextInt(60));
                a.setEnd(calendar.getTime());
                a.setEmployee(e);
                attendanceRepository.save(a);
            }

        }
    }
}
