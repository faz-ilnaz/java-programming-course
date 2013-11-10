package ru.kpfu.itis.servlets.controller;


import ru.kpfu.itis.servlets.dao.ContactsDao;
import ru.kpfu.itis.servlets.dao.ContactsDaoImpl;
import ru.kpfu.itis.servlets.dao.StudentDao;
import ru.kpfu.itis.servlets.dao.StudentDaoImpl;
import ru.kpfu.itis.servlets.model.Contacts;
import ru.kpfu.itis.servlets.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignupServlet extends HttpServlet {

    StudentDao studentDao= new StudentDaoImpl();
    ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        getServletConfig().getServletContext().getRequestDispatcher(
                "/signup.jsp").forward(request, response);
    }

    @Override
    public void doPost (HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String group = request.getParameter("group");
        int lab_num = Integer.parseInt(request.getParameter("laboratory"));
        String laboratory = labs.values()[lab_num].toString();
        String activity = request.getParameter("activity");

        Student student = new Student();
        student.setName(name);
        student.setLastname(lastname);
        student.setEmail(email);
        student.setBirthday(birthday);
        student.setActivity(activity);
        student.setLaboratory(laboratory);
        student.setGroup(group);
        student.setPassword(password);
        student.setAva_url("images/default_avatar.gif");

        if(studentDao.add(student) && contactsDao.add(student.getEmail())) {
            request.setAttribute("ok", true);
            session.setAttribute("student", student);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/profile.jsp").forward(request, response);
        }  else {
            request.setAttribute("ok", false);
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/signup.jsp").forward(request, response);
        }


    }
}