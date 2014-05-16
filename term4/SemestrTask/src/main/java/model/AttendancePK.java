package model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class AttendancePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "att_date", nullable = false)
    private Date actualDate;

    @ManyToOne
    @JoinColumn(name = "att_empl_id",
            referencedColumnName = "empl_id",
            nullable = false)
    @ForeignKey(name = "FK_Att_Empl")
    private Employee employee;

    public AttendancePK(Date actualDate, Employee employee) {
        this.actualDate = actualDate;
        this.employee = employee;
    }

    public AttendancePK() {
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "AttendancePK{" +
                "actualDate=" + actualDate +
                ", employee=" + employee +
                '}';
    }
}
