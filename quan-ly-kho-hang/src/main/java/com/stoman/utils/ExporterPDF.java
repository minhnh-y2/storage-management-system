/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author MinhNH
 */
public class ExporterPDF {

    /**
     * In phiếu dạng pdf
     *
     * @param fileName tên file xuất
     * @param reportPath đường dẫn chứa file report
     * @param parameters các tham số truyền vào báo cáo
     * @return true/false
     * @throws SQLException
     * @throws JRException
     */
    public static boolean printReport(String fileName, String reportPath, HashMap parameters) throws SQLException, JRException {
        String date = XDate.toString(new Date(), "ddMMyyyy");
        fileName = fileName + "_" + date;
        
        // Kết nối với database
        Connection conn = XJdbc.getConnection();
        
        // Biên dịch file
        InputStream path = ExporterPDF.class.getResourceAsStream(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(path);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        
        // Chọn đường dẫn
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName + ".pdf"));
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            return false;
        }
        File selectedFile = fileChooser.getSelectedFile();
        
        // Chuẩn bị trình xuất PDF
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(selectedFile.getAbsolutePath()));
        
        // Điều chỉnh cấu hình xuất
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        
        // Đóng kết nối
        conn.close();
        
        return true;
    }
}
