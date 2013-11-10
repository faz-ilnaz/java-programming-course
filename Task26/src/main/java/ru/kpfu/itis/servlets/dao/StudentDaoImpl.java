package ru.kpfu.itis.servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.kpfu.itis.servlets.dao.factory.ConnectionFactory;
import ru.kpfu.itis.servlets.model.Contacts;
import ru.kpfu.itis.servlets.model.Student;

public class StudentDaoImpl implements StudentDao{

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    ContactsDao contactsDao = new ContactsDaoImpl();

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    private boolean check(String hashedPass, String pass, String salt) {
        return Utils.check(hashedPass, pass, salt);
    }

    @Override
    public Student findByEmail(String email) {
        Student student = null;
        try {
            String querystring = "SELECT * FROM students WHERE email = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, email);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setSalt(rs.getString("salt"));
                student.setLastname(rs.getString("lastname"));
                student.setBirthday(rs.getString("birthday"));
                student.setGroup(rs.getString("groupname"));
                student.setLaboratory(rs.getString("laboratory"));
                student.setActivity(rs.getString("activity"));
                student.setInformation(rs.getString("information"));
                student.setAva_url(rs.getString("ava_url"));
                student.setContacts(contactsDao.findByEmail(email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return student;
    }


    public boolean check(String email, String password) {
        boolean isValid = false;
        String hashedpass = "";
        String salt = "";
        try {
            String querystring = "SELECT password, salt FROM students WHERE email=?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, email);
            rs = ptmt.executeQuery();

            if(rs.next()) {
                hashedpass = rs.getString(1);
                salt = rs.getString(2);
                isValid = check(hashedpass, password, salt);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isValid;
    }

    public boolean add(Student student) {
        boolean ok = true;
        try {
            String querystring = "INSERT INTO students (  " +
                    "name, email, password, salt, lastname, birthday, groupname, laboratory, activity, ava_url) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, student.getName());
            ptmt.setString(2, student.getEmail());
            ptmt.setString(3, student.getPassword());
            ptmt.setString(4, student.getSalt());
            ptmt.setString(5, student.getLastname());
            ptmt.setString(6, student.getBirthday());
            ptmt.setString(7, student.getGroup());
            ptmt.setString(8, student.getLaboratory());
            ptmt.setString(9, student.getActivity());
            ptmt.setString(10, student.getAva_url());
            student.setContacts(new Contacts());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ok;
    }

    public boolean update(Student student) {
        boolean ok = true;
        if (student.getId() == null) {
            student.setId(findByEmail(student.getEmail()).getId());
        }
        try {
            String querystring = "UPDATE students SET " +
                    "name =?, lastname = ?, groupname = ?, laboratory = ?, information = ?, activity = ?, birthday = ?, ava_url = ?  WHERE id = ?; " +
                    "UPDATE contacts SET vk = ?, gmail = ?, twitter = ?, instagram = ?, linkedin = ? WHERE user_email = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);

            ptmt.setString(1, student.getName());
            ptmt.setString(2, student.getLastname());
            ptmt.setString(3, student.getGroup());
            ptmt.setString(4, student.getLaboratory());
            ptmt.setString(5, student.getInformation());
            ptmt.setString(6, student.getActivity());
            ptmt.setString(7, student.getBirthday());
            ptmt.setString(8, student.getAva_url());
            ptmt.setLong(9, student.getId());
            if (student.getContacts() == null) {
                student.setContacts(new Contacts());
            }
            ptmt.setString(10, student.getContacts().getVk());
            ptmt.setString(11, student.getContacts().getGmail());
            ptmt.setString(12, student.getContacts().getTwitter());
            ptmt.setString(13, student.getContacts().getInstagramm());
            ptmt.setString(14, student.getContacts().getLinkedin());
            ptmt.setString(15, student.getEmail());

            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            ok = false;
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ok;
    }

    public void delete(Long id) {
        try {
            String querystring = "DELETE FROM students WHERE id =?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public List findAll() {
        List students = new ArrayList();
        Student student = null;
        try {
            String querystring = "SELECT * FROM students";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setSalt(rs.getString("salt"));
                student.setLastname(rs.getString("lastname"));
                student.setBirthday(rs.getString("birthday"));
                student.setGroup(rs.getString("groupname"));
                student.setLaboratory(rs.getString("laboratory"));
                student.setActivity(rs.getString("activity"));
                student.setInformation(rs.getString("information"));
                student.setAva_url(rs.getString("ava_url"));
                student.setContacts(contactsDao.findByEmail(student.getEmail()));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return students;
    }

    public Student findByPrimaryKey(Long id) {
        Student student = null;
        try {
            String querystring = "SELECT * FROM students WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setLong(1, id);
            rs = ptmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setSalt(rs.getString("salt"));
                student.setLastname(rs.getString("lastname"));
                student.setBirthday(rs.getString("birthday"));
                student.setGroup(rs.getString("groupname"));
                student.setLaboratory(rs.getString("laboratory"));
                student.setActivity(rs.getString("activity"));
                student.setInformation(rs.getString("information"));
                student.setAva_url(rs.getString("ava_url"));
                student.setContacts(contactsDao.findByEmail(student.getEmail()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return student;
    }
}
