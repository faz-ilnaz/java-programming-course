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
import java.util.List;

public class UsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDao studentDao= new StudentDaoImpl();
    ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Student> students = studentDao.findAll();

        HttpSession session = request.getSession(false);

        request.setAttribute("studentsList",students);
        getServletConfig().getServletContext().getRequestDispatcher(
                    "/users.jsp").forward(request, response);
    }
}
