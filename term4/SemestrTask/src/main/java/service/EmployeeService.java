package service;

import model.Attendance;
import model.Employee;

import java.util.Date;

public interface EmployeeService {

    Employee getEmployeeById(Long id);

    Employee getEmployeeByLogin(String login);

    Iterable<Employee> getAllEmployees();

    void save(Employee employee);

    void delete(Long id);

    void saveAttendance(Attendance attendance);

    Attendance getAttendanceByDateAndEmployee(Date d1, Long empl_id);

    Iterable<Attendance> getAttendancesByDateBetween(Date d1, Date d2);

    Iterable<Attendance> getAttendanceByEmployeeAndDateBetween(Employee e, Date d1, Date d2);



}
