package ru.kpfu.itis.servlets.model;

import ru.kpfu.itis.servlets.dao.Utils;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String salt;


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
