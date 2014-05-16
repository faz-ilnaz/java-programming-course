package repository;

import model.Attendance;
import model.AttendancePK;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


public interface AttendanceRepository extends CrudRepository<Attendance, AttendancePK> {
    Attendance getAttendanceByActualDateAndEmployeeId(Date date, Long att_empl_id);
    Iterable<Attendance> getAttendanceByActualDateBetween(Date date1, Date date2);
}
