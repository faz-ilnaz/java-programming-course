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

public class AnotherUserProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    StudentDao studentDao= new StudentDaoImpl();
    ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String studentId = (String)request.getParameter("id");
        System.out.println(studentId);

        long id = Long.parseLong(studentId);

        Student aStudent = studentDao.findByPrimaryKey(id);

        HttpSession session = request.getSession(false);
        request.setAttribute("a_student",aStudent);
        getServletConfig().getServletContext().getRequestDispatcher(
                    "/anotherprofile.jsp").forward(request, response);
    }
}
