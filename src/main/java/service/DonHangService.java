/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iChiTietDonHang;
import Interface.iDonHang;
import exceptions.ChiTietDonHangException;
import exceptions.DonHangException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import model.ChiTietDonHang;
import model.DonHang;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maytinh
 */
public class DonHangService implements iChiTietDonHang, iDonHang {

    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(DonHangService.class.getName());

    public DonHangService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    // ChiTietDonHang Methods
    @Override
    public List<ChiTietDonHang> getAllCTDH() {
        List<ChiTietDonHang> ctdhList = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietDonHang";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                ChiTietDonHang ctdh = new ChiTietDonHang();
                ctdh.setMaDH(rs.getString("MaDH"));
                ctdh.setMaSP(rs.getString("MaSP"));
                ctdh.setSoLuong(rs.getInt("SoLuong"));
                ctdh.setGiaBan(rs.getDouble("GiaBan"));
                ctdh.setMaKM(rs.getString("MaKM"));
                ctdhList.add(ctdh);
            }
            logger.log(Level.INFO, "Load chi tiết đơn hàng thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load chi tiết đơn hàng thất bại", e);
            throw new ChiTietDonHangException("Lỗi khi lấy danh sách chi tiết đơn hàng", e);
        }
        return ctdhList;
    }

    @Override
    public int them(ChiTietDonHang ctdh) {
        String sql = "INSERT INTO ChiTietDonHang (MaDH, MaSP, SoLuong, GiaBan, MaKM) VALUES (?, ?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctdh.getMaDH());
            pre.setString(2, ctdh.getMaSP());
            pre.setInt(3, ctdh.getSoLuong());
            pre.setDouble(4, ctdh.getGiaBan());
            pre.setString(5, ctdh.getMaKM());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm chi tiết đơn hàng mới: {0}", ctdh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm chi tiết đơn hàng", e);
            throw new ChiTietDonHangException("Lỗi khi thêm chi tiết đơn hàng", e);
        }
    }

    @Override
    public int capnhat(ChiTietDonHang ctdh) {
        String sql = "UPDATE ChiTietDonHang SET SoLuong = ?, GiaBan = ?, MaKM = ? WHERE MaDH = ? AND MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setInt(1, ctdh.getSoLuong());
            pre.setDouble(2, ctdh.getGiaBan());
            pre.setString(3, ctdh.getMaKM());
            pre.setString(4, ctdh.getMaDH());
            pre.setString(5, ctdh.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật chi tiết đơn hàng: {0}", ctdh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật chi tiết đơn hàng", e);
            throw new ChiTietDonHangException("Lỗi khi cập nhật chi tiết đơn hàng", e);
        }
    }

    @Override
    public int xoa(ChiTietDonHang ctdh) {
        String sql = "DELETE FROM ChiTietDonHang WHERE MaDH = ? AND MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctdh.getMaDH());
            pre.setString(2, ctdh.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa chi tiết đơn hàng: {0}", ctdh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa chi tiết đơn hàng", e);
            throw new ChiTietDonHangException("Lỗi khi xóa chi tiết đơn hàng", e);
        }
    }

    // DonHang Methods
    @Override
    public List<DonHang> getAllDH() {
        List<DonHang> dhList = new ArrayList<>();
        String sql = "SELECT * FROM DonHang";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMaDH(rs.getString("MaDH"));
                dh.setNgay(rs.getDate("NgayLap"));
                dh.setMaKH(rs.getString("MaKH"));
                dh.setTongTien(rs.getDouble("TongTien"));
                dhList.add(dh);
            }
            logger.log(Level.INFO, "Load đơn hàng thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load đơn hàng thất bại", e);
            throw new DonHangException("Lỗi khi lấy danh sách đơn hàng", e);
        }
        return dhList;
    }

    @Override
    public int them(DonHang dh) {
        String sql = "INSERT INTO DonHang (MaDH, NgayLap, MaKH, TongTien) VALUES (?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, dh.getMaDH());
            pre.setDate(2, new java.sql.Date(dh.getNgay().getTime()));
            pre.setString(3, dh.getMaKH());
            pre.setDouble(4, dh.getTongTien());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm đơn hàng mới: {0}", dh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm đơn hàng", e);
            throw new DonHangException("Lỗi khi thêm đơn hàng", e);
        }
    }

    @Override
    public int capnhat(DonHang dh) {
        String sql = "UPDATE DonHang SET NgayLap = ?, MaKH = ?, TongTien = ? WHERE MaDH = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setDate(1, new java.sql.Date(dh.getNgay().getTime()));
            pre.setString(2, dh.getMaKH());
            pre.setDouble(3, dh.getTongTien());
            pre.setString(4, dh.getMaDH());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật đơn hàng: {0}", dh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật đơn hàng", e);
            throw new DonHangException("Lỗi khi cập nhật đơn hàng", e);
        }
    }

    @Override
    public int xoa(DonHang dh) {
        String sql = "DELETE FROM DonHang WHERE MaDH = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, dh.getMaDH());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa đơn hàng: {0}", dh.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa đơn hàng", e);
            throw new DonHangException("Lỗi khi xóa đơn hàng", e);
        }
    }
}
