/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.dao;

import com.stoman.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) throws SQLException {
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

    }

    public List<Object[]> getListLuuTru(String maKho, String maLHH, String keyword, Integer index) throws SQLException {
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

    public List<Object[]> getListNhap(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) throws SQLException {
        String[] cols = {"TENHH", "SOLUONGNHAP", "SLNHAPTB", "GIANHAPTB", "TONGGIATRINHAP"};
        String sql = "SELECT TENHH, SUM(SOLUONGNHAP) AS SOLUONGNHAP, AVG(SLNHAPTB) AS SLNHAPTB, AVG(GIANHAPTB) AS GIANHAPTB, SUM(TONGGIATRINHAP) AS TONGGIATRINHAP FROM V_HANG_NHAP "
                + "WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM LIKE ? AND THANG LIKE ? "
                + "GROUP BY TENHH";

        if (keyword.length() > 0) {
            sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", nam, "%" + thang + "%", "%" + keyword + "%");
        }

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", nam, "%" + thang + "%");
    }

    public List<Object[]> getListXuat(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) throws SQLException {
        String[] cols = {"TENHH", "SOLUONGXUAT", "SLXUATTB", "GIAXUATTB", "TONGGIATRIXUAT"};
        String sql = "SELECT TENHH, SUM(SOLUONGXUAT) AS SOLUONGXUAT, AVG(SLXUATTB) AS SLXUATTB, AVG(GIAXUATTB) AS GIAXUATTB, SUM(TONGGIATRIXUAT) AS TONGGIATRIXUAT FROM V_HANG_XUAT "
                + "WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM = ? AND THANG LIKE ?"
                + " GROUP BY TENHH";

        if (keyword.length() > 0) {
            sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", nam, "%" + thang + "%", "%" + keyword + "%");
        }

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", nam, "%" + thang + "%");
    }

    public List<Object[]> getListTongHop(String maKho, String maLHH, String thang, String nam, String keyword, Integer index) throws SQLException {
        String[] cols = {"TENHH", "GIATRIXUATNHAP", "GTCHENHLECHTB", "CHENHLECHNHAPXUATTB", "TONGGIATRIXUAT", "TONGGIATRINHAP"};
        String sql = "SELECT TENHH, "
                + "SUM(GIATRIXUATNHAP) AS GIATRIXUATNHAP, "
                + "AVG(GTCHENHLECHTB) AS GTCHENHLECHTB, "
                + "ROUND(AVG(CHENHLECHNHAPXUAT),0) AS CHENHLECHNHAPXUATTB, "
                + "SUM(TONGGIATRIXUAT) AS TONGGIATRIXUAT, "
                + "SUM(TONGGIATRINHAP) AS TONGGIATRINHAP "
                + "FROM V_TONGHOP "
                + "WHERE MAKHO LIKE ? AND MALHH LIKE ? AND NAM = ? AND THANG LIKE ? "
                + "GROUP BY TENHH";

        if (keyword.length() > 0) {
            sql = "SELECT * FROM (" + sql + ") AS BANGPHU WHERE " + cols[index] + " LIKE ?";
            return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", nam, "%" + thang + "%", "%" + keyword + "%");
        }

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", nam, "%" + thang + "%");
    }

    public List<Object[]> getListTongQuan(Integer nam, String kho)  throws SQLException {
        String[] cols = {"THANG", "TONGLUONGXUAT", "TONGLUONGNHAP"};
        String sql = "SELECT THANG, SUM(TONGLUONGXUAT) AS TONGLUONGXUAT, SUM(TONGLUONGNHAP) AS TONGLUONGNHAP "
                + "FROM V_NHAP_XUAT "
                + "WHERE NAM = ? AND MAKHO LIKE ? "
                + "GROUP BY THANG";

        return this.getListOfArray(sql, cols, nam, "%" + kho + "%");
    }

    public List<Object[]> getListThangNhap(Integer nam)  throws SQLException {
        String[] cols = {"THANG"};
        String sql = "SELECT DISTINCT THANG FROM V_HANG_NHAP WHERE NAM = ? ORDER BY THANG";

        return this.getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getListNamTQ() throws SQLException {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_NHAP_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListNamNhap() throws SQLException {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_HANG_NHAP ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListThangXuat(Integer nam) throws SQLException {
        String[] cols = {"THANG"};
        String sql = "SELECT DISTINCT THANG FROM V_HANG_XUAT WHERE NAM = ? ORDER BY THANG";

        return this.getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getListNamXuat() throws SQLException {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_HANG_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListNamNhapXuat() throws SQLException {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_NHAP_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListTongLuongSP() throws SQLException {
        String[] cols = {"TONGLUONGSP"};
        String sql = "SELECT SUM(SOLUONG) AS TONGLUONGSP FROM LUUTRU ";

        return this.getListOfArray(sql, cols);

    }

    public List<Object[]> getListNamTongHop() throws SQLException {
        String[] cols = {"NAM"};
        String sql = "SELECT DISTINCT NAM FROM V_NHAP_XUAT ORDER BY NAM";

        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getListThangTongHop(Integer nam) throws SQLException {
        String[] cols = {"THANG"};
        String sql = "SELECT DISTINCT THANG FROM V_TONGHOP WHERE NAM = ? ORDER BY THANG";

        return this.getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getListTop10LTLHH(String maKho) throws SQLException {
        String[] cols = {"TENLHH", "SOLUONGTON"};
        String sql = "EXEC SP_T10LHHLUUTRU ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%");
    }

    public List<Object[]> getListTop10LTHH(String maKho, String maLHH) throws SQLException {
        String[] cols = {"TENHH", "SOLUONGTON"};
        String sql = "EXEC SP_T10HHLUUTRU ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%");
    }

    public List<Object[]> getListTop10NLHH(String maKho, String thang, String nam) throws SQLException {
        String[] cols = {"TENLHH", "SOLUONGNHAP"};
        String sql = "EXEC SP_T10LHHNHAP ?, ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + thang + "%", nam);
    }

    public List<Object[]> getListTop10NHH(String maKho, String maLHH, String thang, String nam) throws SQLException {
        String[] cols = {"TENHH", "SOLUONGNHAP"};
        String sql = "EXEC SP_T10HHNHAP ?, ?, ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + thang + "%", nam);
    }

    public List<Object[]> getListTop10XLHH(String maKho, String thang, String nam) throws SQLException {
        String[] cols = {"TENLHH", "SOLUONGXUAT"};
        String sql = "EXEC SP_T10LHHXUAT ?, ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + thang + "%", nam);
    }

    public List<Object[]> getListTop10XHH(String maKho, String maLHH, String thang, String nam)  throws SQLException {
        String[] cols = {"TENHH", "SOLUONGXUAT"};
        String sql = "EXEC SP_T10HHXUAT ?, ?, ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + thang + "%", nam);
    }

    public List<Object[]> getListTop10THLHH(String maKho, String thang, String nam) throws SQLException {
        String[] cols = {"TENLHH", "TONGGIATRIXUATNHAP", "TONGGTCHENHLECHTB"};
        String sql = "EXEC SP_T10LHHTH ?, ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + thang + "%", nam);
    }

    public List<Object[]> getListTop10THHH(String maKho, String maLHH, String thang, String nam) throws SQLException {
        String[] cols = {"TENHH", "TONGGIATRIXUATNHAP", "TONGGTCHENHLECHTB"};
        String sql = "EXEC SP_T10HHTH ?, ?, ?, ?";

        return this.getListOfArray(sql, cols, "%" + maKho + "%", "%" + maLHH + "%", "%" + thang + "%", nam);
    }
}
