 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.sql.*;

/**
 *
 * @author Huy
 */
public class XJdbc {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;database=STORAGEMS;"
            + "sslProtocol=TLSv1.2";
    
    private static String user = "sa";
    private static String pass = "123456";
    
    /**
     * Nap driver
     */    
    static {
        try {
            Class.forName(driver);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Xay dung PreparedStatement
     * @param sql la cau lenh SQL
     * @param args la danh sach cac gia tri duoc cung cap cho cac tham so trong cau lenh SQL
     * @return prepareStatement tao duoc
     * @throws SQLException 
     */
    
    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement stmt;
        
        if(sql.trim().startsWith("{")){
            stmt = conn.prepareCall(sql.replaceAll("{", "")); //PROC

        }else {
            stmt = conn.prepareStatement(sql); // SQL
        }
        
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i+1,args[i]);
            
        }
        
        return stmt;
    }
    
    /**
     * Thuc hien cau lenh SQL
     * @param sql la cau lenh SQL
     * @param args la danh sach cac gia tri duoc cung cap cho cac tham so trong cau lenh SQL
     * @throws SQLException 
     */
    
    public static ResultSet query(String sql, Object...args) throws SQLException {
        PreparedStatement stmt = XJdbc.getStmt(sql, args);
        return stmt.executeQuery();
    }
    
    /**
     * Thuc hien cau lenh SQL truy van (SELECT) hoach thu tuc truy van du lieu
     * @param sql la cau lenh SQL truy van
     * @param args la danh sach cac gia tri duoc cung cap cho cac tham so trong cau lenh SQL
     */
    
    public static Object value(String sql, Object...args){
        try{
            ResultSet rs = XJdbc.query(sql, args);
            if(rs.next()){
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
            return null;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Thuc hien cau lenh SQL thao tac (SELECT) hoach thu tuc thao tac du lieu
     * @param sql la cau lenh SQL thao tac
     * @param args la danh sach cac gia tri duoc cung cap cho cac tham so trong cau lenh SQL
     */
    
    public static int update(String sql, Object...args){
        try{
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            try{
                return stmt.executeUpdate();
            }finally{
                stmt.getConnection().close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
