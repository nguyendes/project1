/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iLog;
import exceptions.dbexception;
import java.io.IOException;
import java.util.List;
import model.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author maytinh
 */
public class LogService implements  iLog{
    
    
    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(LogService.class.getName());

    public LogService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    @Override
    public List<Log> getAllLog() {
        List<Log> logs = new ArrayList<>();
        String sql = "SELECT * FROM Log";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Log log = new Log();
                log.setId(rs.getInt("ID"));
                log.setActivity(rs.getString("Activity"));
                log.setMaNV(rs.getString("MaNV"));
                log.setNgay(rs.getDate("Ngay"));
                logs.add(log);
            }
            logger.log(Level.INFO, "Tải lịch sử hoạt động");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi lấy lịch sử hoạt động", e);
            throw new dbexception("Lỗi khi lấy lịch sử hoạt động", e);
        }
        return logs;

    }

    @Override
    public int them(Log log) {
        String sql = "INSERT INTO Log (Activity, MaNV, Ngay) VALUES (?, ?, ?)";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, log.getActivity());
            ps.setString(2, log.getMaNV());
            ps.setDate(3, new java.sql.Date(log.getNgay().getTime()));

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Added new log entry: {0}", log.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm lịch sử hoạt động", e);
            return 0;
        }   
    }
    
}
