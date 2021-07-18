/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.ChiTietPhieu;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class ChiTietPhieuDAO extends StoManDAO<ChiTietPhieu, Integer>{

    @Override
    public void insert(ChiTietPhieu entity) {
        String sql = "INSERT INTO CHITIETPHIEU (MAPHIEU, MALT, SOLUONG, DONGIA) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getMaPhieu(),
                entity.getMaLT(),
                entity.getSoLuong(),
                entity.getDonGia());
    }

    @Override
    public void update(ChiTietPhieu entity) {
        String sql = "UPDATE CHITIETPHIEU SET MAPHIEU=?, MALT=?, SOLUONG=?, DONGIA=? WHERE MACTP=?";
        XJdbc.update(sql,
                entity.getMaPhieu(),
                entity.getMaLT(),
                entity.getSoLuong(),
                entity.getDonGia(),
                entity.getMaCTP());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM CHITIETPHIEU WHERE MACTP = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<ChiTietPhieu> selectAll() {
        String sql = "SELECT * FROM CHITIETPHIEU";
        return selectBySQL(sql);
    }

    @Override
    public ChiTietPhieu selectByID(Integer key) {
        String sql = "SELECT * FROM CHITIETPHIEU WHERE MACTP = ?";
        List<ChiTietPhieu> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<ChiTietPhieu> selectBySQL(String sql, Object... args) {
        List<ChiTietPhieu> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    ChiTietPhieu entity = new ChiTietPhieu();
                    
                    entity.setMaCTP(rs.getInt("MACTP"));
                    entity.setMaPhieu(rs.getInt("MAPHIEU"));
                    entity.setMaLT(rs.getInt("MALT"));
                    entity.setSoLuong(rs.getDouble("SOLUONG"));
                    entity.setDonGia(rs.getDouble("DONGIA"));
                    
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
    
    public List<ChiTietPhieu> selectByMaPhieu(Integer maPhieu) {
        String sql = "SELECT * FROM CHITIETPHIEU WHERE MAPHIEU = ?";
        return this.selectBySQL(sql, maPhieu);
    }
    
    public Integer getOnlyOneMaLT(Integer maPhieu) {
        List<ChiTietPhieu> list = this.selectByMaPhieu(maPhieu);
        return list.size()>0?list.get(0).getMaLT():0;
    }
    
}
