package iuh.fit.se.controllers;

import iuh.fit.se.daos.DanhMucDao;
import iuh.fit.se.daos.TinTucDao;
import iuh.fit.se.models.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet(name = "DanhSachTinTucServlet", urlPatterns = {"/danhSachTinTuc"})
public class DanhSachTinTucServlet extends HttpServlet {
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

        Set<TinTuc> tinTucs = new LinkedHashSet<>();

        String[] danhMucs = req.getParameterValues("danhMuc");
        if (danhMucs == null) {
            tinTucs = tinTucDao.getAllInOrder(true);
        } else {
            for (String danhMuc : danhMucs) {
                tinTucs.addAll(tinTucDao.findByDanhMucInOrder(danhMuc, true));
            }
        }

        req.setAttribute("tinTuc", tinTucs);
        req.setAttribute("pageToInclude", "DanhSachTinTucServlet");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
