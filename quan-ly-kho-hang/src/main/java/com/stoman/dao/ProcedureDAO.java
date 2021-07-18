package com.stoman.dao;

import com.stoman.entity.ChiTietPhieu;
import com.stoman.entity.HangHoa;
import com.stoman.entity.Kho;
import com.stoman.utils.XJdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huy
 */
public class ProcedureDAO {
    public void insertNhap(ChiTietPhieu ctp, int maPhieu, HangHoa hh, Kho kho) {
        String sql = "EXEC SP_NHAPCHITIETPHIEUNHAP ?, ?, ?, ?, ?";
        XJdbc.update(sql,
                maPhieu,
                kho.getMaKho(),
                hh.getMaHH(),
                ctp.getSoLuong(),
                ctp.getDonGia());
    }
    
    public void insertXuat(ChiTietPhieu ctp, int maPhieu, HangHoa hh, Kho kho) {
        String sql = "EXEC SP_NHAPCHITIETPHIEUXUAT ?, ?, ?, ?, ?";
        XJdbc.update(sql,
                maPhieu,
                kho.getMaKho(),
                hh.getMaHH(),
                ctp.getSoLuong(),
                ctp.getDonGia());
    }
    
    public void updateNhap(ChiTietPhieu ctp){
        String sql = "EXEC SP_SUACHITIETPHIEUNHAP ?, ?, ?";
        XJdbc.update(sql,
                ctp.getMaCTP(),
                ctp.getSoLuong(),
                ctp.getDonGia());
    }
    
    public void updateXuat(ChiTietPhieu ctp){
        String sql = "EXEC SP_SUACHITIETPHIEUXUAT ?, ?, ?";
        XJdbc.update(sql,
                ctp.getMaCTP(),
                ctp.getSoLuong(),
                ctp.getDonGia());
    }
    
    public void deleteNhap(ChiTietPhieu ctp){
        String sql = "EXEC SP_XOACHITIETPHIEUNHAP ?";
        XJdbc.update(sql, ctp.getMaCTP());
    }
    
    public void deleteXuat(ChiTietPhieu ctp){
        String sql = "EXEC SP_XOACHITIETPHIEUXUAT ?";
        XJdbc.update(sql, ctp.getMaCTP());
    }
}
