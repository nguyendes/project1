/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maytinh
 */
public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String ChucVu;
    private String Email;
    private String SDT;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, String ChucVu, String Email, String SDT) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.ChucVu = ChucVu;
        this.Email = Email;
        this.SDT = SDT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
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
        return "NhanVien{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + ", ChucVu=" + ChucVu + ", Email=" + Email + ", SDT=" + SDT + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.getMaNV(),this.getTenNV(),this.getChucVu(),this.getEmail(),this.getSDT()};
    }
}
