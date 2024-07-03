/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author maytinh
 */
public interface iNhanVien {
    
    List<NhanVien> getAllNV();
    int them(NhanVien nv);
    int capnhat(NhanVien nv);
    int xoa(NhanVien nv);
}
