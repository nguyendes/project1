/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author maytinh
 */
public class DonHang {
    private String MaDH;
    private String MaNV;
    private String MaKH;
    private Date Ngay;
    private double TongTien;

    public DonHang() {
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public DonHang(String MaDH, String MaNV, String MaKH, Date Ngay, double TongTien) {
        this.MaDH = MaDH;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.Ngay = Ngay;
        this.TongTien = TongTien;
    }

    @Override
    public String toString() {
        return "DonHang{" + "MaDH=" + MaDH + ", MaNV=" + MaNV + ", MaKH=" + MaKH + ", Ngay=" + Ngay + ", TongTien=" + TongTien + '}';
    }
    public Object[] toDataRow(){
        return new Object[]{this.getMaDH(),this.getMaNV(),this.getMaKH(),this.getNgay(),this.getTongTien()};
    }
    
}
