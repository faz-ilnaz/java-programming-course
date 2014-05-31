package model;

import org.hibernate.annotations.GenericGenerator;
import utils.Utils;

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

    @Column(name = "empl_login", nullable = false, unique = true)
    private String login;

    @Column(name = "empl_pass")
    private String pass;

    @Column(name ="empl_salt")
    private String salt;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Attendance> attendances;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.salt = Utils.randString(6);
        this.pass = Utils.md5(pass + this.salt);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

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
                ", job='" + job +
                ", login='" + login + "\'" +
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
