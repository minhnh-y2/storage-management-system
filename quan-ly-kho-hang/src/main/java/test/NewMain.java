/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Huy
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
        
        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();
        
        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        //headerFont.setColor(IndexedColors.RED.getIndex());
        
        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Merging cells
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        
        // Create a Row
        Row rLogo = sheet.createRow(0);
        Row rTitle = sheet.createRow(2);
        Row rSubTitle1 = sheet.createRow(3);
        Row rSubTitle2 = sheet.createRow(4);
        Row rSubTitle3 = sheet.createRow(6);
        Row rSubTitle4 = sheet.createRow(7);
        Row rSubTitle5 = sheet.createRow(8);
        

        // Create cells
        // LOGO
        Cell cLogo = rLogo.createCell(0);
        cLogo.setCellValue("HỆ THỐNG QUẢN LÝ KHO HÀNG STOMAN");
//        cell.setCellStyle(headerCellStyle);
        
        // TITLE
        Cell cTitle = rTitle.createCell(3);
        cTitle.setCellValue("PHIẾU NHẬP KHO");
        
        // SUBTITLE
        Cell cSoPhieuT = rSubTitle1.createCell(3);
        Cell cSoPhieu = rSubTitle1.createCell(4);
        cSoPhieuT.setCellValue("Số phiếu: ");
        cSoPhieu.setCellValue(3);
        
        Cell cNgayLapT = rSubTitle2.createCell(3);
        Cell cNgayLap = rSubTitle2.createCell(4);
        cNgayLapT.setCellValue("Ngày lập: ");
        cNgayLap.setCellValue("22/05/2012");
        
        Cell cTTen = rSubTitle3.createCell(1);
        Cell cTen = rSubTitle3.createCell(2);
        cTTen.setCellValue("Tên đối tác: ");
        cTen.setCellValue("Xưởng mod pc");
        
        Cell cTNgThucHien = rSubTitle3.createCell(6);
        Cell cNgThucHien = rSubTitle3.createCell(7);
        cTNgThucHien.setCellValue("Ngày thực hiện: ");
        cNgThucHien.setCellValue("22/05/2012");
        
        Cell cTNhanVien = rSubTitle4.createCell(1);
        Cell cNhanVien = rSubTitle4.createCell(2);
        cTNhanVien.setCellValue("Nhân viên: ");
        cNhanVien.setCellValue("Nguyễn Hoài Minh");
        
        Cell cTNghoanThanh = rSubTitle4.createCell(6);
        Cell cNghoanThanh = rSubTitle4.createCell(7);
        cTNghoanThanh.setCellValue("Ngày hoàn thành: ");
        cNghoanThanh.setCellValue("22/05/2012");
        
        

        
        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
//        for(Employee employee: employees) {
//            Row row = sheet.createRow(rowNum++);
//
//            row.createCell(0).setCellValue(employee.getName());
//
//            row.createCell(1).setCellValue(employee.getEmail());
//
//            Cell dateOfBirthCell = row.createCell(2);
//            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
//            dateOfBirthCell.setCellStyle(dateCellStyle);
//
//            row.createCell(3).setCellValue(employee.getSalary());
//        }
        
        Row headerRow = sheet.createRow(10);
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        
	// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("F:/poi-generated-file.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex1) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        // Closing the workbook
        
    }

    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};
    

}
