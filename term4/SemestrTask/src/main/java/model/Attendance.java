package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(AttendancePK.class)
public class Attendance implements Serializable {

    @Id
    @AttributeOverrides({
        @AttributeOverride(name = "actualDate", column = @Column(name = "att_date ")),
        @AttributeOverride(name = "employee", column = @Column(name = "att_empl_id"))
    })

    private Date actualDate;
    private Employee employee;

    @Temporal(TemporalType.TIME)
    @Column(name = "att_start")
    private Date start;

    @Temporal(TemporalType.TIME)
    @Column(name = "att_end")
    private Date end;

    @Override
    public String toString() {
        return "Attendance{" +
                "actualDate=" + actualDate +
                ", employee=" + employee +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
