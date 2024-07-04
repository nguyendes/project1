/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iKhachHang;
import exceptions.dbexception;
import exceptions.khachhangexception;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for handling customer operations.
 */
public class KhachHangService implements iKhachHang {
    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(KhachHangService.class.getName());

    public KhachHangService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }


    @Override
    public List<KhachHang> getAllKH() {
        List<KhachHang> khs = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rss = pre.executeQuery()) {

            while (rss.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rss.getString(1));
                kh.setTenKH(rss.getString(2));
                kh.setEmail(rss.getString(3));
                kh.setSDT(rss.getString(4));
                khs.add(kh);
            }
            logger.log(Level.INFO, "Load thong tin khach hang thanh cong");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load that bai", e);
            throw new dbexception("Lỗi khi lấy danh sách khách hàng", e);
        }
        return khs;
    }

    @Override
    public int them(KhachHang kh) {
        String sql = "INSERT INTO KhachHang (MaKH, TenKH, Email, SDT) VALUES (?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, kh.getMaKH());
            pre.setString(2, kh.getTenKH());
            pre.setString(3, kh.getEmail());
            pre.setString(4, kh.getSDT());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Added new customer: {0}", kh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm khách hàng", e);
            throw new khachhangexception("Lỗi khi thêm khách hàng", e);
        }
    }

    @Override
    public int capnhat(KhachHang kh) {
        String sql = "UPDATE KhachHang SET TenKH = ?, Email = ?, SDT = ? WHERE MaKH = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, kh.getTenKH());
            pre.setString(2, kh.getEmail());
            pre.setString(3, kh.getSDT());
            pre.setString(4, kh.getMaKH());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Updated customer: {0}", kh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật khách hàng", e);
            throw new khachhangexception("Lỗi khi cập nhật khách hàng", e);
        }
    }

    @Override
    public int xoa(KhachHang kh) {
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, kh.getMaKH());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Deleted customer: {0}", kh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "lỗi khi xóa khách hàng", e);
            throw new khachhangexception("Lỗi khi xóa khách hàng", e);  
        }
    }
}

