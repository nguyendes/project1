/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iKhachHang;
import exceptions.dbexception;
import exceptions.KhachHangException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;

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
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setEmail(rs.getString(3));
                kh.setSDT(rs.getString(4));
                khs.add(kh);
            }
            logger.log(Level.INFO, "Loaded customer information successfully");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to load customer information", e);
            throw new dbexception("Error fetching customer list", e);
        }
        return khs;
    }

    @Override
    public int them(KhachHang kh) {
        if (kh == null) {
            throw KhachHangException.invalidCustomerData("Customer object is null");
        }
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
             if (e.getErrorCode() == 1062) { 
                throw KhachHangException.duplicateCustomerEntry(kh.getMaKH());
            }
            logger.log(Level.SEVERE, "Error adding customer", e);
            throw new KhachHangException("Error adding customer", e);
        }
    }

    @Override
    public int capnhat(KhachHang kh) {
        if (kh == null) {
            throw KhachHangException.invalidCustomerData("Customer object is null");
        }
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
            if (e.getErrorCode() == 0b1111011) {
                throw KhachHangException.customerNotFound(kh.getMaKH());
            }
            logger.log(Level.SEVERE, "Error updating customer", e);
            throw new KhachHangException("Error updating customer", e);
        }
    }

    @Override
    public int xoa(KhachHang kh) {
        if (kh == null || kh.getMaKH() == null || kh.getMaKH().isEmpty()) {
            throw KhachHangException.invalidCustomerData("Customer ID is null or empty");
        }
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, kh.getMaKH());

            int rowsAffected = pre.executeUpdate();
            if (rowsAffected == 0) {
                throw KhachHangException.customerNotFound(kh.getMaKH());
            }
            logger.log(Level.INFO, "Deleted customer: {0}", kh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting customer", e);
            throw new KhachHangException("Error deleting customer", e);
        }
    }
}