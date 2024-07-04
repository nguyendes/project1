/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iChiTietKhuyenMai;
import Interface.iKhuyenMai;
import exceptions.dbexception;
import exceptions.khuyenmaiexception;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietKM;
import model.KhuyenMai;

/**
 *
 * @author maytinh
 */
public class KhuyenMaiService implements iChiTietKhuyenMai,iKhuyenMai{

    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(KhuyenMaiService.class.getName());

    public KhuyenMaiService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    // ChiTietKhuyenMai Methods
    @Override
    public List<ChiTietKM> getAllCTKM() {
        List<ChiTietKM> ctkmList = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietKhuyenMai";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                ChiTietKM ctkm = new ChiTietKM();
                ctkm.setMaKM(rs.getString("MaKM"));
                ctkm.setMaSP(rs.getString("MaSP"));
                ctkm.setNgayBatDau(rs.getDate("NgayBatDau"));
                ctkm.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                ctkm.setTiLeGiam(rs.getInt("TiLeGiam"));
                ctkm.setGiamToiDa(rs.getDouble("GiamToiDa"));
                ctkmList.add(ctkm);
            }
            logger.log(Level.INFO, "Load chi tiết khuyến mãi thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load chi tiết khuyến mãi thất bại", e);
            throw new dbexception("Lỗi khi lấy danh sách chi tiết khuyến mãi", e);
        }
        return ctkmList;
    }

    @Override
    public int them(ChiTietKM ctkm) {
        String sql = "INSERT INTO ChiTietKhuyenMai (MaKM, MaSP, GiamGia) VALUES (?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctkm.getMaKM());
            pre.setString(2, ctkm.getMaSP());
            pre.setDate(3, new java.sql.Date(ctkm.getNgayBatDau().getTime()));
            pre.setDate(4, new java.sql.Date(ctkm.getNgayKetThuc().getTime()));
            pre.setInt(5, ctkm.getTiLeGiam());
            pre.setDouble(6, ctkm.getGiamToiDa());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm chi tiết khuyến mãi mới: {0}", ctkm.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm chi tiết khuyến mãi", e);
            throw new khuyenmaiexception("Lỗi khi thêm chi tiết khuyến mãi", e);
        }
    }

    @Override
    public int capnhat(ChiTietKM ctkm) {
        String sql = "UPDATE ChiTietKhuyenMai SET GiamGia = ? WHERE MaKM = ? AND MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setDouble(1, ctkm.getGiamToiDa());
            pre.setString(2, ctkm.getMaKM());
            pre.setString(3, ctkm.getMaSP());
            pre.setDate(2, new java.sql.Date(ctkm.getNgayBatDau().getTime()));
            pre.setDate(3, new java.sql.Date(ctkm.getNgayKetThuc().getTime()));
            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật chi tiết khuyến mãi: {0}", ctkm.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật chi tiết khuyến mãi", e);
            throw new khuyenmaiexception("Lỗi khi cập nhật chi tiết khuyến mãi", e);
        }
    }

    @Override
    public int xoa(ChiTietKM ctkm) {
        String sql = "DELETE FROM ChiTietKhuyenMai WHERE MaKM = ? AND MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctkm.getMaKM());
            pre.setString(2, ctkm.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa chi tiết khuyến mãi: {0}", ctkm.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa chi tiết khuyến mãi", e);
            throw new khuyenmaiexception("Lỗi khi xóa chi tiết khuyến mãi", e);
        }
    }

    // KhuyenMai Methods
    @Override
    public List<KhuyenMai> getAllKM() {
        List<KhuyenMai> kmList = new ArrayList<>();
        String sql = "SELECT * FROM KhuyenMai";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString("MaKM"));
                km.setTenKM(rs.getString("TenKM"));
                kmList.add(km);
            }
            logger.log(Level.INFO, "Load khuyến mãi thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load khuyến mãi thất bại", e);
            throw new khuyenmaiexception("Lỗi khi lấy danh sách khuyến mãi", e);
        }
        return kmList;
    }

    @Override
    public int them(KhuyenMai km) {
        String sql = "INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, km.getMaKM());
            pre.setString(2, km.getTenKM());
            
            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm khuyến mãi mới: {0}", km.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm khuyến mãi", e);
            throw new khuyenmaiexception("Lỗi khi thêm khuyến mãi", e);
        }
    }

    @Override
    public int capnhat(KhuyenMai km) {
        String sql = "UPDATE KhuyenMai SET TenKM = ?, NgayBatDau = ?, NgayKetThuc = ? WHERE MaKM = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, km.getTenKM());
            pre.setString(4, km.getMaKM());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật khuyến mãi: {0}", km.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật khuyến mãi", e);
            throw new khuyenmaiexception("Lỗi khi cập nhật khuyến mãi", e);
        }
    }

    @Override
    public int xoa(KhuyenMai km) {
        String sql = "DELETE FROM KhuyenMai WHERE MaKM = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, km.getMaKM());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa khuyến mãi: {0}", km.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa khuyến mãi", e);
            throw new khuyenmaiexception("Lỗi khi xóa khuyến mãi", e);
        }
    }
}
