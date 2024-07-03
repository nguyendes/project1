/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maytinh
 */
public class KhuyenMai {
    private String MaKM;
    private String TenKM;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKM, String TenKM) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
    }

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

    @Override
    public String toString() {
        return "KhuyenMai{" + "MaKM=" + MaKM + ", TenKM=" + TenKM + '}';
    }
    public Object[] toDataRow(){
        return new Object[]{this.getMaKM(),this.getTenKM()};
    }
}
