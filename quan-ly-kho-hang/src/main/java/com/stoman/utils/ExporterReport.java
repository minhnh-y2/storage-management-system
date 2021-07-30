/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoman.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javafx.print.Printer;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.FilenameUtils;

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

    private static String choosePathFileSave(String fileName) {
        JFileChooser fileChooser = new JSystemFileChooser();
        
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Excel Documents", "xlsx"));
        
        
        fileChooser.setSelectedFile(new File(fileName));

        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String pathFile = selectedFile.getAbsolutePath();
            
            if(fileChooser.getFileFilter().getDescription().equals("Microsoft Excel Documents"))
                return pathFile+".xlsx";
            else
                return pathFile+".pdf";
        }
        return null;
    }

    public static void exportFile(String fileName, String reportPath, HashMap parameters) throws SQLException, JRException, IOException {
        String date = XDate.toString(new Date(), "ddMMyyyy");
        fileName = fileName + "_" + date;

        JasperPrint jasperPrint = getJasperPrint(reportPath, parameters);

        String filePath = choosePathFileSave(fileName);

        if (filePath == null) {
            return;
        }
        

        String fileExtend = FilenameUtils.getExtension(filePath);
        System.out.println(fileExtend);
        Exporter exporter;

        switch (fileExtend) {
            case "xlsx":
                // Chuẩn bị trình xuất file Excel
                exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));

                // Điều chỉnh cấu hình xuất
                SimpleXlsxReportConfiguration configurationExcel = new SimpleXlsxReportConfiguration();
                configurationExcel.setOnePagePerSheet(true);
                configurationExcel.setDetectCellType(false);
                exporter.exportReport();

                File outputFile = new File(fileName);
                try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        OutputStream fileOutputStream = new FileOutputStream(outputFile)) {
                    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
                    exporter.setConfiguration(configurationExcel);
                    exporter.exportReport();
                    byteArrayOutputStream.writeTo(fileOutputStream);
                }
                break;
                
            default:
                // Chuẩn bị trình xuất PDF
                exporter = new JRPdfExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));

                // Điều chỉnh cấu hình xuất
                SimplePdfExporterConfiguration configurationPDF = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configurationPDF);
                exporter.exportReport();
                break;
                
        }

    }

    public static void printReport(String fileName, String reportPath, HashMap parameters) throws SQLException, JRException {
        JasperPrint jasperPrint = getJasperPrint(reportPath, parameters);
        jasperPrint.setName(fileName);
        JasperViewer.viewReport(jasperPrint, false);
    }
}
