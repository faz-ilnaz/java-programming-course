package ru.kpfu.itis.servlets.dao;


import ru.kpfu.itis.servlets.dao.factory.ConnectionFactory;
import ru.kpfu.itis.servlets.model.Contacts;
import ru.kpfu.itis.servlets.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactsDaoImpl implements ContactsDao {

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(String email) {
        boolean ok = true;
        try {
            String querystring = "INSERT INTO contacts (user_email) VALUES (?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, email);
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

    @Override
    public boolean update(Contacts contacts) {
        boolean ok = true;
        try {
            String querystring = "UPDATE contacts SET vk = ?, gmail = ?, twitter = ?, instagram = ?, linkedin = ? WHERE user_email = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, contacts.getVk());
            ptmt.setString(2, contacts.getGmail());
            ptmt.setString(3, contacts.getTwitter());
            ptmt.setString(4, contacts.getInstagramm());
            ptmt.setString(5, contacts.getLinkedin());
            ptmt.setString(6, contacts.getUser_email());

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

    @Override
    public void delete(Long id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Student findByPrimaryKey(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Contacts findByEmail(String email) {
        Contacts contacts = null;
        try {
            String querystring = "SELECT * FROM contacts WHERE user_email = ?";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, email);
            rs = ptmt.executeQuery();
            contacts = new Contacts();
            if (rs.next()) {
                contacts.setVk(rs.getString("vk"));
                contacts.setGmail(rs.getString("gmail"));
                contacts.setInstagramm(rs.getString("instagram"));
                contacts.setTwitter(rs.getString("twitter"));
                contacts.setLinkedin(rs.getString("linkedin"));
                contacts.setUser_email(rs.getString("user_email"));
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
        return contacts;
    }
}
