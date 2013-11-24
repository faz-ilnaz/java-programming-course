package ru.kpfu.itis.concurrency;

import ru.kpfu.itis.concurrency.factory.ConnectionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;

public class DBWriter implements Runnable {

    private BlockingQueue<Message> queue;

    Connection con = null;
    PreparedStatement ptmt = null;

    public DBWriter(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;

            while(true){
                if((msg = queue.take()) != null) {
                    add(msg);
                }
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void add(Message msg) {
        try {
            String querystring = "INSERT INTO messages ( email, content) " +
                    "VALUES (?, ?)";
            con = getConnection();
            ptmt = con.prepareStatement(querystring);
            ptmt.setString(1, msg.getEmail());
            ptmt.setString(2, msg.getMsg());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

    private Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }
}
