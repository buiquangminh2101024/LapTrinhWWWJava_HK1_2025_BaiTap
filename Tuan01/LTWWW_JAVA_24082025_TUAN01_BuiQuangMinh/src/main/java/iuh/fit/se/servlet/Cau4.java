package iuh.fit.se.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/cau4"},
//            initParams = {
//                @WebInitParam(name = "hello", value = "Hello"),
//                @WebInitParam(name = "world", value = "world")
//            }
//)
public class Cau4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.println("Init Parameter: " + this.getInitParameter("hello") + " " + this.getInitParameter("world"));
        out.println("Context Parameter: " + this.getServletContext().getInitParameter("hello_world"));
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.println("Init Parameter: " + this.getInitParameter("hello") + " " + this.getInitParameter("world"));
        out.println("Context Parameter: " + this.getServletContext().getInitParameter("hello_world"));
        out.close();
    }
}
