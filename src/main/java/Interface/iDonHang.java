/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.DonHang;

/**
 *
 * @author maytinh
 */
public interface iDonHang {
    List<DonHang> getAllDH();
    int them(DonHang dh);
    int capnhat(DonHang dh);
    int xoa(DonHang dh);
}