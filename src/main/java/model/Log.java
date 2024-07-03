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
public class Log {
    private int id;
    private String activity;
    private String MaNV;
    private Date ngay;

    public Log() {
    }

    public Log(int id, String activity, String MaNV, Date ngay) {
        this.id = id;
        this.activity = activity;
        this.MaNV = MaNV;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", activity=" + activity + ", MaNV=" + MaNV + ", ngay=" + ngay + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.getId(),this.getActivity(),this.getMaNV(),this.getNgay()};
    }
}
