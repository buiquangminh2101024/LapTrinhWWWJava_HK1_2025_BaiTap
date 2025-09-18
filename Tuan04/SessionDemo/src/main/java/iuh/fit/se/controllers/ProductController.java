package iuh.fit.se.controllers;

import iuh.fit.se.daos.ProductDao;
import iuh.fit.se.daos.impl.ProductDaoImpl;
import iuh.fit.se.models.CartItem;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    @Resource(name = "jdbc/DB")
    private DataSource dataSource;

    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        productDao = new ProductDaoImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productDao.findAll());
        req.getRequestDispatcher("views/home.jsp").forward(req, resp);
    }
}
