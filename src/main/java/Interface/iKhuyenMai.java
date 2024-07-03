/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.KhuyenMai;

/**
 *
 * @author maytinh
 */
public interface iKhuyenMai {
     List<KhuyenMai> getAllKM();
    int them(KhuyenMai km);
    int capnhat(KhuyenMai km);
    int xoa(KhuyenMai km);
}
