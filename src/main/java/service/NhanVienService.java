/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iNhanVien;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;

/**
 *
 * @author maytinh
 */
public class NhanVienService implements iNhanVien{

    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(NhanVienService.class.getName());

    public NhanVienService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    @Override
    public List<NhanVien> getAllNV() {
        List<NhanVien> nvs = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setEmail(rs.getString("Email"));
                nv.setSDT(rs.getString("SDT"));
                nvs.add(nv);
            }
            logger.log(Level.INFO, "Loaded employee data successfully");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to load employee data", e);
        }

        return nvs;
    }

    @Override
    public int them(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, TenNV, Email, SDT) VALUES (?, ?, ?, ?)";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getSDT());

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Added new employee: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding new employee", e);
            return 0;
        }
    }

    @Override
    public int capnhat(NhanVien nv) {
        String sql = "UPDATE NhanVien SET TenNV = ?, Email = ?, SDT = ? WHERE MaNV = ?";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getEmail());
            ps.setString(3, nv.getSDT());
            ps.setString(4, nv.getMaNV());

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Updated employee: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating employee", e);
            return 0;
        }
    }

    @Override
    public int xoa(NhanVien nv) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getMaNV());

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Deleted employee: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting employee", e);
            return 0;
        }
    }
}
