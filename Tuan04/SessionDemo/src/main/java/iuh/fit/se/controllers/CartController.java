package iuh.fit.se.controllers;

import iuh.fit.se.daos.ProductDao;
import iuh.fit.se.daos.impl.ProductDaoImpl;
import iuh.fit.se.models.CartItem;
import iuh.fit.se.models.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    @Resource(name = "jdbc/DB")
    private DataSource dataSource;

    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        productDao = new ProductDaoImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add", "update":
                handleAddToCart(req, resp);
                break;
            case "delete":
                handleRemoveFromCart(req, resp);
                break;
            default:
                handleNavigate(req, resp);
                req.getRequestDispatcher("views/cart.jsp").forward(req, resp);
                break;
        }
    }

    public void handleAddToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CartItem> carts = null;

        if (session.getAttribute("cart") == null) {
            carts = new ArrayList<>();
        } else {
            carts = (List<CartItem>) session.getAttribute("cart");
        }

        int id = Integer.parseInt(req.getParameter("id"));

        int index = indexOfCart(carts, id);

        //Kiểm tra số lượng mua
        String strQuantity = req.getParameter("quantity");
        if (!strQuantity.matches("^[0-9]+$")) {
            session.setAttribute("errors", "Phải nhập vào số nguyên > 0");
            if (req.getParameter("action").equals("add"))
                resp.sendRedirect(req.getContextPath() + "/product");
            else
                req.getRequestDispatcher("views/cart.jsp").forward(req, resp);
            return;
        }
        else
            session.removeAttribute("errors");
        int quantity = Integer.parseInt(strQuantity);

        if (index == -1) {
            Product product = productDao.findById(id);
            carts.add(new CartItem(id, product.getModel(), product.getPrice(), quantity, quantity * product.getPrice()));
        } else {
            quantity = quantity + (req.getParameter("action").equals("add")? carts.get(index).getQuantity() : 0);
            carts.get(index).setQuantity(quantity);
        }
        session.setAttribute("cart", carts);


        if (req.getParameter("action").equals("add"))
            resp.sendRedirect(req.getContextPath() + "/product");
        else
            req.getRequestDispatcher("views/cart.jsp").forward(req, resp);
    }

    public void handleRemoveFromCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CartItem> carts = null;

        if (session.getAttribute("cart") == null) {
            throw new IOException("Cannot find carts");
        } else {
            carts = (List<CartItem>) session.getAttribute("cart");
        }

        int id = Integer.parseInt(req.getParameter("id"));
        int index = indexOfCart(carts, id);

        if (index == -1) {
            throw new IOException("Cannot find cart");
        }

        carts.remove(index);

        session.setAttribute("cart", carts);

        req.getRequestDispatcher("views/cart.jsp").forward(req, resp);
    }

    public void handleNavigate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CartItem> carts = null;

        if (session.getAttribute("cart") == null)
            carts = new ArrayList<>();
        else
            carts = (List<CartItem>) session.getAttribute("cart");

        session.setAttribute("cart", carts);
    }

    public int indexOfCart(List<CartItem> carts, int id) {
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getPartNumber() == id) return i;
        }
        return -1;
    }
}
