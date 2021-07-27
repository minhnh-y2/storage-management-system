/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author MinhNH
 */
public class ReportHelper {

    /**
     * In phiếu dạng pdf
     * @param reportPath: Đường dẫn file report
     * @param parameters: Map các tham số truyền vào báo cáo để xuất CSDL
     * @throws SQLException
     * @throws JRException
     */
    public static void printReport(String reportPath, HashMap parameters) throws SQLException, JRException {
        // Kết nối với database
        Connection conn = XJdbc.getConnection();
        // Biên dịch file
        InputStream path = ReportHelper.class.getResourceAsStream(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(path);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        // In phiếu
        JasperPrintManager.printReport(jasperPrint, false);
        conn.close();
    }
}
