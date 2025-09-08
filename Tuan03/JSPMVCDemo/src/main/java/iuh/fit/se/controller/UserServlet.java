package iuh.fit.se.controller;

import iuh.fit.se.model.User;
import iuh.fit.se.model.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("re-email");
        String password = req.getParameter("password");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String gender = req.getParameter("gender");

        if(firstName == null || lastName == null || email == null || password == null || day == null || month == null || year == null || gender == null){
            resp.sendRedirect("form.jsp?error=null");
            return;
        }

        if(!email.equals(reEmail)){
            resp.sendRedirect("form.jsp?error=re-email");
            return;
        }

        System.out.println(day + " " +  month + " " + year);
        User user = new User(firstName, lastName, email, password, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), gender);

        String message = UserDao.insertUser(user);

        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
