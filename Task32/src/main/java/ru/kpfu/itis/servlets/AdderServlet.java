package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static volatile double number1;
    private static volatile double number2;
    private static volatile double sum;



    @Override
    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));

            request.setAttribute("result", num1 + num2);
            request.setAttribute("num1", num1);
            request.setAttribute("num2", num2);
            setVars(num1,num2,sum);

            System.out.println(number1 + " + " + number2 + " = " + sum);

            getServletConfig().getServletContext().getRequestDispatcher(
                    "/index.jsp").forward(request, response);

    }

    static synchronized void setVars(double num1, double num2, double s) {
        number1 = num1;
        number2 = num2;
        sum = s;
    }
}
