package repository.fixture;

import model.Attendance;
import model.Employee;

import java.util.Calendar;

import static repository.fixture.TestConstants.EmployeeConstants.*;

public class TestData {
    public static Employee generalEmployee() {
        Employee employee = new Employee();
        employee.setFirstname(EMPLOYEE_FIRSTNAME);
        employee.setLastname(EMPLOYEE_LASTNAME);
        employee.setJob(EMPLOYEE_JOB);
        employee.setLogin(EMPLOYEE_LOGIN);
        return employee;
    }

    public static Attendance commonAttendance() {
        Attendance attendance = new Attendance();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(2014, 04, 20);
        attendance.setActualDate(calendar.getTime());
        attendance.setStart(calendar.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        attendance.setEnd(calendar.getTime());
        attendance.setEmployee(generalEmployee());
        return attendance;
    }
}
