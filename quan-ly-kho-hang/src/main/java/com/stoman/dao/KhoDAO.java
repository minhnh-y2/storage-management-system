/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.Kho;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class KhoDAO extends StoManDAO<Kho, Integer>{

    @Override
    public void insert(Kho entity) {
        String sql = "INSERT INTO KHO (MAKHO, DIACHI, MATK) VALUES (?, ?, ?)";
        XJdbc.update(sql,
                entity.getMaKho(),
                entity.getDiaChi(),
                entity.getMaTK());
    }

    @Override
    public void update(Kho entity) {
        String sql = "UPDATE KHO SET DIACHI=?, MATK=? WHERE MAKHO=?";
        XJdbc.update(sql,
                entity.getDiaChi(),
                entity.getMaTK(),
                entity.getMaKho());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM KHO WHERE MAKHO = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<Kho> selectAll() {
        String sql = "SELECT * FROM KHO";
        return selectBySQL(sql);
    }

    @Override
    public Kho selectByID(Integer key) {
        String sql = "SELECT * FROM KHO WHERE MAKHO = ?";
        List<Kho> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Kho> selectBySQL(String sql, Object... args) {
        List<Kho> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    Kho entity = new Kho();
                    
                    entity.setMaKho(rs.getInt("MAKHO"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setMaTK(rs.getString("MATK"));
                    
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
    
    public List<Kho> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM KHO WHERE DIACHI LIKE ?";
        return this.selectBySQL(sql, "%" + keyword + "%");
    }
    
}
