/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iNhanVien;
import exceptions.NhanVienException;
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
        List<NhanVien> nvList = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                // other fields...
                nvList.add(nv);
            }
            logger.log(Level.INFO, "Load nhân viên thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load nhân viên thất bại", e);
            throw NhanVienException.databaseError("Lỗi khi lấy danh sách nhân viên", e);
        }
        return nvList;
    }

    @Override
    public int them(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, TenNV, ...) VALUES (?, ?, ...)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, nv.getMaNV());
            pre.setString(2, nv.getTenNV());
            // other fields...

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm nhân viên mới: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm nhân viên", e);
            throw NhanVienException.databaseError("Lỗi khi thêm nhân viên", e);
        }
    }

    @Override
    public int capnhat(NhanVien nv) {
        String sql = "UPDATE NhanVien SET TenNV = ?, ... WHERE MaNV = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, nv.getTenNV());
            pre.setString(2, nv.getMaNV());
            // other fields...

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật nhân viên: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật nhân viên", e);
            throw NhanVienException.databaseError("Lỗi khi cập nhật nhân viên", e);
        }
    }

    @Override
    public int xoa(NhanVien nv) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, nv.getMaNV());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa nhân viên: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa nhân viên", e);
            throw NhanVienException.databaseError("Lỗi khi xóa nhân viên", e);
        }
    }

}


