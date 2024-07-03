/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.SanPham;

/**
 *
 * @author maytinh
 */
public interface iSanPham {
 
    List<SanPham> getAllSP();
    int them(SanPham sp);
    int capnhat(SanPham sp);
    int xoa(SanPham sp);
}

