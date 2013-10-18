package ru.kpfu.itis.servlets.controller;


import ru.kpfu.itis.servlets.dao.StudentDao;
import ru.kpfu.itis.servlets.dao.StudentDaoImpl;
import ru.kpfu.itis.servlets.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentDao studentDao= new StudentDaoImpl();

    @Override
    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        HttpSession session = request.getSession();

        if(studentDao.check(email, password)) {
            request.setAttribute("ok", true);
            Student student = studentDao.findByEmail(email);
            session.setAttribute("student", student);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/jsp/profile.jsp").forward(request, response);
        } else {
            request.setAttribute("ok", false);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/index.jsp").forward(request, response);
        }
    }
}
