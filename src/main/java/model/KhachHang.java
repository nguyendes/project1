/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.logging.Logger;

/**
 *
 * @author maytinh
 */
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String Email;
    private String SDT;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String Email, String SDT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.Email = Email;
        this.SDT = SDT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "MaKH=" + MaKH + ", TenKH=" + TenKH + ", Email=" + Email + ", SDT=" + SDT + '}';
    }
    public Object[] toDataRow(){
        return new Object[]{this.getMaKH(),this.getTenKH(),this.getEmail(),this.getSDT()};
    }
    
    
}
