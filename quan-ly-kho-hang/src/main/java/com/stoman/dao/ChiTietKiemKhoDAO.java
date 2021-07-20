/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.ChiTietKiemKho;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class ChiTietKiemKhoDAO extends StoManDAO<ChiTietKiemKho, Integer> {

    @Override
    public void insert(ChiTietKiemKho entity) {
        String sql = "INSERT INTO CHITIETKIEMKHO (SOLUONGTON, SOLUONGTHUC, MAKK, MALT) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getSoLuongTon(),
                entity.getSoLuongThuc(),
                entity.getMaKK(),
                entity.getMaLT());
    }

    @Override
    public void update(ChiTietKiemKho entity) {
        String sql = "UPDATE CHITIETKIEMKHO SET SOLUONGTON=?, SOLUONGTHUC=?, MAKK=?, MALT=? WHERE MACTKK=?";
        XJdbc.update(sql,
                entity.getSoLuongTon(),
                entity.getSoLuongThuc(),
                entity.getMaKK(),
                entity.getMaLT(),
                entity.getMaCTKK());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM CHITIETKIEMKHO WHERE MACTKK = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<ChiTietKiemKho> selectAll() {
        String sql = "SELECT * FROM CHITIETKIEMKHO";
        return selectBySQL(sql);
    }

    @Override
    public ChiTietKiemKho selectByID(Integer key) {
        String sql = "SELECT * FROM CHITIETKIEMKHO WHERE MACTKK = ?";
        List<ChiTietKiemKho> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<ChiTietKiemKho> selectBySQL(String sql, Object... args) {
        List<ChiTietKiemKho> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    ChiTietKiemKho entity = new ChiTietKiemKho();
                    
                    entity.setMaCTKK(rs.getInt("MACTKK"));
                    entity.setSoLuongTon(rs.getDouble("SOLUONGTON"));
                    entity.setSoLuongThuc(rs.getDouble("SOLUONGTHUC"));
                    entity.setMaKK(rs.getInt("MALT"));
                    entity.setMaLT(rs.getInt("MAKK"));
                    
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
    
    public List<ChiTietKiemKho> selectByMaPhieu(Integer maPhieu) {
        String sql = "SELECT * FROM CHITIETKIEMKHO WHERE MAKK = ?";
        return this.selectBySQL(sql, maPhieu);
    }
    
    public Integer getOnlyOneMaLT(Integer maPhieu) {
        List<ChiTietKiemKho> list = this.selectByMaPhieu(maPhieu);
        return list.size()>0?list.get(0).getMaLT():0;
    }
}
