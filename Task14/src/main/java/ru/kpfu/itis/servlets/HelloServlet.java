package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, String> users;

    @Override
    public void init() throws ServletException {
        users = new HashMap<String, String>();
        users.put("admin", "qwerty");
        users.put("user_1", "password");
        users.put("user_2", "123456");
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
	public void doGet (HttpServletRequest request,
					   HttpServletResponse response) throws ServletException, IOException {

			String username = request.getParameter("username");
			String password = request.getParameter("pass");
            if(users.containsKey(username) && users.get(username).equals(password)) {
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
