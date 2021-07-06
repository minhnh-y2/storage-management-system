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
    private Date NgayLap;
    private Date NgayKiem;
    private boolean trangThai;
    private String maNV;

    public PhieuKiemKho() {
    }

    public PhieuKiemKho(int maKK, Date NgayLap, Date NgayKiem, boolean trangThai, String maNV) {
        this.maKK = maKK;
        this.NgayLap = NgayLap;
        this.NgayKiem = NgayKiem;
        this.trangThai = trangThai;
        this.maNV = maNV;
    }

    public int getMaKK() {
        return maKK;
    }

    public void setMaKK(int maKK) {
        this.maKK = maKK;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public Date getNgayKiem() {
        return NgayKiem;
    }

    public void setNgayKiem(Date NgayKiem) {
        this.NgayKiem = NgayKiem;
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
    
    
}
