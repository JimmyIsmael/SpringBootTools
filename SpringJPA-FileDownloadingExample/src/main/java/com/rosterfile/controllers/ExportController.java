package com.rosterfile.controllers;

import com.rosterfile.model.Roster;
import com.rosterfile.services.RosterFileService;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * Created by Jimmy Pena on 9/27/2017.
 */
@Controller
public class ExportController {
    @Autowired
    RosterFileService rosterFileService;

    private static final String FILE_PATH = "SalesRoster.xlsx";
    private static final String SALESROSTER_XLSX = "SalesRoster/xlsx";

    private File getFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }
        return file;
    }


    /*
    * Send the rosterList object to the model, when the model received it the ExcelView class
    * catchs it and creat the Excel file.
    * Look a the line 30 on ExcelView class */
    @RequestMapping(value = "/exportToExcel")
    public void exportToExcel( HttpServletResponse response) throws IOException {

        // Using XSSF for xlsx format, for xls use HSSF
        XSSFWorkbook workbook = new XSSFWorkbook();

        Sheet studentsSheet = workbook.createSheet("SalesRoster");
        studentsSheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = studentsSheet.createRow(0);
        header.createCell(0).setCellValue("ZRT");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Name");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Mailing Address 1");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Mailing Address 2");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("City");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("State");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("ZIP");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Phone Number");
        header.getCell(7).setCellStyle(style);

        int rowCount = 1;
        for(Roster user : rosterFileService.listAll()){
            Row userRow =  studentsSheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(user.getZRT());
            userRow.createCell(1).setCellValue(user.getFULL_NAME());
            userRow.createCell(2).setCellValue(user.getHOMEADDRESS1());
            userRow.createCell(3).setCellValue(user.getHOMEADDRESS2());
            userRow.createCell(4).setCellValue(user.getHOMECITY());
            userRow.createCell(5).setCellValue(user.getHOMESTATE());
            userRow.createCell(6).setCellValue(user.getHOMEZIPCODE());
            userRow.createCell(7).setCellValue(user.getCELL_PHONE());
        }


        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //-----Downloading the file-----//
        File file = getFile();
        InputStream in = new FileInputStream(file);
        response.setContentType(SALESROSTER_XLSX);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());

        System.out.println(FILE_PATH + " is successfully downloaded");
    }
}
