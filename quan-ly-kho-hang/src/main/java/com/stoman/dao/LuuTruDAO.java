/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.LuuTru;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class LuuTruDAO extends StoManDAO<LuuTru, Integer> {

    @Override
    public void insert(LuuTru entity) {
        String sql = "INSERT INTO LUUTRU (MAKHO, MAHH, SOLUONG) VALUES (?, ?, ?)";
        XJdbc.update(sql,
                entity.getMaKho(),
                entity.getMaHH(),
                entity.getSoLuong());    }

    @Override
    public void update(LuuTru entity) {
        String sql = "UPDATE LUUTRU SET MAKHO=?, MAHH=?, SOLUONG=? WHERE MALT=?";
        XJdbc.update(sql,
                entity.getMaKho(),
                entity.getMaHH(),
                entity.getSoLuong(),
                entity.getMaLT());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM LUUTRU WHERE MALT = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<LuuTru> selectAll() {
        String sql = "SELECT * FROM LUUTRU";
        return selectBySQL(sql);
    }

    @Override
    public LuuTru selectByID(Integer key) {
        String sql = "SELECT * FROM LUUTRU WHERE MALT = ?";
        List<LuuTru> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LuuTru> selectBySQL(String sql, Object... args) {
        List<LuuTru> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    LuuTru entity = new LuuTru();
                    
                    entity.setMaLT(rs.getInt("MALT"));
                    entity.setMaHH(rs.getString("MAHH"));
                    entity.setMaKho(rs.getInt("MAKHO"));
                    entity.setSoLuong(rs.getDouble("SOLUONG"));
                    
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
    public int getMaKho(int maLT) {
        String sql = "SELECT MAKHO FROM LUUTRU WHERE MALT = ?";
        return (int) XJdbc.value(sql, maLT);
    }
    
    public List<LuuTru> selectNotInList(Integer maKho, String keyword, Integer index, List<Integer> listCT){
        String[] header = {"MAHH", "TENHH", "DONGIA", "DONVITINH"};
        String sql = "SELECT * FROM LUUTRU WHERE MAKHO LIKE ?";
        
        if(listCT.size()>0){
            sql += " AND MALT NOT IN (";
            for (Integer integer : listCT) {
                sql += ", " + integer;
            }
            sql += ")";
            sql = sql.replaceFirst(", ", "");
        }
        return selectBySQL(sql, maKho);
    }
    
    public double getSoLuong(Integer maKho, String maHH){
        String sql = "SELECT * FROM LUUTRU WHERE MAKHO = ? AND MAHH = ?";
        List<LuuTru> l = this.selectBySQL(sql, maKho, maHH);
        
        return l.size()>0?l.get(0).getSoLuong():-1.0;
    }
    
    
    public Integer getMaLT(Integer maKho, String maHH){
        String sql = "SELECT * FROM LUUTRU WHERE MAKHO = ? AND MAHH = ?";
        List<LuuTru> l = this.selectBySQL(sql, maKho, maHH);
        
        return l.size()>0?l.get(0).getMaLT():0;
    }
    
}
