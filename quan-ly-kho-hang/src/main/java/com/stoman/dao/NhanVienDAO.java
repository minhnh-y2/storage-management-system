/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.NhanVien;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class NhanVienDAO extends StoManDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NHANVIEN (MANV, TENNV, VAITRO, MATKHAU, MUOI) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getMaNV(),
                entity.getTenNV(),
                entity.isVaiTRo(),
                entity.getMatKhau(),
                entity.getMuoi());
    }

    @Override
    public void update(NhanVien entity) {
        String sql = "UPDATE NHANVIEN SET TENNV=?, VAITRO=?, MATKHAU=?, MUOI=? WHERE MANV=?";
        XJdbc.update(sql,
                entity.getTenNV(),
                entity.isVaiTRo(),
                entity.getMatKhau(),
                entity.getMuoi(),
                entity.getMaNV());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM NHANVIEN";
        return selectBySQL(sql);
    }

    @Override
    public NhanVien selectByID(String key) {
        String sql = "SELECT * FROM NHANVIEN WHERE MANV = ?";
        List<NhanVien> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien entity = new NhanVien();
                    
                    entity.setMaNV(rs.getString("MANV"));
                    entity.setTenNV(rs.getString("TENNV"));
                    entity.setVaiTRo(rs.getBoolean("VAITRO"));
                    entity.setMatKhau(rs.getString("MATKHAU"));
                    entity.setMuoi(rs.getString("MUOI"));

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
    
}