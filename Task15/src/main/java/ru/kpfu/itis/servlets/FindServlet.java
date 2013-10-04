package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static List<String> list;


	@Override
	public void doPost (HttpServletRequest request,
					   HttpServletResponse response) throws ServletException, IOException {

			String filename = request.getParameter("filename");
			String path = request.getParameter("path");

        try {

            if(filename == null || filename.isEmpty()) {
                throw new IllegalArgumentException("File name can't be blank");
            }

            if(path == null || path.isEmpty()) {
                throw new IllegalArgumentException("Path can't be blank");
            }



            // initial directory
            File startF = new File(path);

            list = new ArrayList<String>();

            //starting search
            find(startF, filename);

            request.setAttribute("list", list);
            getServletConfig().getServletContext().getRequestDispatcher(
                        "/index.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("exception", e.getMessage());
            getServletConfig().getServletContext().getRequestDispatcher(
                    "/index.jsp").forward(request, response);
        } finally {
        }



	}

    private static void find(File file, String filename) {
//		System.out.println("Searching: " + file.getPath());
        File[] files = file.listFiles();

        if(files == null) {
            return;
        }

        for (File f : files) {
            if (f.isFile() && f.getName().contains(filename)) {
                list.add(f.getAbsolutePath());
            };
            if (f.isDirectory()) {
                find(f, filename);
            }
        }
    }
}
