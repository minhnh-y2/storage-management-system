/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.entity;

/**
 *
 * @author Huy
 */
public class NhanVien {
    private String maNV;
    private String tenNV;
    private boolean vaiTro;
    private String matKhau;
    private String muoi;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, boolean vaiTro, String matKhau, String muoi) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.muoi = muoi;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isVaiTRo() {
        return vaiTro;
    }

    public void setVaiTRo(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMuoi() {
        return muoi;
    }

    public void setMuoi(String muoi) {
        this.muoi = muoi;
    }
       
}
