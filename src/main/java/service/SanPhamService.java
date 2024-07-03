/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iSanPham;
import exceptions.dbexception;
import exceptions.sanphamexception;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;

/**
 *
 * @author maytinh
 */
public class SanPhamService implements iSanPham{

    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(SanPhamService.class.getName());

    public SanPhamService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    @Override
    public List<SanPham> getAllSP() {
        List<SanPham> sps = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setGia((float) rs.getDouble("Gia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sps.add(sp);
            }
            logger.log(Level.INFO, "Load sản phẩm thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load sản phẩm thất bại", e);
            throw new dbexception("Lỗi khi lấy danh sách sản phẩm", e);
        }
        return sps;
    }

    @Override
    public int them(SanPham sp) {
        String sql = "INSERT INTO SanPham (MaSP, TenSP, Gia, SoLuong) VALUES (?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, sp.getMaSP());
            pre.setString(2, sp.getTenSP());
            pre.setDouble(3, sp.getGia());
            pre.setInt(4, sp.getSoLuong());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm sản phẩm mới: {0}", sp.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm sản phẩm", e);
            throw new sanphamexception("Lỗi khi thêm sản phẩm", e);
        }
    }

    @Override
    public int capnhat(SanPham sp) {
        String sql = "UPDATE SanPham SET TenSP = ?, Gia = ?, SoLuong = ? WHERE MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, sp.getTenSP());
            pre.setDouble(2, sp.getGia());
            pre.setInt(3, sp.getSoLuong());
            pre.setString(4, sp.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật sản phẩm: {0}", sp.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật sản phẩm", e);
            throw new sanphamexception("Lỗi khi cập nhật sản phẩm", e);
        }
    }

    @Override
    public int xoa(SanPham sp) {
        String sql = "DELETE FROM SanPham WHERE MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, sp.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa sản phẩm: {0}", sp.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa sản phẩm", e);
            throw new sanphamexception("Lỗi khi xóa sản phẩm", e);
        }
    }
}
