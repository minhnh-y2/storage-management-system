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
    private String maLT;
    private int maKho;
    private int maHH;
    private Double soLuong;

    public LuuTru(String maLT, int maKho, int maHH, Double soLuong) {
        this.maLT = maLT;
        this.maKho = maKho;
        this.maHH = maHH;
        this.soLuong = soLuong;
    }

    public String getMaLT() {
        return maLT;
    }

    public void setMaLT(String maLT) {
        this.maLT = maLT;
    }

    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
    }

    public int getMaHH() {
        return maHH;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
