/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author maytinh
 */
public interface iKhachHang {
    List<KhachHang> getAllKH();
    int them(KhachHang kh);
    int capnhat(KhachHang kh);
    int xoa(KhachHang kh);
}
