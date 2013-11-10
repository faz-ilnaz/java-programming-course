package ru.kpfu.itis.servlets.controller;


import ru.kpfu.itis.servlets.dao.ContactsDao;
import ru.kpfu.itis.servlets.dao.ContactsDaoImpl;
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
    ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null
                || session.getAttribute("student") == null) {
            request.getRequestDispatcher("/").forward(request,
                    response);
        } else {
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/profile.jsp").forward(request, response);
        }


    }

    @Override
    public void doPost (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        HttpSession session = request.getSession();

        if(!email.isEmpty() && !password.isEmpty() &&
                studentDao.check(email, password)) {
            request.setAttribute("ok", true);
            Student student = studentDao.findByEmail(email);
            session.setAttribute("student", student);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/profile.jsp").forward(request, response);
        } else {
            request.setAttribute("ok", false);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/").forward(request, response);
        }
    }
}
