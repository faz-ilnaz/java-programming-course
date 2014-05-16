package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Employee  implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "empl_id")
    private Long id;

    @Column(name = "empl_fname")
    private String firstname;

    @Column(name = "empl_lname")
    private String lastname;

    @Column(name = "empl_job")
    private String job;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Attendance> attendances;

    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", job='" + job + '\'' +
                ", attendances=" + attendances +
                '}';
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Iterable<Attendance> attendances) {
        this.attendances = (List<Attendance>) attendances;
    }

}
