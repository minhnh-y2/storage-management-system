/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.DoiTac;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class DoiTacDAO extends StoManDAO<DoiTac, Integer>{

    @Override
    public void insert(DoiTac entity) {
        String sql = "INSERT INTO DOITAC (TENDT, DIACHI, EMAIL, SODT, VAITRO, MALDT) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getTenDT(),
                entity.getDiaChi(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.isVaiTro(),
                entity.getMaLDT());
    }

    @Override
    public void update(DoiTac entity) {
        String sql = "UPDATE DOITAC SET TENDT=?, DIACHI=?, EMAIL=?, SODT=?, VAITRO=?, MALDT=? WHERE MADT=?";
        XJdbc.update(sql,
                entity.getTenDT(),
                entity.getDiaChi(),
                entity.getEmail(),
                entity.getSoDT(),
                entity.isVaiTro(),
                entity.getMaLDT(),
                entity.getMaDT());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM DOITAC WHERE MADT = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<DoiTac> selectAll() {
        String sql = "SELECT * FROM DOITAC";
        return selectBySQL(sql);
    }

    @Override
    public DoiTac selectByID(Integer key) {
        String sql = "SELECT * FROM DOITAC WHERE MADT = ?";
        List<DoiTac> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<DoiTac> selectBySQL(String sql, Object... args) {
        List<DoiTac> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    DoiTac entity = new DoiTac();
                    
                    entity.setMaDT(rs.getInt("MADT"));
                    entity.setTenDT(rs.getString("TENDT"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setEmail(rs.getString("EMAIL"));
                    entity.setSoDT(rs.getString("SODT"));
                    entity.setVaiTro(rs.getBoolean("VAITRO"));
                    entity.setMaLDT(rs.getInt("MALDT"));

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
    
    public List<DoiTac> selectByKeyword(Integer maLDT, String keyword) {
        String sql = "SELECT * FROM DOITAC WHERE MaLDT = ? AND TenDT LIKE ?";
        return this.selectBySQL(sql, maLDT, "%" + keyword + "%");
    }
    
}
