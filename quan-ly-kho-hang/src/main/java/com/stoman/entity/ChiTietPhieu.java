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
public class ChiTietPhieu {
    private int maCTP;
    private int maPhieu;
    private int maLT;
    private double soLuong;
    private double donGia;

    public ChiTietPhieu() {
    }

    public ChiTietPhieu(int maCTP, int maPhieu, int maLT, double soLuong, double donGia) {
        this.maCTP = maCTP;
        this.maPhieu = maPhieu;
        this.maLT = maLT;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaCTP() {
        return maCTP;
    }

    public void setMaCTP(int maCTP) {
        this.maCTP = maCTP;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaLT() {
        return maLT;
    }

    public void setMaLT(int maLT) {
        this.maLT = maLT;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    
}
