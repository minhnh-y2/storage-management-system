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
public class HangHoa {
    private int maHH;
    private String tenHH;
    private Double donGia;
    private String donViTinh;
    private String maLHH;

    public HangHoa(int maHH, String tenHH, Double donGia, String donViTinh, String maLHH) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.maLHH = maLHH;
    }

    public int getMaHH() {
        return maHH;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMaLHH() {
        return maLHH;
    }

    public void setMaLHH(String maLHH) {
        this.maLHH = maLHH;
    }
    
}
