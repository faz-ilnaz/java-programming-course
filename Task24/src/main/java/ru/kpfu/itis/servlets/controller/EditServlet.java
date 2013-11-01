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

public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentDao studentDao= new StudentDaoImpl();
    ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        getServletConfig().getServletContext().getRequestDispatcher(
                "/edit.jsp").forward(request, response);
    }

    @Override
    public void doPost (HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");

        if (request.getParameter("labs") != null) {
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String birthday = request.getParameter("birthday");
            String group = request.getParameter("group");
            int lab_num = 0;
            if(request.getParameter("labs") != null) {
                lab_num = Integer.parseInt(request.getParameter("labs"));
            }
            String laboratory = labs.values()[lab_num].toString();

            String activity = request.getParameter("activity");
            String information = request.getParameter("information").trim();



            student.setName(name);
            student.setLastname(lastname);
            student.setBirthday(birthday);
            student.setActivity(activity);
            student.setLaboratory(laboratory);
            student.setGroup(group);
            student.setInformation(information);

            studentDao.update(student);

        } else {

            String vk = request.getParameter("vk");
            String gmail = request.getParameter("gmail");
            String twitter = request.getParameter("twitter");
            String instagram = request.getParameter("instagram");
            String linkedin = request.getParameter("linkedin");

            if(student.getContacts() == null) {
                student.setContacts(new Contacts());
            }

            Contacts contacts = student.getContacts();
            contacts.setGmail(gmail);
            contacts.setInstagramm(instagram);
            contacts.setLinkedin(linkedin);
            contacts.setTwitter(twitter);
            contacts.setVk(vk);
            contacts.setUser_email(student.getEmail());

            student.setContacts(contacts);

            contactsDao.update(contacts);

        }

        session.setAttribute("student", student);

        getServletConfig().getServletContext().getRequestDispatcher(
                "/profile.jsp").forward(request, response);

    }
}
