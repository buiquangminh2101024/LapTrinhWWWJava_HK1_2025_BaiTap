package iuh.fit.se.controllers;

import iuh.fit.se.daos.DanhMucDao;
import iuh.fit.se.daos.TinTucDao;
import iuh.fit.se.daos.impl.DanhMucDaoImpl;
import iuh.fit.se.daos.impl.TinTucDaoImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@WebListener
public class AppInitializer implements ServletContextListener {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Future<DanhMucDao> future1 = executor.submit(() -> new DanhMucDaoImpl());
        Future<TinTucDao> future2 = executor.submit(() -> new TinTucDaoImpl());
        context.setAttribute("danhMucContext", future1);
        context.setAttribute("tinTucContext", future2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        executor.shutdown();
    }
}
