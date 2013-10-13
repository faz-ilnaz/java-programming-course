package ru.kpfu.itis.servlets.dao;

import ru.kpfu.itis.servlets.model.Student;

import java.util.List;

public interface StudentDao {

    public  boolean check(String email, String password);

    public void add(Student student);

    public void update(Student student);

    public void delete(Long id);

    public List findAll();

    public Student findByPrimaryKey(Long id) ;
}
