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
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);

            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getListLuuTru(String maKho, String maLHH, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGTONTONG", "DONGIATONG"};
        String sql = "SELECT TENHH, SUM(SOLUONGTON) AS SOLUONGTONTONG, AVG(DONGIA) AS DONGIATONG "
                + "FROM V_LUU_TRU "
                + "WHERE MAKHO LIKE ? AND MALHH LIKE ? GROUP BY TENHH";

        if (keyword.length() > 0) {
            sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + keyword + "%");
        }
        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%");
    }

    
    
    public List<Object[]> getListNhap(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGNHAP", "SLNHAPTB", "GIANHAPTB", "TONGGIATRINHAP"};
        String sql = "SELECT TENHH, SUM(SOLUONGNHAP) AS SOLUONGNHAP, AVG(SLNHAPTB) AS SLNHAPTB, AVG(GIANHAPTB) AS GIANHAPTB, SUM(TONGGIATRINHAP) AS TONGGIATRINHAP FROM V_HANG_NHAP "
                + "WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM LIKE ? AND THANG LIKE ? "
                + "GROUP BY TENHH";

        if (keyword.length() > 0) {
             sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + nam + "%", "%" + thang + "%", "%" + keyword + "%");
        }

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + nam + "%", "%" + thang + "%");
    }

    public List<Object[]> getListXuat(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) {
        String[] cols = {"TENHH", "SOLUONGXUAT", "SLXUATTB", "GIAXUATTB", "TONGGIATRIXUAT"};
        String sql = "SELECT TENHH, SUM(SOLUONGXUAT) AS SOLUONGXUAT, AVG(SLXUATTB) AS SLXUATTB, AVG(GIAXUATTB) AS GIAXUATTB, SUM(TONGGIATRIXUAT) AS TONGGIATRIXUAT FROM V_HANG_XUAT "
                + "WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM LIKE ? AND THANG LIKE ?"
                + " GROUP BY TENHH";

        if (keyword.length() > 0) {
            sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + nam + "%", "%" + thang + "%", "%" + keyword + "%");
        }

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + nam + "%", "%" + thang + "%");
    }

    public List<Object[]> getListTongHop(String maKho, int nam, String keyword, Integer index) {
        String[] cols = {"THANG", "XUATTRONGTHANG", "TONGGTXUAT", "NHAPTRONGTHANG", "TONGGTNHAP", "TONGGTXUATNHAP"};
        String sql = "SELECT THANG, SUM(XUATTRONGTHANG) AS XUATTRONGTHANG, SUM(TONGGTXUAT) AS TONGGTXUAT, "
                    + "SUM(NHAPTRONGTHANG) AS NHAPTRONGTHANG, SUM(TONGGTNHAP) AS TONGGTNHAP, "
                    + "SUM(TONGGTXUATNHAP) AS TONGGTXUATNHAP FROM V_TONGHOP "
                    + "WHERE MAKHO LIKE ? AND NAM LIKE ? "
                    + "GROUP BY THANG";

        if (keyword.length() > 0) {
            sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + nam + "%", "%" + keyword + "%");
        }

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + nam + "%");
    }

    public List<Object[]> getListTongQuan(Integer nam) {
        String[] cols = {"THANG", "TONGLUONGXUAT", "TONGLUONGNHAP", "NAM"};
        String sql = "SELECT * FROM V_NHAP_XUAT WHERE NAM = ?";

        return this.getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getListThangNhap(Integer nam) {
        String[] cols = {"THANG"};
        String sql = "SELECT DISTINCT THANG FROM V_HANG_NHAP WHERE NAM = ? ORDER BY THANG";

        return this.getListOfArray(sql, cols, nam);
    }
    
    public List<Object[]> getListNamTQ() {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_NHAP_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
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

    public List<Object[]> getListNamNhapXuat() {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_NHAP_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListTongLuongSP() {
        String[] cols = {"TONGLUONGSP"};
        String sql = "SELECT SUM(SOLUONG) AS TONGLUONGSP FROM LUUTRU ";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListNamTongHop() {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_NHAP_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }
}
