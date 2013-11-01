package ru.kpfu.itis.servlets.filter;

import ru.kpfu.itis.servlets.model.Student;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class UserLogFilter implements Filter {

    private String username;
    private String time;
    private String url;

    private File logFile;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logFile = new File(filterConfig.getInitParameter("logFile"));

        if(!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        url = request.getRequestURL().toString();
        time = new Date().toString();

        HttpSession session = request.getSession(false);
        if (session == null
                || session.getAttribute("student") == null) {
            username = "anonymous";
        } else {
            Student student = (Student) session.getAttribute("student");
            username = "id: " + student.getId() + ", " + student.getLastname() + " " + student.getName();
        }

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(logFile, true));
            out.append("user: " + username + ", time: " + time + ", url: " + url);
            out.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
