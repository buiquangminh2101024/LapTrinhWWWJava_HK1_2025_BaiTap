package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.ProductDao;
import iuh.fit.se.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final DataSource dataSource;

    public ProductDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO Product (model, description, quantity, price, imgURL) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, product.getModel());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setDouble(4, product.getPrice());
            if (product.getImgURL() != null) {
                pstmt.setString(5, product.getImgURL());
            } else {
                pstmt.setNull(5, java.sql.Types.VARCHAR);
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE Product SET model = ?, description = ?, quantity = ?, price = ?, imgURL = ? WHERE id = ?";
        try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, product.getModel());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setDouble(4, product.getPrice());
            if (product.getImgURL() != null) {
                pstmt.setString(5, product.getImgURL());
            } else {
                pstmt.setNull(5, java.sql.Types.VARCHAR);
            }
            pstmt.setInt(6, product.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Product WHERE id = ?";
        try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM Product WHERE id = ?";
        try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString((6)));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM Product";
        try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString((6))));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
