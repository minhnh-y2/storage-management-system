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
    
    public List<Object[]> getListNhap(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGNHAP", "SLNHAPTB", "GIANHAPTB", "TONGGIATRINHAP", "MAHH", "MALHH", "MAKHO", "THANG", "NAM"};
        String sql = "SELECT * FROM V_HANG_NHAP WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM LIKE ? AND THANG LIKE ?";
        
        
        if(keyword.length()>0){
            sql += " AND " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+nam+"%", "%"+thang+"%", "%"+keyword+"%");
        }
        
        return this.getListOfArray(sql, cols, "%"+maKho+"%", "%"+maLHH+"%", "%"+nam+"%", "%"+thang+"%");
    }
    
    public List<Object[]> getListXuat(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGXUAT", "SLXUATTB", "GIAXUATTB", "TONGGIATRIXUAT", "MAHH", "MALHH", "MAKHO", "THANG", "NAM"};
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
    
    public List<Object[]> getListThangNhap(Integer nam) {
        String[] cols = {"THANG"};
        String sql = "SELECT DISTINCT THANG FROM V_HANG_NHAP WHERE NAM = ? ORDER BY THANG";
        
        return this.getListOfArray(sql, cols, nam);
    }
    
    public List<Object[]> getListNamNhap() {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_HANG_NHAP ORDER BY NAM";
        
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getListThangXuat(Integer nam) {
        String[] cols = {"THANG"};
        String sql = "SELECT DISTINCT THANG FROM V_HANG_XUAT WHERE NAM = ? ORDER BY THANG";
        
        return this.getListOfArray(sql, cols, nam);
    }
    
    public List<Object[]> getListNamXuat() {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_HANG_XUAT ORDER BY NAM";
        
        return this.getListOfArray(sql, cols);
    }

}
