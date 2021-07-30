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
import javafx.print.Printer;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MinhNH
 */
public class ExporterReport {
    
    private static JasperPrint getJasperPrint(String reportPath, HashMap parameters) throws SQLException, JRException {
        // Kết nối với database
        Connection conn = XJdbc.getConnection();
        
        // Biên dịch file
        InputStream path = ExporterReport.class.getResourceAsStream(reportPath);
        JasperReport jasperReport = JasperCompileManager.compileReport(path);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        
        // Đóng kết nối
        conn.close();
        
        return jasperPrint;
    }
    
    private static String choosePathFileSave(String fileName){
        String pathFile = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName));
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pathFile = selectedFile.getAbsolutePath();
        }
        return pathFile;
    }
    
    public static boolean exportPDF (String fileName, String reportPath, HashMap parameters) throws SQLException, JRException {
        String date = XDate.toString(new Date(), "ddMMyyyy");
        fileName = fileName + "_" + date;
        
        JasperPrint jasperPrint = getJasperPrint(reportPath, parameters);
        
        String filePath = choosePathFileSave(fileName + ".pdf");
        
        // Chuẩn bị trình xuất PDF
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));
        
        // Điều chỉnh cấu hình xuất
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        
        return true;
    }
    
    public static boolean exportExcel (String fileName, String reportPath, HashMap parameters) throws SQLException, JRException {
        String date = XDate.toString(new Date(), "ddMMyyyy");
        fileName = fileName + "_" + date;
        
        JasperPrint jasperPrint = getJasperPrint(reportPath, parameters);
        
        String filePath = choosePathFileSave(fileName + ".xlsx");
        
        // Chuẩn bị trình xuất file Excel
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));
        
        // Điều chỉnh cấu hình xuất
        SimpleXlsxReportConfiguration  configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(false);
        configuration.setDetectCellType(false);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        
        return true;
    }
    
    public static void printReport (String fileName, String reportPath, HashMap parameters) throws SQLException, JRException {
        JasperPrint jasperPrint = getJasperPrint(reportPath, parameters);
        jasperPrint.setName(fileName);
        JasperViewer.viewReport(jasperPrint, false);
    }
}
