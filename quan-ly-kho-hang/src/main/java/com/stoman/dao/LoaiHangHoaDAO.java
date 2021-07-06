/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.LoaiHangHoa;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class LoaiHangHoaDAO extends StoManDAO<LoaiHangHoa, String> {

    @Override
    public void insert(LoaiHangHoa entity) {
        String sql = "INSERT INTO LOAIHANGHOA (TENLHH) VALUES (?)";
        XJdbc.update(sql,
                entity.getTenLHH());
    }

    @Override
    public void update(LoaiHangHoa entity) {
        String sql = "UPDATE LOAIHANGHOA SET TENLHH=? WHERE MALHH=?";
        XJdbc.update(sql,
                entity.getTenLHH(),
                entity.getMaLHH());
    }

    @Override
    public void delete(String key) {
        String sql = "DELETE FROM LOAIHANGHOA WHERE MALHH = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<LoaiHangHoa> selectAll() {
        String sql = "SELECT * FROM LOAIHANGHOA";
        return selectBySQL(sql);
    }

    @Override
    public LoaiHangHoa selectByID(String key) {
        String sql = "SELECT * FROM LOAIHANGHOA WHERE MALHH = ?";
        List<LoaiHangHoa> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiHangHoa> selectBySQL(String sql, Object... args) {
        List<LoaiHangHoa> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    LoaiHangHoa entity = new LoaiHangHoa();
                    
                    entity.setMaLHH(rs.getString("MALHH"));
                    entity.setTenLHH(rs.getString("TENLHH"));
                    
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
