/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.entity;

import java.util.Date;

/**
 *
 * @author Huy
 */
public class PhieuKiemKho {
    private int maKK;
    private Date ngayLap = new Date();
    private Date ngayKiem;
    private String ghiChu;
    private boolean trangThai = true;
    private String maNV;

    public PhieuKiemKho() {
    }

    public PhieuKiemKho(int maKK, Date ngayKiem, String ghiChu, String maNV) {
        this.maKK = maKK;
        this.ngayKiem = ngayKiem;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
    }
    
    public int getMaKK() {
        return maKK;
    }

    public void setMaKK(int maKK) {
        this.maKK = maKK;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.ngayLap = NgayLap;
    }

    public Date getNgayKiem() {
        return ngayKiem;
    }

    public void setNgayKiem(Date NgayKiem) {
        this.ngayKiem = NgayKiem;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
