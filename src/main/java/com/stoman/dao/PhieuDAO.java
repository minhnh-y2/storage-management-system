/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.Phieu;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Huy
 */
public class PhieuDAO extends StoManDAO<Phieu, Integer>{

    @Override  
    public void insert(Phieu entity) {
        String sql = "INSERT INTO PHIEU (NGAYLAP, LOAI, TRANGTHAI, NGTHUCHIEN, NGHOANTHANH, GHICHU, MADT, TINHTRANGTT, SOTIENDATHANHTOAN, MANV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getNgayLap(),
                entity.isLoai(),
                entity.isTrangThai(),
                entity.getNgThucHien(),
                entity.getNgHoanThanh(),
                entity.getGhiChu(),
                entity.getMaDT(),
                entity.isTinhTrangThanhToan(),
                entity.getSoTienThanhToan(),
                entity.getMaNV());
    }

    @Override   
    public void update(Phieu entity) {
        String sql = "UPDATE PHIEU SET NGAYLAP=?, LOAI=?, TRANGTHAI=?, NGTHUCHIEN=?, NGHOANTHANH=?, GHICHU=?, MADT=?, TINHTRANGTT = ?, SOTIENDATHANHTOAN = ?, MANV=?  WHERE MAPHIEU=?";
        XJdbc.update(sql,
                entity.getNgayLap(),
                entity.isLoai(),
                entity.isTrangThai(),
                entity.getNgThucHien(),
                entity.getNgHoanThanh(),
                entity.getGhiChu(),
                entity.getMaDT(),
                entity.isTinhTrangThanhToan(),
                entity.getSoTienThanhToan(),
                entity.getMaNV(),
                entity.getMaPhieu());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM PHIEU WHERE MAPHIEU = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<Phieu> selectAll() {
        String sql = "SELECT * FROM PHIEU ORDER BY MAPHIEU DESC";
        return selectBySQLTest(sql);
    }

    @Override
    public Phieu selectByID(Integer key) {
        String sql = "SELECT * FROM PHIEU WHERE MAPHIEU = ?";
        List<Phieu> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Phieu> selectBySQL(String sql, Object... args) {
        List<Phieu> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    Phieu entity = new Phieu();
                    
                    entity.setMaPhieu(rs.getInt("MAPHIEU"));
                    entity.setNgayLap(rs.getDate("NGAYLAP"));
                    entity.setLoai(rs.getBoolean("LOAI"));
                    entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                    entity.setNgThucHien(rs.getDate("NGTHUCHIEN"));
                    entity.setNgHoanThanh(rs.getDate("NGHOANTHANH"));
                    entity.setGhiChu(rs.getString("GHICHU"));
                    entity.setMaDT(rs.getInt("MADT"));
                    entity.setMaNV(rs.getString("MANV"));
                            
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    protected List<Phieu> selectBySQLTest(String sql, Object... args) {
        List<Phieu> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    Phieu entity = new Phieu();
                    
                    entity.setMaPhieu(rs.getInt("MAPHIEU"));
                    entity.setNgayLap(rs.getDate("NGAYLAP"));
                    entity.setLoai(rs.getBoolean("LOAI"));
                    entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
                    entity.setNgThucHien(rs.getDate("NGTHUCHIEN"));
                    entity.setNgHoanThanh(rs.getDate("NGHOANTHANH"));
                    entity.setGhiChu(rs.getString("GHICHU"));
                    entity.setMaDT(rs.getInt("MADT"));
                    entity.setTinhTrangThanhToan(rs.getBoolean("TINHTRANGTT"));
                    entity.setSoTienThanhToan(rs.getDouble("SOTIENDATHANHTOAN"));
                    entity.setMaDT(rs.getInt("MADT"));
                    entity.setMaNV(rs.getString("MANV"));
                            
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public Integer getMaPhieuByNVandCreatedDate(String MaNV, Date NgayLap){
        String sql = "SELECT * FROM PHIEU WHERE MANV = ? AND NGAYLAP = ?";
        List<Phieu> list = this.selectBySQL(sql, MaNV, NgayLap);
        return list.size() > 0 ? list.get(0).getMaPhieu() : null;
    }
    
    public List<Phieu> selectByLoaiPhieu(boolean loaiPhieu) {
        String sql = "SELECT * FROM PHIEU WHERE LOAI = ? ORDER BY MAPHIEU DESC";
        return selectBySQLTest(sql, loaiPhieu);
    }
}
