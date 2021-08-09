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
public class DoiTacDAO extends StoManDAO<DoiTac, Integer> {

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
        List<DoiTac> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
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
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<DoiTac> selectByKeyword(Integer maLDT, String keyword, int index) {
        String header[] = {"TENDT", "DIACHI", "EMAIL", "SODT", "VAITRO"};
        if (header[index].equalsIgnoreCase("VAITRO")) {
            if (("NHÀ PHÂN PHỐI").contains(keyword.toUpperCase())) {
                keyword = "1";
            } else if (("KHÁCH HÀNG").contains(keyword.toUpperCase())) {
                keyword = "0";
            }
        }
        String sql = "SELECT * FROM DOITAC WHERE MALDT = ? AND " + header[index] + " LIKE ?";
        return this.selectBySQL(sql, maLDT, "%" + keyword + "%");
    }
    
    public List<DoiTac> selectByLoaiDT(Integer maLDT) {
        String sql = "SELECT * FROM DOITAC WHERE MALDT = ?";
        return this.selectBySQL(sql, maLDT);
    }

    public List<DoiTac> selectByLoaiDTandVaiTro(Integer maLDT, boolean vaiTro) {
        String sql = "SELECT * FROM DOITAC WHERE MALDT = ? AND VAITRO = ?";
        return this.selectBySQL(sql, maLDT, vaiTro);
    }

    public String getTenDT(int maDT) {
        String sql = "SELECT TENDT FROM DOITAC WHERE MADT = ?";
        return (String) XJdbc.value(sql, maDT);
    }
    
}
