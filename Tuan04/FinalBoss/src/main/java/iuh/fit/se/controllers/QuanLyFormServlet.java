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
import java.util.stream.Collectors;

@WebServlet(name = "QuanLyServlet", urlPatterns = {"/quanLy"})
public class QuanLyFormServlet extends HttpServlet {
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

        Set<TinTuc> tinTucs = getTinTucsWithOption(req, resp);

        req.setAttribute("tinTuc", tinTucs);
        req.setAttribute("pageToInclude", "QuanLyServlet");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("danhMuc") == null)
            req.setAttribute("danhMuc", danhMucDao.getAll());

        int maTT = Integer.parseInt(req.getParameter("maTT"));
        tinTucDao.delete(maTT);
        Set<TinTuc> tinTucs = getTinTucsWithOption(req, resp);

        req.setAttribute("tinTuc", tinTucs);
        req.setAttribute("pageToInclude", "QuanLyServlet");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public Set<TinTuc> getTinTucsWithOption(HttpServletRequest req, HttpServletResponse resp) {
        Set<TinTuc> tinTucs = new LinkedHashSet<>();

        String order = req.getParameter("order");
        String[] danhMucs = req.getParameterValues("danhMuc");
        if (danhMucs == null) {
            tinTucs = tinTucDao.getAllInOrder(order == null || order.equals("desc"));
        } else {
            for (String danhMuc : danhMucs) {
                tinTucs.addAll(tinTucDao.findByDanhMucInOrder(danhMuc, order.equals("desc")));
            }
        }

        String tieuDe = req.getParameter("tieuDe");
        //Khi mới vào thì chưa gửi form có parameter tieuDe
        if (tieuDe != null) {
            tinTucs = tinTucs
                    .stream()
                    .filter(t -> t.getTieuDe().contains(tieuDe))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        req.setAttribute("optionDanhMuc", danhMucs);
        req.setAttribute("optionOrder", order);
        req.setAttribute("optionTieuDe", tieuDe);

        return tinTucs;
    }
}
