package iuh.fit.se.uploadfilesdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 25
)
public class UploadFiles extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        Collection<Part> parts = req.getParts();

        InputStream input = null;
        String filePath = "C:\\Users\\QUANG MINH\\Documents\\lap_trinh_IntelliJIDEA_Java\\Servlet1\\Tuan02\\UploadFilesDemo\\src\\main\\webapp\\uploads\\";
        if (parts.size() != 0) {
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();
                if(fileName == null || fileName.isEmpty())
                    continue;

                input = part.getInputStream();
                OutputStream out = new FileOutputStream(filePath + fileName);

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                out.flush();
                out.close();
                input.close();
            }
            resp.getWriter().println("Thêm thành công");
        } else
            resp.getWriter().println("Thêm thất bại");
    }
}
