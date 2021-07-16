/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.HangHoa;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class HangHoaDAO extends StoManDAO<HangHoa, String>{

    @Override
    public void insert(HangHoa entity) {
        String sql = "INSERT INTO HANGHOA (MAHH, TENHH, DONGIA, DONVITINH, MALHH) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                entity.getMaHH(),
                entity.getTenHH(),
                entity.getDonGia(),
                entity.getDonViTinh(),
                entity.getMaLHH());
    }

    @Override
    public void update(HangHoa entity) {
        String sql = "UPDATE HANGHOA SET TENHH=?, DONGIA=?, DONVITINH=?, MALHH=? WHERE MAHH=?";
        XJdbc.update(sql,
                entity.getTenHH(),
                entity.getDonGia(),
                entity.getDonViTinh(),
                entity.getMaLHH(),
                entity.getMaHH());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM HANGHOA WHERE MAHH = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<HangHoa> selectAll() {
        String sql = "SELECT * FROM HANGHOA";
        return selectBySQL(sql);
    }

    @Override
    public HangHoa selectByID(String key) {
        String sql = "SELECT * FROM HANGHOA WHERE MAHH = ?";
        List<HangHoa> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HangHoa> selectBySQL(String sql, Object... args) {
        List<HangHoa> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    HangHoa entity = new HangHoa();
                    entity.setMaHH(rs.getString("MAHH"));
                    entity.setTenHH(rs.getString("TENHH"));
                    entity.setDonGia(rs.getDouble("DONGIA"));
                    entity.setDonViTinh(rs.getString("DONVITINH"));
                    entity.setMaLHH(rs.getInt("MALHH"));
                    
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
    
    public List<HangHoa> selectByKeyword(Integer maLHH, String keyword) {
        String sql = "SELECT * FROM HANGHOA WHERE MALHH = ? AND TENHH LIKE ?";
        return this.selectBySQL(sql, maLHH, "%" + keyword + "%");
    }
    
    public List<HangHoa> selectByLoaiHangHoa(Integer maLHH) {
        String sql = "SELECT * FROM HANGHOA WHERE MALHH = ?";
        return this.selectBySQL(sql, maLHH);
    }

}
