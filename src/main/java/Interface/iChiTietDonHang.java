/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.ChiTietDonHang;

/**
 *
 * @author maytinh
 */
public interface iChiTietDonHang {
    List<ChiTietDonHang> getAllCTDH();
    int them(ChiTietDonHang ctdh);
    int capnhat(ChiTietDonHang ctdh);
    int xoa(ChiTietDonHang ctdh);
}

