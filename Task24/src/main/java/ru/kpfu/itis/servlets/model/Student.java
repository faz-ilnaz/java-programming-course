package ru.kpfu.itis.servlets.model;

import ru.kpfu.itis.servlets.dao.Utils;

public class Student {
    private Long id;
    private String name;
    private String lastname;
    private String birthday;
    private String group;
    private String laboratory;
    private String information;
    private String activity;
    private String email;
    private String password;
    private String salt;
    private Contacts contacts;
    private String ava_url;

    public String getAva_url() {
        return ava_url;
    }

    public void setAva_url(String ava_url) {
        this.ava_url = ava_url;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", group='" + group + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", information='" + information + '\'' +
                ", activity='" + activity + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", contacts=" + contacts +
                '}';
    }



    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }




    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSalt() {

        return salt;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.salt = Utils.randString(6);
        this.password = Utils.md5(password + this.salt);
    }
}
