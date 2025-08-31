package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/uploadFormData")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 25
)
public class UploadFormData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = null;

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        Part filePart = req.getPart("portraitphoto");

        InputStream inputStream = null;
        String fileName = null;

        if(filePart != null){
            fileName = filePart.getSubmittedFileName();
            if(fileName != null && !fileName.isEmpty()){
                inputStream = filePart.getInputStream();
            }
        }

        try(Connection conn = DBConnection.getConnection()) {
            // Tạo lệnh chèn dữ liệu
            String stmt = "insert into UploadFormData (first_name,last_name,photo) values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            if(inputStream != null){
                pstmt.setBlob(3, inputStream);
            }
            else {
                pstmt.setNull(3, java.sql.Types.BLOB);
            }

            // Chèn dữ liệu
            int row = pstmt.executeUpdate();
            if(row > 0){
                message = "Đã thêm thành công";
                // Lấy hình từ csdl rồi đưa vào thư mục uploads
                getImageAndSaveInProject(req, fileName);
            }
        } catch (Exception e) {
            message = "ERROR:" + e.getMessage();
            e.printStackTrace();
        }

        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/message").forward(req, resp);
    }

    private void getImageAndSaveInProject(HttpServletRequest req, String fileName) throws ServletException, IOException {
        try(Connection conn = DBConnection.getConnection()) {
            String stmt = "select photo from UploadFormData order by id desc limit 1";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                InputStream in = rs.getBinaryStream("photo");

                String userDir = System.getProperty("user.dir");
                if(userDir.contains("tomcat") && userDir.endsWith("bin")) {
                    userDir = new File(userDir).getParent();
                    userDir = new File(userDir).getParent();
                }
                String filePath = userDir + "/Tuan02/UploadFilesToDatabaseDemo/src/main/webapp/uploads/" + fileName;

                Files.copy(in, Path.of(filePath), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
