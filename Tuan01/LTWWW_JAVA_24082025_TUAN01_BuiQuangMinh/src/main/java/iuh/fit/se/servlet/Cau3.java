package iuh.fit.se.servlet;

import iuh.fit.se.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cau3")
public class Cau3 extends HelloServlet {
    private User user;

    @Override
    public void init() {
        user = new User("Bùi Quang Minh", "buiquangminh", "buiquangminh", "buiquangminh@gmail.com", "buiquangminh", "Sinh viên kĩ thuật phần mềm");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.println(User.toJson(user));
        out.close();
    }
}
