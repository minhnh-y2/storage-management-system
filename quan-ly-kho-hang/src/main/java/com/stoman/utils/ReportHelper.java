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
import java.util.HashMap;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author MinhNH
 */
public class ReportHelper {

    /**
     * In phiếu dạng pdf
     *
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
        
        // Chọn đường dẫn
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("PhieuXuatNhapKho.pdf"));
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File selectedFile = fileChooser.getSelectedFile();
        
        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();
        ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
        
        // Exporter Input
        exporter.setExporterInput(exporterInput);
        
        // Exporter Output
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                selectedFile.getAbsolutePath());
        
        // Output
        exporter.setExporterOutput(exporterOutput);
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        conn.close();
    }
}
