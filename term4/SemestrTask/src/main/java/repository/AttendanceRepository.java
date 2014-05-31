package repository;

import model.Attendance;
import model.AttendancePK;
import model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface AttendanceRepository extends CrudRepository<Attendance, AttendancePK> {
    Attendance getAttendanceByActualDateAndEmployeeId(Date date, Long att_empl_id);
    Iterable<Attendance> getAttendanceByActualDateBetween(Date date1, Date date2);
    List<Attendance> getAttendanceByEmployeeAndActualDateBetween(Employee e, Date date1, Date date2);
    List<Attendance> getAttendanceByEmployeeIdAndActualDateBetween(Long empl_id, Date date1, Date date2);


//    @Query("select a from (select a from Attendance a where a.employee.id = :id) b  right join " +
//            "generate_series(':date1', ':date2', '1 day'::interval) on b.actualDate = generate_series ")
//    Iterable<Attendance> findAttendancesByEmployeeIdAndBetweenDates(@Param("id") Long id, @Param("date1") Date date1, @Param("date2") Date date2);

}
