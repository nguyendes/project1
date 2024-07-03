/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;
import model.ChiTietKM;

/**
 *
 * @author maytinh
 */
public interface iChiTietKhuyenMai {
    List<ChiTietKM> getAllCTKM();
    int them(ChiTietKM ctkm);
    int capnhat(ChiTietKM ctkm);
    int xoa(ChiTietKM ctkm);
}
