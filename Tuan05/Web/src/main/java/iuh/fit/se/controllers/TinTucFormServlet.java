package iuh.fit.se.controllers;

import iuh.fit.se.daos.DanhMucDao;
import iuh.fit.se.daos.TinTucDao;
import iuh.fit.se.models.DanhMuc;
import iuh.fit.se.models.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet(name = "ThemTinTucServlet", urlPatterns = {"/themTinTuc"})
public class TinTucFormServlet extends HttpServlet {
    private DanhMucDao danhMucDao;
    private TinTucDao tinTucDao;

    @Override
    public void init() throws ServletException {
        try {
            danhMucDao = ((Future<DanhMucDao>) getServletContext().getAttribute("danhMucContext")).get();
            tinTucDao = ((Future<TinTucDao>) getServletContext().getAttribute("tinTucContext")).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("danhMuc") == null)
            req.setAttribute("danhMuc", danhMucDao.getAll());

        req.setAttribute("pageToInclude", "ThemTinTucServlet");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("danhMuc") == null)
            req.setAttribute("danhMuc", danhMucDao.getAll());

        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDung");
        String lienKet = req.getParameter("lienKet");
        int maDanhMuc = Integer.parseInt(req.getParameter("maDanhMuc"));

        DanhMuc danhMuc = danhMucDao.findByID(maDanhMuc);
        TinTuc tinTuc = new TinTuc(tieuDe, noiDung, lienKet, danhMuc);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();
        Set<ConstraintViolation<TinTuc>> violations = validator.validate(tinTuc);

        if (!violations.isEmpty()) {
            req.getSession().setAttribute("errors", violations);
            req.setAttribute("pageToInclude", "ThemTinTucServlet");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            tinTucDao.save(tinTuc);

            resp.sendRedirect(req.getContextPath() + "/danhSachTinTuc");
        }
    }
}
