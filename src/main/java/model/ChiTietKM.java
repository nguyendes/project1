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
public class ChiTietKM {
    private String MaKM;
    private String MaSP;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private int TiLeGiam;
    private double GiamToiDa;

    public ChiTietKM() {
    }

    public ChiTietKM(String MaKM, String MaSP, Date NgayBatDau, Date NgayKetThuc, int TiLeGiam, double GiamToiDa) {
        this.MaKM = MaKM;
        this.MaSP = MaSP;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TiLeGiam = TiLeGiam;
        this.GiamToiDa = GiamToiDa;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
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

    @Override
    public String toString() {
        return "ChiTietKM{" + "MaKM=" + MaKM + ", MaSP=" + MaSP + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", TiLeGiam=" + TiLeGiam + ", GiamToiDa=" + GiamToiDa + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.getMaKM(),this.getMaSP(),this.getNgayBatDau(),this.getNgayKetThuc(),this.getTiLeGiam(),this.getGiamToiDa()};
    }
}
