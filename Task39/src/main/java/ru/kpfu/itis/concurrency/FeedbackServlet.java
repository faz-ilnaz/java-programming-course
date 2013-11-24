package ru.kpfu.itis.concurrency;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //Creating BlockingQueue of size 10
    BlockingQueue<Message> queue;


    @Override
    public void init() throws ServletException {
        queue = new ArrayBlockingQueue<Message>(10);
        new Thread(new DBWriter(queue)).start();
        super.init();
    }

    @Override
    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String content = request.getParameter("content").trim();
        String email = request.getParameter("email");

        try {
            queue.put(new Message(email, content));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        getServletConfig().getServletContext().getRequestDispatcher(
                "/jsp/hello.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher(
                "/").forward(req, resp);
    }
}
