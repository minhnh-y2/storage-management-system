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
public class LoaiHangHoa {
    private int maLHH;
    private String tenLHH;

    public LoaiHangHoa() {
    }

    public LoaiHangHoa(String tenLHH) {
        this.tenLHH = tenLHH;
    }
    
    @Override
    public String toString() {
        return this.tenLHH;
    }
    
    @Override
    public boolean equals(Object obj) {
        LoaiHangHoa other = (LoaiHangHoa) obj;
        return other.getMaLHH() == this.getMaLHH();
    }

    public int getMaLHH() {
        return maLHH;
    }

    public void setMaLHH(int maLHH) {
        this.maLHH = maLHH;
    }

    public String getTenLHH() {
        return tenLHH;
    }

    public void setTenLHH(String tenLHH) {
        this.tenLHH = tenLHH;
    }
    
}
