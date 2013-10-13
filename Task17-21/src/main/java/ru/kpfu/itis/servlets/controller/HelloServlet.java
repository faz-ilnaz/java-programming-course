package ru.kpfu.itis.servlets.controller;


import ru.kpfu.itis.servlets.dao.StudentDao;
import ru.kpfu.itis.servlets.dao.StudentDaoImpl;
import ru.kpfu.itis.servlets.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentDao studentDao= new StudentDaoImpl();

    @Override
    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        if(studentDao.check(email, password)) {
            request.setAttribute("ok", true);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/profile.jsp").forward(request, response);
        } else {
            request.setAttribute("ok", false);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/index.jsp").forward(request, response);
        }
    }
}
