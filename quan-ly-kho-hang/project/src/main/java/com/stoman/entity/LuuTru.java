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
public class LuuTru {
    private int maLT;
    private int maKho;
    private String maHH;
    private Double soLuong;

    public LuuTru() {
    }

    public LuuTru(int maLT, int maKho, String maHH, Double soLuong) {
        this.maLT = maLT;
        this.maKho = maKho;
        this.maHH = maHH;
        this.soLuong = soLuong;
    }

    public int getMaLT() {
        return maLT;
    }

    public void setMaLT(int maLT) {
        this.maLT = maLT;
    }

    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
