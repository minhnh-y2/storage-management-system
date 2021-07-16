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
    private Date ngayLap = new Date();
    private boolean loai = true;
    private boolean trangThai = true;
    private Date NgThucHien;
    private Date NgHoanThanh;
    private int maDT;
    private String maNV;
    private String ghiChu;

    public Phieu() {
    }

    public Phieu(Integer maPhieu, Date NgThucHien, Date NgHoanThanh, int maDT, String maNV, String ghiChu) {
        this.maPhieu = maPhieu;
        this.NgThucHien = NgThucHien;
        this.NgHoanThanh = NgHoanThanh;
        this.maDT = maDT;
        this.maNV = maNV;
        this.ghiChu = ghiChu;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
