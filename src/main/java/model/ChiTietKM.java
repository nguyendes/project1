/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class ChiTietKM {
    private String MaKM;
    private String TenKM; // Thêm thuộc tính này
    private String MaSP;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private int TiLeGiam;
    private double GiamToiDa;

    // Các phương thức getter và setter
    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getTiLeGiam() {
        return TiLeGiam;
    }

    public void setTiLeGiam(int TiLeGiam) {
        this.TiLeGiam = TiLeGiam;
    }

    public double getGiamToiDa() {
        return GiamToiDa;
    }

    public void setGiamToiDa(double GiamToiDa) {
        this.GiamToiDa = GiamToiDa;
    }

    public Object[] toDataRow() {
        return new Object[]{MaKM, TenKM, MaSP, NgayBatDau, NgayKetThuc, TiLeGiam, GiamToiDa};
    }
}
