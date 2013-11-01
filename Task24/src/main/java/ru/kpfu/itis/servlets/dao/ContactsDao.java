package ru.kpfu.itis.servlets.dao;


import ru.kpfu.itis.servlets.model.Contacts;
import ru.kpfu.itis.servlets.model.Student;

import java.util.List;

public interface ContactsDao {

    public boolean add(String email);

    public boolean update(Contacts contacts);

    public void delete(Long id);

    public List findAll();

    public Student findByPrimaryKey(Long id) ;

    public Contacts findByEmail(String email) ;
}
