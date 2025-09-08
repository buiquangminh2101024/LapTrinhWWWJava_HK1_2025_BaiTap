package iuh.fit.se.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class UserDao {
    public static String insertUser(User user) {
        try(Connection conn = DBConnection.getConnection()) {
            // Tạo lệnh chèn dữ liệu
            String stmt = "insert into User (first_name,last_name,email,pwd,dob,gender) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setDate(5, Date.valueOf(user.getBirthday()));
            pstmt.setString(6, user.getGender());

            // Chèn dữ liệu
            int row = pstmt.executeUpdate();
            return "Đã thêm thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR:" + e.getMessage();
        }
    }
}
