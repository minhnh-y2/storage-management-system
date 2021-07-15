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
    private String maHH;
    private String tenHH;
    private Double donGia;
    private String donViTinh;
    private int maLHH;

    public HangHoa() {
    }

    public HangHoa(String maHH, String tenHH, Double donGia, String donViTinh, int maLHH) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.maLHH = maLHH;
    }
    
    @Override
    public String toString() {
        return this.tenHH;
    }
    
    @Override
    public boolean equals(Object obj) {
        HangHoa other = (HangHoa) obj;
        return other.getMaLHH() == this.getMaLHH();
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
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

    public int getMaLHH() {
        return maLHH;
    }

    public void setMaLHH(int maLHH) {
        this.maLHH = maLHH;
    }
    
}
