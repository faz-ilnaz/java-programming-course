package service.impl;

import model.Attendance;
import model.Employee;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AttendanceRepository;
import repository.EmployeeRepository;
import service.EmployeeService;

import java.util.Date;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private AttendanceRepository attendanceRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AttendanceRepository attendanceRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findOne(id);
        if(employee != null) {
            Hibernate.initialize(employee.getAttendances());
        }
        return employee;
    }

    @Override
    @Transactional
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Override
    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    @Transactional
    public void saveAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    @Transactional
    public Attendance getAttendanceByDateAndEmployee(Date d1, Long empl_id) {
        return attendanceRepository.getAttendanceByActualDateAndEmployeeId(d1, empl_id);
    }

    @Override
    @Transactional
    public Iterable<Attendance> getAttendancesByDateBetween(Date d1, Date d2) {
        return attendanceRepository.getAttendanceByActualDateBetween(d1, d2);
    }
}
