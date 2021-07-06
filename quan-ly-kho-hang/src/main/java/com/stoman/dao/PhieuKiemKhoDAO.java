/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.PhieuKiemKho;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class PhieuKiemKhoDAO extends StoManDAO<PhieuKiemKho, Integer> {

    @Override
    public void insert(PhieuKiemKho entity) {
        String sql = "INSERT INTO PHIEUKIEMKHO (NGAYLAP, NGAYKIEM, TRANGTHAI, MANV) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getNgayLap(),
                entity.getNgayKiem(),
                entity.isTrangThai(),
                entity.getMaNV());
    }

    @Override
    public void update(PhieuKiemKho entity) {
        String sql = "UPDATE PHIEUKIEMKHO SET NGAYLAP=?, NGAYKIEM=?, TRANGTHAI=?, MANV=? WHERE MAKK=?";
        XJdbc.update(sql,
                entity.getNgayLap(),
                entity.getNgayKiem(),
                entity.isTrangThai(),
                entity.getMaNV(),
                entity.getMaKK());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE PHIEUKIEMKHO PHIEU WHERE MAKK = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<PhieuKiemKho> selectAll() {
        String sql = "SELECT * FROM PHIEUKIEMKHO";
        return selectBySQL(sql);
    }

    @Override
    public PhieuKiemKho selectByID(Integer key) {
        String sql = "SELECT * FROM PHIEUKIEMKHO WHERE MAKK = ?";
        List<PhieuKiemKho> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuKiemKho> selectBySQL(String sql, Object... args) {
        List<PhieuKiemKho> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    PhieuKiemKho entity = new PhieuKiemKho();
                    
                    entity.setMaKK(rs.getInt("MAKK"));
                    entity.setNgayLap(rs.getDate("NGAYLAP"));
                    entity.setNgayKiem(rs.getDate("NGAYKIEM"));
                    entity.setTrangThai(rs.getBoolean("TRANGTHAI"));
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
    
}
