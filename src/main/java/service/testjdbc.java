/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


/**
 *
 * @author maytinh
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testjdbc {
    public static void main(String[] args) {
        try {
            DatabaseConnectionManager dcm = new DatabaseConnectionManager();
            try (Connection cnt = dcm.getConnection();
                 PreparedStatement pre = cnt.prepareStatement("SELECT * FROM NhanVien");
                 ResultSet rss = pre.executeQuery()) {

                while (rss.next()) {
                    System.out.println(rss.getInt(1) + " " + rss.getString(2)+rss.getString(3));
                }
                System.out.println("done");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

