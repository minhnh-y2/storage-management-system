/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try{
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);

            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
            
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getListLuuTru(String maKho, String maLHH, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGTON", "DONGIA", "MAHH", "MALHH", "MAKHO"};
        String sql = "SELECT * FROM V_LUU_TRU WHERE MAKHO LIKE ? AND MALHH LIKE ?";
        
        
        if(keyword.length()>0){
            sql += " AND " + cols[index] + " LIKE ?";
            System.out.println(sql);
            return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+keyword+"%");
        }
        System.out.println(sql);
        return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%");
    }
    
    public List<Object[]> getListNhap(Integer maKho, Integer maLHH, Integer thang, Integer nam, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGNHAP", "DONGIA", "TONGCONGNHAP", "MAHH", "MALHH", "MAKHO", "THANG", "NAM"};
        String sql = "SELECT * FROM V_HANG_NHAP WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM LIKE ? AND THANG LIKE ?";
        
        
        if(keyword.length()>0){
            sql += " AND " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+nam+"%", "%"+thang+"%", "%"+keyword+"%");
        }
        
        return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+nam+"%", "%"+thang+"%");
    }
    
    public List<Object[]> getListXuat(Integer maKho, Integer maLHH, Integer thang, Integer nam, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGXUAT", "DONGIA", "TONGCONGXUAT", "MAHH", "MALHH", "MAKHO", "THANG", "NAM"};
        String sql = "SELECT * FROM V_HANG_XUAT WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM LIKE ? AND THANG LIKE ?";
        
        
        if(keyword.length()>0){
            sql += " AND " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+nam+"%", "%"+thang+"%", "%"+keyword+"%");
        }
        
        return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+nam+"%", "%"+thang+"%");
    }
    
    public List<Object[]> getListCanCan(int nam) {
        String[] cols = {"THANG", "TONGLUONGXUAT", "TONGLUONGNHAP", "NAM"};
        String sql = "SELECT * FROM V_NHAP_XUAT WHERE NAM = ?";
        
        return this.getListOfArray(sql, cols, nam);
    }
    
    public List<Object[]> getListTongQuan(Integer nam) {
        String[] cols = {"THANG", "TONGCONGXUAT", "TONGCONGNHAP", "CANCAN", "NAM"};
        String sql = "SELECT * FROM V_CAN_CAN WHERE NAM = ?";
        
        return this.getListOfArray(sql, cols, nam);
    }

}
