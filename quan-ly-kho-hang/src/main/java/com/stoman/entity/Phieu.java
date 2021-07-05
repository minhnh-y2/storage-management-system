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
public class Phieu {
    private Integer maPhieu;
    private Date ngayLap;
    private boolean loai;
    private boolean trangThai;
    private Date NgThucHien;
    private Date NgHoanThanh;
    private int maDT;
    private String maNV;

    public Phieu(Integer maPhieu, Date ngayLap, boolean loai, boolean trangThai, Date NgThucHien, Date NgHoanThanh, int maDT, String maNV) {
        this.maPhieu = maPhieu;
        this.ngayLap = ngayLap;
        this.loai = loai;
        this.trangThai = trangThai;
        this.NgThucHien = NgThucHien;
        this.NgHoanThanh = NgHoanThanh;
        this.maDT = maDT;
        this.maNV = maNV;
    }

    public Integer getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(Integer maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public boolean isLoai() {
        return loai;
    }

    public void setLoai(boolean loai) {
        this.loai = loai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgThucHien() {
        return NgThucHien;
    }

    public void setNgThucHien(Date NgThucHien) {
        this.NgThucHien = NgThucHien;
    }

    public Date getNgHoanThanh() {
        return NgHoanThanh;
    }

    public void setNgHoanThanh(Date NgHoanThanh) {
        this.NgHoanThanh = NgHoanThanh;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}
