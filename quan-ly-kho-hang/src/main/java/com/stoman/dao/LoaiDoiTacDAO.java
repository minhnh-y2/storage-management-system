/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.entity.LoaiDoiTac;
import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class LoaiDoiTacDAO extends StoManDAO<LoaiDoiTac, Integer>{

    @Override
    public void insert(LoaiDoiTac entity) {
        String sql = "INSERT INTO LOAIDOITAC (TENLDT) VALUES (?)";
        XJdbc.update(sql,
                entity.getTenLDT());
    }

    @Override
    public void update(LoaiDoiTac entity) {
        String sql = "UPDATE LOAIDOITAC SET TENLDT=? WHERE MALDT=?";
        XJdbc.update(sql,
                entity.getTenLDT(),
                entity.getMaLDT());
    }

    @Override
    public void delete(Integer key) {
        String sql = "DELETE FROM LOAIDOITAC WHERE MALDT = ?";
        XJdbc.update(sql, key);
    }

    @Override
    public List<LoaiDoiTac> selectAll() {
        String sql = "SELECT * FROM LOAIDOITAC";
        return selectBySQL(sql);
    }

    @Override
    public LoaiDoiTac selectByID(Integer key) {
        String sql = "SELECT * FROM LOAIDOITAC WHERE MALDT = ?";
        List<LoaiDoiTac> list = this.selectBySQL(sql, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiDoiTac> selectBySQL(String sql, Object... args) {
        List<LoaiDoiTac> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    LoaiDoiTac entity = new LoaiDoiTac();
                    
                    entity.setMaLDT(rs.getInt("MALDT"));
                    entity.setTenLDT(rs.getString("TENLDT"));
                    
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
    
    public List<LoaiDoiTac> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM LOAIDOITAC WHERE TENLDT LIKE ?";
        return this.selectBySQL(sql, "%" + keyword + "%");
    }

    public List<LoaiDoiTac> selectLDTonVaiTro(boolean loai) {
        String sql = "SELECT LDT.MALDT, TENLDT FROM LOAIDOITAC LDT INNER JOIN DOITAC DT ON LDT.MALDT = DT.MALDT WHERE VAITRO = ? GROUP BY LDT.MALDT, TENLDT";
        return this.selectBySQL(sql, loai);
    }
}
