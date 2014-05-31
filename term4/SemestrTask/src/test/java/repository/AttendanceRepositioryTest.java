package repository;

import config.DataSourceConfig;
import config.PersistenceConfig;
import model.Attendance;
import model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static repository.fixture.TestData.commonAttendance;
import static repository.fixture.TestData.generalEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class AttendanceRepositioryTest {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void testFindAll() {
        //create
        Attendance attendance = commonAttendance();
        Employee employee = generalEmployee();
        attendance.setEmployee(employee);
        employeeRepository.save(employee);
        attendanceRepository.save(attendance);
        Iterable<Attendance> attendances = attendanceRepository.findAll();
        assertNotNull(attendances);
        assertTrue(attendances.iterator().hasNext());
        for(Attendance a : attendances) {
            assertNotNull(a);
        }

        //delete
        attendanceRepository.delete(attendances);
        employeeRepository.delete(employee);

    }

    @Test
    public void testGetAttendancesByDateBetween() {
        Attendance attendance = commonAttendance();
        Employee employee = generalEmployee();
        attendance.setEmployee(employee);
        employeeRepository.save(employee);
        attendanceRepository.save(attendance);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(2014, 4, 15);
        Iterable<Attendance> attendances = attendanceRepository.getAttendanceByActualDateBetween(calendar.getTime(), new Date());
        assertNotNull(attendances);
        assertTrue(attendances.iterator().hasNext());
        for(Attendance a : attendances) {
            assertNotNull(a);
            assertNotNull(a.getEmployee());
            assertNotNull(a.getEmployee().getId());
        }
        //delete
        attendanceRepository.delete(attendances);
        employeeRepository.delete(employee);
    }

    @Test
    public void testGetAttendancesByEmployeeAndDateBetween() {
        Attendance attendance = commonAttendance();
        Employee employee = generalEmployee();
        attendance.setEmployee(employee);
        employeeRepository.save(employee);
        attendanceRepository.save(attendance);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 4, 13);
        Iterable<Attendance> attendances = attendanceRepository.getAttendanceByEmployeeIdAndActualDateBetween(employee.getId(), calendar.getTime(), new Date());
        assertNotNull(attendances);
        assertTrue(attendances.iterator().hasNext());
        for(Attendance a : attendances) {
            assertNotNull(a);
            assertNotNull(a.getEmployee());
            assertNotNull(a.getEmployee().getId());
        }
        //delete
        attendanceRepository.delete(attendances);
        employeeRepository.delete(employee);
    }

//    @Test
//    @Ignore
//    public void testFindAttendacesByEmployeeIdAndSpecifiedDateBetween() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2014, 4, 20);
//        Iterable<Attendance> attendances = attendanceRepository.findAttendancesByEmployeeAndBetweenDates(1L, calendar.getTime(), new Date());
//        assertNotNull(attendances);
//        assertTrue(attendances.iterator().hasNext());
//        for(Attendance a : attendances) {
//            assertNotNull(a);
//            assertNotNull(a.getEmployee());
//            assertNotNull(a.getEmployee().getId());
//            System.out.println(a);
//        }
//    }



}
