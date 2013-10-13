package ru.kpfu.itis.servlets.dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.kpfu.itis.servlets.dao.factory.ConnectionFactory;
import ru.kpfu.itis.servlets.model.Student;

public class StudentDaoImpl implements StudentDao{

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    public boolean check(String email, String password) {
        String hashedpass = "";
        String salt = "";
        try {
            String querystring = "SELECT password, salt FROM students WHERE email=?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, email);
            rs = ptmt.executeQuery();

            while(rs.next()) {
                hashedpass = rs.getString(1);
                salt = rs.getString(2);
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
        return Student.check(hashedpass, password, salt);
    }

    public void add(Student student) {

        try {
            String querystring = "INSERT INTO students (name, email, password, salt) VALUES (?, ?, ?, ?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, student.getName());
            ptmt.setString(2, student.getEmail());
            ptmt.setString(3, student.getPassword());
            ptmt.setString(4, student.getSalt());
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

    public void update(Student student) {
        try {
            String querystring = "UPDATE students SET email =?,password =? WHERE id = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);

            ptmt.setString(1, student.getEmail());
            ptmt.setString(2, student.getPassword());
            ptmt.setLong(3, student.getId());
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
                student.setEmail(rs.getString(1));
                student.setPassword(rs.getString(2));

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
                student.setEmail(rs.getString(1));
                student.setPassword(rs.getString(2));
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
