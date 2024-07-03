/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maytinh
 */
public class ChiTietDonHang {
    private String MaDH;
    private String MaSP;
    private double GiaBan;
    private int SoLuong;
    private String MaKM;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String MaDH, String MaSP, double GiaBan, int SoLuong, String MaKM) {
        this.MaDH = MaDH;
        this.MaSP = MaSP;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.MaKM = MaKM;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    @Override
    public String toString() {
        return "ChiTietDonHang{" + "MaDH=" + MaDH + ", MaSP=" + MaSP + ", GiaBan=" + GiaBan + ", SoLuong=" + SoLuong + ", MaKM=" + MaKM + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.getMaDH(),this.getMaSP(),this.getGiaBan(),this.getSoLuong(),this.getMaKM()};
    }
}
