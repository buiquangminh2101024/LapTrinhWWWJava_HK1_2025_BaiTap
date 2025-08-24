package iuh.fit.se.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cau5")
public class Cau5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("first_name") + " " + req.getParameter("last_name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String facebook = req.getParameter("facebook");
        String shortBio = req.getParameter("short_bio");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Câu5");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Name: " + name + "<br>");
        out.println("Username: " + username + "<br>");
        out.println("E-mail: " + email + "<br>");
        out.println("Facebook: " + facebook + "<br>");
        out.println("Short Bio: " + shortBio + "<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
